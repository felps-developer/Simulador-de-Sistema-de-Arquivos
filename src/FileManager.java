import java.io.IOException;
import java.nio.file.*;

class FileManager {
    public void createFile(String filePath) throws IOException {
        Files.createFile(Paths.get(filePath));
        System.out.println("File created: " + filePath);
    }

    public void copyFile(String sourcePath, String destPath) throws IOException {
        Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File copied from " + sourcePath + " to " + destPath);
    }

    public void deleteFile(String filePath) throws IOException {
        Files.delete(Paths.get(filePath));
        System.out.println("File deleted: " + filePath);
    }

    public void renameFile(String oldName, String newName) throws IOException {
        Files.move(Paths.get(oldName), Paths.get(newName), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File renamed from " + oldName + " to " + newName);
    }
}
