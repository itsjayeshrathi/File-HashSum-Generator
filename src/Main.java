import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // To get the input of a directory created a scanner object
        Scanner scanner = new Scanner(System.in);

        // Taking the input of filepath as a string
        System.out.print("Enter the directory file path: ");
        String directory = scanner.nextLine();
        //Creating a file object inorder to get the hashcode
        File fileEntry = new File(directory);
        int totalHash = getHashOfDirectory(fileEntry);
        System.out.println("The total size of directory is: "+totalHash);
    }
    static   int calHash = 0;
    static public int getHashOfDirectory(final File fileEntry)
    {
        final File[] file = fileEntry.listFiles();
        if(file != null) {
            for (final File f : file) {
                if (f.isDirectory()) {
                    getHashOfDirectory(f);
                } else {
                    calHash += f.hashCode();
                }
            }
        }
        return calHash;
    }
}
