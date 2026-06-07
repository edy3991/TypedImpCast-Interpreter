package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainTypedImpCast {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Usage: java MainTypedImpCast <file>");
            return;
        }

        if (!args[0].endsWith(".lpext")) {
            System.err.println("Expected .lpext file");
            return;
        }

        String program = Files.readString(Path.of(args[0]));

        CharStream cs = CharStreams.fromString(program);

        TypedImpCastLexer lexer = new TypedImpCastLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypedImpCastParser parser = new TypedImpCastParser(tokens);

        ParseTree tree = parser.main();

        TypedImpCastTS typeSystem = new TypedImpCastTS();

        try {
            typeSystem.visit(tree);

            TypedImpCastIntp interpreter = new TypedImpCastIntp();
            interpreter.visit(tree);

        } catch (RuntimeException re) {
            System.err.println("Error found.");
            System.err.println(re.getMessage());
        }
    }
}
