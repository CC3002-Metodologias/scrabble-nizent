package cl.uchile.dcc.scrabble.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;

public class AndFactory implements LogicalOperationFactory{
    @Override
    public LogicalOperation create(OperableEntity operand1, OperableEntity operand2) {
        return new And(operand1, operand2);
    }
}
