package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents the negation logical operation
 * Uses composite pattern
 */
public class Not implements LogicalOperation {
    private OperableEntity operableEntity;

    /**
     * Checks equality with an object
     * @param obj the objecto
     * @return true if the operation is equal to the object
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Not){
            Not op = (Not) obj;
            return op.operableEntity.equals(this.operableEntity);
        }
        return false;
    }

    /**
     * Gets the hashCode of the negation
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Gets a String representation of the negation
     * @return a String containing the representation of operation
     */
    @Override
    public String toString(){
        return "Not{" + operableEntity.toString() + "}";
    }

    /**
     * Creates a new Not object
     * @param operableEntity the entity
     */
    public Not(OperableEntity operableEntity){
        this.operableEntity = operableEntity;
    }

    /**
     * Evaluates the result of the negation
     * @return the result
     */
    @Override
    public Constant evaluate() {
        return this.operableEntity.evaluate().negate();
    }
}
