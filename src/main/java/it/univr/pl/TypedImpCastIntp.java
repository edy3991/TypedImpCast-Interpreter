package it.univr.pl;

import it.univr.pl.type.ExpType;
import it.univr.pl.type.SimpleType;
import it.univr.pl.type.TypeUtils;
import it.univr.pl.value.*;
import org.apache.commons.text.StringEscapeUtils;

public class TypedImpCastIntp extends TypedImpCastBaseVisitor<Value> {

    private final Mem mem;

    public TypedImpCastIntp(Mem mem) {
        this.mem = new Mem(mem);
    }

    public TypedImpCastIntp() {
        mem = new Mem();
    }

    public Mem getMem() {
        return mem;
    }

    private ComValue visitCom(TypedImpCastParser.ComContext ctx) {
        return (ComValue) visit(ctx);
    }

    private ExpValue<?> visitExp(TypedImpCastParser.ExpContext ctx) {
        return (ExpValue<?>) visit(ctx);
    }

    private NumValue<?> visitNumExp(TypedImpCastParser.ExpContext ctx) {
        return (NumValue<?>) visitExp(ctx);
    }

    private BoolValue visitBoolExp(TypedImpCastParser.ExpContext ctx) {
        return (BoolValue) visitExp(ctx);
    }

    private StringValue visitStringExp(TypedImpCastParser.ExpContext ctx) {
        return (StringValue) visitExp(ctx);
    }

    private double unwrapToDouble(NumValue<?> numValue) {
        return numValue.toJavaValue().doubleValue();
    }

    @Override
    public ComValue visitMain(TypedImpCastParser.MainContext ctx) {
        return visitCom(ctx.com());
    }

