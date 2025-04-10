package complexnumberoperations;

public class Main {

    /*
     2. Complex number operations
     A complex number is a number that can be expressed in the form a + bi, where a
     and b are real numbers, and i is a solution of the equation x2 = −1. Because no real
     number satisfies this equation, i is called an imaginary number. For the complex
     number, a + bi, a is called the real part, and b is called the imaginary part. To add or
     subtract two complex numbers, just add or subtract the corresponding real and
     imaginary parts. For instance, the sum of 5 + 3i and 4 + 2i is 9 + 5i. For another, the
     sum of 3 + i and –1 + 2i is 2 + 3i.

     Write a class with the name ComplexNumber. The class needs two fields (instance
     variables) with name real and imaginary of type double. It represents the Complex
     Number.
     The class needs to have one constructor. The constructor has parameters real and
     imaginary of type double and it needs to initialize the fields.

     Write the following instance methods:
     • Method named getReal without any parameters, which would return the value of
     real field.
     • Method named getImaginary without any parameters, which would return the
     value of imaginary field.
     • Method named add with two parameters real and imaginary of type double,
     which would add parameters to fields. In other words, it needs to do a complex
     number add operation as described above.
     • Method named subtract with two parameters real and imaginary of type double,
     which would subtract parameters from fields, in other words, it needs to do a
     complex number subtract operation as described above.

     Write the following static methods:
     • Method named addNumbers with two parameters, which are complex numbers.
     It should add those two numbers and return the result of the operation as a
     complex number.
     • Method named subtractNumbers with two parameters, which are complex
     numbers. It should subtract those two numbers and return the result of the
     operation as a complex number.
     Create several instances of the ComplexNumber class in your Main class main
     method with different values and use both instance and static methods on them.
    */

    public static void main(String[] args) {

        ComplexNumber num1 = new ComplexNumber(5, 3);
        ComplexNumber num2 = new ComplexNumber(4, 2);

        System.out.println("Complex number num1 is: " + num1);
        System.out.println("Complex number num2 is: " + num2);

        num1.add(1, 1);
        System.out.println("After adding (1 + 1i) to num1: " + num1);

        num2.subtract(2, 1);
        System.out.println("After subtracting (2 + 1i) from num2: " + num2);

        ComplexNumber sum = ComplexNumber.addNumbers(num1, num2);
        System.out.println("Sum of num1 and num2: " + sum);

        ComplexNumber difference = ComplexNumber.subtractNumbers(num1, num2);
        System.out.println("Difference of num1 and num2: " + difference);

        ComplexNumber num3 = new ComplexNumber(3, 1);
        ComplexNumber num4 = new ComplexNumber(-1, 2);
        ComplexNumber result = ComplexNumber.addNumbers(num3, num4);
        System.out.println("Sum of 3 + i and -1 + 2i: " + result);
    }
}
