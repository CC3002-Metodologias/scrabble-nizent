package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import cl.uchile.dcc.scrabble.test.AbstractScrabbleTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest extends AbstractScrabbleTypeTest {
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
        assertNotEquals((new ScrabbleInt(intNegativeBinParam)).hashCode(), intTest.hashCode());
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
        // Positive binary
        assertEquals(new ScrabbleBinary(binParam), intTest.transformToScrabbleBinary());
        // Negative binary
        assertEquals(new ScrabbleBinary(negativeBinParam), (new ScrabbleInt(intNegativeBinParam)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary(otherNegativeBinParam), (new ScrabbleInt(intOtherNegativeBinParam)).transformToScrabbleBinary());
        //  1 and -1
        assertEquals(new ScrabbleBinary("01"), (new ScrabbleInt(1)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary("11"), (new ScrabbleInt(-1)).transformToScrabbleBinary());
        // Case 32 bit binary
        assertEquals(new ScrabbleBinary("11111111111111111111111110100111").toInt(), -89);
        // Number 0
        assertEquals(new ScrabbleBinary("0"), (new ScrabbleInt(0)).transformToScrabbleBinary());
        // Different equivalent ScrabbleBinaries
        assertEquals(new ScrabbleBinary("10"), (new ScrabbleInt(-2)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary("1111110"), (new ScrabbleInt(-2)).transformToScrabbleBinary());
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