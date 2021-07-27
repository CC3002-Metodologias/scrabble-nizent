package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents a multiplication
 * Uses composite pattern
 */
public class Mult implements ArithmeticOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    /**
     * Checks if the operaation is equals to an object
     * @param obj the object
     * @return true if equals the object
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Mult){
            Mult op = (Mult) obj;
            return op.leftEntity.equals(this.leftEntity) &
                    op.rightEntity.equals(this.rightEntity);
        }
        return false;
    }

    /**
     * Gets the hashCode of the tree
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Creates a new Mult object
     * @param leftOperand left entity
     * @param rightOperand right entity
     */
    public Mult(OperableEntity leftOperand, OperableEntity rightOperand){
        this.leftEntity = leftOperand;
        this.rightEntity = rightOperand;
    }

    /**
     * Evaluates the operation
     * @return the result of operation
     */
    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().mult(
                this.rightEntity.evaluate()
        );
    }

    /**
     * Transforms the tree into a String
     * @return a String that represents the operation
     */
    @Override
    public String toString(){
        return "Mult{" + leftEntity.toString() + ", " + rightEntity.toString() + "}";
    }
}