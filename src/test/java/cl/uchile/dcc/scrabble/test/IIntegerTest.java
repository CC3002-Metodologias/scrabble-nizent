package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.IInteger;
import cl.uchile.dcc.scrabble.models.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.ScrabbleInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IIntegerTest extends INumberTest {
    IInteger sameScrabbleInt;
    IInteger sameScrabbleBinary;

    @BeforeEach
    public void init(){
        setUp();
        sameScrabbleInt= new ScrabbleInt(12);
        sameScrabbleBinary = new ScrabbleBinary("01100");
    }

    @Test
    void transformToScrabbleBinaryTest(){
        assertEquals(sameScrabbleBinary, sameScrabbleInt.transformToScrabbleBinary());
        assertEquals(sameScrabbleBinary, sameScrabbleBinary.transformToScrabbleBinary());
    }

    @Test
    void transformToScrabbleIntTest(){
        assertEquals(sameScrabbleInt, sameScrabbleInt.transformToScrabbleInt());
        assertEquals(sameScrabbleInt, sameScrabbleBinary.transformToScrabbleInt());
    }

    @Test
    void sumToBinaryTest(){
        resultTest = intNumber.sumToBinary(binaryNumber);
        Assertions.assertEquals(new ScrabbleBinary(sumBinaryIntParams), resultTest);
        resultTest = binaryNumber.sumToBinary(binaryNumber);
        Assertions.assertEquals(new ScrabbleBinary(twiceBinaryParam), resultTest);
    }

    @Test
    void subtractToBinaryTest(){
        resultTest = intNumber.subtractToBinary(binaryNumber);
        Assertions.assertEquals(new ScrabbleBinary(subtractBinaryIntParams), resultTest);
        resultTest = binaryNumber.subtractToBinary(binaryNumber);
        Assertions.assertEquals(new ScrabbleBinary("0"), resultTest);
    }

    @Test
    void divideToBinaryTest(){
        resultTest = intNumber.divideToBinary(binaryNumber);
        Assertions.assertEquals((new ScrabbleInt(binaryNumber.toInt()/intParam)).transformToScrabbleBinary(), resultTest);
        resultTest = binaryNumber.divideToBinary(binaryNumber);
        Assertions.assertEquals(new ScrabbleBinary("01"), resultTest);
    }

    @Test
    void multiplyToBinaryTest(){
        resultTest = intNumber.multiplyToBinary(binaryNumber);
        Assertions.assertEquals((new ScrabbleInt(binaryNumber.toInt()*intParam)).transformToScrabbleBinary(), resultTest);
        resultTest = binaryNumber.multiplyToBinary(binaryNumber);
        Assertions.assertEquals((new ScrabbleInt(binaryNumber.toInt()*binaryNumber.toInt())).transformToScrabbleBinary(), resultTest);
    }
}