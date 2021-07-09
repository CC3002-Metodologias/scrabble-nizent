package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents a division operation
 * Uses composite pattern
 */
public class Div implements ArithmeticOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    /**
     * Checks equality with other object
     * @param obj the object
     * @return a boolean
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Div){
            Div op = (Div) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    /**
     * Returns the hashCode of the operation
     * @return the hash as an int
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Creates a new Div object
     * @param leftOperand the left entity
     * @param rightOperand the right entity
     */
    public Div(OperableEntity leftOperand, OperableEntity rightOperand){
        this.leftEntity = leftOperand;
        this.rightEntity = rightOperand;
    }

    /**
     * Evaluates the operation
     * @return the operation result
     */
    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().div(
                this.rightEntity.evaluate()
        );
    }

    /**
     * Transforms the operation to a String
     * @return a String representing the operation
     */
    @Override
    public String toString(){
        return "Div{" + leftEntity.toString() + ", " + rightEntity.toString() + "}";
    }
}
