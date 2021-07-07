package cl.uchile.dcc.scrabble.test.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoolConstantTest {
    BoolConstant constant;
    boolean value;

    @BeforeEach
    void setUp(){
        value = true;
        constant = new BoolConstant(new ScrabbleBool(value));
    }

    @Test
    void constructorTest(){
        assertEquals(new BoolConstant(new ScrabbleBool(value)), constant);
        assertNotEquals(new BoolConstant(new ScrabbleBool(false)),
                constant);
        assertFalse(constant.equals("Hi"));
        assertEquals((new BoolConstant(new ScrabbleBool(value))).hashCode(),
                constant.hashCode());
    }

    @Test
    void andToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                constant.andToBin(new BinConstant(new ScrabbleBinary("1"))));
    }

    @Test
    void andToBoolTest(){
        assertEquals(constant, constant.andToBool(constant));
    }

    @Test
    void andTest(){
        assertNull(constant.and(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.and(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(constant, constant.and(constant));
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                constant.and(new BinConstant(new ScrabbleBinary("1"))));
        assertNull(constant.and(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void orToBinTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                constant.orToBin(new BinConstant(new ScrabbleBinary("1"))));
    }

    @Test
    void orToBoolTest(){
        assertEquals(constant, constant.orToBool(constant));
    }

    @Test
    void orTest(){
        assertNull(constant.or(new IntConstant(new ScrabbleInt(2))));
        assertNull(constant.or(new FloatConstant(new ScrabbleFloat(2))));
        assertEquals(constant, constant.or(constant));
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                constant.or(new BinConstant(new ScrabbleBinary("1"))));
        assertNull(constant.or(new StringConstant(new ScrabbleString("true"))));
    }

    @Test
    void negateTest(){
        assertEquals(new BoolConstant(new ScrabbleBool(false)), constant.negate());
    }

    @Test
    void evaluateTest(){
        assertEquals(constant, constant.evaluate());
    }

    @Test
    void invalidOpsTest(){
        assertNull(constant.add(constant));
        assertNull(constant.sub(constant));
        assertNull(constant.div(constant));
        assertNull(constant.mult(constant));
    }

    @Test
    void toStringTest(){
        assertEquals("SBool(true)", constant.toString());
    }
}
