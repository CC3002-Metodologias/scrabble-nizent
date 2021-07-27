package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Mult;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;

/**
 * Represents an operation tree
 */
public class AST {
    private final String type;
    private OperableEntity operableEntity = null;
    private AST left;
    private AST right;

    /**
     * Constructs a new AST
     * @param type the AST type (String, Add, ...)
     */
    public AST(String type){
        this.type = type;
    }

    /**
     * Gets the type of the AST
     * @return type
     */
    public String getType(){
        return this.type;
    }

    /**
     * Sets the main entity
     * @param operableEntity main entity
     */
    public void setMainEntity(OperableEntity operableEntity){
        this.operableEntity = operableEntity;
    }

    /**
     * Gets the main entity
     */
    public OperableEntity getMainEntity(){
        return this.operableEntity;
    }

    /**
     * Gets the left operand
     * @return left operand
     */
    public AST getLeft(){
        return left;
    }

    /**
     * Gets the right operand
     * @return right operand
     */
    public AST getRight(){
        return right;
    }

    /**
     * Set left operand
     * @param left operand
     */
    public void setLeft(AST left){
        this.left = left;
    }

    /**
     * Set right operand
     * @param right operand
     */
    public void setRight(AST right){
        this.right = right;
    }

    /**
     * Evaluates the AST
     * @return the constant result
     */
    public Constant evaluate(){
        switch (type) {
            case ScrabbleTypes.ADD_ID:
                return (new Add(left.evaluate(), right.evaluate())).evaluate();
            case ScrabbleTypes.SUB_ID:
                return (new Sub(left.evaluate(), right.evaluate())).evaluate();
            case ScrabbleTypes.MULT_ID:
                return (new Mult(left.evaluate(), right.evaluate())).evaluate();
            case ScrabbleTypes.DIV_ID:
                return (new Div(left.evaluate(), right.evaluate())).evaluate();
            case ScrabbleTypes.AND_ID:
                return (new And(left.evaluate(), right.evaluate())).evaluate();
            case ScrabbleTypes.OR_ID:
                return (new Or(left.evaluate(), right.evaluate())).evaluate();
            case ScrabbleTypes.NOT_ID:
                return (new Not(left.evaluate())).evaluate();
            default:
                return operableEntity.evaluate();
        }
    }
}
