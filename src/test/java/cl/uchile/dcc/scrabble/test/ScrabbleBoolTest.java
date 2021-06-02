package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBoolTest extends AbstractScrabbleTypeTest {
    private ScrabbleInt intTest;
    private ScrabbleBool falseBool;
    private ScrabbleBool trueBool;
    private ScrabbleBinary scrabbleBinary;
    private int intParam;
    private String binValue;
    private String binOrTrue;

    @BeforeEach
    public void setUp(){
        intParam = 89;
        intTest = new ScrabbleInt(intParam);
        falseBool = new ScrabbleBool(false);
        trueBool = new ScrabbleBool(true);
        binValue = "0111";
        binOrTrue = "1111";
        scrabbleBinary = new ScrabbleBinary(binValue);
    }

    @Test
    void constructorTest(){
        checkConstructor(falseBool, new ScrabbleBool(false),
                new ScrabbleBool(true),
                intTest);
        assertEquals((new ScrabbleBool(false)).hashCode(), falseBool.hashCode());
        assertNotEquals((new ScrabbleBool(true)).hashCode(), falseBool.hashCode());
    }

    @Test
    void ValueTest(){
        assertFalse(falseBool.Value());
    }

    @Test
    void setValueTest(){
        falseBool.setValue(true);
        assertTrue(falseBool.Value());
    }

    @Test
    void toStringTest(){
        assertEquals(Boolean.toString(false), falseBool.toString());
    }

    @Test
    void transformToScrabbleBoolTest(){
        assertEquals(new ScrabbleBool(false), falseBool.transformToScrabbleBool());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(falseBool.toString()),
                falseBool.transformToScrabbleString());
    }

    @Test
    void andBoolTest(){
        assertEquals(new ScrabbleBool(true),
                trueBool.andBool(trueBool));
        assertEquals(new ScrabbleBool(false),
                trueBool.andBool(falseBool));
    }

    @Test
    void andBinaryTest(){
        assertEquals(new ScrabbleBinary(binValue),
                trueBool.andBinary(scrabbleBinary));
        assertEquals(new ScrabbleBinary("0"),
                falseBool.andBinary(scrabbleBinary));
    }

    @Test
    void andTest(){
        assertEquals(new ScrabbleBinary(binValue),
                trueBool.and(scrabbleBinary));
        assertEquals(new ScrabbleBinary("0"),
                falseBool.and(scrabbleBinary));
        assertEquals(new ScrabbleBool(true),
                trueBool.and(trueBool));
        assertEquals(new ScrabbleBool(false),
                trueBool.and(falseBool));
    }

    @Test
    void orBoolTest(){
        assertEquals(new ScrabbleBool(true),
                trueBool.orBool(trueBool));
        assertEquals(new ScrabbleBool(true),
                falseBool.orBool(trueBool));
        assertEquals(falseBool,
                falseBool.orBool(falseBool));
    }

    @Test
    void orBinaryTest(){
        assertEquals(new ScrabbleBinary(binOrTrue),
                trueBool.orBinary(scrabbleBinary));
        assertEquals(new ScrabbleBinary(binValue),
                falseBool.orBinary(scrabbleBinary));
    }

    @Test
    void orTest(){
        assertEquals(new ScrabbleBinary(binOrTrue),
                trueBool.or(scrabbleBinary));
        assertEquals(new ScrabbleBinary(binValue),
                falseBool.or(scrabbleBinary));
        assertEquals(new ScrabbleBool(true),
                trueBool.or(trueBool));
        assertEquals(new ScrabbleBool(true),
                trueBool.or(falseBool));
        assertEquals(new ScrabbleBool(false),
                falseBool.or(falseBool));
    }
}