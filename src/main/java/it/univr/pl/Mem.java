package it.univr.pl;

import it.univr.pl.type.ExpType;
import it.univr.pl.type.TypeUtils;
import it.univr.pl.value.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Mem {

    // pila ambienti di valori
    private final List<Map<String, ExpValue<?>>> valuesEnv;
    // pila ambienti di tipi
    private final List<Map<String, ExpType>> typesEnv;

    public Mem() {
        valuesEnv = new ArrayList<>();
        typesEnv = new ArrayList<>();
        // crea lo scope globale iniziale
        valuesEnv.add(new HashMap<>());
        typesEnv.add(new HashMap<>());
    }

    public Mem(Mem mem) {
        valuesEnv = new ArrayList<>();
        typesEnv = new ArrayList<>();

        // copia tutti gli scope dei valori
        for (Map<String, ExpValue<?>> m : mem.valuesEnv)
            valuesEnv.add(new HashMap<>(m));

        // copia tutti gli scope dei tipi
        for (Map<String, ExpType> m : mem.typesEnv)
            typesEnv.add(new HashMap<>(m));
    }

    // entra in un nuovo blocco/funzione e aggiunge un ambiente in cima alla pila
    public void enterScope() {
        valuesEnv.add(new HashMap<>());
        typesEnv.add(new HashMap<>());
    }

    // esce dal blocco/funzione e toglie l'ambiente dalla cima della piola
    public void exitScope() {
        valuesEnv.remove(valuesEnv.size() - 1);
        typesEnv.remove(typesEnv.size() - 1);
    }

    // controlla se la variabile ha un valore associato
    public boolean contains(String id) {
        return getValue(id) != null;
    }

    // cerca il valore della variabile partendo dallo scope più interno verso quello globale
    public ExpValue<?> getValue(String id) {
        for (int i = valuesEnv.size() - 1; i >= 0; i--) {
            if (valuesEnv.get(i).containsKey(id)) {
                return valuesEnv.get(i).get(id);
            }
        }
        return null;
    }

    public ExpType getType(String id) {
        for (int i = typesEnv.size() - 1; i >= 0; i--) {
            if (typesEnv.get(i).containsKey(id)) {
                return typesEnv.get(i).get(id);
            }
        }
        return null;
    }

    // gestisce correttamente lo shadowing aggiornando il valore della variabile a partire dallo scope più interno
    public void updateValue(String id, ExpValue<?> value) {
        for (int i = valuesEnv.size() - 1; i >= 0; i--) {
            if (valuesEnv.get(i).containsKey(id)) {
                valuesEnv.get(i).put(id, value);
                return;
            }
        }
        throw new RuntimeException("Variable " + id + " not declared.");
    }

    // aggiunge una variabile inizializzata allo scope corrente
    public void add(String id, ExpValue<?> value) {
        Map<String, ExpValue<?>> currentValues = valuesEnv.get(valuesEnv.size() - 1);
        Map<String, ExpType> currentTypes = typesEnv.get(typesEnv.size() - 1);

        currentValues.put(id, value);
        currentTypes.put(id, TypeUtils.fromValue(value));
    }

    // aggiunge una variabile dichiarata ma non inizializzata, valore null ma tipo salvato
    public void add(String id, ExpType type) {
        Map<String, ExpValue<?>> currentValues = valuesEnv.get(valuesEnv.size() - 1);
        Map<String, ExpType> currentTypes = typesEnv.get(typesEnv.size() - 1);

        currentValues.put(id, null);
        currentTypes.put(id, type);
    }

    @Override
    public String toString() {
    // rappresentazione testuale degli ambienti attuali
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < valuesEnv.size(); i++) {
            sb.append("Scope ").append(i).append(": ");
            sb.append(valuesEnv.get(i));
            sb.append("\n");
        }

        return sb.toString();
    }
}