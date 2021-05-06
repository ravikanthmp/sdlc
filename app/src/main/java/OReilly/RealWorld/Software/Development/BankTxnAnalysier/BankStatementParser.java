package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.util.List;

public interface BankStatementParser {
    public List<BankTransaction> parseFromFile(String fileName) throws IOException;

    public BankTransaction parseFromLine(String line) throws IOException;
}
