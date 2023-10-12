import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // To get the input of a directory created a scanner object
        Scanner scanner = new Scanner(System.in);

        // Taking the input of filepath as a string
        System.out.print("Enter the directory file path: ");
        String directory = scanner.nextLine().trim();
        int i = 0;
        Runner runner = new Runner(directory, i);
        Thread thread = new Thread(runner);
        thread.start();
        thread.join();
        System.out.println(runner.getHash());
    }
}
