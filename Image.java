public class Image {
    String user;
    String path;

    public Image(){
        user = "unknown";
        path = "";
    }
    public Image(String u, String p){
        this.user = u;
        this.path = p;
    }
    public String GetUser() {
        return this.user;
    }
    public String GetPath() {
        return this.path;
    }
    public void Print() {
        System.out.println(String.format("Img Path: %s \t owned by %s", this.path, this.user));
    }
}