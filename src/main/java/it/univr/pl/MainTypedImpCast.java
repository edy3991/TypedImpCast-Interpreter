package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainTypedImpCast {

    private static final String IN =
            """
            int v = 9;
            string s;
            dec x;
            int i = 0;
            while (i < 5) {
              v = v + 1;
              i = i + 1
            };
            if (false) {
              int j = 0;
              j = j + 1;
              i = i + 11
            } else {
              int f = 0;
              f = f - 1;
              print toStr(f);
              i = i + 9
            };
            print toStr(v);
            print toStr("hello \\\\ world");
            s = "3";
            print s : "  " : toStr(8.7);
            x = 3.1;
            print toStr(4 + x); // implicit upcast
            int k;
            k = (int) x; // explicit downcast
            print toStr(k)
            """;

    public static void main(String[] args) {
        String prog = IN;
        CharStream cs = CharStreams.fromString(prog);
        TypedImpCastLexer lexer = new TypedImpCastLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypedImpCastParser parser = new TypedImpCastParser(tokens);
        ParseTree tree = parser.main();
        TypedImpCastTS typeSystem = new TypedImpCastTS();
        try {
            typeSystem.visit(tree);
            TypedImpCastIntp interpreter = new TypedImpCastIntp();
            interpreter.visit(tree);
            //System.out.println(interpreter.getMem());
        } catch (RuntimeException re) {
            System.out.println("Typing error(s) found.");
            System.out.println(re.getMessage());
        }
    }
}
