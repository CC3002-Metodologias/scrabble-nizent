package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.type.ScrabbleString;

public class StringConstant extends AbstractConstant{
    private ScrabbleString value;

    public StringConstant(ScrabbleString value) {
        this.value = value;
    }

    public ScrabbleString value(){
        return this.value;
    }

    @Override
    public Constant add(Constant constant) {
        return constant.addToString(this);
    }

    @Override
    public Constant addToString(StringConstant stringConstant) {
        return new StringConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant evaluate() {
        return new StringConstant(this.value);
    }
}