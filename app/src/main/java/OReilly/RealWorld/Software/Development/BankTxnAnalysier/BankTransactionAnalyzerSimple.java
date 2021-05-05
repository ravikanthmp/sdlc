package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerSimple {


    private final String fileName;

    public BankTransactionAnalyzerSimple(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "bank-data-simple.csv";

        BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple =
                new BankTransactionAnalyzerSimple(fileName);

        BankAnalyzerCSVParser csvParser = new BankAnalyzerCSVParser(
                bankTransactionAnalyzerSimple.fileName
        );

        BankTransactionProcessor bankTransactionProcessor =
                new BankTransactionProcessor(csvParser.parse());

        System.out.println(bankTransactionProcessor.numberOfTransactions(Month.JANUARY));
        System.out.println(bankTransactionProcessor.getPnL());
    }
}
