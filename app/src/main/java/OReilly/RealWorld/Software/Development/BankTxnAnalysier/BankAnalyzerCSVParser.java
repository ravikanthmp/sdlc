package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class BankAnalyzerCSVParser {
    private static final String RESOURCES = "app/src/main/resources/";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankAnalyzerCSVParser(String fileName) {
        this.fileName = fileName;
    }

    private final String fileName;

    public List<BankTransaction> parse() throws IOException {
        Path path = Paths.get(RESOURCES + fileName);

        return Files.readAllLines(path)
                .stream()
                .map(s -> {
                    String[] split = s.split(",");
                    return new BankTransaction(
                            LocalDate.parse(split[0], dateTimeFormatter),
                            Double.parseDouble(split[1]),
                            split[2]);
                })
                .collect(Collectors.toList());

    }
}
