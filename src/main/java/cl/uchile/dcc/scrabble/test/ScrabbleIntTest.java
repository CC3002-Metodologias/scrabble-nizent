package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest extends AbstractScrabbleTypeTest{
    ScrabbleFloat floatTest;
    ScrabbleInt intTest;
    double doubleParam;
    String binParam, negativeBinParam, otherNegativeBinParam;
    int intParam, intNegativeBinParam, intOtherNegativeBinParam;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        intParam = 89;
        negativeBinParam="1001";
        intNegativeBinParam = -7;
        otherNegativeBinParam = "1010";
        intOtherNegativeBinParam = intNegativeBinParam+1;
        binParam = "01011001";
        floatTest = new ScrabbleFloat(doubleParam);
        intTest = new ScrabbleInt(intParam);
    }

    @Test
    void constructorTest(){
        checkConstructor(intTest, new ScrabbleInt(intParam),
                new ScrabbleInt(intNegativeBinParam),
                floatTest);
        assertEquals((new ScrabbleInt(intNegativeBinParam)).hashCode(), intTest.hashCode());
        // numbers of different class are compared by its value
        assertEquals(intTest, new ScrabbleFloat(intParam));
    }

    @Test
    void setValueTest(){
        intTest.setValue(2*intParam);
        assertEquals(intTest.Value(), 2*intParam);
    }

    @Test
    void toStringTest(){
        assertEquals(Integer.toString(intParam), intTest.toString());
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(Float.valueOf(intParam)), intTest.transformToScrabbleFloat());
    }

    @Test
    void transformToScrabbleBinaryTest(){
        assertEquals(new ScrabbleBinary(binParam), intTest.transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary(negativeBinParam), (new ScrabbleInt(intNegativeBinParam)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary(otherNegativeBinParam), (new ScrabbleInt(intOtherNegativeBinParam)).transformToScrabbleBinary());
    }

    @Test
    void transformToScrabbleIntTest(){
        assertEquals(new ScrabbleInt(intParam), intTest.transformToScrabbleInt());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(intTest.toString()),intTest.transformToScrabbleString());
    }
}