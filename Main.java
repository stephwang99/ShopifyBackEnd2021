import java.util.*;
import java.io.File;

public class Main {
    public static void main(String args[]) {
        Repository rep = new Repository("Shopify Repository");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select the following options for the Shopify Repository:");
            System.out.println("[1] List the images in the repository");
            System.out.println("[2] Add an image to the repository");
            System.out.println("[3] Delete an image(s) in the repository");
            System.out.println("[4] Delete all images in the repository (require root)");
            System.out.println("[5] Exit the program");

            String input = scanner.nextLine();
            int value = 0;
            try{
                value = Integer.parseInt(input);
            } catch(final NumberFormatException e){
            }
            

            if (value == 1){
                rep.List();
            } else if (value == 2) {
                System.out.println("Enter your username:");
                String user = scanner.nextLine();
                System.out.println("Enter the image path:");
                String path = scanner.nextLine();
                rep.Add(user, path);
            } else if (value == 3){
                System.out.println("Enter your username:");
                String user = scanner.nextLine();
                System.out.println("Enter the image path or 'all' to remove all images:");
                String path = scanner.nextLine();
                rep.Delete(user, path);
            } else if (value == 4){
                System.out.println("Enter your username:");
                String user = scanner.nextLine();
                System.out.println("Enter password:");
                String pass = scanner.nextLine();
                rep.DeleteAll(user, pass);
            } else if (value == 5){
                return;
            } else {
                System.out.println("Command not found; please enter the number of the option you'd like.");
            }
        }
    }
}