    @Override
    public ComValue visitDecl(TypedImpCastParser.DeclContext ctx) {

        ExpType type = TypeUtils.fromString(ctx.TYPE().getText());
        String id = ctx.ID().getText();
        mem.add(id, type);
        if (ctx.exp() != null) {
            ExpValue<?> val = visitExp(ctx.exp());
            mem.updateValue(id, val);
        }

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIf(TypedImpCastParser.IfContext ctx) {
        if (!visitBoolExp(ctx.exp()).toJavaValue())
            return ComValue.INSTANCE;

        TypedImpCastIntp interpreter = new TypedImpCastIntp(mem);
        interpreter.visitCom(ctx.com());
        mem.updateValues(interpreter.getMem());

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIfElse(TypedImpCastParser.IfElseContext ctx) {
        TypedImpCastIntp interpreter = new TypedImpCastIntp(mem);
        if (visitBoolExp(ctx.exp()).toJavaValue())
            interpreter.visitCom(ctx.com(0));
        else
            interpreter.visitCom(ctx.com(1));
        mem.updateValues(interpreter.getMem());

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitAssign(TypedImpCastParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());

        mem.updateValue(id, v); // safe due to type checking

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitSeq(TypedImpCastParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitWhile(TypedImpCastParser.WhileContext ctx) {
        if (!visitBoolExp(ctx.exp()).toJavaValue())
            return ComValue.INSTANCE;

        TypedImpCastIntp interpreter = new TypedImpCastIntp(mem);
        interpreter.visitCom(ctx.com());
        mem.updateValues(interpreter.getMem());

        return visitWhile(ctx);
    }

    @Override
    public ComValue visitOut(TypedImpCastParser.OutContext ctx) {
        System.out.println(visitStringExp(ctx.exp()).toJavaValue());
        return ComValue.INSTANCE;
    }

    @Override
    public NumValue<?> visitNumeric(TypedImpCastParser.NumericContext ctx) {
        return (NumValue<?>) visit(ctx.num());
    }

    @Override
    public IntValue visitIntNum(TypedImpCastParser.IntNumContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public DecValue visitDecNum(TypedImpCastParser.DecNumContext ctx) {
        return new DecValue(Double.parseDouble(ctx.DEC().getText()));
    }

    @Override
    public BoolValue visitBoolean(TypedImpCastParser.BooleanContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public StringValue visitString(TypedImpCastParser.StringContext ctx) {
        String str = ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1);
        return new StringValue(StringEscapeUtils.unescapeJava(str));
    }

    @Override
    public ExpValue<?> visitParExp(TypedImpCastParser.ParExpContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public StringValue visitTostr(TypedImpCastParser.TostrContext ctx) {
        return new StringValue(visitExp(ctx.exp()).toString());
    }

    @Override
    public ExpValue<?> visitPow(TypedImpCastParser.PowContext ctx) {
        NumValue<?> base = visitNumExp(ctx.exp(0));
        NumValue<?> exponent = visitNumExp(ctx.exp(1));
        SimpleType baseType = (SimpleType) TypeUtils.fromValue(base);
        SimpleType exponentType = (SimpleType) TypeUtils.fromValue(exponent);

        double result = Math.pow(unwrapToDouble(base), unwrapToDouble(exponent));
        SimpleType retType = baseType.isCompatible(exponentType) ? baseType : exponentType;
        if (retType == SimpleType.INT) return new IntValue((int) result);
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitNot(TypedImpCastParser.NotContext ctx) {
        return new BoolValue(!visitBoolExp(ctx.exp()).toJavaValue());
    }

    @Override
    public ExpValue<?> visitMulDivMod(TypedImpCastParser.MulDivModContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));
        SimpleType leftType = (SimpleType) TypeUtils.fromValue(left);
        SimpleType rightType = (SimpleType) TypeUtils.fromValue(right);

        Double result;
        switch (ctx.op.getType()) {
            case TypedImpCastParser.DIV -> result = unwrapToDouble(left) / unwrapToDouble(right);
            case TypedImpCastParser.MUL -> result = unwrapToDouble(left) * unwrapToDouble(right);
            case TypedImpCastParser.MOD -> result = unwrapToDouble(left) % unwrapToDouble(right);
            default -> result = null; // unreachable code
        }

        assert result != null; // always true
        SimpleType retType = leftType.isCompatible(rightType) ? leftType : rightType;
        if (retType == SimpleType.INT) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public ExpValue<?> visitAddSub(TypedImpCastParser.AddSubContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));
        SimpleType leftType = (SimpleType) TypeUtils.fromValue(left);
        SimpleType rightType = (SimpleType) TypeUtils.fromValue(right);

        Double result;
        switch (ctx.op.getType()) {
            case TypedImpCastParser.ADD -> result = unwrapToDouble(left) + unwrapToDouble(right);
            case TypedImpCastParser.SUB -> result = unwrapToDouble(left) - unwrapToDouble(right);
            default -> result = null; // unreachable code
        }

        assert result != null; // always true
        SimpleType retType = leftType.isCompatible(rightType) ? leftType : rightType;
        if (retType == SimpleType.INT) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitEqExp(TypedImpCastParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case TypedImpCastParser.EQQ -> new BoolValue(left.equals(right));
            case TypedImpCastParser.NEQ -> new BoolValue(!left.equals(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public ExpValue<?> visitCast(TypedImpCastParser.CastContext ctx) {
        ExpValue<?> val = visitExp(ctx.exp());
        ExpType targetType = TypeUtils.fromString(ctx.TYPE().getText());
        return TypeUtils.castValue(val, targetType);
    }

    @Override
    public ExpValue<?> visitId(TypedImpCastParser.IdContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> value = mem.getValue(id);

        if(value == null) throw new RuntimeException("Runtime error: variable '" + id + "' is not initialized");
        return value;
    }

    @Override
    public BoolValue visitCmpExp(TypedImpCastParser.CmpExpContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case TypedImpCastParser.GEQ -> new BoolValue(unwrapToDouble(left) >= unwrapToDouble(right));
            case TypedImpCastParser.LEQ -> new BoolValue(unwrapToDouble(left) <= unwrapToDouble(right));
            case TypedImpCastParser.LT -> new BoolValue(unwrapToDouble(left) < unwrapToDouble(right));
            case TypedImpCastParser.GT -> new BoolValue(unwrapToDouble(left) > unwrapToDouble(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public BoolValue visitAndOr(TypedImpCastParser.AndOrContext ctx) {
        BoolValue left = visitBoolExp(ctx.exp(0));
        BoolValue right = visitBoolExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case TypedImpCastParser.AND -> new BoolValue(left.toJavaValue() && right.toJavaValue());
            case TypedImpCastParser.OR -> new BoolValue(left.toJavaValue() || right.toJavaValue());
            default -> null; // unreachable code
        };
    }

    @Override
    public StringValue visitConcat(TypedImpCastParser.ConcatContext ctx) {
        StringValue left = visitStringExp(ctx.exp(0));
        StringValue right = visitStringExp(ctx.exp(1));

        return new StringValue(left.toJavaValue() + right.toJavaValue());
    }

}
