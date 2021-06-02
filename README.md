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
            ScrabbleBinary,
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

You can make different logical operations with and(ILogic iLogic) or or(ILogic iLogic)

```java
boolean val = s.Value(); // val is true
ScrabbleBool falseBool = sBool.and(new ScrabbleBool(false)); // falseBool contains false value
ScrabbleBool trueBool = sBool.or(new ScrabbleBool(false)); // trueBool contains true value
```

**3. Scrabble Binaries**

Scrabble Binaries represents binary numbers. You can construct a new Scrabble Binary with 
a String containing at most 32 bits represented by the characters '0' and '1'. Negative numbers 
must start with '1' character an positive number starts with '0' character. It is supposed 
that a number of the form "1..." is negative, and "0..." is positive. Binaries can behave as Logical
objects.

```java
String bin = "0101011111";
ScrabbleBinary sBin = new ScrabbleBinary(bin);
```

You can treat this object as a number that can only be operated with integer representable objects, 
this is ScrabbleInt or ScrabbleBin. This means that you can't divide a ScrabbleBinary by a ScrabbleFloat.
But you can do the following (operation sum, subtraction, division, multiplication results remain as binary)

```java
String  otherBin = "0111";
ScrabbleBinary otherSBin = new ScrabbleBinary(otherBin);
sBin.sum(otherSBin); //this returns a new ScrabbleBinary containing a binary representation of sBin+otherSBin
sBin.divideBy(otherSBin); //this returns a new ScrabbleBinary containing a binary representation of sBin/otherSBin
ScrabbleInt anInt = new ScrabbleInt(7);
sBin.sum(anInt); // you can sum different IInteger objects
otherBin.and(falseBool) // returns a new ScrabbleBinary containing "0000", bits are compared one by one
```
**4. Scrabble Integers**

Scrabble Integers represents integer numbers. You can construct a new Scrabble Int with 
an int value.

```java
int integer = 14;
ScrabbleInt sInt = new ScrabbleInt(integer);
```

You can make operations as sum, subtraction, division and multiplication with any type of Scrabble Number (those who inherits from AbstractNumber Class). 
Here you can see an example 

```java
sInt.sum(new ScrabbleInt(9)); //this returns a new ScrabbleInt containing 14+9
sInt.multiplyBy(sInt); //this returns a new ScrabbleInt containing 14*14
sInt.subtract(new ScrabbleInt(3)); // returns a new ScrabbleInt containing 14-3
sInt.divideBy(new ScrabbleFloat(2.5)); // returns a new ScrabbleFloat containing 14/2.5
```

**5. Scrabble Floats**

Scrabble Floats represents float numbers. You can construct a new Scrabble Float with 
a double value.

```java
double value = 14.5;
ScrabbleFloat sFloat = new ScrabbleFloat(value);
```

You can make operations as sum, subtraction, division and multiplication with any type of Scrabble Number (those who inherits from AbstractNumber Class). 
Here you can see an example 

```java
sFloat.sum(new ScrabbleInt(9)); //this returns a new ScrabbleFloat containing 14.5+9
sFloat.multiplyBy(sFloat); //this returns a new ScrabbleFloat containing 14.5*14.5
sFloat.subtract(new ScrabbleInt(3)); // returns a new ScrabbleFloat containing 14.5-3
sFloat.divideBy(new ScrabbleFloat(2.5)); // returns a new ScrabbleFloat containing 14.5/2.5
```

There are more functionalities that you can check, every method is documented. The classes
structure may change in the future.

**The rest of the documentation is left for the users of this template to complete**