package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;

/**
 * Represents a factory that can create addition operations
 */
public class AddFactory implements ArithmeticOperationFactory {

    /**
     * Creates a new addition
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Add(operand1, operand2);
    }
}