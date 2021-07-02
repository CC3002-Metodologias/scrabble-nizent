package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;

public class DivFactory implements ArithmeticOperationFactory{
    @Override
    public ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Div(operand1, operand2);
    }
}
