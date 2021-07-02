package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;

public class OrFactory implements LogicalOperationFactory{
    @Override
    public LogicalOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new Or(operand1, operand2);
    }
}
