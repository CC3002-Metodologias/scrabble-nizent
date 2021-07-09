package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;

/**
 * Represents a factory that can create Or operations
 */
public class OrFactory implements LogicalOperationFactory{

    /**
     * Creates a new or logical operation
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    @Override
    public LogicalOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Or(operand1, operand2);
    }
}
