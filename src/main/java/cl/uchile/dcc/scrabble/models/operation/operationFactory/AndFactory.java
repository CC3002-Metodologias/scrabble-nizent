package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;

/**
 * Represents a factory that can create And operations
 */
public class AndFactory implements LogicalOperationFactory{

    /**
     * Creates a new and logical operation
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    @Override
    public LogicalOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new And(operand1, operand2);
    }
}
