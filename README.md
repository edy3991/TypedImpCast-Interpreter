# TypedImpCastExt — Java & ANTLR Interpreter

TypedImpCastExt is a statically and strongly typed imperative programming language implemented in **Java** using **ANTLR4**. The project includes both a **static type checker** and a **tree-walking interpreter** capable of executing programs written in the language.

For compatibility with the original project structure, the ANTLR grammar retains the technical name `TypedImpCast` (`TypedImpCast.g4`). Source programs use the `.lpext` extension.

The interpreter supports four primitive types (`int`, `dec`, `bool`, and `string`), expressions, control flow, lexical scoping, functions, and several additional language features.

## Features

- Variable declarations, initialization, and assignments
- Static type checking and explicit type conversions
- `if` / `if-else` conditionals and `while` loops
- Arithmetic, comparison, and Boolean expressions
- Lexical scopes and variable shadowing
- Prefix and postfix increment/decrement (`++`, `--`)
- Compound assignments (`+=`, `-=`, `*=`, `/=`)
- Ternary expressions (`condition ? a : b`)
- String concatenation and expression interpolation (`${...}`)
- Functions with mandatory return values
- Pass-by-value and pass-by-reference parameters
- Recursive functions

## Quick Start

### Requirements

- **Java 17 or later**
- **Apache Maven**
- **ANTLR 4.13.2** (used by the project for lexer and parser generation)

You can open the project in **IntelliJ IDEA** or run the Maven commands directly in a terminal. Run the commands from the project directory containing `pom.xml`.

### Compile

Generate the ANTLR lexer and parser and compile the Java sources:

```bash
mvn clean compile
```

### Run a program

```bash
mvn exec:java -Dexec.mainClass="it.univr.pl.MainTypedImpCast" -Dexec.args="programs/PROGRAM_NAME.lpext"
```

Replace `PROGRAM_NAME` with the name of a program in the `programs/` directory. For example:

```bash
mvn exec:java -Dexec.mainClass="it.univr.pl.MainTypedImpCast" -Dexec.args="programs/fact.lpext"
```

The entry point expects files with the **`.lpext`** extension. If the extension is not valid, the application reports:

```text
Expected .lpext file
```

### A first example

A simple expression in TypedImpCastExt:

```text
int x = 5;
int y = 3;
print(toStr(x + y))
```

Expected output:

```text
8
```

> This is a short language snippet. The full program structure, including `main`, is shown in the function examples below.

---

## Language Syntax

The syntax is defined by the ANTLR grammar in `TypedImpCast.g4`.

### Primitive types

| Type | Meaning |
| --- | --- |
| `int` | Integer values |
| `dec` | Decimal values |
| `bool` | Boolean values |
| `string` | Character strings |

### Statements

The language supports the following statement forms (notation is illustrative):

```text
TYPE ID = exp                    // Declaration with initialization
TYPE ID                          // Declaration without initialization
ID = exp                         // Assignment
print exp                        // Output
if (exp) { com }                 // Conditional
if (exp) { com } else { com }    // Conditional with else
while (exp) { com }              // Loop
nop                              // No-op
com ; com                        // Statement sequence
return exp                       // Return a value from a function
```

### Expressions

Supported expression forms include:

- Integer and decimal literals, `true` / `false`, string literals, and identifiers
- Arithmetic: `+`, `-`, `*`, `/`, `mod`, `^`
- Comparisons: `<`, `<=`, `>`, `>=`, `==`, `!=`
- Boolean operators: `and`, `or`, `not`
- Explicit casts and `toStr(exp)`
- String concatenation
- Ternary expressions: `condition ? expression1 : expression2`
- Function calls

### Syntactic sugar

Prefix and postfix operators:

```text
x++    // Post-increment
++x    // Pre-increment
x--    // Post-decrement
--x    // Pre-decrement
```

Compound assignments:

```text
x += exp
x -= exp
x *= exp
x /= exp
```

