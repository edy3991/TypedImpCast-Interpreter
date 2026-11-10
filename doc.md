# Introduzione

TypedImpCastExt è un linguaggio di programmazione imperativo e fortemente tipato. Per compatibilità con la struttura iniziale del progetto, il nome tecnico della grammatica ANTLR rimane TypedImpCast.

L'obiettivo principale del progetto è stato quello di progettare e implementare un interprete completo a partire da una grammatica ANTLR, realizzando sia il controllo statico dei tipi sia l'esecuzione dei programmi.

I tipi di dato supportati sono:

* `int` per numeri interi;
* `dec` per numeri decimali;
* `bool` per valori booleani;
* `string` per stringhe di caratteri.

Il linguaggio include inoltre costrutti tipici dei linguaggi imperativi moderni, quali:

* dichiarazione e assegnamento di variabili;
* istruzioni condizionali (`if`, `if-else`);
* cicli (`while`);
* conversione esplicita a stringa tramite `toStr`;
* concatenazione di stringhe;
* scope lessicale e shadowing delle variabili;
* operatori di incremento e decremento pre e postfissi;
* assegnamenti composti (`+=`, `-=`, `*=`, `/=`);
* operatore condizionale ternario.
* funzioni e funzioni ricorsive

L'implementazione è basata sul framework ANTLR4 per la generazione automatica di lexer e parser. L'analisi statica viene effettuata mediante un visitor dedicato al controllo dei tipi, mentre l'esecuzione dei programmi è affidata ad un secondo visitor che implementa la semantica operazionale del linguaggio.

# Guida Rapida

## Requisiti

Per compilare ed eseguire il progetto sono necessari:

* Java 17+;
* Apache Maven;
* ANTLR 4.13.2.

## Compilazione

Per compilare il progetto ed eseguire la generazione del lexer e del parser ANTLR, bisogna scrivere sul terminale di IntelliJ

```text
mvn clean compile
```

## Esecuzione

Per eseguire un programma è sufficiente scrivere:

```text
mvn exec:java -Dexec.mainClass="it.univr.pl.MainTypedImpCast" -Dexec.args="programs/NOME_PROGRAMMA.lpext"
```
Se il programma non è nel formato .lpext allora non viene accettato e darà errore.

```text
Expected .lpext file
```
## Primo Programma

```text
int x = 5;
int y = 3;
print(toStr(x + y))
```

Output:

```text
8
```

# Sintassi

TypedImpCastExt è un linguaggio imperativo tipato staticamente. La sintassi del linguaggio è definita tramite una grammatica ANTLR nel file `TypedImpCast.g4`.

## Tipi

Il linguaggio supporta quattro tipi primitivi:

```text
int
dec
bool
string
```

## Comandi

I principali comandi supportati sono:

```text
TYPE ID = exp        | dichiarazione con inizializzazione
TYPE ID              | dichiarazione senza inizializzazione
ID = exp             | assegnamento
print exp            | stampa
if (exp) { com }     | condizionale
if (exp) { com } else { com } 
while (exp) { com }  | ciclo
nop                  | comando vuoto
com ; com            | sequenza di comandi
return               | ritorno di una funzione
```

## Espressioni

Le espressioni includono:

```text
numeri interi e decimali
booleani true / false
stringhe
identificatori
operazioni aritmetiche + - * / mod ^
confronti < <= > >= == !=
operatori booleani and or not
cast espliciti
toStr(exp)
concatenazione di stringhe
operatore ternario cond ? exp1 : exp2
funzioni
```

## Zucchero sintattico

Il linguaggio estende la sintassi base con:

```text
x++    post-incremento
++x    pre-incremento
x--    post-decremento
--x    pre-decremento

x += exp
x -= exp
x *= exp
x /= exp
```

Gli assegnamenti composti sono equivalenti ai rispettivi assegnamenti semplici:

```text
x += 5  equivale a  x = x + 5
x -= 5  equivale a  x = x - 5
x *= 5  equivale a  x = x * 5
x /= 5  equivale a  x = x / 5
```

Il linguaggio supporta inoltre espressioni all’interno delle stringhe tramite interpolazione:

```text
"Risultato: ${x + y}"
```

## Funzioni

TypedImpCastExt supporta la definizione e la chiamata di funzioni con parametri e valore di ritorno obbligatorio. Le funzioni sono dichiarate prima del blocco `main` in una sezione non eseguibile del programma.

La sintassi generale è:

