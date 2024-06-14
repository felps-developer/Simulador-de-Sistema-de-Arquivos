import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class JournalManager {
    private static final String JOURNAL_FILE = "journal.log";

    public void log(String command) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_FILE, true))) {
            writer.write(command);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error logging command: " + e.getMessage());
        }
    }
}
