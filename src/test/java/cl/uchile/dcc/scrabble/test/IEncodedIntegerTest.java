package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.ScrabbleInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IEncodedIntegerTest extends IIntegerTest {

    @Test
    void sumTest(){
        resultTest = binaryNumber.sum(intNumber);
        Assertions.assertEquals(new ScrabbleBinary(sumBinaryIntParams), resultTest);
        resultTest = binaryNumber.sum(binaryNumber);
        Assertions.assertEquals(new ScrabbleInt(2*binaryNumber.toInt()), resultTest);
    }

    @Test
    void subtractTest(){
        resultTest = binaryNumber.subtract(intNumber);
        Assertions.assertEquals(new ScrabbleBinary(subtractBinaryIntParams), resultTest);
    }

    @Test
    void divideByTest(){
        resultTest = binaryNumber.divideBy(intNumber);
        Assertions.assertEquals(new ScrabbleInt(binaryNumber.toInt()/intParam).transformToScrabbleBinary(), resultTest,"Division between binary and int mistaken");
        resultTest = binaryNumber.divideBy(binaryNumber);
        Assertions.assertEquals(new ScrabbleInt(1).transformToScrabbleBinary(), resultTest,"Division between binary and binary mistaken");
    }

    @Test
    void multiplyByTest(){
        resultTest = binaryNumber.multiplyBy(intNumber);
        Assertions.assertEquals(new ScrabbleInt(binaryNumber.toInt()*intParam).transformToScrabbleBinary(), resultTest,"Multiplication between binary and int mistaken");
        resultTest = binaryNumber.multiplyBy(binaryNumber);
        Assertions.assertEquals(new ScrabbleInt(binaryNumber.toInt()*binaryNumber.toInt()).transformToScrabbleBinary(), resultTest,"Multiplication between binary and binary mistaken");
    }
}