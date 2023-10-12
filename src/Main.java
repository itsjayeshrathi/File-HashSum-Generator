import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        // To get the input of a directory created a scanner object
        Scanner scanner = new Scanner(System.in);

        // Taking the input of filepath as a string
        System.out.print("Enter the directory file path: ");
        String directory = scanner.nextLine().trim();

        Hash test = new Hash();
        System.out.println(test.calculateHash(directory));
    }
}