```text
fun TYPE nome(parametri) {
    comandi
}

main {
    comandi
}
```

I parametri possono essere passati per valore oppure per riferimento:

```text
val TYPE x
ref TYPE x
```

Il passaggio per valore crea una copia del valore passato alla funzione. Le modifiche al parametro formale non modificano la variabile originale.

Il passaggio per riferimento permette invece alla funzione di modificare direttamente la variabile passata come argomento. Concettualmente è simile all’uso di un puntatore: il parametro formale diventa collegato alla variabile originale.

Esempio:

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

Output atteso:

```text
100
5
100
100
```

Il linguaggio supporta anche funzioni ricorsive. Ad esempio:

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

Output atteso:

```text
120
```


## Limitazioni sintattiche

Nella grammatica la sequenza di comandi è rappresentata tramite `com ; com`. Di conseguenza il punto e virgola separa due comandi, ma non è richiesto dopo l’ultimo comando del programma o di un blocco.

# Semantica

TypedImpCastExt utilizza un controllo statico dei tipi. Prima dell’esecuzione, il programma viene visitato dal type checker, che verifica la correttezza delle dichiarazioni, degli assegnamenti e delle espressioni.

## Tipaggio

Il linguaggio è tipato staticamente: il tipo di ogni espressione viene determinato prima dell’esecuzione. Ad esempio, il programma seguente viene rifiutato:

```text
int x = 5;
x = "ciao"
```

perché una variabile di tipo `int` non può ricevere un valore di tipo `string`.

## Ambienti e scope

La memoria è organizzata come una pila di ambienti. Ogni ambiente associa identificatori a valori. Quando si entra in un blocco, come il corpo di un `if` o di un `while`, viene creato un nuovo ambiente; quando si esce dal blocco, l’ambiente viene rimosso.

Questo permette di gestire lo shadowing:

```text
int x = 1;
if (true) {
    int x = 2;
    print(toStr(x))
};
print(toStr(x))
```

Output:

```text
2
1
```

La variabile `x` interna nasconde temporaneamente quella esterna, ma al termine del blocco viene rimossa.

## Visibilità delle variabili

Una variabile dichiarata in uno scope interno non è visibile all’esterno:

```text
if (true) {
    int y = 2;
    print(toStr(y))
};
print(toStr(y))
```

Il programma produce un errore, perché `y` non è dichiarata nello scope globale.

## Valutazione delle espressioni

Le espressioni vengono valutate dall’interprete visitando il parse tree. Le operazioni aritmetiche sono definite su valori numerici, le operazioni booleane su valori booleani e la concatenazione su stringhe.

L’operatore ternario:

```text
cond ? exp1 : exp2
```

valuta `cond`; se il risultato è `true`, restituisce la valutazione di `exp1`, altrimenti restituisce la valutazione di `exp2`.

## Conversioni

Il linguaggio supporta conversioni esplicite tramite cast:

```text
(int) exp
(dec) exp
(string) exp
(bool) exp
```

La funzione `toStr(exp)` converte il valore di un’espressione in una stringa.

## Errori

Gli errori principali sono:

```text
variabile non dichiarata
variabile già dichiarata nello stesso scope
assegnamento con tipo incompatibile
uso di espressioni non booleane in if/while
uso di operatori su tipi non compatibili
uso di variabili non inizializzate
```

Gli errori di tipo vengono rilevati dal type checker prima dell’esecuzione, mentre gli errori di runtime vengono rilevati dall’interprete.

# Implementazione

L’implementazione di TypedImpCastExt è basata su ANTLR4. Il file `TypedImpCast.g4` definisce la grammatica del linguaggio, includendo sia le regole lessicali sia le regole sintattiche. A partire da questo file ANTLR genera automaticamente lexer, parser e visitor.

## Lexer e Parser

Il lexer suddivide il codice sorgente in token, come identificatori, numeri, parole chiave e operatori. Il parser riceve questi token e verifica che rispettino la grammatica del linguaggio, costruendo un parse tree.

## Visitor

Il progetto utilizza il pattern Visitor per attraversare il parse tree. Sono stati implementati due visitor principali:

```text
TypedImpCastTS
TypedImpCastIntp
```

`TypedImpCastTS` implementa il controllo statico dei tipi. Visita il parse tree prima dell’esecuzione e verifica che il programma sia ben tipato.

`TypedImpCastIntp` implementa l’interprete. Visita il parse tree dopo il controllo dei tipi ed esegue concretamente i comandi del programma.

## Memoria

