package it.univr.pl;

import it.univr.pl.type.ErrType;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TypedImpCastIntpTest {
    private static final String PROG =
            """
            int x = 1;
            if (x == 1) {
                int x = 2;
                print toStr(x)
            };
            print toStr(x)
            """;
    /*// scope.tic
                int x = 1;
                if (true) {
                  int y = 2;
                  print toStr(y)
                };
            print toStr(y)
            // runtime_error.tic
                int x;
                print toStr(x)*/
    public static void main(String[] args) {
        ParseTree tree = runTS(PROG);
        if (tree != null) {
            Mem res = runIntp(tree);
            if (res != null) {
                System.out.println(res);
            }
        } else
            System.out.println("Typing error(s).");
    }

    private static ParseTree runTS(String prog) {
        CharStream cs = CharStreams.fromString(prog);
        TypedImpCastLexer lexer = new TypedImpCastLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypedImpCastParser parser = new TypedImpCastParser(tokens);
        ParseTree tree = parser.main();
        TypedImpCastTS typeSystem = new TypedImpCastTS();
        return typeSystem.visit(tree) != ErrType.INSTANCE ? tree : null;
    }

    private static Mem runIntp(ParseTree tree) {
        TypedImpCastIntp interpreter = new TypedImpCastIntp();
        try {
            interpreter.visit(tree);
            return interpreter.getMem();
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
            return null;
        }
    }
}
