package cl.uchile.dcc.scrabble.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class And implements LogicalOperation {
    private OperableEntity leftEntity;
    private OperableEntity rightEntity;

    public And(OperableEntity leftOperation, OperableEntity rightOperation){
        this.leftEntity = leftOperation;
        this.rightEntity = rightOperation;
    }

    @Override
    public Constant evaluate() {
        return this.leftEntity.evaluate().and(
                this.rightEntity.evaluate()
        );
    }
}