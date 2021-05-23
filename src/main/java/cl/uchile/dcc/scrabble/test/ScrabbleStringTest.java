package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleStringTest extends AbstractScrabbleTypeTest{
    ScrabbleString stringTest;
    ScrabbleFloat floatTest;
    double doubleParam;
    String stringParam;
    String otherStringParam;
    ScrabbleString result;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        stringParam = "Mono";
        otherStringParam = "88";
        stringTest  = new ScrabbleString(stringParam);
        floatTest = new ScrabbleFloat(doubleParam);
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
        assertEquals(new ScrabbleString(stringParam+String.valueOf(doubleParam)), result);
    }
}