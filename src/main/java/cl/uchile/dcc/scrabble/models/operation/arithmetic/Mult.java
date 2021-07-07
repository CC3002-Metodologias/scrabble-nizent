package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class Mult implements ArithmeticOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Mult){
            Mult op = (Mult) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    public Mult(OperableEntity leftOperation, OperableEntity rightOperation){
        this.leftEntity = leftOperation;
        this.rightEntity = rightOperation;
    }

    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().mult(
                this.rightEntity.evaluate()
        );
    }

    @Override
    public String toString(){
        return "Mult{" + leftEntity.toString() + ", " + rightEntity.toString() + "}";
    }
}
