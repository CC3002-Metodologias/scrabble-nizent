package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.ILogic;
import cl.uchile.dcc.scrabble.models.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.ScrabbleBool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ILogicTest extends ITypeTest {
    ScrabbleBinary scrabbleBinary;
    ScrabbleBinary otherScrabbleBinary;
    ILogic result;
    String binaryString;
    String otherBinaryString;
    String andBinaryString;
    String orBinaryString;
    ScrabbleBool scrabbleBool;
    ScrabbleBool otherScrabbleBool;

    @BeforeEach
    void setUp(){
        binaryString = "0111";
        scrabbleBinary = new ScrabbleBinary(binaryString);
        otherBinaryString = "11010";
        otherScrabbleBinary = new ScrabbleBinary(otherBinaryString);
        andBinaryString = "00010";
        orBinaryString = "11111";
        scrabbleBool = new ScrabbleBool(true);
        otherScrabbleBool = new ScrabbleBool(false);
    }

    @Test
    void andBoolTest(){
        result = scrabbleBinary.andBool(scrabbleBool);
        assertEquals(new ScrabbleBinary(binaryString), result);
        result = scrabbleBinary.andBool(otherScrabbleBool);
        assertEquals(new ScrabbleBinary("0"), result);
        result = scrabbleBool.andBool(scrabbleBool);
        assertEquals(new ScrabbleBool(true), result);
        result = scrabbleBool.andBool(otherScrabbleBool);
        assertEquals(new ScrabbleBool(false), result);
    }

    @Test
    void andBinaryTest(){
        result = scrabbleBinary.andBinary(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary(andBinaryString), result);
        result = scrabbleBool.andBinary(scrabbleBinary);
        assertEquals(new ScrabbleBinary("0111"), result);
        result = otherScrabbleBool.andBinary(scrabbleBinary);
        assertEquals(new ScrabbleBinary("0"), result);
    }

    @Test
    void andTest(){
        result = scrabbleBinary.and(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary(andBinaryString), result);
        result = scrabbleBool.and(scrabbleBinary);
        assertEquals(new ScrabbleBinary("0111"), result);
        result = otherScrabbleBool.and(scrabbleBinary);
        assertEquals(new ScrabbleBinary("0"), result);
        result = scrabbleBinary.and(scrabbleBool);
        assertEquals(new ScrabbleBinary(binaryString), result);
        result = scrabbleBinary.and(otherScrabbleBool);
        assertEquals(new ScrabbleBinary("0"), result);
        result = scrabbleBool.and(scrabbleBool);
        assertEquals(new ScrabbleBool(true), result);
        result = scrabbleBool.and(otherScrabbleBool);
        assertEquals(new ScrabbleBool(false), result);
    }

    @Test
    void orBoolTest(){
        result = scrabbleBinary.orBool(scrabbleBool);
        assertEquals(new ScrabbleBinary("1111"), result);
        result = scrabbleBinary.orBool(otherScrabbleBool);
        assertEquals(new ScrabbleBinary(binaryString), result);
        result = scrabbleBool.orBool(scrabbleBool);
        assertEquals(new ScrabbleBool(true), result);
        result = scrabbleBool.orBool(otherScrabbleBool);
        assertEquals(new ScrabbleBool(true), result);
    }

    @Test
    void orBinaryTest(){
        result = scrabbleBinary.orBinary(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary("11111"), result);
        result = scrabbleBool.orBinary(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary("11111"), result);
        result = otherScrabbleBool.orBinary(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary(otherBinaryString), result);
    }

    @Test
    void orTest(){
        result = scrabbleBinary.or(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary("11111"), result);
        result = scrabbleBool.or(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary("11111"), result);
        result = otherScrabbleBool.or(otherScrabbleBinary);
        assertEquals(new ScrabbleBinary(otherBinaryString), result);
        result = scrabbleBinary.or(scrabbleBool);
        assertEquals(new ScrabbleBinary("1111"), result);
        result = scrabbleBinary.or(otherScrabbleBool);
        assertEquals(new ScrabbleBinary(binaryString), result);
        result = scrabbleBool.or(scrabbleBool);
        assertEquals(new ScrabbleBool(true), result);
        result = scrabbleBool.or(otherScrabbleBool);
        assertEquals(new ScrabbleBool(true), result);
    }
}