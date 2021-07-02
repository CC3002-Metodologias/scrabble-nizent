package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;

public interface ArithmeticOperationFactory {
    ArithmeticOperation create(OperableEntity operand1, OperableEntity operand2);
}
