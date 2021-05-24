package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleFloatTest extends AbstractScrabbleTypeTest{
    ScrabbleFloat floatTest;
    ScrabbleInt intTest;
    double doubleParam;
    int intParam;
    double otherDoubleParam;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        otherDoubleParam = 88.8;
        intParam = 89;
        floatTest = new ScrabbleFloat(doubleParam);
        intTest = new ScrabbleInt(intParam);
    }

    @Test
    void constructorTest(){
        checkConstructor(floatTest, new ScrabbleFloat(doubleParam),
                new ScrabbleFloat(otherDoubleParam),
                intTest);
        assertNotEquals((new ScrabbleFloat(otherDoubleParam)).hashCode(), floatTest.hashCode());
        assertEquals((new ScrabbleFloat(doubleParam)).hashCode(), floatTest.hashCode());
    }

    @Test
    void setValueTest(){
        floatTest.setValue(otherDoubleParam);
        assertEquals(floatTest.Value(), otherDoubleParam);
    }

    @Test
    void toStringTest(){
        assertEquals(Integer.toString(intParam), intTest.toString());
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam), floatTest.transformToScrabbleFloat());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(floatTest.toString()),floatTest.transformToScrabbleString());
    }

}