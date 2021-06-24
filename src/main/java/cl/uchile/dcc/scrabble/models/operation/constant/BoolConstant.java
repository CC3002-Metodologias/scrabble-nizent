package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.type.IType;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;

public class BoolConstant extends AbstractConstant {
    private ScrabbleBool value;

    public BoolConstant(ScrabbleBool value){
        this.value = value;
    }

    public ScrabbleBool value() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof BoolConstant){
            BoolConstant boolConstant = (BoolConstant) obj;
            return boolConstant.value().equals(this.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public Constant andToBin(BinConstant binConstant) {
        return new BinConstant(this.value.andBinary(binConstant.value()));
    }

    @Override
    public Constant addToString(StringConstant stringConstant) {
        return new StringConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant orToBin(BinConstant binConstant) {
        return new BinConstant(this.value.orBinary(binConstant.value()));
    }

    @Override
    public Constant orToBool(BoolConstant boolConstant) {
        return new BoolConstant(this.value.orBool(boolConstant.value()));
    }

    @Override
    public Constant andToBool(BoolConstant boolConstant) {
        return new BoolConstant(this.value.andBool(boolConstant.value()));
    }

    @Override
    public Constant and(Constant constant){
        return constant.andToBool(this);
    }

    @Override
    public Constant or(Constant constant){
        return constant.orToBool(this);
    }

    @Override
    public Constant negate(){
        return new BoolConstant(this.value.negate());
    }

    @Override
    public Constant evaluate(){
        return new BoolConstant(this.value);
    }
}
