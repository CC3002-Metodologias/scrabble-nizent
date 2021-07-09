package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;

/**
 * Represents a factory that can create subtraction operations
 */
public class SubFactory implements ArithmeticOperationFactory{

    /**
     * Creates a new subtraction
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Sub(operand1, operand2);
    }
}
