package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class Or implements LogicalOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Or){
            Or op = (Or) obj;
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
        return "Or{" + leftEntity.toString() + ", " + rightEntity.toString()  + "}";
    }

    public Or(OperableEntity leftOperation, OperableEntity rightOperation){
        this.leftEntity = leftOperation;
        this.rightEntity = rightOperation;
    }

    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().or(
                this.rightEntity.evaluate()
        );
    }
}
