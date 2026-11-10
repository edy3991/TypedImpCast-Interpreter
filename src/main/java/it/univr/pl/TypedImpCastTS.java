package it.univr.pl;

import it.univr.pl.exception.TypeMismatchException;
import it.univr.pl.exception.VarDeclarationException;
import it.univr.pl.type.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class TypedImpCastTS extends TypedImpCastBaseVisitor<Type> {

    private final List<Map<String, ExpType>> env = new ArrayList<>();

    private final Map<String, TypedImpCastParser.FunDeclContext> functions = new HashMap<>();

    private ExpType currentReturnType = null;

    public TypedImpCastTS() {
        env.add(new HashMap<>());
    }

    private void enterScope() {
        env.add(new HashMap<>());
    }

    private void exitScope() {
        env.remove(env.size() - 1);
    }

    private ExpType lookup(String id) {
        for (int i = env.size() - 1; i >= 0; i--) {
            if (env.get(i).containsKey(id))
                return env.get(i).get(id);
        }
        throw new VarDeclarationException("Variable " + id + " not declared.");
    }

    public Map<String, ExpType> getTypeMap() {
        return env.get(0);
    }

    private ComType visitCom(TypedImpCastParser.ComContext ctx) {
        return (ComType) visit(ctx);
    }

    private SimpleType visitBoolExp(TypedImpCastParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.BOOL)) { // not boolean expression
            String err = "Type mismatch: boolean expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    private SimpleType visitStringExp(TypedImpCastParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.STRING)) { // not string expression
            String err = "Type mismatch: string expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.STRING;
    }

    private SimpleType visitNumExp(TypedImpCastParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.INT) && !expType.isCompatible(SimpleType.DEC)) { // not numeric expression
            String err = "Type mismatch: numeric expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return (SimpleType) expType;
    }

    private boolean tryToUpcast(ExpType typeA, ExpType typeB) {
        return typeA == typeB || typeA.isCompatible(typeB) || typeB.isCompatible(typeA);
    }

    @Override
    public ComType visitDecl(TypedImpCastParser.DeclContext ctx) {

        ExpType varType = TypeUtils.fromString(ctx.TYPE().getText());
        String id = ctx.ID().getText();
        //
        Map<String, ExpType> current = env.get(env.size() - 1);

        if (current.containsKey(id)) {
            throw new VarDeclarationException("Variable " + id + " already declared.");
        }
        current.put(id, varType);
        //
        if (ctx.exp() != null) {
            ExpType expType = (ExpType) visit(ctx.exp());
            assert varType != null; // always true
            if (!varType.isCompatible(expType)) {// type mismatch
                String err = "Variable " + id + " cannot be assigned with " + expType.getName() + ".\n"+
                             "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
                throw new TypeMismatchException(err);
            }
        }

        return ComType.INSTANCE;
    }

    @Override
    public ComType visitWhile(TypedImpCastParser.WhileContext ctx) {
        visitBoolExp(ctx.exp());
        //
        enterScope();
        visitCom(ctx.com());
        exitScope();

        return ComType.INSTANCE;
        //
    }

    @Override
    public ComType visitIf(TypedImpCastParser.IfContext ctx) {
        visitBoolExp(ctx.exp());
        //
        enterScope();
        visitCom(ctx.com());
        exitScope();
        //
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitIfElse(TypedImpCastParser.IfElseContext ctx) {
        visitBoolExp(ctx.exp());
        //
        enterScope();
        visitCom(ctx.com(0));
        exitScope();

        enterScope();
        visitCom(ctx.com(1));
        exitScope();
        //
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitAssign(TypedImpCastParser.AssignContext ctx) {

        String id = ctx.ID().getText();
        //
        ExpType varType = lookup(id);
        ExpType expType = (ExpType) visit(ctx.exp());

        if (!varType.isCompatible(expType)) {
            throw new TypeMismatchException(
                    "Variable " + id + " cannot be assigned with " + expType.getName() + "."
            );
        }

        return ComType.INSTANCE;
        //
    }

    @Override
    public ComType visitSeq(TypedImpCastParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override //
    public ExpType visitId(TypedImpCastParser.IdContext ctx) { return lookup(ctx.ID().getText()); }

    @Override
    public ComType visitOut(TypedImpCastParser.OutContext ctx) {
        visitStringExp(ctx.exp());

        return ComType.INSTANCE;
    }

    @Override
    public ComType visitNop(TypedImpCastParser.NopContext ctx) {
        return ComType.INSTANCE;
    }


    @Override
    public SimpleType visitTostr(TypedImpCastParser.TostrContext ctx) {
        visit(ctx.exp());

        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitMulDivMod(TypedImpCastParser.MulDivModContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (!tryToUpcast(left, right)) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return left.isCompatible(right) ? left : right;
    }

    @Override
    public SimpleType visitString(TypedImpCastParser.StringContext ctx) {
        String raw = ctx.STRING().getText();
        String str = raw.substring(1, raw.length() - 1);

        checkInterpolations(str);

        return SimpleType.STRING;
    }

    private void checkInterpolations(String str) {
        int i = 0;

        while (i < str.length()) {
            int start = str.indexOf("${", i);

            if (start == -1) {
                break;
            }

            int end = str.indexOf("}", start);

            if (end == -1) {
                throw new TypeMismatchException("Invalid string interpolation: missing }.");
            }

            String expText = str.substring(start + 2, end);

            checkExpressionFromString(expText);

            i = end + 1;
        }
    }

    private void checkExpressionFromString(String expText) {
        TypedImpCastLexer lexer = new TypedImpCastLexer(
                CharStreams.fromString(expText)
        );

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypedImpCastParser parser = new TypedImpCastParser(tokens);

        TypedImpCastParser.ExpContext expCtx = parser.exp();

        visit(expCtx);
    }



    @Override
    public SimpleType visitNumeric(TypedImpCastParser.NumericContext ctx) {
        return (SimpleType) visit(ctx.num());
    }

    @Override
    public SimpleType visitIntNum(TypedImpCastParser.IntNumContext ctx) {
        return SimpleType.INT;
    }

    @Override
    public SimpleType visitDecNum(TypedImpCastParser.DecNumContext ctx) {
        return SimpleType.DEC;
    }

    @Override
    public SimpleType visitAddSub(TypedImpCastParser.AddSubContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (!tryToUpcast(left, right)) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return left.isCompatible(right) ? left : right;
    }

    @Override
    public SimpleType visitConcat(TypedImpCastParser.ConcatContext ctx) {
        visitStringExp(ctx.exp(0));
        visitStringExp(ctx.exp(1));

        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitAndOr(TypedImpCastParser.AndOrContext ctx) {
        visitBoolExp(ctx.exp(0));
        visitBoolExp(ctx.exp(1));

        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitNot(TypedImpCastParser.NotContext ctx) {
        visitBoolExp(ctx.exp());

        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitEqExp(TypedImpCastParser.EqExpContext ctx) {
        ExpType left = (ExpType) visit(ctx.exp(0));
        ExpType right = (ExpType) visit(ctx.exp(1));

        if (!tryToUpcast(left, right)) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitBoolean(TypedImpCastParser.BooleanContext ctx) {
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitCmpExp(TypedImpCastParser.CmpExpContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (!tryToUpcast(left, right)) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    @Override
    public ExpType visitParExp(TypedImpCastParser.ParExpContext ctx) {
        return (ExpType) visit(ctx.exp());
    }

    @Override
    public ExpType visitCast(TypedImpCastParser.CastContext ctx) {
        ExpType expType = (ExpType) visit(ctx.exp());
        ExpType targetType = TypeUtils.fromString(ctx.TYPE().getText());

        assert targetType != null; // always true
        if (!targetType.isCompatible(expType) && !expType.canDownCastTo(targetType)) {
            String err = "Type mismatch: invalid cast.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return targetType;
    }

    @Override
    public SimpleType visitPow(TypedImpCastParser.PowContext ctx) {
        SimpleType base = visitNumExp(ctx.exp(0));
        SimpleType exponent = visitNumExp(ctx.exp(1));

        if (!tryToUpcast(base, exponent)) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return base.isCompatible(exponent) ? base : exponent;
    }

    //controlla il tipo della variabile che sia int o dec
    @Override
    public ComType visitPostInc(TypedImpCastParser.PostIncContext ctx) {
        ExpType type = lookup(ctx.ID().getText());

        if(!type.isCompatible(SimpleType.INT) && !type.isCompatible(SimpleType.DEC)) {
            throw new TypeMismatchException("Type mismatch: requires int variable.");
        }

        return ComType.INSTANCE;
    }

    //controlla il tipo della variabile che sia int o dec
    @Override
    public ComType visitPreInc(TypedImpCastParser.PreIncContext ctx) {
        ExpType type = lookup(ctx.ID().getText());

        if(!type.isCompatible(SimpleType.INT) && !type.isCompatible(SimpleType.DEC)) {
            throw new TypeMismatchException("Type mismatch: requires int variable.");
        }

        return ComType.INSTANCE;
    }

    //controlla il tipo della variabile che sia int o dec
    @Override
    public ComType visitPostDecr(TypedImpCastParser.PostDecrContext ctx) {
        ExpType type = lookup(ctx.ID().getText());

        if(!type.isCompatible(SimpleType.INT) && !type.isCompatible(SimpleType.DEC)) {
            throw new TypeMismatchException("Type mismatch: requires int variable.");
        }

        return ComType.INSTANCE;
    }

    //controlla il tipo della variabile che sia int o dec
    @Override
    public ComType visitPreDecr(TypedImpCastParser.PreDecrContext ctx) {
        ExpType type = lookup(ctx.ID().getText());

        if(!type.isCompatible(SimpleType.INT) && !type.isCompatible(SimpleType.DEC)) {
            throw new TypeMismatchException("Type mismatch: requires int variable.");
        }

        return ComType.INSTANCE;
    }


    @Override
    public ComType visitCompAssign(TypedImpCastParser.CompAssignContext ctx) {
        String id = ctx.ID().getText(); // prende la variabile a sinistra

        ExpType varType = lookup(ctx.ID().getText()); // controlla il tipo della variabile a sinistra
        ExpType expType = (ExpType) visit(ctx.exp()); // risolve la parte di destra

        if ((!varType.isCompatible(SimpleType.INT) && !varType.isCompatible(SimpleType.DEC)) ||
                (!expType.isCompatible(SimpleType.INT) && !expType.isCompatible(SimpleType.DEC))) {
            throw new TypeMismatchException("Compound assignment requires numeric operands.");
        }

        if (!varType.isCompatible(expType)) {
            throw new TypeMismatchException("Compound assignment result is not compatible with variable type.");
        }

        return ComType.INSTANCE;
    }

    @Override
    public ExpType visitTernary(TypedImpCastParser.TernaryContext ctx) {
        visitBoolExp(ctx.exp(0)); // prende il primo nodo del parse tree

        ExpType trueType = (ExpType) visit(ctx.exp(1));
        ExpType falseType = (ExpType) visit(ctx.exp(2));

        if (!tryToUpcast(trueType, falseType)) {
            throw new TypeMismatchException("Type mismatch: ternary branches have incompatible types.");
        }

        return trueType.isCompatible(falseType) ? trueType : falseType;
    }

    @Override
    public ComType visitMain(TypedImpCastParser.MainContext ctx) {

        // salva tutte le funzioni dichiarate nel programma in una mappa
        for (TypedImpCastParser.FunDeclContext f : ctx.funDecl()) {
            String name = f.ID().getText();

            if (functions.containsKey(name)) {
                throw new RuntimeException("Function " + name + " already declared.");
            }

            functions.put(name, f);
        }

        // controlla semanticamente che le funzioni siano scritte in modo corretto
        for (TypedImpCastParser.FunDeclContext f : ctx.funDecl()) {
            visitFunDecl(f);
        }

        currentReturnType = null; // al di fuori delle funzioni non si aspetta alcun ritorno
        return visitCom(ctx.com()); // analizza il main alla fine
    }

    @Override
    public Type visitFunDecl(TypedImpCastParser.FunDeclContext ctx) {
        // salva il tipo di ritorno per ripristinarlo quando si esce dalla funzione
        ExpType oldReturnType = currentReturnType;

        // imposta il tipo di ritorno atteso della funzione corrente
        currentReturnType = TypeUtils.fromString(ctx.TYPE().getText());

        // crea un nuovo scope locale nella funzione
        enterScope();

        // inserisce i parametri formali nell'ambiente locale della funzione
        if (ctx.params() != null) {
            for (TypedImpCastParser.ParamContext p : ctx.params().param()) {
                ExpType paramType = TypeUtils.fromString(p.TYPE().getText());
                String paramName = p.ID().getText();

                Map<String, ExpType> current = env.get(env.size() - 1);

                if (current.containsKey(paramName)) {
                    throw new VarDeclarationException("Variable " + paramName + " already declared.");
                }

                current.put(paramName, paramType);
            }
        }

        // analizza semanticamente il corpo della funzione
        visitCom(ctx.com());

        // rimuove lo scope locale
        exitScope();

        // ripristina il tipo di ritorno precedente
        currentReturnType = oldReturnType;

        return ComType.INSTANCE;
    }

    // calcola l'espressione del return e verifica che sia compatibile con la firma della funzione
    @Override
    public ComType visitReturn(TypedImpCastParser.ReturnContext ctx) {
        if (currentReturnType == null) {
            throw new RuntimeException("Return outside function.");
        }

        ExpType actualType = (ExpType) visit(ctx.exp());

        if (!currentReturnType.isCompatible(actualType)) {
            throw new RuntimeException("Invalid return type. Expected "
                    + currentReturnType + " but found " + actualType + ".");
        }

        return ComType.INSTANCE;
    }

    @Override
    public ExpType visitFunCall(TypedImpCastParser.FunCallContext ctx) {
        // recupera il nome della funzione chiamata
        String name = ctx.ID().getText();

        // controlla che la funzione chiamata sia dichiarata
        if (!functions.containsKey(name)) {
            throw new RuntimeException("Function " + name + " not declared.");
        }

        // recupera dalla mappa la dichiarazione della funzione
        TypedImpCastParser.FunDeclContext fun = functions.get(name);

        // calcola il numero di parametri attesi e il numero di parametri passati
        int expectedArgs = fun.params() == null ? 0 : fun.params().param().size();
        int actualArgs = ctx.args() == null ? 0 : ctx.args().exp().size();

        // controlla che il numero di argomenti coincida
        if (expectedArgs != actualArgs) {
            throw new RuntimeException("Function " + name + " expects "
                    + expectedArgs + " arguments but found " + actualArgs + ".");
        }

        // controlla uno per uno gli argomenti della chiamata
        for (int i = 0; i < expectedArgs; i++) {
            TypedImpCastParser.ParamContext param = fun.params().param(i);

            ExpType expectedType = TypeUtils.fromString(param.TYPE().getText());
            ExpType actualType = (ExpType) visit(ctx.args().exp(i));

            // controlla che il tipo atteso e il tipo effettivo degli argomenti coincidano
            if (!actualType.equals(expectedType)) {
                throw new RuntimeException("Invalid argument type in function "
                        + name + ". Expected " + expectedType
                        + " but found " + actualType + ".");
            }

            // caso in cui l'argomento viene passato per riferimento, deve essere una variabile e non un'espressione generica
            if (param.paramMode().REF() != null) {
                if (!(ctx.args().exp(i) instanceof TypedImpCastParser.IdContext)) {
                    throw new RuntimeException("Reference parameter requires a variable.");
                }
            }
        }

        // il tipo della chiamata è il tipo di ritorno dichiarato dalla funzione
        return TypeUtils.fromString(fun.TYPE().getText());
    }
}
