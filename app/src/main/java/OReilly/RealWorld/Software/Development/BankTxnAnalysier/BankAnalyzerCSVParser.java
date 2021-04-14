package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankAnalyzerCSVParser {
    private static final String RESOURCES = "app/src/main/resources/";
    public BankAnalyzerCSVParser(String fileName) {
        this.fileName = fileName;
    }

    private final String fileName;

    public List<String> parse() throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        return Files.readAllLines(path);
    }
}
