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
For running the program run Scrabble.java at src/main/java/cl/uchile/dcc/scrabble/gui/Scrabble.java
![start1](https://github.com/nizent/images/blob/main/run.png?raw=true)
# View 
Once yo run the program there will appear this window, on the left you have the operators and constants inside 
a scroll pane.
![start1](https://github.com/nizent/images/blob/main/img1.png?raw=true)
You have to scroll to see the other elements
![start1](https://github.com/nizent/images/blob/main/img2.png?raw=true)
Then, to create a new element do double click over the element, and then the element will appear
on the right side
![start1](https://github.com/nizent/images/blob/main/img3.png?raw=true)
Once the element appears, you can drag it
![start1](https://github.com/nizent/images/blob/main/img4.png?raw=true)
And you can set the constant value, by putting some text inside the textfield
![start1](https://github.com/nizent/images/blob/main/img5.png?raw=true)
If you need to know the element value, just double click over the draggable element and then will appear
a green label containing the value
![start1](https://github.com/nizent/images/blob/main/img6.png?raw=true)

**Creating operations**
You can create operations, first, double click over the operation you want in the scroll pane.
![start1](https://github.com/nizent/images/blob/main/img7.png?raw=true) 
next, you have to insert the element to the left or right pane of the operation, drag the element to the left or right pane and 
it will be set as left/right operand respectively
![start1](https://github.com/nizent/images/blob/main/img8.png?raw=true)
You can evaluate the operation with a double click over the operation region (blue region), i recommend doing double click 
on the symbol.  If the operation is not well built it will throw the message "Tree not correctly built".
![start1](https://github.com/nizent/images/blob/main/img9.png?raw=true) 
In the last image, it is not well built because it doesn't have the right operand, it must be inserted, like in
the next image
![start1](https://github.com/nizent/images/blob/main/img10.png?raw=true)
And you can do any operation you want  
![start1](https://github.com/nizent/images/blob/main/img11.png?raw=true)
In the last image, the operation was (99+"011")/9 = (99+3)/9 = 11.333
# Model
# Types
Dear user, the types are defined by 5 usable classes. Every class has it own getters and setters called
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

# Operations

For the operation modelling, there is defined the interface OperableEntity that represents an operable entity, and it is used the Composite 
Pattern to define them. There are two kinds of operable entities. 
* ```interface Operation```: This interface represents the operations, that can be ```LogicalOperation or ArithmeticOperation```. The arithmetic 
operations are the classes ```Add, Sub, Mult & Div```, each one refers to addition, subtraction, multiplication and division respectively. On
the other hand, logical operations are represented by the classes ```And, Or & Not``` that refers to logical and, or and negation respectively. 
* ```interface Constant```: This interface represents constant values, that can be ```BinConstant, FloatConstant, StringConstant, BoolConstant
 and IntConstant ```
 
 **OPERATIONS**
 
 You can create a lot of operations, for example
 ```java 
bin = new BinConstant(new ScrabbleBinary("1"));
Add add = new Add(new negation(bin), new IntConstant(new ScrabbleInt(1)));
Sub sub = new sub(new FloatConstant(new ScrabbleFloat(1)), add); 
Mult mult = new Mult(sub, add);
Div div = new Div(sub, sub);
```

And you can evaluate the result of that operations (this is implemented using recursion), for example
 ```java 
add.evaluate(); // equivalent to (~1)+1 = 1, because ~1=0, this must return a BinConstant containing "1"
sub.evaluate(); // returns a FloatConstant containing 0.0
mult.evaluate(); // returns a FloatConstant containing 1.0
div.evaluate(); // returns a FloatConstant containing 1.0
```

Finally you can get the String representation of the operations with toString() method

```java 
add.toString(); // returns "Add{Not(SBin(1), SInt(1))}"
```

Also, you can concatenate Strings as left operand with everything as the right operand
```java 
Add addString = new Add(new StringConstant(new ScrabbleString("Hello world")), new BoolConstant(new ScrabbleBool(true))); 
addString.evaluate(); // returns "Hello worldtrue"
```
**CONSTANTS**

There are constants that can't change its value. Everyone, has defined arithmetic and logical operations, but those who
can't perform a operation returns null instead of trying to get the result, also, it is used Double Dispath to implement
the operations (see addToString, subToFloat, ... methods). For example
```java 
FloatConstant value1 = new FloatConstant(new ScrabbleFloat(1));
BoolConstant value2 = new BoolConstant(new ScrabbleBool(true));
value1.add(value1); // returns a FloatConstant containing ScrabbleFloat(2)
value1.add(value2); // returns null
value2.and(value2); // returns a BoolConstant containing true
value2.and(value1); // returns null, because float is not a logical component
```

**VARIABLES**

The class Variable implements the OperableEntity interface, and it represents variables 
that can be assigned. For example

```java 
Variable x = new Variable("x");
BinConstant binConstant = BinFactory.getConstant(new ScrabbleBinary("0"));
x.assign(binConstant);
binConstant.equals(x.evaluate()); // returns true 
```

# Memory optimization

This program uses Flyweight Pattern to save memory. So there are defined Constant factories, that has a static map inside and 
has the static method getConstant(IType i) (Types are defined as the key, and values are the constants) to check if the object has been already created, and if not it creates a new one and save it, 
then return the object. The factories are

```java 
class BinFactory;
class FloatFactory;
class IntFactory;
class StringFactory;
class BoolFactory;
```

For example, you can call

```java 
BinFactory.getConstant(new ScrabbleBinary("111")); 
// creates the object and saves in the hash map

BinFactory.getConstant(new ScrabbleBinary("111")); 
// gets the constant already created
```
And that instance will be saved in the class. 

# Controller
# Operations implemented correctly

For this purpose, there were created 
* Operations factories: There were only defined for the operations that have 2 operands, they are
 AddFactory, SubFactory, MultFactory, DivFactory, AndFactory & OrFactory. The purpose of this factories 
 is to simplify the controller, because arithmetic operations are similar in behavior. For example, you can 
 add, sub, mult & div between float and bin, but not bin and float. If these factories doesn't exist, 
 the program must have 1 method for every kind of operations that checks the correct construction of operations in the
 controller. Factories are classified with the interfaces LogicalOperationFactory & ArithmeticOperationFactory. 
  
```java 
AddFactory addFactory = new AddFactory();
// creates the factory
BinConstant bin = BinFactory.getConstant(new ScrabbleBinary("1")));
addFactory.create(bin, bin); 
// creates the operation
```

* Controller: Defined in the ASTController class. 

```java 
ASTController astController = new ASTController();
AddFactory addFactory = new AddFactory();
SubFactory subFactory = new SubFactory();
ScrabbleBinary sbin = new ScrabbleBinary("1101010101");
ScrabbleFloat sfloat = new ScrabbleFloat(7);

astController.operateBinWithBin(sbin, sbin, addFactory);
astController.operateFloatWithBin(sfloat, bin, subFactory);
// creates operations between valid types
```

**The rest of the documentation is left for the users of this template to complete**