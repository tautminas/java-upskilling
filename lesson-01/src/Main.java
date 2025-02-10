public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // ===================================================

        // Integer types
        byte byteValue = 127;
        short shortValue = 32767;
        int intValue = 2147483647;
        long longValue = 9223372036854775807L;

        // Floating-point types
        float floatValue = 3.14f;
        double doubleValue = 3.141592653589793;

        // Character type
        char charValue = 'A';

        // Boolean type
        boolean booleanValue = true;

        // Print values
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: " + charValue);
        System.out.println("boolean: " + booleanValue);

        // ===================================================

        // All primitive types have wrapper classes with a capitalized first letter
        // Example: int → Integer
        int primitiveInt = 10;
        // Auto-boxing is the automatic conversion of a primitive type (e.g., int) to its corresponding wrapper class (e.g., Integer).
        // Auto-unboxing is the automatic conversion of a wrapper class (e.g., Integer) back to its corresponding primitive type (e.g., int).
        Integer wrapperInt = primitiveInt;

        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapper Integer: " + wrapperInt);

        // ===================================================

        // Overflow occurs when a value exceeds the maximum limit of a data type.
        // Underflow occurs when a value falls below the minimum limit of a data type.

        // Example of overflow (exceeds maximum for byte)
        byte maxByte = Byte.MAX_VALUE;
        byte overflowByte = (byte) (maxByte + 1);  // Overflow, wraps around to -128
        System.out.println("Overflowed byte: " + overflowByte);  // Output: -128

        // Example of underflow (falls below minimum for byte)
        byte minByte = Byte.MIN_VALUE;
        byte underflowByte = (byte) (minByte - 1);  // Underflow, wraps around to 127
        System.out.println("Underflowed byte: " + underflowByte);  // Output: 127

        // ===================================================

        String str1 = "Hello, World!"; // String literal
        String str2 = new String("Hello, World!"); // Using new keyword

        // ===================================================

        // Strings are immutable, any operation that seems to modify a string actually creates a new string.

        // The **stack** is used for storing method call frames, local variables, and primitive types.
        // It follows a Last In First Out (LIFO) structure, and memory is automatically managed (memory is freed when a method finishes).
        // It's fast but limited in size and is used for temporary memory allocation.

        // The **heap** is used for storing objects and their references. It allows for dynamic memory allocation,
        // meaning you manually allocate memory (e.g., using `new` keyword) and Java's garbage collector manages it.
        // The heap is slower than the stack but can hold much larger data.

        // ===================================================

        // Implicit type casting automatically converts smaller data types to larger ones when the conversion is safe, without explicit casting (e.g., int to long).

    }
}