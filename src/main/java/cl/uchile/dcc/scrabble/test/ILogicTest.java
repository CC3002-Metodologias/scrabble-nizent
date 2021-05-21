package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.ILogic;
import cl.uchile.dcc.scrabble.models.ScrabbleBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ILogicTest {
    ScrabbleBinary scrabbleBinary;
    ScrabbleBinary otherScrabbleBinary;
    ILogic result;
    String binaryString;
    String otherBinaryString;

    @BeforeEach
    void setUp(){
        binaryString = "0111";
        scrabbleBinary = new ScrabbleBinary(binaryString);
        otherBinaryString = "11010";
        otherScrabbleBinary = new ScrabbleBinary(otherBinaryString);
    }

    @Test
    void andBinaryTest(){
        result = scrabbleBinary.andBinary(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary("00010"), result);
    }

    @Test
    void orBinaryTest(){
        result = scrabbleBinary.orBinary(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary("11111"), result);
    }

}