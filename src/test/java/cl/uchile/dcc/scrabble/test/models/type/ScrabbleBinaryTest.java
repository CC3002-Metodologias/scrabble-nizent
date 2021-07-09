package cl.uchile.dcc.scrabble.test.models.type;

import cl.uchile.dcc.scrabble.models.type.*;
import cl.uchile.dcc.scrabble.test.models.type.AbstractScrabbleTypeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBinaryTest extends AbstractScrabbleTypeTest {
    private ScrabbleFloat floatTest;
    private ScrabbleInt intTest;
    private ScrabbleBinary binaryTest;
    private ScrabbleBinary negativeBin;
    private ScrabbleBinary positiveBin;
    private double doubleParam;
    private String binParam;
    private String negatedBinParam;
    private String otherBinParam;
    private String negativeBinParam;
    private int negativeBinToInt;
    private String positiveBinParam;
    private int positiveBinToInt;
    private int intBinParam;
    private int intNegativeBinParam;
    private int intParam;
    private int result;
    private ScrabbleBool trueScrabbleBool;
    private ScrabbleBool falseScrabbleBool;
    private String positiveAndNegative;
    private String positiveAndBinTest;
    private String positiveOrNegative;
    private String positiveOrBinTest;

    @BeforeEach
    public void setUp(){
        doubleParam = 67.9;
        binParam = "0111";
        negatedBinParam = "1000";
        intBinParam = 7;
        negativeBinParam = "101";
        negativeBinToInt = -3;
        negativeBin = new ScrabbleBinary(negativeBinParam);
        positiveBinParam = "01111";
        positiveBinToInt = 15;
        positiveBin = new ScrabbleBinary(positiveBinParam);
        positiveAndNegative = "01101"; // 01111 & 101
        positiveAndBinTest = "00111"; // 01111 & 0111
        positiveOrNegative = "11111"; // 01111 | 101
        positiveOrBinTest = "01111"; // 01111 & 0111
        intNegativeBinParam = -3;
        otherBinParam = "010101";
        floatTest = new ScrabbleFloat(doubleParam);
        binaryTest = new ScrabbleBinary(binParam);
        intParam = 70;
        intTest = new ScrabbleInt(intParam);
        trueScrabbleBool = new ScrabbleBool(true);
        falseScrabbleBool = new ScrabbleBool(false);
    }

    @Test
    void constructorTest(){
        checkConstructor(binaryTest, new ScrabbleBinary(binParam),
                new ScrabbleBinary(otherBinParam),
                floatTest);
        assertNotEquals((new ScrabbleBinary(otherBinParam)).hashCode(), binaryTest.hashCode());
        assertEquals((new ScrabbleBinary(binParam)).hashCode(), binaryTest.hashCode());
    }

    @Test
    void setValueTest(){
        binaryTest.setValue(otherBinParam);
        assertEquals(binaryTest.value(), otherBinParam);
    }

    @Test
    void valueTest(){
        assertEquals(binParam ,binaryTest.value());
    }

    @Test
    void toStringTest(){
        assertEquals(String.valueOf(binParam), binaryTest.toString());
    }

    @Test
    void toBinaryTest(){
        assertEquals(positiveBinParam, ScrabbleBinary.toBinary(positiveBinToInt));
        assertEquals(new ScrabbleBinary(negativeBinParam), new ScrabbleBinary(ScrabbleBinary.toBinary(negativeBinToInt)));
    }

    @Test
    void transformToScrabbleBinaryTest(){
        assertEquals(new ScrabbleBinary(binParam), binaryTest.transformToScrabbleBinary());
    }

    @Test
    void transformToScrabbleIntTest(){
        assertEquals(new ScrabbleInt(intBinParam), binaryTest.transformToScrabbleInt());
        assertEquals(new ScrabbleInt(intNegativeBinParam), (new ScrabbleBinary(negativeBinParam)).transformToScrabbleInt());
        // -1 can be expressed as binaries of the form 1...1
        assertEquals(new ScrabbleInt(-1), (new ScrabbleBinary("1")).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(-1), (new ScrabbleBinary("111")).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(-1), (new ScrabbleBinary("11111")).transformToScrabbleInt());
        // 0 can be expressed as binaries of the form 0...0
        assertEquals(new ScrabbleInt(0), (new ScrabbleBinary("0")).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(0), (new ScrabbleBinary("000")).transformToScrabbleInt());
        assertEquals(new ScrabbleInt(0), (new ScrabbleBinary("00000")).transformToScrabbleInt());
    }

    @Test
    void transformToScrabbleFloatTest(){
        assertEquals(new ScrabbleFloat(intBinParam), binaryTest.transformToScrabbleFloat());
        // negative binary
        assertEquals(new ScrabbleFloat(negativeBinToInt), negativeBin.transformToScrabbleFloat());
        // positive binary
        assertEquals(new ScrabbleFloat(positiveBinToInt), positiveBin.transformToScrabbleFloat());
    }

    @Test
    void transformToScrabbleStringTest(){
        assertEquals(new ScrabbleString(binParam),binaryTest.transformToScrabbleString());
    }

    @Test
    void toIntTest(){
        // positive binary
        assertEquals(positiveBinToInt, positiveBin.toInt());
        // negative binary
        assertEquals(negativeBinToInt, negativeBin.toInt());
    }

    @Test
    void sumTest(){
        // sum with ScrabbleInt
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(intBinParam+intParam)),
                binaryTest.sum(intTest));

        // sum with ScrabbleBin
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(2*binaryTest.toInt())), binaryTest.sum(binaryTest));

        // sum with a negative binary
        result = binaryTest.toInt()+negativeBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.sum(negativeBin));

        // sum with a negative ScrabbleInt
        result = binaryTest.toInt()+(-intParam);
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.sum(new ScrabbleInt(-intParam)));
    }

    @Test
    void subtractTest(){
        result = binaryTest.toInt()-intParam;
        Assertions.assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.subtract(intTest));
    }

    @Test
    void divideByTest(){
        result = binaryTest.toInt()/intTest.value();
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.divideBy(intTest),"Division between binary and int mistaken");
        assertEquals(new ScrabbleBinary("01"),
                binaryTest.divideBy(binaryTest),"Division between binary and binary mistaken");
    }

    @Test
    void multiplyByTest(){
        result = binaryTest.toInt()*intParam;
        Assertions.assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.multiplyBy(intTest),
                "Multiplication between binary and int mistaken");
        result = binaryTest.toInt()*binaryTest.toInt();
        Assertions.assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.multiplyBy(binaryTest),"Multiplication between binary and binary mistaken");
    }

    @Test
    void sumToBinaryTest(){
        result = intBinParam + intBinParam;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)), binaryTest.sumToBinary(binaryTest));
        result = positiveBinToInt + negativeBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                negativeBin.sumToBinary(positiveBin));
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                positiveBin.sumToBinary(negativeBin));
    }

    @Test
    void subtractToBinaryTest(){
        assertEquals(new ScrabbleBinary("0"), binaryTest.subtractToBinary(binaryTest));
        result = positiveBinToInt - negativeBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                negativeBin.subtractToBinary(positiveBin));
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(-result)),
                positiveBin.subtractToBinary(negativeBin));
    }

    @Test
    void divideToBinaryTest(){
        result = 1;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.divideToBinary(binaryTest));
        result = positiveBinToInt/negativeBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                negativeBin.divideToBinary(positiveBin));
        result = negativeBinToInt/positiveBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                positiveBin.divideToBinary(negativeBin));
    }

    @Test
    void multiplyToBinaryTest(){
        result = intBinParam*intBinParam;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                binaryTest.multiplyToBinary(binaryTest));
        result = positiveBinToInt*negativeBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                negativeBin.multiplyToBinary(positiveBin));
        result = negativeBinToInt*positiveBinToInt;
        assertEquals(new ScrabbleBinary(ScrabbleBinary.toBinary(result)),
                positiveBin.multiplyToBinary(negativeBin));
    }

    @Test
    void sumToIntTest(){
        assertEquals(new ScrabbleInt(intBinParam+intParam),
                binaryTest.sumToInt(intTest));
        assertEquals(new ScrabbleInt(negativeBinToInt+intParam),
                negativeBin.sumToInt(intTest));
        assertEquals(new ScrabbleInt(positiveBinToInt+intParam),
                positiveBin.sumToInt(intTest));
    }

    @Test
    void subtractToIntTest(){
        assertEquals(new ScrabbleInt(-intBinParam+intParam),
                binaryTest.subtractToInt(intTest));
        assertEquals(new ScrabbleInt(-negativeBinToInt+intParam),
                negativeBin.subtractToInt(intTest));
        assertEquals(new ScrabbleInt(-positiveBinToInt+intParam),
                positiveBin.subtractToInt(intTest));
    }

    @Test
    void divideToIntTest(){
        assertEquals(new ScrabbleInt(intParam/intBinParam),
                binaryTest.divideToInt(intTest));
        assertEquals(new ScrabbleInt(intParam/negativeBinToInt),
                negativeBin.divideToInt(intTest));
        assertEquals(new ScrabbleInt(intParam/positiveBinToInt),
                positiveBin.divideToInt(intTest));
    }

    @Test
    void multiplyToIntTest(){
        assertEquals(new ScrabbleInt(intParam*intBinParam),
                binaryTest.multiplyToInt(intTest));
        assertEquals(new ScrabbleInt(intParam*negativeBinToInt),
                negativeBin.multiplyToInt(intTest));
        assertEquals(new ScrabbleInt(intParam*positiveBinToInt),
                positiveBin.multiplyToInt(intTest));
    }

    @Test
    void sumToFloatTest(){
        assertEquals(new ScrabbleFloat(intBinParam+doubleParam),
                binaryTest.sumToFloat(floatTest));
        assertEquals(new ScrabbleFloat(negativeBinToInt+doubleParam),
                negativeBin.sumToFloat(floatTest));
        assertEquals(new ScrabbleFloat(positiveBinToInt+doubleParam),
                positiveBin.sumToFloat(floatTest));
    }

    @Test
    void subtractToFloatTest(){
        assertEquals(new ScrabbleFloat(-intBinParam+doubleParam),
                binaryTest.subtractToFloat(floatTest));
        assertEquals(new ScrabbleFloat(-negativeBinToInt+doubleParam),
                negativeBin.subtractToFloat(floatTest));
        assertEquals(new ScrabbleFloat(-positiveBinToInt+doubleParam),
                positiveBin.subtractToFloat(floatTest));
    }

    @Test
    void divideToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam/intBinParam),
                binaryTest.divideToFloat(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam/negativeBinToInt),
                negativeBin.divideToFloat(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam/positiveBinToInt),
                positiveBin.divideToFloat(floatTest));
    }

    @Test
    void multiplyToFloatTest(){
        assertEquals(new ScrabbleFloat(doubleParam*intBinParam),
                binaryTest.multiplyToFloat(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam*negativeBinToInt),
                negativeBin.multiplyToFloat(floatTest));
        assertEquals(new ScrabbleFloat(doubleParam*positiveBinToInt),
                positiveBin.multiplyToFloat(floatTest));
    }

    @Test
    void andBoolTest(){
        assertEquals(new ScrabbleBinary(binParam),
                binaryTest.andBool(trueScrabbleBool));
        assertEquals(new ScrabbleBinary("0"),
                binaryTest.andBool(falseScrabbleBool));
    }

    @Test
    void andBinaryTest(){
        assertEquals(new ScrabbleBinary(binParam),
                binaryTest.andBinary(binaryTest));
        assertEquals(new ScrabbleBinary(positiveAndNegative),
                positiveBin.andBinary(negativeBin));
        assertEquals(new ScrabbleBinary(positiveAndNegative),
                negativeBin.andBinary(positiveBin));
        assertEquals(new ScrabbleBinary(positiveAndBinTest),
                positiveBin.andBinary(binaryTest));
    }

    @Test
    void andTest(){
        assertEquals(new ScrabbleBinary(positiveAndBinTest),
                binaryTest.and(positiveBin));
        assertEquals(new ScrabbleBinary(binParam),
                binaryTest.and(trueScrabbleBool));
        assertEquals(new ScrabbleBinary("0"),
                binaryTest.and(falseScrabbleBool));
    }

    @Test
    void orBoolTest(){
        assertEquals(new ScrabbleBinary("1111"),
                binaryTest.orBool(trueScrabbleBool));
        assertEquals(new ScrabbleBinary(binParam),
                binaryTest.orBool(falseScrabbleBool));
    }

    @Test
    void orBinaryTest(){
        assertEquals(new ScrabbleBinary(binParam),
                binaryTest.orBinary(binaryTest));
        assertEquals(new ScrabbleBinary(positiveOrNegative),
                positiveBin.orBinary(negativeBin));
        assertEquals(new ScrabbleBinary(positiveOrNegative),
                negativeBin.orBinary(positiveBin));
        assertEquals(new ScrabbleBinary(positiveOrBinTest),
                positiveBin.orBinary(binaryTest));
    }

    @Test
    void orTest(){
        assertEquals(new ScrabbleBinary(positiveOrBinTest),
                binaryTest.or(positiveBin));
        assertEquals(new ScrabbleBinary(positiveOrNegative),
                negativeBin.or(positiveBin));
        assertEquals(new ScrabbleBinary("1111"),
                binaryTest.or(trueScrabbleBool));
        assertEquals(new ScrabbleBinary(binParam),
                binaryTest.or(falseScrabbleBool));
    }

    @Test
    void negateTest(){
        assertEquals(negatedBinParam, binaryTest.negate().toString());
    }
}