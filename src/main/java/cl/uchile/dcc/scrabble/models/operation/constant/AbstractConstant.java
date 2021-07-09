package cl.uchile.dcc.scrabble.models.operation.constant;

/**
 * Holds the common behavior of constants, this is the operations that can perform
 */
public abstract class AbstractConstant implements Constant {

    /**
     * Makes an addition with another constant
     * @param constant the other constant
     * @return null if the constant can't be used for addition
     */
    @Override
    public Constant add(Constant constant) {
        return null;
    }

    /**
     * Divides the constant by another constant
     * @param evaluate the other constant
     * @return null if the constant can't perform the division
     */
    @Override
    public Constant div(Constant evaluate) {
        return null;
    }

    /**
     * Multiplies the constant by another constant
     * @param evaluate the other constant
     * @return null if operation can't be performed
     */
    @Override
    public Constant mult(Constant evaluate) {
        return null;
    }

    /**
     * Subtracts the constant by another constant
     * @param evaluate the other constant
     * @return null if operation can't be performed
     */
    @Override
    public Constant sub(Constant evaluate) {
        return null;
    }

    /**
     * Makes a logical and operation with other constant
     * @param constant the other constant
     * @return null if the constant can't perform the operation
     */
    @Override
    public Constant and(Constant constant) {
        return null;
    }

    /**
     * Makes a logical or operation with other constant
     * @param constant the other constant
     * @return null if the constant can't perform the operation
     */
    @Override
    public Constant or(Constant constant) {
        return null;
    }

    /**
     * Makes a logical negation operation to the constant
     * @return null if the constant can't perform negation
     */
    @Override
    public Constant negate() {
        return null;
    }

    /**
     * Makes an addition with a BinConstant
     * @param binConstant the BinConstant
     * @return the result of addition
     */
    @Override
    public Constant addToBin(BinConstant binConstant) {
        return null;
    }

    /**
     * Subtracts to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToBin(BinConstant binConstant) {
        return null;
    }

    /**
     * Multiplies to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToBin(BinConstant binConstant) {
        return null;
    }

    /**
     * Divides a BinConstant
     * @param binConstant the BinConstant
     * @return the result of division
     */
    @Override
    public Constant divToBin(BinConstant binConstant) {
        return null;
    }

    /**
     * Makes an addition with an IntConstant
     * @param intConstant the IntConstant
     * @return the result of addition
     */
    @Override
    public Constant addToInt(IntConstant intConstant) {
        return null;
    }

    /**
     * Subtracts to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToInt(IntConstant intConstant) {
        return null;
    }

    /**
     * Multiplies to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToInt(IntConstant intConstant) {
        return null;
    }

    /**
     * Divides to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of division
     */
    @Override
    public Constant divToInt(IntConstant intConstant) {
        return null;
    }

    /**
     * Adds to an FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of addition
     */
    @Override
    public Constant addToFloat(FloatConstant floatConstant) {
        return null;
    }

    /**
     * Subtraction to an FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return null;
    }


    /**
     * Multiplies to an FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return null;
    }


    /**
     * Divides to an FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of division
     */
    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return null;
    }

    /**
     * Makes an and to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of and operation
     */
    @Override
    public Constant andToBin(BinConstant binConstant) {
        return null;
    }

    /**
     * Makes an or to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of or operation
     */
    @Override
    public Constant orToBin(BinConstant binConstant) {
        return null;
    }


    /**
     * Makes an or to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of or operation
     */
    @Override
    public Constant orToBool(BoolConstant boolConstant) {
        return null;
    }


    /**
     * Makes an and to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of and operation
     */
    @Override
    public Constant andToBool(BoolConstant boolConstant) {
        return null;
    }


    /**
     * Evaluates the constant
     * @return the constant
     */
    @Override
    public Constant evaluate() {
        return this;
    }
}
