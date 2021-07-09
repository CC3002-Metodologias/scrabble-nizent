package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;

/**
 * This interface represents a Constant which its value never changes
 */
public interface Constant extends OperableEntity {
    /**
     * Makes an addition with another constant
     * @param constant the other constant
     * @return the result of addition
     */
    Constant add(Constant constant);

    /**
     * Divides the constant by another constant
     * @param evaluate the other constant
     * @return the result
     */
    Constant div(Constant evaluate);

    /**
     * Multiplies the constant by another constant
     * @param evaluate the other constant
     * @return the result
     */
    Constant mult(Constant evaluate);

    /**
     * Subtracts the constant by another constant
     * @param evaluate the other constant
     * @return the result
     */
    Constant sub(Constant evaluate);

    /**
     * Makes a logical and operation with other constant
     * @param constant the other constant
     * @return a constant containing the and result
     */
    Constant and(Constant constant);

    /**
     * Makes a logical or operation with other constant
     * @param constant the other constant
     * @return a constant containing the and result
     */
    Constant or(Constant constant);

    /**
     * Makes a logical negation operation to the constant
     * @return a constant containing the and result
     */
    Constant negate();

    /**
     * Concatenates the constant to a StringConstant
     * @param stringConstant the StringConstant
     * @return the StringConstant concatenated to this constant
     */
    Constant addToString(StringConstant stringConstant);

    /**
     * Makes an addition with a BinConstant
     * @param binConstant the BinConstant
     * @return the result of addition
     */
    Constant addToBin(BinConstant binConstant);

    /**
     * Subtracts to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of subtraction
     */
    Constant subToBin(BinConstant binConstant);

    /**
     * Multiplies to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of multiplication
     */
    Constant multToBin(BinConstant binConstant);

    /**
     * Divides a BinConstant
     * @param binConstant the BinConstant
     * @return the result of division
     */
    Constant divToBin(BinConstant binConstant);

    /**
     * Makes an addition with an IntConstant
     * @param intConstant the IntConstant
     * @return the result of addition
     */
    Constant addToInt(IntConstant intConstant);

    /**
     * Subtracts to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of subtraction
     */
    Constant subToInt(IntConstant intConstant);

    /**
     * Multiplies to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of multiplication
     */
    Constant multToInt(IntConstant intConstant);

    /**
     * Divides to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of division
     */
    Constant divToInt(IntConstant intConstant);

    /**
     * Adds to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of addition
     */
    Constant addToFloat(FloatConstant floatConstant);

    /**
     * Subtraction to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of subtraction
     */
    Constant subToFloat(FloatConstant floatConstant);

    /**
     * Multiplies to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of multiplication
     */
    Constant multToFloat(FloatConstant floatConstant);

    /**
     * Divides to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of division
     */
    Constant divToFloat(FloatConstant floatConstant);

    /**
     * Makes an and to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of and operation
     */
    Constant andToBin(BinConstant binConstant);

    /**
     * Makes an or to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of or operation
     */
    Constant orToBin(BinConstant binConstant);

    /**
     * Makes an or to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of or operation
     */
    Constant orToBool(BoolConstant boolConstant);

    /**
     * Makes an and to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of and operation
     */
    Constant andToBool(BoolConstant boolConstant);
}