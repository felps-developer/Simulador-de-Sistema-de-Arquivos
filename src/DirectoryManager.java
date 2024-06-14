import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;

class DirectoryManager {
    public void createDirectory(String dirPath) throws IOException {
        Files.createDirectories(Paths.get(dirPath));
        System.out.println("Directory created: " + dirPath);
    }

    public void deleteDirectory(String dirPath) throws IOException {
        Files.walk(Paths.get(dirPath))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(java.io.File::delete);
        System.out.println("Directory deleted: " + dirPath);
    }

    public void renameDirectory(String oldDir, String newDir) throws IOException {
        Files.move(Paths.get(oldDir), Paths.get(newDir), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Directory renamed from " + oldDir + " to " + newDir);
    }

    public void listDirectory(String dirPath) throws IOException {
        Files.list(Paths.get(dirPath)).forEach(path -> System.out.println(path.getFileName()));
    }
}
