package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class Not implements LogicalOperation {
    private OperableEntity operableEntity;

    public Not(OperableEntity operableEntity){
        this.operableEntity = operableEntity;
    }

    @Override
    public Constant evaluate() {
        return operableEntity.evaluate().negate();
    }
}
