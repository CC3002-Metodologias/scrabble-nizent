package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleStringTest extends AbstractScrabbleTypeTest {
    private ScrabbleString stringTest;
    private ScrabbleFloat floatTest;
    private double doubleParam;
    private String stringParam;
    private String otherStringParam;
    private ScrabbleString result;
    private ScrabbleInt scrabbleInt;
    private ScrabbleBinary scrabbleBinary;
    private ScrabbleBool scrabbleBool;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        stringParam = "Mono";
        otherStringParam = "88";
        stringTest  = new ScrabbleString(stringParam);
        floatTest = new ScrabbleFloat(doubleParam);
        scrabbleInt = new ScrabbleInt(14);
        scrabbleBinary = new ScrabbleBinary("01010101010");
        scrabbleBool = new ScrabbleBool(true);
    }

    @Test
    void constructorTest(){
        checkConstructor(stringTest, new ScrabbleString(stringParam),
                new ScrabbleString(otherStringParam),
                floatTest);
        assertNotEquals((new ScrabbleString(otherStringParam)).hashCode(), stringTest.hashCode());
    }

    @Test
    void setValueTest(){
        stringTest.setValue(otherStringParam);
        assertEquals(stringTest.Value(), otherStringParam);
    }

    @Test
    void toStringTest(){
        assertEquals(String.valueOf(stringParam), stringTest.toString());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(stringTest.toString()),stringTest.transformToScrabbleString());
    }

    @Test
    void sumTest(){
        result = stringTest.sum(floatTest);
        assertEquals(new ScrabbleString(stringParam+doubleParam), result);
        result = stringTest.sum(scrabbleInt);
        assertEquals(new ScrabbleString(stringParam+scrabbleInt.toString()), result);
        result = stringTest.sum(scrabbleBinary);
        assertEquals(new ScrabbleString(stringParam+scrabbleBinary.toString()), result);
        result = stringTest.sum(scrabbleBool);
        assertEquals(new ScrabbleString(stringParam+scrabbleBool.toString()), result);
    }

    @Test
    void valueTest(){
        assertEquals(stringParam, stringTest.Value());
    }
}