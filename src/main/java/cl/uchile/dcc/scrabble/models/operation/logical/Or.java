package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents an or logical operation
 * Uses composite pattern
 */
public class Or implements LogicalOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    /**
     * Checks equality with an object
     * @param obj the object
     * @return true if object and or operation are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Or){
            Or op = (Or) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    /**
     * Returns the hashCode of the operation
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Gets a String representation of the or operation
     * @return a String that represents the operation
     */
    @Override
    public String toString(){
        return "Or{" + leftEntity.toString() + ", " + rightEntity.toString()  + "}";
    }

    /**
     * Creates a new Or object
     * @param leftOperation the left operand
     * @param rightOperation the right operand
     */
    public Or(OperableEntity leftOperation, OperableEntity rightOperation){
        this.leftEntity = leftOperation;
        this.rightEntity = rightOperation;
    }

    /**
     * Evaluates the or operation
     * @return the result of the operation
     */
    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().or(
                this.rightEntity.evaluate()
        );
    }
}
