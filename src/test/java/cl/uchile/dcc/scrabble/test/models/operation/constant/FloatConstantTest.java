package cl.uchile.dcc.scrabble.test.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloatConstantTest {
    FloatConstant constant;
    double value;

    @BeforeEach
    void setUp(){
        value = 100;
        constant = new FloatConstant(new ScrabbleFloat(value));
    }

    @Test
    void constructorTest(){
        assertEquals(new FloatConstant(new ScrabbleFloat(value)), constant);
        assertNotEquals(new FloatConstant(new ScrabbleFloat(value + 1)),
                constant);
        assertFalse(constant.equals("Hi"));
        assertEquals((new FloatConstant(new ScrabbleFloat(value))).hashCode(),
                constant.hashCode());
    }

    @Test
    void valueTest() {
        assertEquals(new ScrabbleFloat(value), constant.value());
    }

    @Test
    void addToBinTest(){
        assertNull(constant.addToBin(new BinConstant(new ScrabbleBinary("11"))));
    }

    @Test
    void addToStringTest(){
        assertEquals(new StringConstant((new ScrabbleString(value+""))),
                constant.addToString(new StringConstant(new ScrabbleString(""))));
    }

    @Test
    void addTest(){
        assertEquals(new FloatConstant(new ScrabbleFloat(value+2)),
                constant.add(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value+2)),
                constant.add(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value*2)),
                constant.add(constant));
        assertNull(constant.add(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.add(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void subToBinTest(){
        assertNull(constant.subToBin(new BinConstant(new ScrabbleBinary("0"))));
    }

    @Test
    void subTest(){
        assertEquals(new FloatConstant(new ScrabbleFloat(value-2)),
                constant.sub(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value-2)),
                constant.sub(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(0)),
                constant.sub(constant));
        assertNull(constant.sub(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.sub(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void multToBinTest(){
        assertNull(constant.multToBin(new BinConstant(new ScrabbleBinary("01"))));
    }

    @Test
    void multTest(){
        assertEquals(new FloatConstant(new ScrabbleFloat(2*value)),
                constant.mult(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(2*value)),
                constant.mult(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value*value)),
                constant.mult(constant));
        assertNull(constant.mult(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.mult(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void divToBinTest(){
        assertNull(constant.divToBin(new BinConstant(new ScrabbleBinary("01"))));
    }

    @Test
    void addToIntTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(102)),
                constant.addToInt(new IntConstant(new ScrabbleInt(2))));
    }

    @Test
    void subToIntTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(5-value)),
                constant.subToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void multToIntTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(value*5)),
                constant.multToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void divToIntTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(5/value)),
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
        assertEquals(new FloatConstant(new ScrabbleFloat(5/value)),
                constant.divToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void divTest(){
        assertEquals(new FloatConstant(new ScrabbleFloat(value/2)),
                constant.div(new IntConstant(new ScrabbleInt(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(value+2)),
                constant.add(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new FloatConstant(new ScrabbleFloat(1)),
                constant.div(constant));
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
        assertEquals("SFloat(100.0)", constant.toString());
    }
}
