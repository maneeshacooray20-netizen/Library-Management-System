package service;

import model.User;
import java.io.*;

public class FileService {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/data/users.txt";
    public static void addUser(User user, String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(user.getName() + "," + user.getEmail() + "\n");
        fw.close();
    }
}
