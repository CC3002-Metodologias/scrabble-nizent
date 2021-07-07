package cl.uchile.dcc.scrabble.models.operation;

import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public interface OperableEntity {
    /**
     * Returns the scrabble value
     * @return value
     */
    Constant evaluate();
}
