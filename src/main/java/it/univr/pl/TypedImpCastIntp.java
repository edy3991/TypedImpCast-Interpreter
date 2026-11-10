package it.univr.pl;

import it.univr.pl.type.ComType;
import it.univr.pl.type.ExpType;
import it.univr.pl.type.SimpleType;
import it.univr.pl.type.TypeUtils;
import it.univr.pl.value.*;
import org.apache.commons.text.StringEscapeUtils;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.util.HashMap;
import java.util.Map;

public class TypedImpCastIntp extends TypedImpCastBaseVisitor<Value> {

    private final Mem mem;

    private final Map<String, TypedImpCastParser.FunDeclContext> functions = new HashMap<>();

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
        //
        mem.enterScope();
        visitCom(ctx.com());
        mem.exitScope();
        //
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIfElse(TypedImpCastParser.IfElseContext ctx) {
        //
        if (visitBoolExp(ctx.exp()).toJavaValue()) {
            mem.enterScope();
            visitCom(ctx.com(0));
            mem.exitScope();
        } else {
            mem.enterScope();
            visitCom(ctx.com(1));
            mem.exitScope();
        }

        return ComValue.INSTANCE;
        //
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
        //
        while (visitBoolExp(ctx.exp()).toJavaValue()) {
            mem.enterScope();
            visitCom(ctx.com());
            mem.exitScope();
        }

        return ComValue.INSTANCE;
        //
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
        String raw = ctx.STRING().getText();

        //toglie le virgolette iniziali e finali
        String str = raw.substring(1, raw.length() - 1);

        str = StringEscapeUtils.unescapeJava(str);

        String result = interpolate(str);

        return new StringValue(result);
    }

    private String interpolate(String str) {
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < str.length()) {
            int start = str.indexOf("${", i);

            if (start == -1) {
                result.append(str.substring(i));
                break;
            }

            result.append(str, i, start);

            int end = str.indexOf("}", start);

            if (end == -1) {
                throw new RuntimeException("Invalid string interpolation: missing }.");
            }

            String expText = str.substring(start + 2, end);

            ExpValue<?> value = evalExpressionFromString(expText);

            result.append(value.toString());

            i = end + 1;
        }

