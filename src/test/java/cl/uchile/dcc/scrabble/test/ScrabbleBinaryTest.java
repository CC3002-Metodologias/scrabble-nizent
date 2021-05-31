package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import cl.uchile.dcc.scrabble.test.AbstractScrabbleTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBinaryTest extends AbstractScrabbleTypeTest {
    ScrabbleFloat floatTest;
    ScrabbleBinary binaryTest;
    double doubleParam;
    String binParam, otherBinParam, negativeBinParam;
    int intBinParam, intNegativeBinParam;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        binParam = "0111";
        intBinParam = 7;
        negativeBinParam = "101";
        intNegativeBinParam = -3;
        otherBinParam = "010101";
        floatTest = new ScrabbleFloat(doubleParam);
        binaryTest = new ScrabbleBinary(binParam);
    }

    @Test
    void constructorTest(){
        checkConstructor(binaryTest, new ScrabbleBinary(binParam),
                new ScrabbleBinary(otherBinParam),
                floatTest);
        assertNotEquals((new ScrabbleBinary(otherBinParam)).hashCode(), binaryTest.hashCode());
    }

    @Test
    void setValueTest(){
        binaryTest.setValue(otherBinParam);
        assertEquals(binaryTest.Value(), otherBinParam);
    }

    @Test
    void toStringTest(){
        assertEquals(String.valueOf(binParam), binaryTest.toString());
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(intBinParam), binaryTest.transformToScrabbleFloat());
    }

    @Test
    void transformToScrabbleBinaryTest(){
        assertEquals(new ScrabbleBinary(binParam), binaryTest.transformToScrabbleBinary());
    }

    @Test
    void transformToScrabbleIntTest(){
        assertEquals(new ScrabbleInt(intBinParam), binaryTest.transformToScrabbleInt());
        assertEquals(new ScrabbleInt(intNegativeBinParam), (new ScrabbleBinary(negativeBinParam)).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(-1), (new ScrabbleBinary("1")).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(-1), (new ScrabbleBinary("111")).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(-1), (new ScrabbleBinary("11111")).transformToScrabbleInt());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(binaryTest.toString()),binaryTest.transformToScrabbleString());
    }
}