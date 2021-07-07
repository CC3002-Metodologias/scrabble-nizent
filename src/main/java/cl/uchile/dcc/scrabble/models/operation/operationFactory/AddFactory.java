package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;

public class AddFactory implements ArithmeticOperationFactory {
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Add(operand1, operand2);
    }
}