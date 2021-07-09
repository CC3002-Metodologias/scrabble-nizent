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
 * Uses composite pattern
 */
public class Add implements ArithmeticOperation {
    private OperableEntity leftOperand;
    private OperableEntity rightOperand;

    /**
     * Checks if other object is equal to this operation
     * @param obj the object
     * @return a boolean
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Add){
            Add add = (Add) obj;
            return add.leftOperand.equals(this.leftOperand) &
                    add.rightOperand.equals(this.rightOperand);
        }
        return false;
    }

    /**
     * Returns the hashCode of the operation
     * @return
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Creates anew Add operation
     * @param leftOperableEntity left entity
     * @param rightOperableEntity right entity
     */
    public Add(OperableEntity leftOperableEntity, OperableEntity rightOperableEntity){
        this.leftOperand = leftOperableEntity;
        this.rightOperand = rightOperableEntity;
    }

    /**
     * Evaluates the operation
     * @return the result constant of the evaluation
     */
    @Override
    public Constant evaluate() {
        return this.leftOperand.evaluate().add(
                this.rightOperand.evaluate()
        );
    }

    /**
     * Transforms the operation tree to a string
     * @return a String representing the tree
     */
    @Override
    public String toString(){
        return "Add{" + leftOperand.toString() + ", " + rightOperand.toString() + "}";
    }
}
