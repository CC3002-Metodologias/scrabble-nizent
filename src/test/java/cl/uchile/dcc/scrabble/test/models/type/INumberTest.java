package cl.uchile.dcc.scrabble.test.models.type;

import cl.uchile.dcc.scrabble.models.type.INumber;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class INumberTest extends ITypeTest {
    ScrabbleInt intNumber;
    ScrabbleFloat floatNumber;
    ScrabbleBinary binaryNumber;
    INumber resultTest;
    int intParam;
    double doubleParam;
    String binaryParam;
    String sumBinaryIntParams;
    String twiceBinaryParam;
    String subtractBinaryIntParams;

    @BeforeEach
    void setUp(){
        intParam = 89;
        intNumber = new ScrabbleInt(intParam);
        doubleParam = 9.7;
        floatNumber = new ScrabbleFloat(doubleParam);
        binaryParam = "0111";
        binaryNumber = new ScrabbleBinary(binaryParam);
        sumBinaryIntParams = "01100000"; // binaryParam + intParam binary form
        subtractBinaryIntParams = "10101110"; // binaryParam - intParam form
        twiceBinaryParam = "01110";
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(intParam),intNumber.transformToScrabbleFloat());
        assertEquals(new ScrabbleFloat(doubleParam), floatNumber.transformToScrabbleFloat());
        assertEquals(new ScrabbleFloat(binaryNumber.toInt()), binaryNumber.transformToScrabbleFloat());
    }

    @Test
    void sumToFloatTest(){
        resultTest = floatNumber.sumToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(2*doubleParam), resultTest);
        resultTest = intNumber.sumToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
    }

    @Test
    void sumToIntTest(){
        resultTest = floatNumber.sumToInt(intNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
        resultTest = intNumber.sumToInt(intNumber);
        assertEquals(new ScrabbleInt(intParam+intParam), resultTest);
        resultTest = binaryNumber.sumToInt(intNumber);
        assertEquals(new ScrabbleBinary(sumBinaryIntParams), resultTest);
    }

    @Test
    void subtractToIntTest(){
        resultTest = floatNumber.subtractToInt(intNumber);
        assertEquals(new ScrabbleFloat(intParam-doubleParam), resultTest);
        resultTest = intNumber.subtractToInt(intNumber);
        assertEquals(new ScrabbleInt(0), resultTest);
        resultTest = binaryNumber.subtractToInt(intNumber);
        assertEquals(new ScrabbleInt(intParam-binaryNumber.toInt()), resultTest);
    }

    @Test
    void subtractToFloatTest(){
        resultTest = floatNumber.subtractToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(0), resultTest);
        resultTest = intNumber.subtractToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(-intParam+doubleParam), resultTest);
    }

    @Test
    void divideToIntTest(){
        resultTest = floatNumber.divideToInt(intNumber);
        assertEquals(new ScrabbleFloat(intParam/doubleParam), resultTest);
        resultTest = intNumber.divideToInt(intNumber);
        assertEquals(new ScrabbleInt(1), resultTest);
        resultTest = binaryNumber.divideToInt(intNumber);
        assertEquals(new ScrabbleInt(intParam/binaryNumber.toInt()), resultTest);
    }

    @Test
    void divideToFloatTest(){
        resultTest = floatNumber.divideToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(1), resultTest);
        resultTest = intNumber.divideToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam/intParam), resultTest);
    }

    @Test
    void multiplyToIntTest(){
        resultTest = floatNumber.multiplyToInt(intNumber);
        assertEquals(new ScrabbleFloat(intParam*doubleParam), resultTest);
        resultTest = intNumber.multiplyToInt(intNumber);
        assertEquals(new ScrabbleInt(intParam*intParam), resultTest);
        resultTest = binaryNumber.multiplyToInt(intNumber);
        assertEquals(new ScrabbleInt(intParam*binaryNumber.toInt()), resultTest);
    }

    @Test
    void multiplyToFloatTest(){
        resultTest = floatNumber.multiplyToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam*doubleParam), resultTest);
        resultTest = intNumber.multiplyToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam*intParam), resultTest);
    }
}