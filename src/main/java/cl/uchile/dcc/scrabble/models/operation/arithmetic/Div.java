package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class Div implements ArithmeticOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Div){
            Div op = (Div) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    public Div(OperableEntity leftOperation, OperableEntity rightOperation){
        this.leftEntity = leftOperation;
        this.rightEntity = rightOperation;
    }

    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().div(
                this.rightEntity.evaluate()
        );
    }

    @Override
    public String toString(){
        return "Div{" + leftEntity.toString() + ", " + rightEntity.toString() + "}";
    }
}
