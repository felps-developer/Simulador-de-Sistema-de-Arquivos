import java.io.IOException;
import java.util.Scanner;

public class FileSystemSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        DirectoryManager directoryManager = new DirectoryManager();
        JournalManager journalManager = new JournalManager();

        while (true) {
            System.out.print("shell> ");
            String command = scanner.nextLine();
            journalManager.log(command);

            String[] commandParts = command.split(" ");
            String action = commandParts[0];

            try {
                switch (action) {
                    case "create":
                        if (commandParts.length < 2) {
                            System.out.println("Error: Missing argument for create. Usage: create <filePath>");
                        } else {
                            fileManager.createFile(commandParts[1]);
                        }
                        break;
                    case "copy":
                        if (commandParts.length < 3) {
                            System.out.println("Error: Missing arguments for copy. Usage: copy <source> <destination>");
                        } else {
                            fileManager.copyFile(commandParts[1], commandParts[2]);
                        }
                        break;
                    case "delete":
                        if (commandParts.length < 2) {
                            System.out.println("Error: Missing argument for delete. Usage: delete <filePath>");
                        } else {
                            fileManager.deleteFile(commandParts[1]);
                        }
                        break;
                    case "rename":
                        if (commandParts.length < 3) {
                            System.out.println("Error: Missing arguments for rename. Usage: rename <oldName> <newName>");
                        } else {
                            fileManager.renameFile(commandParts[1], commandParts[2]);
                        }
                        break;
                    case "mkdir":
                        if (commandParts.length < 2) {
                            System.out.println("Error: Missing argument for mkdir. Usage: mkdir <dirPath>");
                        } else {
                            directoryManager.createDirectory(commandParts[1]);
                        }
                        break;
                    case "rmdir":
                        if (commandParts.length < 2) {
                            System.out.println("Error: Missing argument for rmdir. Usage: rmdir <dirPath>");
                        } else {
                            directoryManager.deleteDirectory(commandParts[1]);
                        }
                        break;
                    case "renamedir":
                        if (commandParts.length < 3) {
                            System.out.println("Error: Missing arguments for renamedir. Usage: renamedir <oldDir> <newDir>");
                        } else {
                            directoryManager.renameDirectory(commandParts[1], commandParts[2]);
                        }
                        break;
                    case "list":
                        if (commandParts.length < 2) {
                            System.out.println("Error: Missing argument for list. Usage: list <dirPath>");
                        } else {
                            directoryManager.listDirectory(commandParts[1]);
                        }
                        break;
                    case "exit":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
