package cl.uchile.dcc.scrabble.test.models.type;

import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;
import cl.uchile.dcc.scrabble.test.models.type.AbstractScrabbleTypeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest extends AbstractScrabbleTypeTest {
    private ScrabbleFloat floatTest;
    private ScrabbleInt intTest;
    private ScrabbleBinary binTest;
    private double doubleParam;
    private String binParam;
    private String negativeBinParam;
    private String otherNegativeBinParam;
    private int intParam;
    private int intNegativeBinParam;
    private int intOtherNegativeBinParam;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        intParam = 89;
        negativeBinParam="1001";
        intNegativeBinParam = -7;
        otherNegativeBinParam = "1010";
        intOtherNegativeBinParam = intNegativeBinParam+1;
        binParam = "01011001";
        binTest = new ScrabbleBinary(binParam);
        floatTest = new ScrabbleFloat(doubleParam);
        intTest = new ScrabbleInt(intParam);

    }

    @Test
    void constructorTest(){
        checkConstructor(intTest, new ScrabbleInt(intParam),
                new ScrabbleInt(intNegativeBinParam),
                floatTest);
        assertNotEquals((new ScrabbleInt(intNegativeBinParam)).hashCode(),
                intTest.hashCode());
        assertEquals((new ScrabbleInt(intParam)).hashCode(),
                intTest.hashCode());
        // numbers of different class are compared by its value
        assertEquals(intTest, new ScrabbleFloat(intParam));
        assertEquals(intTest, new ScrabbleBinary(ScrabbleBinary.toBinary(intParam)));
    }

    @Test
    void setValueTest(){
        intTest.setValue(2*intParam);
        assertEquals(intTest.value(), 2*intParam);
    }

    @Test
    void valueTest(){
        assertEquals(intParam, intTest.value());
    }

    @Test
    void toStringTest(){
        assertEquals(Integer.toString(intParam), intTest.toString());
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(intParam), intTest.transformToScrabbleFloat());
    }

    @Test
    void transformToScrabbleBinaryTest(){
        // Positive binary
        assertEquals(new ScrabbleBinary(binParam), intTest.transformToScrabbleBinary());
        // Negative binary
        assertEquals(new ScrabbleBinary(negativeBinParam), (new ScrabbleInt(intNegativeBinParam)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary(otherNegativeBinParam), (new ScrabbleInt(intOtherNegativeBinParam)).transformToScrabbleBinary());
        //  1 and -1
        assertEquals(new ScrabbleBinary("01"), (new ScrabbleInt(1)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary("11"), (new ScrabbleInt(-1)).transformToScrabbleBinary());
        // Case 32 bit binary
        assertEquals(new ScrabbleBinary("11111111111111111111111110100111").toInt(), -89);
        // Number 0
        assertEquals(new ScrabbleBinary("0"), (new ScrabbleInt(0)).transformToScrabbleBinary());
        // Different equivalent ScrabbleBinaries
        assertEquals(new ScrabbleBinary("10"), (new ScrabbleInt(-2)).transformToScrabbleBinary());
        assertEquals(new ScrabbleBinary("1111110"), (new ScrabbleInt(-2)).transformToScrabbleBinary());
    }

    @Test
    void transformToScrabbleIntTest(){
        assertEquals(new ScrabbleInt(intParam), intTest.transformToScrabbleInt());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(intTest.toString()),intTest.transformToScrabbleString());
    }

    @Test
    void sumToFloatTest(){
        assertEquals(new ScrabbleFloat(intParam+doubleParam),
                intTest.sumToFloat(floatTest));
    }

    @Test
    void sumToIntTest(){
        assertEquals(new ScrabbleInt(intParam+intParam),
                intTest.sumToInt(intTest));
    }

    @Test
    void subtractToIntTest(){
        assertEquals(new ScrabbleInt(0),
                intTest.subtractToInt(intTest));
    }

    @Test
    void subtractToFloatTest(){
        assertEquals(new ScrabbleFloat(-intParam+doubleParam),
                intTest.subtractToFloat(floatTest));
    }

    @Test
    void divideToIntTest(){
        assertEquals(new ScrabbleInt(1),
                intTest.divideToInt(intTest));
    }

    @Test
    void divideToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam/intParam),
                intTest.divideToFloat(floatTest));
    }

    @Test
    void multiplyToIntTest(){
        assertEquals(new ScrabbleInt(intParam*intParam),
                intTest.multiplyToInt(intTest));
    }

    @Test
    void multiplyToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam*intParam),
                intTest.multiplyToFloat(floatTest));
    }

    @Test
    void sumToBinaryTest(){
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(binTest.toInt()+intParam)),
                intTest.sumToBinary(binTest));
    }

    @Test
    void subtractToBinaryTest(){
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(binTest.toInt()-intParam)),
                intTest.subtractToBinary(binTest));
    }

    @Test
    void divideToBinaryTest(){
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(binTest.toInt()/intParam)),
                intTest.divideToBinary(binTest));
    }

    @Test
    void multiplyToBinaryTest(){
        assertEquals((new ScrabbleBinary(ScrabbleBinary.toBinary(binTest.toInt()*intParam))),
                intTest.multiplyToBinary(binTest));
    }
}