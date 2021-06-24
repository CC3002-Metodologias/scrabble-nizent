package cl.uchile.dcc.scrabble.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents an add operation
 */
public class Add implements Operation {
    private OperableEntity leftOperableEntity;
    private OperableEntity rightOperableEntity;

    public Add(OperableEntity leftOperableEntity, OperableEntity rightOperableEntity){
        this.leftOperableEntity = leftOperableEntity;
        this.rightOperableEntity = rightOperableEntity;
    }

    @Override
    public Constant evaluate() {
        return this.leftOperableEntity.evaluate().add(
                this.rightOperableEntity.evaluate()
        );
    }
}