        return result.toString();
    }

    private ExpValue<?> evalExpressionFromString(String expText) {
        TypedImpCastLexer lexer = new TypedImpCastLexer(
                CharStreams.fromString(expText)
        );

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypedImpCastParser parser = new TypedImpCastParser(tokens);

        TypedImpCastParser.ExpContext expCtx = parser.exp();

        return visitExp(expCtx);
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

    @Override
    public ComValue visitPostInc(TypedImpCastParser.PostIncContext ctx) {
        // recupera il nome della variabile da incrementare
        String id = ctx.ID().getText();

        // legge il valore corrente della variabile
        IntValue oldValue =  (IntValue) mem.getValue(id);
        // aggiorna il valore della variabile incrementando di 1
        mem.updateValue(id, new IntValue(oldValue.toJavaValue() + 1));

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitPreInc(TypedImpCastParser.PreIncContext ctx) {
        // recupera il nome della variabile da incrementare
        String id = ctx.ID().getText();

        // legge il valore corrente della variabile
        IntValue oldValue =  (IntValue) mem.getValue(id);
        // aggiorna il valore della variabile incrementando di 1
        mem.updateValue(id, new IntValue(oldValue.toJavaValue() + 1));

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitPreDecr(TypedImpCastParser.PreDecrContext ctx) {
        // recupera il nome della variabile da decrementare
        String id = ctx.ID().getText();

        // legge il valore corrente della variabile
        IntValue oldValue =  (IntValue) mem.getValue(id);
        // aggiorna il valore della variabile decrementato di 1
        mem.updateValue(id, new IntValue(oldValue.toJavaValue() - 1));

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitPostDecr(TypedImpCastParser.PostDecrContext ctx) {
        // recupera il nome della variabile da decrementare
        String id = ctx.ID().getText();

        // legge il valore corrente della variabile
        IntValue oldValue =  (IntValue) mem.getValue(id);
        // aggiorna il valore della variabile decrementato di 1
        mem.updateValue(id, new IntValue(oldValue.toJavaValue() - 1));

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitCompAssign(TypedImpCastParser.CompAssignContext ctx) {
        // recupera il nome della variabile
        String id = ctx.ID().getText();

        // legge il valore della variabile a sinistra
        NumValue<?> left = (NumValue<?>) mem.getValue(id);
        // legge il valore della variabile a destra
        NumValue<?> right = visitNumExp(ctx.exp());

        double result;

        // in base al tipo di operatore viene eseguita l'operazione
        switch (ctx.op.getType()) {
            case TypedImpCastParser.ADD_ASSIGN ->
                    result = left.toJavaValue().doubleValue() + right.toJavaValue().doubleValue();

            case TypedImpCastParser.SUB_ASSIGN ->
                    result = left.toJavaValue().doubleValue() - right.toJavaValue().doubleValue();

            case TypedImpCastParser.MUL_ASSIGN ->
                    result = left.toJavaValue().doubleValue() * right.toJavaValue().doubleValue();

            case TypedImpCastParser.DIV_ASSIGN ->
                    result = left.toJavaValue().doubleValue() / right.toJavaValue().doubleValue();

            default -> throw new RuntimeException("Unknown compound assignment operator.");
        }

        // aggiorna il valore della variabile mantenendo il tipo int se possibile
        if (left instanceof IntValue && right instanceof IntValue && ctx.op.getType() != TypedImpCastParser.DIV_ASSIGN) {
            mem.updateValue(id, new IntValue((int) result));
        } else {
            mem.updateValue(id, new DecValue(result));
        }

        return ComValue.INSTANCE;
    }

    @Override
    public ExpValue<?> visitTernary(TypedImpCastParser.TernaryContext ctx) {
        // valuta la condizione del ternario
        BoolValue condition = visitBoolExp(ctx.exp(0));

        // se è vera restituisce il valore della prima espressione
        if(condition.toJavaValue()) {
            return visitExp(ctx.exp(1));
        }

        // se è falsa restituisce il valore della seconda espressione
        return visitExp(ctx.exp(2));
    }

    @Override
    public ComValue visitMain(TypedImpCastParser.MainContext ctx) {
        // vengono solo registrate le funzioni nella mappa, non eseguite
        for (TypedImpCastParser.FunDeclContext f : ctx.funDecl()) {
            String name = f.ID().getText();

            if (functions.containsKey(name)) {
                throw new RuntimeException("Function " + name + " already declared.");
            }

            functions.put(name, f);
        }
        // una volta salvate, viene eseguito il blocco main
        return visitCom(ctx.com());
    }

    // interrompe l'esecuzione della funzione e propaga il valore di ritorno fino alla funzione chiamante
    private static class ReturnException extends RuntimeException {
        private final ExpValue<?> value;

        public ReturnException(ExpValue<?> value) {
            this.value = value;
        }

        public ExpValue<?> getValue() {
            return value;
        }
    }

    // valuta l'espressione dopo il return e lancia una return exception
    @Override
    public ComValue visitReturn(TypedImpCastParser.ReturnContext ctx) {
        throw new ReturnException(visitExp(ctx.exp()));
    }


    @Override
    public ExpValue<?> visitFunCall(TypedImpCastParser.FunCallContext ctx) {
        // recupera il nome della funzione
        String name = ctx.ID().getText();

        // controlla che la funzione esista nella mappa delle funzioni
        if (!functions.containsKey(name)) {
            throw new RuntimeException("Function " + name + " not declared.");
        }

        // recupera la dichiarazione delle funzioni
        TypedImpCastParser.FunDeclContext fun = functions.get(name);

        // calcola il numero di parametro attesi
        int expectedArgs = fun.params() == null ? 0 : fun.params().param().size();
        int actualArgs = ctx.args() == null ? 0 : ctx.args().exp().size();

        // controlla che siano uguali, in termini di quantità
        if (expectedArgs != actualArgs) {
            throw new RuntimeException("Function " + name + " expects "
                    + expectedArgs + " arguments but found " + actualArgs + ".");
        }

        // passaggio per valore
        ExpValue<?>[] argValues = new ExpValue<?>[actualArgs];
        // associazione per il passaggio di riferimento
        Map<String, String> refBindings = new HashMap<>();

        // valuta gli argomenti PRIMA del nuovo scope, quindi guarda nello scope attuale
        for (int i = 0; i < actualArgs; i++) {
            argValues[i] = visitExp(ctx.args().exp(i));

            TypedImpCastParser.ParamContext param = fun.params().param(i);

            // se il parametro è ref, l'argomento deve essere una variabile
            if (param.paramMode().REF() != null) {
                TypedImpCastParser.ExpContext arg = ctx.args().exp(i);

                if (!(arg instanceof TypedImpCastParser.IdContext)) {
                    throw new RuntimeException("Reference parameter requires a variable.");
                }

                String paramName = param.ID().getText();
                String originalName = ((TypedImpCastParser.IdContext) arg).ID().getText();

                refBindings.put(paramName, originalName);
            }
        }

        // ora crea lo scope della funzione
        mem.enterScope();

        // inserisce i parametri formali nello scope della funzione e li inizializza con i valori degli argomenti
        try {
            for (int i = 0; i < expectedArgs; i++) {
                TypedImpCastParser.ParamContext param = fun.params().param(i);

                String paramName = param.ID().getText();
                ExpType paramType = TypeUtils.fromString(param.TYPE().getText());

                mem.add(paramName, paramType);
                mem.updateValue(paramName, argValues[i]);
            }

            // esegue il corpo della funzione, il corpo deve terminare con un return
            visitCom(fun.com());

            // errore se non termina con un return
            throw new RuntimeException("Function " + name + " ended without return.");

        } catch (ReturnException re) {

            // aggiorna i valori dei parametri passati come riferimento
            for (String paramName : refBindings.keySet()) {
                String originalName = refBindings.get(paramName);
                ExpValue<?> finalValue = mem.getValue(paramName);
                mem.updateValue(originalName, finalValue);
            }

            // il valore della return exception diventa il valore della chiamata di funzione
            return re.getValue();

        } finally {
            // rimuove lo scope della funzione
            mem.exitScope();
        }
    }
}
