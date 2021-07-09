package cl.uchile.dcc.scrabble.models.operation;

import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents operable entities. It is part of the composite pattern
 */
public interface OperableEntity {
    /**
     * Returns the scrabble value
     * @return value
     */
    Constant evaluate();
}
