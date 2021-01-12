# Shopify Back-end developer Summer 2021
An image repository built from scratch using object-oriented design. It allows simple commands such as list, add and delete

**Image Class**
- String user
- String path
- String GetUser()
- String GetPath()
- void Print()

**Repository Class**
- String name
- byte[] password
- ArrayList repo
- void List()
- void Add()
- void Delete()
- void DeleteAll()

Run:\
To run the program, you can simply run it on the terminal or IDE of your choice and the program will start. To run on the terminal, simply go to the directory where exists the files, and compile the code like this `javac Main.java` then run `java Main`.

Usage:\
The program will prompt users for options by entering the number corresponding to the option. This runs infinitely until the user chooses the exit. If the user provides an input that is not part of the option, the program will reask the user again for a valid option.

Option 1: List\
List will print the repository name and all the images in  it including their names and paths

Option 2: Add\
Add will accept the user and a path and add all images to the repository underneath that user. If a directory is provided in the path name, all images in the directory will be added into the repository (not recursively). If a file path name is provided, then simply the file will be added.

Option 3: Delete\
Delete also accepts the user and path of the image needed to be deleted. It checks that the image was added by the same user before deleting it. If the user provides "all" as the pathname, then all images added by the user will be delete.

Option 4: Delete all\
Delete all will empty the entire repository. Since there is a possibility of many users adding various images, the program will ensure only the root user can delete all images. The program will also prompt for a password. The default password (_rootpasssword_) is encoded in base64, and will be compared with the user's input.

Option 5: Exit\
This will just terminate the program.
