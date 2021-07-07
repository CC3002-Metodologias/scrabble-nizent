package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class And implements LogicalOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof And){
            And op = (And) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    @Override
    public String toString(){
        return "And{" + leftEntity.toString() + ", " + rightEntity.toString()  + "}";
    }

    public And(OperableEntity leftOperation, OperableEntity rightOperation){
        this.leftEntity = leftOperation;
        this.rightEntity = rightOperation;
    }

    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().and(
                this.rightEntity.evaluate()
        );
    }
}