La classe `Mem` rappresenta la memoria runtime del linguaggio. È stata estesa per supportare una pila di ambienti, implementata tramite una lista di mappe. Ogni mappa rappresenta uno scope e associa nomi di variabili ai rispettivi valori.

Questa scelta permette di gestire correttamente scope lessicale e shadowing.

## Gerarchia dei tipi

La cartella `type` contiene le classi e interfacce che rappresentano i tipi statici del linguaggio, come `SimpleType`, `ExpType` e `ComType`.

La cartella `value` contiene invece i valori runtime, come `IntValue`, `DecValue`, `BoolValue` e `StringValue`.

La separazione tra tipi e valori permette di distinguere chiaramente il controllo statico dall’esecuzione.

## Estensioni implementate

Il linguaggio è stato esteso con:

```text
scope lessicale
shadowing
operatori di incremento e decremento
assegnamenti composti
operatore ternario
interpolazione di espressioni nelle stringhe
funzioni con parametri e valore di ritorno
passaggio dei parametri per valore e per riferimento
funzioni ricorsive
```

Una difficoltà significativa è stata la gestione dello shadowing. Inizialmente la memoria e il type checker utilizzavano una singola mappa globale per associare i nomi delle variabili ai rispettivi tipi o valori. Questa soluzione non permetteva di distinguere correttamente variabili con lo stesso nome dichiarate in scope diversi.

La soluzione adottata è stata rappresentare gli ambienti tramite una pila di mappe. Ogni volta che l’interprete o il type checker entrano in un blocco, viene creato un nuovo ambiente; quando il blocco termina, l’ambiente viene rimosso. La ricerca di una variabile avviene partendo dallo scope più interno verso quello più esterno.

Un’altra difficoltà ha riguardato l’interpolazione delle espressioni nelle stringhe. Per supportare stringhe come:

```text
"Risultato: ${x + y}"
```

l’interprete analizza il contenuto della stringa, individua le parti comprese tra `${` e `}`, le interpreta come espressioni del linguaggio e sostituisce il risultato all’interno della stringa finale.

L’estensione più complessa è stata l’implementazione delle funzioni. Le funzioni non vengono eseguite nel momento in cui vengono dichiarate, ma vengono salvate in una mappa globale che associa il nome della funzione al nodo del parse tree corrispondente alla sua dichiarazione.

Quando viene incontrata una chiamata di funzione, l’interprete recupera la definizione dalla mappa, valuta gli argomenti, crea un nuovo ambiente per la chiamata e associa i parametri formali ai valori ricevuti. Questo meccanismo permette anche la ricorsione, perché ogni chiamata ricorsiva crea un nuovo ambiente indipendente.

Il comando `return` è stato implementato tramite un’eccezione interna. Quando l’interprete incontra un `return`, lancia un’eccezione contenente il valore restituito. In questo modo l’esecuzione del corpo della funzione viene interrotta immediatamente e il valore viene riportato al punto della chiamata.

Per il passaggio per riferimento, l’interprete mantiene un collegamento tra il parametro formale e la variabile originale passata come argomento. Alla fine della chiamata, il valore finale del parametro viene copiato nella variabile originale. In questo modo una funzione può modificare una variabile dichiarata dal chiamante.

# Programmi di Test

## Test 1 — Scope e Shadowing

File: `scope_shadowing.lpext`

Mostra `if-else`, scope locale e shadowing.

Output atteso:

```text
valore iniziale:
10
x interna:
100
x esterna:
10
```

## Test 2 — Aritmetica e Calcoli

File: `aritmetica_composta.lpext`

Calcoli aritmetici di base e calcoli composti.

Output atteso:
```text
somma:
13
potenza:
100
valore finale:
26
risultato = 26
```
## Test 3 — While e zucchero sintattico

File: `while_ternario.lpext`

Esecuzione di un while +  exp ? exp : exp

Output atteso:
```text
somma:
15
somma maggiore di 10
```

## Test 4 — Programma completo

File: `programma_completo.lpext`

Un esempio di un programma completo

Output atteso:
```text
studente: edoardo
voto: 27
esame superato
senza lode
```
## Test 5 — Passaggio per valore e riferimento

File: `fun_v_r.lpext`

Delle funzioni di base che usano i parametri attuali o come riferimento o come valori

Output atteso:
```text
100
5
100
100
```
## Test 6 — Funzione ricorsiva

File: `fact.lpext`

Classica funzione ricorsiva con i fattoriali

Output atteso:
```text
120
```