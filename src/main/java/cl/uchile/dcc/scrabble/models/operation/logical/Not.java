package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class Not implements LogicalOperation {
    private OperableEntity operableEntity;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Not){
            Not op = (Not) obj;
            return op.operableEntity.equals(this.operableEntity);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    @Override
    public String toString(){
        return "Not{" + operableEntity.toString() + "}";
    }

    public Not(OperableEntity operableEntity){
        this.operableEntity = operableEntity;
    }

    @Override
    public Constant evaluate() {
        return this.operableEntity.evaluate().negate();
    }
}
