package cl.uchile.dcc.scrabble.test.models.type;

import cl.uchile.dcc.scrabble.models.type.IType;
import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractScrabbleTypeTest {

    public void checkConstructor(IType object, IType expectedObject,
                                 IType sameClassDifferentObject,
                                 IType differentClassDifferentObject){
        assertEquals(expectedObject, object);
        assertNotEquals(sameClassDifferentObject, object);
        assertNotEquals(differentClassDifferentObject,object);
        assertNotEquals(object,differentClassDifferentObject);
    }

}