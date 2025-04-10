package complexnumberoperations;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public static ComplexNumber addNumbers(ComplexNumber c1, ComplexNumber c2) {
        double realPart = c1.real + c2.real;
        double imaginaryPart = c1.imaginary + c2.imaginary;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static ComplexNumber subtractNumbers(ComplexNumber c1, ComplexNumber c2) {
        double realPart = c1.real - c2.real;
        double imaginaryPart = c1.imaginary - c2.imaginary;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
