package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementCSVParser implements BankStatementParser {
    private static final String RESOURCES = "app/src/main/resources/";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankStatementCSVParser(){
    }

    public List<BankTransaction> parseFromFile(String fileName) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);

        return Files.readAllLines(path)
                .stream()
                .map(s -> parseFromLine(s))
                .collect(Collectors.toList());

    }

    @Override
    public BankTransaction parseFromLine(String line){
        String[] split = line.split(",");
        return new BankTransaction(
                LocalDate.parse(split[0], dateTimeFormatter),
                Double.parseDouble(split[1]),
                split[2]);
    }
}
