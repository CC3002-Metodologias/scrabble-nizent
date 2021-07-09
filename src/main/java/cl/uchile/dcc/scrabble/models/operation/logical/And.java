package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents an and operation, for logical operands
 * Uses composite pattern
 */
public class And implements LogicalOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    /**
     * Checks equality with an object
     * @param obj the object
     * @return true if operation is equal to the object
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof And){
            And op = (And) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    /**
     * Gets the hashCode of the operation
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Gets a String representation of the and operation
     * @return a String that represents the and operation
     */
    @Override
    public String toString(){
        return "And{" + leftEntity.toString() + ", " + rightEntity.toString()  + "}";
    }

    /**
     * Creates a new And object
     * @param leftOperand the left operand
     * @param rightOperand the right operand
     */
    public And(OperableEntity leftOperand, OperableEntity rightOperand){
        this.leftEntity = leftOperand;
        this.rightEntity = rightOperand;
    }

    /**
     * Evaluates the and result
     * @return the operation result
     */
    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().and(
                this.rightEntity.evaluate()
        );
    }
}