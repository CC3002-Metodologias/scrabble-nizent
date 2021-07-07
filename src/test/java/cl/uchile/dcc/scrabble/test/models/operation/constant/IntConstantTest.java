package cl.uchile.dcc.scrabble.test.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntConstantTest {
    IntConstant constant;
    int value;

    @BeforeEach
    void setUp(){
        value = 100;
        constant = new IntConstant(new ScrabbleInt(value));
    }

    @Test
    void constructorTest(){
        assertEquals(new IntConstant(new ScrabbleInt(value)), constant);
        assertNotEquals(new IntConstant(new ScrabbleInt(value + 1)),
                constant);
        assertFalse(constant.equals("Hi"));
        assertEquals((new IntConstant(new ScrabbleInt(value))).hashCode(),
                constant.hashCode());
    }

    @Test
    void valueTest() {
        assertEquals(new ScrabbleInt(value), constant.value());
    }

    @Test
    void addToBinTest(){
        assertEquals(new BinConstant(constant.value().transformToScrabbleBinary()),
                constant.addToBin(new BinConstant(new ScrabbleBinary("0"))));
    }

    @Test
    void addToStringTest(){
        assertEquals(new StringConstant((new ScrabbleString(value+""))),
                constant.addToString(new StringConstant(new ScrabbleString(""))));
    }

    @Test
    void addTest(){
        assertEquals(new IntConstant(new ScrabbleInt(value+2)),
                constant.add(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value+2)),
                constant.add(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new IntConstant(new ScrabbleInt(value+1)),
                constant.add(new BinConstant(new ScrabbleBinary("01"))));
        assertNull(constant.add(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.add(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void subToBinTest(){
        assertEquals(new BinConstant(new ScrabbleInt(-value).transformToScrabbleBinary()),
                constant.subToBin(new BinConstant(new ScrabbleBinary("0"))));
    }

    @Test
    void subTest(){
        assertEquals(new IntConstant(new ScrabbleInt(value-2)),
                constant.sub(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value-2)),
                constant.sub(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new IntConstant(new ScrabbleInt(value-1)),
                constant.sub(new BinConstant(new ScrabbleBinary("01"))));
        assertNull(constant.sub(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.sub(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void multToBinTest(){
        assertEquals(new BinConstant(constant.value().transformToScrabbleBinary()),
                constant.multToBin(new BinConstant(new ScrabbleBinary("01"))));
    }

    @Test
    void multTest(){
        assertEquals(new IntConstant(new ScrabbleInt(2*value)),
                constant.mult(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(2*value)),
                constant.mult(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(constant,
                constant.mult(new BinConstant(new ScrabbleBinary("01"))));
        assertNull(constant.mult(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.mult(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void divToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("0")),
                constant.divToBin(new BinConstant(new ScrabbleBinary("01"))));
    }

    @Test
    void addToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(value+2)),
                constant.addToInt(new IntConstant(new ScrabbleInt(2))));
    }

    @Test
    void subToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(5-value)),
                constant.subToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void multToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(value*5)),
                constant.multToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void divToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(5/value)),
                constant.divToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void addToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(value+5)),
                constant.addToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void subToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(5-value)),
                constant.subToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void multToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(5*value)),
                constant.multToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void divToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(1)),
                constant.divToFloat(new FloatConstant(new ScrabbleFloat(value))));
    }

    @Test
    void divTest(){
        assertEquals(new IntConstant(new ScrabbleInt(value/2)),
                constant.div(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value+2)),
                constant.add(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(constant,
                constant.div(new BinConstant(new ScrabbleBinary("01"))));
        assertNull(constant.div(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.div(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void andToBinTest(){
        assertNull(constant.andToBin(new BinConstant(new ScrabbleBinary("1"))));
    }

    @Test
    void andToBoolTest(){
        assertNull(constant.andToBool(new BoolConstant(new ScrabbleBool(true))));
    }

    @Test
    void andTest(){
        assertNull(constant.and(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.and(new FloatConstant(new ScrabbleFloat(2))));
        assertNull(constant.and(constant));
        assertNull(constant.and(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.and(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void orToBinTest(){
        assertNull(constant.orToBin(new BinConstant(new ScrabbleBinary("1"))));
    }

    @Test
    void orToBoolTest(){
        assertNull(constant.orToBool(new BoolConstant(new ScrabbleBool(true))));
    }

    @Test
    void orTest(){
        assertNull(constant.or(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.or(new FloatConstant(new ScrabbleFloat(2))));
        assertNull(constant.or(constant));
        assertNull(constant.or(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.or(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void negateTest(){
        assertNull(constant.negate());
    }

    @Test
    void evaluateTest(){
        assertEquals(constant, constant.evaluate());
    }

    @Test
    void toStringTest(){
        assertEquals("SInt(100)", constant.toString());
    }
}