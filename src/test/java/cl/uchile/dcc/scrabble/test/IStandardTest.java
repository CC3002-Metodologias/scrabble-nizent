package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.ScrabbleInt;
import cl.uchile.dcc.scrabble.test.INumberTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IStandardTest extends INumberTest {

    @Test
    void sumTest(){
        resultTest = intNumber.sum(floatNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
        resultTest = floatNumber.sum(intNumber);
        assertEquals(new ScrabbleFloat(intParam+doubleParam), resultTest);
        resultTest = intNumber.sum(binaryNumber);
        assertEquals(new ScrabbleInt(intParam+binaryNumber.toInt()), resultTest);
        resultTest = floatNumber.sum(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam+binaryNumber.toInt()), resultTest);
        resultTest = intNumber.sum(intNumber);
        assertEquals(new ScrabbleInt(2*intParam), resultTest);
        resultTest = floatNumber.sum(floatNumber);
        assertEquals(new ScrabbleFloat(2*doubleParam), resultTest);
    }

    @Test
    void subtractTest(){
        resultTest = intNumber.subtract(floatNumber);
        assertEquals(new ScrabbleFloat(intParam-doubleParam), resultTest);
        resultTest = floatNumber.subtract(intNumber);
        assertEquals(new ScrabbleFloat(-intParam+doubleParam), resultTest);
        resultTest = intNumber.subtract(binaryNumber);
        assertEquals(new ScrabbleInt(intParam-binaryNumber.toInt()), resultTest);
        resultTest = floatNumber.subtract(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam-binaryNumber.toInt()), resultTest);
    }

    @Test
    void divideByTest(){
        resultTest = intNumber.divideBy(floatNumber);
        assertEquals(new ScrabbleFloat(intParam/doubleParam), resultTest, "Division between int and double mistaken");
        resultTest = floatNumber.divideBy(intNumber);
        assertEquals(new ScrabbleFloat(doubleParam/intParam), resultTest,"Division between double and int mistaken");
        resultTest = intNumber.divideBy(binaryNumber);
        assertEquals(new ScrabbleInt(intParam/binaryNumber.toInt()), resultTest,"Division between int and binary mistaken");
        resultTest = floatNumber.divideBy(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam/binaryNumber.toInt()), resultTest,"Division between float and binary mistaken");
        resultTest = intNumber.divideBy(intNumber);
        assertEquals(new ScrabbleInt(1), resultTest,"Division between int and int mistaken");
        resultTest = floatNumber.divideBy(floatNumber);
        assertEquals(new ScrabbleFloat(1), resultTest,"Division between float and float mistaken");
    }

    @Test
    void multiplyByTest(){
        resultTest = intNumber.multiplyBy(floatNumber);
        assertEquals(new ScrabbleFloat(intParam*doubleParam), resultTest, "Multiplication between int and double mistaken");
        resultTest = floatNumber.multiplyBy(intNumber);
        assertEquals(new ScrabbleFloat(doubleParam*intParam), resultTest,"Multiplication between double and int mistaken");
        resultTest = intNumber.multiplyBy(binaryNumber);
        assertEquals(new ScrabbleInt(intParam*binaryNumber.toInt()), resultTest,"Multiplication between int and binary mistaken");
        resultTest = floatNumber.multiplyBy(binaryNumber);
        assertEquals(new ScrabbleFloat(doubleParam*binaryNumber.toInt()), resultTest,"Multiplication between float and binary mistaken");
        resultTest = intNumber.multiplyBy(intNumber);
        assertEquals(new ScrabbleInt(intParam*intParam), resultTest,"Multiplication between int and int mistaken");
        resultTest = floatNumber.multiplyBy(floatNumber);
        assertEquals(new ScrabbleFloat(doubleParam*doubleParam), resultTest,"Multiplication between float and float mistaken");
    }
}