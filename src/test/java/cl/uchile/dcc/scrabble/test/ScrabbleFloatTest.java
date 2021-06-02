package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleFloatTest extends AbstractScrabbleTypeTest {
    private ScrabbleFloat floatTest;
    private ScrabbleInt intTest;
    private ScrabbleBinary binTest;
    private double doubleParam;
    private int intParam;
    private double otherDoubleParam;
    private String binParam;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        otherDoubleParam = 88.8;
        intParam = 89;
        floatTest = new ScrabbleFloat(doubleParam);
        intTest = new ScrabbleInt(intParam);
        binParam = "0111";
        binTest = new ScrabbleBinary(binParam);
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
    void valueTest(){
        assertEquals(doubleParam, floatTest.Value());
    }

    @Test
    void sumToFloatTest(){
        assertEquals(new ScrabbleFloat(2*doubleParam),
                floatTest.sumToFloat(floatTest));
    }

    @Test
    void sumToIntTest(){
        assertEquals(new ScrabbleFloat(intParam+doubleParam),
                floatTest.sumToInt(intTest));
    }

    @Test
    void subtractToIntTest(){
        assertEquals(new ScrabbleFloat(intParam-doubleParam),
                floatTest.subtractToInt(intTest));
    }

    @Test
    void subtractToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam-doubleParam),
                floatTest.subtractToFloat(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam/2-doubleParam),
                floatTest.subtractToFloat(new ScrabbleFloat(doubleParam/2)));
    }

    @Test
    void divideToIntTest(){
        assertEquals(new ScrabbleFloat(intParam/doubleParam),
                floatTest.divideToInt(intTest));
    }

    @Test
    void divideToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam/doubleParam),
                floatTest.divideToFloat(floatTest));
        assertEquals(new ScrabbleFloat((doubleParam/2)/doubleParam),
                floatTest.divideToFloat(new ScrabbleFloat(doubleParam/2)));

    }

    @Test
    void multiplyToIntTest(){
        assertEquals(new ScrabbleFloat(intParam*doubleParam),
                floatTest.multiplyToInt(intTest));
    }

    @Test
    void multiplyToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam*doubleParam),
                floatTest.multiplyToFloat(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam/2*doubleParam),
                floatTest.multiplyToFloat(new ScrabbleFloat(doubleParam/2)));
    }

    @Test
    void toStringTest(){
        assertEquals(Integer.toString(intParam),
                intTest.toString());
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam),
                floatTest.transformToScrabbleFloat());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(floatTest.toString()),
                floatTest.transformToScrabbleString());
    }

    @Test
    void sumTest(){
        assertEquals(new ScrabbleFloat(doubleParam+doubleParam),
                floatTest.sum(floatTest));
        assertEquals(new ScrabbleFloat(intParam+doubleParam),
                floatTest.sum(intTest));
        assertEquals(new ScrabbleFloat(doubleParam+binTest.toInt()),
                floatTest.sum(binTest));
    }

    @Test
    void subtractTest(){
        assertEquals(new ScrabbleFloat(doubleParam-doubleParam),
                floatTest.subtract(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam-intParam),
                floatTest.subtract(intTest));
        assertEquals(new ScrabbleFloat(doubleParam-binTest.toInt()),
                floatTest.subtract(binTest));
    }

    @Test
    void divideByTest(){
        assertEquals(new ScrabbleFloat(doubleParam/doubleParam),
                floatTest.divideBy(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam/intParam),
                floatTest.divideBy(intTest));
        assertEquals(new ScrabbleFloat(doubleParam/binTest.toInt()),
                floatTest.divideBy(binTest));
    }

    @Test
    void multiplyByTest(){
        assertEquals(new ScrabbleFloat(doubleParam*doubleParam),
                floatTest.multiplyBy(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam*intParam),
                floatTest.multiplyBy(intTest));
        assertEquals(new ScrabbleFloat(doubleParam*binTest.toInt()),
                floatTest.multiplyBy(binTest));
    }
}