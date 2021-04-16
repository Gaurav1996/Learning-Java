According to Oracle Java Documentation:

**Constructor** — A class contains constructors that are invoked to create objects from the class blueprint. Constructor declarations look like method declarations — except that they use the name of the class and have no return type.

**Static Block** — A static initialization block is a normal block of code enclosed in braces, { } and preceded by the static keyword. A class can have any number of static initialization blocks, and they can appear anywhere in the class body. The runtime system guarantees that static initialization blocks are called in the order that they appear in the source code.
There is an alternative to static blocks — you can write a private static method. The advantage of private static methods is that they can be reused later if you need to reinitialize the class variable.

**Instance Block** — Normally, you would put code to initialize an instance variable in a constructor. There are two alternatives to using a constructor to initialize instance variables: initializer blocks and final methods. The Java compiler copies initializer blocks into every constructor. Therefore, this approach can be used to share a block of code between multiple constructors.
A final method cannot be overridden in a subclass. This is discussed in the lesson on interfaces and inheritance. This is especially useful if subclasses might want to reuse the initialization method. The method is final because calling non-final methods during instance initialization can cause problems.

**Nested Class** — The Java programming language allows us to define a class within another class. Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes.
As with class methods and variables, a static nested class is associated with its outer class. And like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class: it can use them only through an object reference.
A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class. In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.

**Abstract Class** — An abstract class is a class that is declared abstract—it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.