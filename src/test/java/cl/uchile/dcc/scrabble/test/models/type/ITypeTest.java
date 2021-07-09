package cl.uchile.dcc.scrabble.test.models.type;

import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ITypeTest {
    IType scrabbleString;
    IType scrabbleBinary;
    IType scrabbleFloat;
    IType scrabbleBool;
    IType scrabbleInt;

    @BeforeEach
    void setUpITypes(){
        scrabbleString = new ScrabbleString("Hola Mundo");
        scrabbleBinary = new ScrabbleBinary("01");
        scrabbleFloat = new ScrabbleFloat(1.5);
        scrabbleInt = new ScrabbleInt(123);
        scrabbleBool = new ScrabbleBool(true);
    }

    @Test
    void transformToScrabbleBinaryTest(){
        assertEquals(scrabbleString ,scrabbleString.transformToScrabbleString());
        assertEquals(new ScrabbleString(scrabbleBool.toString()), scrabbleBool.transformToScrabbleString());
        assertEquals(new ScrabbleString(scrabbleFloat.toString()),scrabbleFloat.transformToScrabbleString());
        assertEquals(new ScrabbleString(scrabbleInt.toString()), scrabbleInt.transformToScrabbleString());
        assertEquals(new ScrabbleString(scrabbleBinary.toString()), scrabbleBinary.transformToScrabbleString());
    }
}