package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;

public interface LogicalOperationFactory {
    LogicalOperation create(OperableEntity operand1, OperableEntity operand2);
}
