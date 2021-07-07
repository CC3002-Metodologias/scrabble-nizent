package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;

public class SubFactory implements ArithmeticOperationFactory{
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Sub(operand1, operand2);
    }
}
