package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Mult;

/**
 * Represents a factory that can create multiplication operations
 */
public class MultFactory implements ArithmeticOperationFactory {

    /**
     * Creates a new multiplication
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Mult(operand1, operand2);
    }
}