They have the same assignment effect as their expanded forms:

```text
x += 5    // x = x + 5
x -= 5    // x = x - 5
x *= 5    // x = x * 5
x /= 5    // x = x / 5
```

### String interpolation

Expressions can be embedded in strings using `${...}`:

```text
"Risultato: ${x + y}"
```

The interpreter evaluates the embedded expression and inserts its result into the string.

### Functions

TypedImpCastExt supports function declarations, calls, parameters, and mandatory return values. Functions are declared before the `main` block, in a section that is not executed until a function is called.

General structure:

```text
fun TYPE functionName(parameters) {
    statements
}

main {
    statements
}
```

Parameters can be passed **by value** or **by reference**:

```text
val TYPE x
ref TYPE x
```

Passing by value provides the function with a copy of the argument's value. Changes to the formal parameter do not modify the caller's original variable. Passing by reference allows the function to modify the caller's variable.

Example:

```text
fun int cambiav(val int x) {
    x = 100;
    return x
}

fun int cambiar(ref int x) {
    x = 100;
    return x
}

main {
    int a = 5;
    print toStr(cambiav(a));
    print toStr(a);

    int b = 9;
    print toStr(cambiar(b));
    print toStr(b)
}
```

Expected output:

```text
100
5
100
100
```

### Recursive functions

Recursion is supported. This example computes the factorial of 5:

```text
fun int fact(val int n) {
    if (n == 0) {
        return 1
    } else {
        return n * fact(n - 1)
    }
}

main {
    print toStr(fact(5))
}
```

Expected output:

```text
120
```

### Statement separators

In the grammar, a statement sequence is represented as `com ; com`. A semicolon **separates** consecutive statements, but is not required after the final statement in a program or block.

---

## Language Semantics

### Static typing

Before execution, a dedicated visitor checks declarations, assignments, and expression types. Each expression's type is determined statically.

For example, the following code is rejected:

```text
int x = 5;
x = "ciao"
```

A variable of type `int` cannot be assigned a `string` value.

### Environments, lexical scope, and shadowing

Runtime memory is organized as a **stack of environments**. Each environment maps identifiers to values. A new environment is created when entering a nested block, and removed upon leaving it.

This supports shadowing:

```text
int x = 1;
if (true) {
    int x = 2;
    print(toStr(x))
};
print(toStr(x))
```

Expected output:

```text
2
1
```

The inner `x` temporarily hides the outer variable; once the nested block ends, the outer `x` becomes visible again.

Variables declared inside a block are not visible outside it. For example:

```text
if (true) {
    int y = 2;
    print(toStr(y))
};
print(toStr(y))
```

This program reports an error because `y` is not declared in the outer scope.

### Expression evaluation

The interpreter evaluates expressions by visiting the parse tree. Arithmetic operates on numeric values, Boolean operators on Boolean values, and string concatenation on strings.

The ternary expression:

```text
condition ? expression1 : expression2
```

first evaluates `condition`. If it is `true`, the first expression is selected; otherwise, the second is selected.

### Explicit conversions

The language provides explicit casts:

```text
(int) exp
(dec) exp
(string) exp
(bool) exp
```

The `toStr(exp)` operation converts an expression's value into a string.

### Error handling

Examples of errors detected by the language implementation include:

- Undeclared variables
- Duplicate declarations in the same scope
- Assignments between incompatible types
- Non-Boolean conditions in `if` and `while`
- Operators applied to incompatible operand types
- Use of uninitialized variables

Type errors are detected by the static type checker before execution; runtime errors are handled by the interpreter.

---

## Implementation

### ANTLR lexer and parser

The `TypedImpCast.g4` grammar defines both lexical and syntactic rules. ANTLR4 generates the lexer, parser, and visitor interfaces from this file.

The **lexer** converts source code into tokens such as identifiers, literals, keywords, and operators. The **parser** verifies that the token stream follows the language grammar and constructs a parse tree.

### Visitor-based architecture

