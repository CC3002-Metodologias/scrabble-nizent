package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;

/**
 * Represents a factory that can create division operations
 */
public class DivFactory implements ArithmeticOperationFactory{

    /**
     * Creates a new division
     * @param operand1 left operand
     * @param operand2 right operand
     * @return the operation
     */
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Div(operand1, operand2);
    }
}
