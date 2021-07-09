package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents a subtraction
 * Uses composite pattern
 */
public class Sub implements ArithmeticOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    /**
     * Checks equality with an object
     * @param obj the object
     * @return true if objects are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Sub){
            Sub op = (Sub) obj;
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
     * Creates a new Sub object
     * @param leftOperand left operand
     * @param rightOperand right operand
     */
    public Sub(OperableEntity leftOperand, OperableEntity rightOperand){
        this.leftEntity = leftOperand;
        this.rightEntity = rightOperand;
    }

    /**
     * Evaluates the operation
     * @return the subtraction result
     */
    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().sub(
                this.rightEntity.evaluate()
        );
    }

    /**
     * Gets the String representation of the operation
     * @return a String that represents the operation
     */
    @Override
    public String toString(){
        return "Sub{" + leftEntity.toString() + ", " + rightEntity.toString()  + "}";
    }
}
