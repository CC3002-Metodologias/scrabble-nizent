package cl.uchile.dcc.scrabble.models.operation;

import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

/**
 * Represents a variable that can hold a constant value
 */
public class Variable implements OperableEntity {
    private final String name;
    private Constant constant;

    /**
     * Creates a new variable
     * @param name variable name
     */
    public Variable(String name){
        this.name = name;
    }

    /**
     * Asigns a constant to the variable
     * @param constant the constant
     */
    public void assign(Constant constant){
        this.constant = constant;
    }

    /**
     * Evaluates the variable
     * @return its constant
     */
    @Override
    public Constant evaluate() {
        return this.constant;
    }
}
