package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;

/**
 * Represents a factory that creates a 2 factor logical operation
 */
public interface LogicalOperationFactory {
    /**
     * Creates a new logical operation
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    LogicalOperation create(OperableEntity operand1, OperableEntity operand2);
}
