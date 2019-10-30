import java.io.File;
import java.util.Scanner;

public class FileScanner {
    public static void main(String[] args) throws Exception {
        File file = new File("sherlock.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            count += line.split(" ").length;
        }
        System.out.println("The text files has "+count+" words in total");
        scanner.close();
    }
}