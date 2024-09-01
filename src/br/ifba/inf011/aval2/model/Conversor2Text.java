package br.ifba.inf011.aval2.model;

import br.ifba.inf011.aval2.model.bridge.Conversor;

//ConcreteImplementor
public class Conversor2Text extends Conversor {
    @Override
    public String encode(String string) {
        return string;
    }

    @Override
    public String decode(String string) {
        return string;
    }
}
