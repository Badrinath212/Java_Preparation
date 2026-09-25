package IO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileIOTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\HP\\OneDrive\\Desktop\\test.txt");
        File file1 = new File("C:\\Users\\HP\\OneDrive\\Desktop\\temp\\test.txt");

        try {
            // file.createNewFile();
            // System.out.println("File created");

            boolean isFolderCreated = file1.mkdirs();
            System.out.println("Folder created");

            long len = file.length();
            System.out.println("Length of file in bytes:" + len);

            long lastModified = file.lastModified();

            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getPath());
            System.out.println("Parent path: " + file.getParent());
            System.out.println("Absolute path: " + file.getAbsolutePath());

            // file.delete();
            // System.out.println("File deleted");

            // File file2 = new File("C:\\Users\\HP\\OneDrive\\Desktop\\test1.txt");

            // file.renameTo(file2);
            // System.out.println("File renamed");

            try (FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

                int read;
                char[] data = new char[1024];
                while ((read = bufferedReader.read(data, 0, 1024)) != -1) {
                    System.out.print(new String(data, 0, read));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
