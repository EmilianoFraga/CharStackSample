# Char Stack Sample
This is a sample Java project exercising an autoboxed character stack, plus some text indentation features.

Please note that:

* StringBuilder is used to store the current line being built. Contention markers goes to the stack.
* I tried to pratice clean coding. Do not expect a short cryptic code.
* Each line built are trimmed before being printed on screen.

This project used Java 1.8 and Apache Maven.

In order to run you must have a valid Java 1.8 and Maven environment.

Then:

`
mvn clean test
`
