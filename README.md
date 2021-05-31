# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

Dear user, this program has 5 usable classes. Every class has it own getters and setters called
Value() and setValue(type value), and they are compared by its value overriding equals(Object obj) method. 

1. ScrabbleString: This class wraps a String value. 
2. ScrabbleBool: This class wraps a boolean value. 
3. ScrabbleInt: This class wraps an int value.
4. ScrabbleBinary: This class wraps a Binary String and supports at most 32 bits.  
5. ScrabbleDouble: This class wraps a double value.

Please check the tests that checks the correct behavior of the models. You can look the tests at the src/test/java/cl/uchile/scrabble/test 
folder. To execute them you have to make a right click over "src/test" folder and select "Run 'All Tests' with coverage" option.

Every class of the models folder in "src/main/java/cl/uchile/dcc/scrabble/models" folder, has it own test. 
Every method of interfaces (those who starts with 'i') implemented in classes that implement the interface 
are tested in the interfaces Tests. In a class test you can find tests for the class method, but not all. 
Although, every method of every class is tested both in an interface test, or his class test.
 
**CLASSES & INTERFACES** 

The classes were created with the following structure (imagine it as a tree)
    
    AbstractScrabbleType{
        ScrabbleString, 
        ScrabbleBool,
        AbstractNumber{
            ScrabbleInt,
            ScrabbleBin,
            ScrabbleFloat
        }
    }

Every AbstractScrabbleType represents a Scrabble type, and the 
AbstractNumber represents a number wrapping a primitive java type. The program has multiple interfaces 
representing different behaviors. 

1. IType: Represents the behavior of a type. It allows to be able to transform to a String.

2. ILogic: Represents logical elements and its behavior. It allows the classes to 
have logical operations as "or" (|) and "and" (&).

3. INumber: Represents a number, that can be encoded (like 010101111) or in its standard form (like 12.3333).
Because of that it just allows the numbers to be transformed into a float and operate
Standard numbers as ScrabbleFloat and ScrabbleInt.

4. IStandard: Represents number in its standard form (decimal or base 10 in case of integers). It makes the
objects operable with INumber types.

5. IInteger: Represents an integer behavior. This means, they are operable with
binary numbers and integers (ScrabbleBinary and ScrabbleInt respectively). 

6. IEncodedInteger: Represents encoded numbers. This numbers can only be operated 
with IInteger types.

The following tree resumes the classes structure in the form {Interface(Classes that implements it){Child interfaces}}
    
    IType(AbstractScrabbleType){
        ILogic(ScrabbleBool, ScrabbleBinary),
        INumber(AbstractNumber){ 
            IInteger(ScrabbleInt){ 
                IEncoded(ScrabbleBinary)
            }, 
            IStandard(ScrabbleFloat, ScrabbleInt)
        }
    }

**USAGE**

**1. Scrabble Strings**

This kind of objects can be constructed with a String value. As follows

```java
ScrabbleString s = new ScrabbleString("Hola Mundo ");
```

And you can append another Type as follows with sum(IType iType) method, and set and get its value

```java
String val = s.Value(); // val is "Hola Mundo "
IType iType = new ScrabbleFloat(12.5);
ScrabbleString newSString = s.sum(iType) // newSString contains "Hola Mundo 12.5"
iType = new ScrabbleBool(false);
newSString = s.sum(iType) // newSString now contains "Hola Mundo false"
s.setValue("Hola Nuevo Mundo"); // Now, s value is "Hola Nuevo Mundo"
```
**2. Scrabble Booleans**

This kind of objects can be constructed with a boolean value. As follows

```java
boolean b = true;
ScrabbleBool sBool = new ScrabbleBool(b);
```

And you can make another Type as follows with sum(IType iType) method

```java
boolean val = s.Value(); // val is true
IType iType = new ScrabbleFloat(12.5);
ScrabbleString newSString = s.sum(iType) // newSString contains "Hola Mundo 12.5"
iType = new ScrabbleBool(false);
newSString = s.sum(iType) // newSString now contains "Hola Mundo false"
s.setValue("Hola Nuevo Mundo"); // Now, s value is "Hola Nuevo Mundo"
```
**The rest of the documentation is left for the users of this template to complete**