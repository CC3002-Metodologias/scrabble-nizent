package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBoolTest extends AbstractScrabbleTypeTest{
    ScrabbleInt intTest;
    ScrabbleBool boolTest;
    int intParam;
    boolean boolParam;

    @BeforeEach
    public void setUp(){
        intParam = 89;
        boolParam = false;
        intTest = new ScrabbleInt(intParam);
        boolTest = new ScrabbleBool(boolParam);
    }

    @Test
    void constructorTest(){
        checkConstructor(boolTest, new ScrabbleBool(boolParam),
                new ScrabbleBool(!boolParam),
                intTest);
        assertEquals((new ScrabbleBool(!boolParam)).hashCode(), boolTest.hashCode());
    }

    @Test
    void setValueTest(){
        boolTest.setValue(!boolParam);
        assertEquals(boolTest.Value(), !boolParam);
    }

    @Test
    void toStringTest(){
        assertEquals(Boolean.toString(boolParam), boolTest.toString());
    }

    @Test
    void transformToScrabbleBoolTest(){
        assertEquals(new ScrabbleBool(boolParam), boolTest.transformToScrabbleBool());
    }

}