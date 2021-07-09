package cl.uchile.dcc.scrabble.test.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.StringConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringConstantTest {
    StringConstant constant;
    String value;

    @BeforeEach
    void setUp(){
        value = "Hola mundo";
        constant = new StringConstant(new ScrabbleString(value));
    }

    @Test
    void constructorTest(){
        assertEquals(new StringConstant(new ScrabbleString(value)), constant);
        assertNotEquals(new StringConstant(new ScrabbleString(value + "7")), constant);
        assertFalse(constant.equals("Hi"));
        assertEquals((new StringConstant(new ScrabbleString(value))).hashCode(), constant.hashCode());
    }

    @Test
    void valueTest(){
        assertEquals(constant.value(), new ScrabbleString(value));
    }

    @Test
    void addTest(){
        assertEquals(StringFactory.getConstant(new ScrabbleString(value).sum(new ScrabbleFloat(7))),
                constant.add(new FloatConstant(new ScrabbleFloat(7))));
    }

    @Test
    void addToStringTest(){
        assertEquals(new StringConstant(new ScrabbleString(value).sum(new ScrabbleString("7"))),
                constant.add(new StringConstant(new ScrabbleString("7"))));
    }

    @Test
    void invalidOpsTest(){
        assertNull(constant.sub(constant));
        assertNull(constant.mult(constant));
        assertNull(constant.div(constant));
        assertNull(constant.and(constant));
        assertNull(constant.or(constant));
        assertNull(constant.negate());
    }

    @Test
    void toStringTest(){
        assertEquals("SString(Hola mundo)", constant.toString());
    }
}
