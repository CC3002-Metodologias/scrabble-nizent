package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;

/**
 * Represents a factory that creates arithmetic operations with 2 operands
 */
public interface ArithmeticOperationFactory {
    /**
     * Creates a new operation
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2);
}