Two main visitors process the parse tree:

| Component | Responsibility |
| --- | --- |
| `TypedImpCastTS` | Static type checking before execution |
| `TypedImpCastIntp` | Program interpretation after type checking |

This separates the validation of program types from their runtime behavior.

### Memory management

The `Mem` class models runtime memory as a stack of environments, implemented using a list of maps. Each map represents one scope and associates variable names with their values.

Variable lookup starts in the innermost environment and proceeds outward, allowing lexical scoping and shadowing.

### Types and runtime values

The `type` package defines classes and interfaces representing static types, including `SimpleType`, `ExpType`, and `ComType`.

The `value` package defines runtime values, including `IntValue`, `DecValue`, `BoolValue`, and `StringValue`.

Keeping these concerns separate makes the distinction between type checking and execution explicit.

### Implemented extensions

Beyond the original language features, the project implements:

- Lexical scoping and variable shadowing
- Prefix/postfix increment and decrement
- Compound assignments
- Ternary expressions
- String expression interpolation
- Functions with parameters and return values
- Pass-by-value and pass-by-reference parameters
- Recursive functions

### Implementation challenges

**Variable shadowing.** Initially, runtime memory and the type checker relied on a single global map for variable names and their types or values. This could not distinguish variables with the same identifier in different scopes. The solution was a stack of maps: a new environment is pushed on block entry and popped on exit, while lookup searches from the innermost scope outward.

**String interpolation.** To evaluate strings such as:

```text
"Risultato: ${x + y}"
```

the interpreter identifies the content between `${` and `}`, interprets it as a language expression, and substitutes the evaluated result into the final string.

**Functions and recursion.** Functions are not executed when declared. Instead, their names are stored in a global map along with the corresponding declaration nodes from the parse tree. On each function call, the interpreter retrieves the definition, evaluates the arguments, creates a new call environment, and binds formal parameters to supplied values. Each recursive call receives its own environment.

**Return statements.** The interpreter uses an internal exception to implement `return`. When a return statement is encountered, it raises an exception carrying the return value. This immediately stops execution of the function body and propagates the value back to the call site.

**Pass-by-reference behavior.** The interpreter maintains the association between a formal reference parameter and the caller's variable. At the end of the call, the parameter's final value is copied back to the original variable, allowing the function to modify it.

---

## Example Programs and Expected Output

Example `.lpext` programs are available in the `programs/` directory. The output text below preserves the strings used in the original example programs.

### 1. Scope and shadowing

File: `programs/scope_shadowing.lpext`

Demonstrates `if-else`, local scope, and shadowing.

```text
valore iniziale:
10
x interna:
100
x esterna:
10
```

### 2. Arithmetic and compound calculations

File: `programs/aritmetica_composta.lpext`

Demonstrates basic arithmetic and compound calculations.

```text
somma:
13
potenza:
100
valore finale:
26
risultato = 26
```

### 3. While loops and syntactic sugar

File: `programs/while_ternario.lpext`

Demonstrates a `while` loop and a ternary expression.

```text
somma:
15
somma maggiore di 10
```

### 4. Complete program

File: `programs/programma_completo.lpext`

A more comprehensive program combining several language constructs.

```text
studente: edoardo
voto: 27
esame superato
senza lode
```

### 5. Pass-by-value and pass-by-reference

File: `programs/fun_v_r.lpext`

Demonstrates the difference between value and reference parameters.

```text
100
5
100
100
```

### 6. Recursive factorial

File: `programs/fact.lpext`

Demonstrates recursion using factorial calculation.

```text
120
```

---

## Project Context

TypedImpCastExt is a university language implementation project focused on language design, static semantics, and interpretation. Its main learning objectives include grammar design with ANTLR, the Visitor pattern, environment management, type checking, and function-call semantics.

This documentation is adapted into English from the original project notes. The commands, examples, and expected outputs reflect those notes; they have not been independently re-tested in this documentation update.
