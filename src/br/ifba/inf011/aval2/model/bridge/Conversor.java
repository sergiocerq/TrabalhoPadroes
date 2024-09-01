package br.ifba.inf011.aval2.model.bridge;

//Implementor no Bridge
public abstract class Conversor {
    public abstract String encode(String string);
    public abstract String decode(String string);
}
