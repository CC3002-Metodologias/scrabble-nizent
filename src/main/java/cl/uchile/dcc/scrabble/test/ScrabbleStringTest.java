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
        assertEquals((new ScrabbleString(otherStringParam)).hashCode(), stringTest.hashCode());
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

}