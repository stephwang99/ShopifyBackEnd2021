import java.io.File;
import java.util.*;

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
    public void List(){
        System.out.println(String.format("Repo Name: %s", this.name));
        for (int i = 0; i < this.repo.size(); i++){
            this.repo.get(i).Print();
        }
    }
    public void Add(String user, String path){
        File file = new File(path);
        if (file.isDirectory()){
            String[] files = file.list();
            for (String filename: files){
                Image img = new Image(user, path+"/"+filename);
                this.repo.add(img);
            }
        } else if (file.isFile()){
            Image img = new Image(user, file.getPath());
            this.repo.add(img);
        }
    }
    public void Delete(String user, String path){

        for (int i = 0; i < this.repo.size(); i++){
            Image img = this.repo.get(i);
            if (user.equals(img.GetUser()) && (path.equals(img.GetPath()) || path.equals("all"))){
                this.repo.remove(i);
                --i;
            }
        }

        System.out.println("Deleted all found images.");
    }
    public void DeleteAll(String user, String password){
        byte[] encodedPass = Base64.getEncoder().encode(password.getBytes());
        if (user.equals("root") && Arrays.equals(encodedPass, this.password)){
            this.repo = new ArrayList<Image>();
            System.out.println("Successfully deleted all images in repository.");
        } else {
            System.out.println("Failed to validate credentials.");
        }
    }
}