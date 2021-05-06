package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.time.Month;

public class BankTransactionAnalyzerSimple {


    private BankStatementParser parser;

    public BankTransactionAnalyzerSimple(BankStatementParser parser) {
        this.parser = parser;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "bank-data-simple.csv";

        BankStatementCSVParser csvParser = new BankStatementCSVParser();

        BankTransactionProcessor bankTransactionProcessor =
                new BankTransactionProcessor(csvParser.parseFromFile(fileName));

        System.out.println(bankTransactionProcessor.numberOfTransactions(Month.JANUARY));
        System.out.println(bankTransactionProcessor.getPnL());
    }
}
