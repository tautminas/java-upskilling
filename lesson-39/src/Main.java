import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.TreeMap;

    /*
     1. RandomAccessFile
     In this challenge, you'll be using an indexed file, that contains a series of employee records.
     This file starts with a total count of employee records that are in the file, an integer value.
     This is followed by a series of key value pairs.
     The key is an integer value, representing the employee id. The value is a long value; that's the file position of the employee record in the file.

     For this challenge:
     • Open a RandomAccessFile class with appropriate permissions.
     • Load the employee index into memory.
     • List your employee IDs in order.
     • Retrieve an Employee Record from the file, using an employee id, to locate the position of that record in the file.
     • Print the employee record information to the console.
     • Update the selected Employee's salary in the file.
     • Retrieve the record from the file again, and print the information to the console, confirming that the salary was persisted.

     Each employee record in the file consists of the following information, and in this order:
     • Employee ID, an int.
     • Salary, a double.
     • First Name, a string, with a variable width.
     • Last Name, also a variable width string.
    */

public class Main {

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("ERROR: employees.dat not found or empty.");
            System.out.println("Run FileCreator first.");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {

            TreeMap<Integer, Long> index = new TreeMap<>();

            int count = raf.readInt();
            for (int i = 0; i < count; i++) {
                int id = raf.readInt();
                long pos = raf.readLong();
                index.put(id, pos);
            }

            System.out.println("Employee IDs:");
            for (int id : index.keySet()) {
                System.out.println(id);
            }

            int selectedId = index.firstKey();
            long position = index.get(selectedId);

            Employee emp = readEmployee(raf, position);
            System.out.println("\nBefore update:");
            System.out.println(emp);

            updateSalary(raf, position, emp.salary + 5000);

            Employee updated = readEmployee(raf, position);
            System.out.println("\nAfter update:");
            System.out.println(updated);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee readEmployee(RandomAccessFile raf, long pos) throws IOException {
        raf.seek(pos);
        return new Employee(
                raf.readInt(),
                raf.readDouble(),
                raf.readUTF(),
                raf.readUTF()
        );
    }

    private static void updateSalary(RandomAccessFile raf, long pos, double newSalary) throws IOException {
        raf.seek(pos + Integer.BYTES);
        raf.writeDouble(newSalary);
    }
}
