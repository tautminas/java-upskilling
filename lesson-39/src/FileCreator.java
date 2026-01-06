import java.io.RandomAccessFile;
import java.io.IOException;

public class FileCreator {

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(101, 50000, "John", "Smith"),
                new Employee(205, 62000, "Anna", "Brown"),
                new Employee(150, 58000, "Mike", "Wilson")
        };

        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {

            raf.setLength(0);

            raf.writeInt(employees.length);

            long indexStart = raf.getFilePointer();
            for (int i = 0; i < employees.length; i++) {
                raf.writeInt(0);
                raf.writeLong(0);
            }

            long[] positions = new long[employees.length];

            for (int i = 0; i < employees.length; i++) {
                positions[i] = raf.getFilePointer();

                raf.writeInt(employees[i].id);
                raf.writeDouble(employees[i].salary);
                raf.writeUTF(employees[i].firstName);
                raf.writeUTF(employees[i].lastName);
            }

            raf.seek(indexStart);
            for (int i = 0; i < employees.length; i++) {
                raf.writeInt(employees[i].id);
                raf.writeLong(positions[i]);
            }

            System.out.println("employees.dat created successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
