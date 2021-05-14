package cl.uchile.dcc.scrabble.test;

import cl.uchile.dcc.scrabble.models.IType;
import org.junit.jupiter.api.Test;

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