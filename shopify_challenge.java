import java.util.*;
import java.io.File;

public class Image {
    String user;
    String path;

    public Image(){
        this.user = "unknown";
        this.path = "";
    }
    public Image(String user, String path){
        this.user = user;
        this.path = path;
    }
    public static String GetUser() {
        return this.user;
    }
    public static String GetPath() {
        return this.path;
    }
    public static void Print() {
        System.out.println(String.format("Img Path: %s \t owned by %s", this.path, this.user));
    }
}

public class Repository {
    String name;
    byte[] password;
    ArrayList<Image> repo;

    public Repository() {
        this.name = "unknown";
        this.password = Base64.getEncoder().encode("rootpassword".getBytes());
        this.repo = new ArrayList<Image>();
    }
    public Repository(String n){
        this.name = n;
        this.password = Base64.getEncoder().encode("rootpassword".getBytes());
        this.repo = new ArrayList<Image>();
    }
    public static void List(){
        System.out.println(String.format("Repo Name: %s", this.name));
        for (int i = 0; i < this.repo.size(); i++){
            this.repo.get(i).Print();
        }
    }
    public static void Add(String user, String path){
        File file = new File(path);
        if (file.isDirectory()){
            File[] files = file.listFile();
            for (File subfile: files){
                Image img = new Image(this.user, subfile.getPath());
                this.repo.Add(img);
            }
        } else if (file.isFile()){
            Image img = new Image(this.user, file.getPath());
            this.repo.Add(img);
        }
    }
    public static void Delete(String user, String path){
        for (int i = 0; i < this.repo.size(); i++){
            if (user.equals(this.repo.get(i).GetUser()) && path.equals(this.repo.get(i).GetPath()) || user.equals(this.repo.get(i).GetUser() && path.equals("all"))){
                this.repo.remove(i);
            }
        }
        System.out.println("Deleted all found images.");
    }
    public static void DeleteAll(String user, String password){
        byte[] encodedPass = Base64.getEncoder().encode(password.getBytes());
        if (user.equals("root") && Arrays.equals(encodedPass, this.password)){
            this.repo = new ArrayList<Image>();
            System.out.println("Successfully deleted all images in repository.");
        } else {
            System.out.println("Failed to validate credentials.")
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Repository rep = new Repository("Shopify Repository");
        while true {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select the following options for the Shopify Repository:");
            System.out.println("[1] List the images in the repository");
            System.out.println("[2] Add an image to the repository");
            System.out.println("[3] Delete an image(s) in the repository");
            System.out.println("[4] Delete all images in the repository (require root)");
            System.out.println("[5] Exit the program");

            String input = scanner.nextLine();

            int value = Integer.parseInt(input);

            if (value == 1){
                rep.List();
            } else if (value == 2) {
                System.out.println("Enter your username:");
                String user = scanner.nextLine();
                System.out.println("Enter the image path:");
                String path = scanner.nextLine();
                repository.Add(user, path)
            } else if (value == 3){
                System.out.println("Enter your username:");
                String user = scanner.nextLine();
                System.out.println("Enter the image path or 'all' to remove all images:");
                String path = scanner.nextLine();
                repository.Delete(user, path)
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
