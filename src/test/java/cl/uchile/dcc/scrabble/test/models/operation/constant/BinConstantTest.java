package cl.uchile.dcc.scrabble.test.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinConstantTest {
    BinConstant constant;
    String value;

    @BeforeEach
    void setUp(){
        value = "0101";
        constant = new BinConstant(new ScrabbleBinary(value));
    }

    @Test
    void constructorTest(){
        assertEquals(new BinConstant(new ScrabbleBinary(value)), constant);
        assertNotEquals(new BinConstant(new ScrabbleBinary(value + "1")),
                constant);
        assertFalse(constant.equals("Hi"));
        assertEquals((new BinConstant(new ScrabbleBinary(value))).hashCode(),
                constant.hashCode());
    }

    @Test
    void valueTest() {
        assertEquals(new ScrabbleBinary(value), constant.value());
    }

    @Test
    void addToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("01010")),
                constant.addToBin(constant));
    }

    @Test
    void addToStringTest(){
        assertEquals(new StringConstant((new ScrabbleBinary(value)).transformToScrabbleString()),
                constant.addToString(new StringConstant(new ScrabbleString(""))));
    }

    @Test
    void addTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("0111")),
                constant.add(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.add(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new BinConstant(new ScrabbleBinary("01010")),
                constant.add(constant));
        assertNull(constant.add(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.add(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void subToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("0")),
                constant.subToBin(constant));

    }

    @Test
    void subTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("011")),
                constant.sub(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.sub(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new BinConstant(new ScrabbleBinary("0")),
                constant.sub(constant));
        assertNull(constant.sub(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.sub(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void multToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("011001")),
                constant.multToBin(constant));
    }

    @Test
    void multTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("01010")),
                constant.mult(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.mult(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new BinConstant(new ScrabbleBinary("011001")),
                constant.mult(constant));
        assertNull(constant.mult(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.mult(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void divToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("01")),
                constant.divToBin(constant));
    }

    @Test
    void addToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(7)),
                constant.addToInt(new IntConstant(new ScrabbleInt(2))));
    }

    @Test
    void subToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(0)),
                constant.subToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void multToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(25)),
                constant.multToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void divToIntTest() {
        assertEquals(new IntConstant(new ScrabbleInt(1)),
                constant.divToInt(new IntConstant(new ScrabbleInt(5))));
    }

    @Test
    void addToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(10)),
                constant.addToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void subToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(0)),
                constant.subToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void multToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(25)),
                constant.multToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void divToFloatTest() {
        assertEquals(new FloatConstant(new ScrabbleFloat(1)),
                constant.divToFloat(new FloatConstant(new ScrabbleFloat(5))));
    }

    @Test
    void divTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("010")),
                constant.div(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.add(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(new BinConstant(new ScrabbleBinary("01")),
                constant.div(constant));
        assertNull(constant.div(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.div(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void andToBinTest(){
        assertEquals(constant,
                constant.andToBin(constant));
    }

    @Test
    void andToBoolTest(){
        assertEquals(constant,
                constant.andToBool(new BoolConstant(new ScrabbleBool(true))));
    }

    @Test
    void andTest(){
        assertNull(constant.and(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.and(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(constant,
                constant.and(constant));
        assertEquals(constant, constant.and(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.and(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void orToBinTest(){
        assertEquals(constant,
                constant.orToBin(constant));
    }

    @Test
    void orToBoolTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                constant.orToBool(new BoolConstant(new ScrabbleBool(true))));
    }

    @Test
    void orTest(){
        assertNull(constant.or(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.or(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(constant,
                constant.or(constant));
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                constant.or(new BoolConstant(new ScrabbleBool(true))));
        assertNull(constant.or(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void negateTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("1010")),
                constant.negate());
    }
}
