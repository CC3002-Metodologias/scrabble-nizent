package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;

/**
 * Represents an add operation
 */
public class Add implements ArithmeticOperation {
    private OperableEntity leftOperableEntity;
    private OperableEntity rightOperableEntity;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Add){
            Add add = (Add) obj;
            return add.leftOperableEntity.equals(this.leftOperableEntity) &
                    add.rightOperableEntity.equals(this.rightOperableEntity);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    public Add(OperableEntity leftOperableEntity, OperableEntity rightOperableEntity){
        this.leftOperableEntity = leftOperableEntity;
        this.rightOperableEntity = rightOperableEntity;
    }

    @Override
    public Constant evaluate() {
        return this.leftOperableEntity.evaluate().add(
                this.rightOperableEntity.evaluate()
        );
    }

    @Override
    public String toString(){
        return "Add{" + leftOperableEntity.toString() + ", " + rightOperableEntity.toString() + "}";
    }
}
