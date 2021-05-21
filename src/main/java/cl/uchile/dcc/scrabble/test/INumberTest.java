package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class INumberTest {
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
    void sumIntTest(){
        resultTest = floatNumber.sumInt(intNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
        resultTest = intNumber.sumInt(intNumber);
        assertEquals(new ScrabbleInt(intParam+intParam), resultTest);
        resultTest = binaryNumber.sumInt(intNumber);
        assertEquals(new ScrabbleBinary(sumBinaryIntParams), resultTest);
    }

    @Test
    void sumBinaryTest(){
        resultTest = intNumber.sumBinary(binaryNumber);
        assertEquals(new ScrabbleBinary(sumBinaryIntParams), resultTest);
        resultTest = binaryNumber.sumBinary(binaryNumber);
        assertEquals(new ScrabbleBinary(twiceBinaryParam), resultTest);
    }

    @Test
    void sumFloatTest(){
        resultTest = floatNumber.sumFloat(floatNumber);
        assertEquals(new ScrabbleFloat(2*doubleParam), resultTest);
        resultTest = intNumber.sumFloat(floatNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
    }

    @Test
    void sumTest(){
        resultTest = intNumber.sum(floatNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
        resultTest = floatNumber.sum(intNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
        resultTest = intNumber.sum(binaryNumber);
        assertEquals(new ScrabbleInt(intParam+binaryNumber.toInt()), resultTest);
        resultTest = binaryNumber.sum(intNumber);
        assertEquals(new ScrabbleBinary(sumBinaryIntParams), resultTest);
        resultTest = floatNumber.sum(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam+binaryNumber.toInt()), resultTest);
        resultTest = intNumber.sum(intNumber);
        assertEquals(new ScrabbleInt(2*intParam), resultTest);
        resultTest = floatNumber.sum(floatNumber);
        assertEquals(new ScrabbleFloat(2*doubleParam), resultTest);
        resultTest = binaryNumber.sum(binaryNumber);
        assertEquals(new ScrabbleInt(2*binaryNumber.toInt()), resultTest);
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
    void subtractToBinaryTest(){
        resultTest = intNumber.subtractToBinary(binaryNumber);
        assertEquals(new ScrabbleBinary(subtractBinaryIntParams), resultTest);
        resultTest = binaryNumber.subtractToBinary(binaryNumber);
        assertEquals(new ScrabbleBinary("0"), resultTest);
    }

    @Test
    void subtractToFloatTest(){
        resultTest = floatNumber.subtractToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(0), resultTest);
        resultTest = intNumber.subtractToFloat(floatNumber);
        assertEquals(new ScrabbleFloat(-intParam+doubleParam), resultTest);
    }

    @Test
    void subtractTest(){
        resultTest = intNumber.subtract(floatNumber);
        assertEquals(new ScrabbleFloat(intParam-doubleParam), resultTest);
        resultTest = floatNumber.subtract(intNumber);
        assertEquals(new ScrabbleFloat(-intParam+doubleParam), resultTest);
        resultTest = intNumber.subtract(binaryNumber);
        assertEquals(new ScrabbleInt(intParam-binaryNumber.toInt()), resultTest);
        resultTest = binaryNumber.subtract(intNumber);
        assertEquals(new ScrabbleBinary(subtractBinaryIntParams), resultTest);
        resultTest = floatNumber.subtract(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam-binaryNumber.toInt()), resultTest);
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
    void divideToBinaryTest(){
        resultTest = intNumber.divideToBinary(binaryNumber);
        assertEquals((new ScrabbleInt(binaryNumber.toInt()/intParam)).transformToScrabbleBinary(), resultTest);
        resultTest = binaryNumber.divideToBinary(binaryNumber);
        assertEquals(new ScrabbleBinary("01"), resultTest);
    }

    @Test
    void divideFloatTest(){
        resultTest = floatNumber.divideFloat(floatNumber);
        assertEquals(new ScrabbleFloat(1), resultTest);
        resultTest = intNumber.divideFloat(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam/intParam), resultTest);
    }

    @Test
    void divideByTest(){
        resultTest = intNumber.divideBy(floatNumber);
        assertEquals(new ScrabbleFloat(intParam/doubleParam), resultTest, "Division between int and double mistaken");
        resultTest = floatNumber.divideBy(intNumber);
        assertEquals(new ScrabbleFloat(doubleParam/intParam), resultTest,"Division between double and int mistaken");
        resultTest = intNumber.divideBy(binaryNumber);
        assertEquals(new ScrabbleInt(intParam/binaryNumber.toInt()), resultTest,"Division between int and binary mistaken");
        resultTest = binaryNumber.divideBy(intNumber);
        assertEquals(new ScrabbleInt(binaryNumber.toInt()/intParam).transformToScrabbleBinary(), resultTest,"Division between binary and int mistaken");
        resultTest = floatNumber.divideBy(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam/binaryNumber.toInt()), resultTest,"Division between float and binary mistaken");
        resultTest = intNumber.divideBy(intNumber);
        assertEquals(new ScrabbleInt(1), resultTest,"Division between int and int mistaken");
        resultTest = binaryNumber.divideBy(binaryNumber);
        assertEquals(new ScrabbleInt(1).transformToScrabbleBinary(), resultTest,"Division between binary and binary mistaken");
        resultTest = floatNumber.divideBy(floatNumber);
        assertEquals(new ScrabbleFloat(1), resultTest,"Division between float and float mistaken");
    }

    @Test
    void multiplyIntTest(){
        resultTest = floatNumber.multiplyInt(intNumber);
        assertEquals(new ScrabbleFloat(intParam*doubleParam), resultTest);
        resultTest = intNumber.multiplyInt(intNumber);
        assertEquals(new ScrabbleInt(intParam*intParam), resultTest);
        resultTest = binaryNumber.multiplyInt(intNumber);
        assertEquals(new ScrabbleInt(intParam*binaryNumber.toInt()), resultTest);
    }

    @Test
    void multiplyBinaryTest(){
        resultTest = intNumber.multiplyBinary(binaryNumber);
        assertEquals((new ScrabbleInt(binaryNumber.toInt()*intParam)).transformToScrabbleBinary(), resultTest);
        resultTest = binaryNumber.multiplyBinary(binaryNumber);
        assertEquals((new ScrabbleInt(binaryNumber.toInt()*binaryNumber.toInt())).transformToScrabbleBinary(), resultTest);
    }

    @Test
    void multiplyFloatTest(){
        resultTest = floatNumber.multiplyFloat(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam*doubleParam), resultTest);
        resultTest = intNumber.multiplyFloat(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam*intParam), resultTest);
    }

    @Test
    void multiplyByTest(){
        resultTest = intNumber.multiplyBy(floatNumber);
        assertEquals(new ScrabbleFloat(intParam*doubleParam), resultTest, "Multiplication between int and double mistaken");
        resultTest = floatNumber.multiplyBy(intNumber);
        assertEquals(new ScrabbleFloat(doubleParam*intParam), resultTest,"Multiplication between double and int mistaken");
        resultTest = intNumber.multiplyBy(binaryNumber);
        assertEquals(new ScrabbleInt(intParam*binaryNumber.toInt()), resultTest,"Multiplication between int and binary mistaken");
        resultTest = binaryNumber.multiplyBy(intNumber);
        assertEquals(new ScrabbleInt(binaryNumber.toInt()*intParam).transformToScrabbleBinary(), resultTest,"Multiplication between binary and int mistaken");
        resultTest = floatNumber.multiplyBy(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam*binaryNumber.toInt()), resultTest,"Multiplication between float and binary mistaken");
        resultTest = intNumber.multiplyBy(intNumber);
        assertEquals(new ScrabbleInt(intParam*intParam), resultTest,"Multiplication between int and int mistaken");
        resultTest = binaryNumber.multiplyBy(binaryNumber);
        assertEquals(new ScrabbleInt(binaryNumber.toInt()*binaryNumber.toInt()).transformToScrabbleBinary(), resultTest,"Multiplication between binary and binary mistaken");
        resultTest = floatNumber.multiplyBy(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam*doubleParam), resultTest,"Multiplication between float and float mistaken");
    }
}