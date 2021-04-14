package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    /**
     * What is the total profit and loss from a list of bank statements? Is it positive or negative?
     *
     * How many bank transactions are there in a particular month?
     *
     * What are his top-10 expenses?
     *
     * Which category does he spend most of his money on?
     */

    private final String fileName;

    public BankTransactionAnalyzerSimple(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return
     * @throws IOException
     *
     * Pros -
     *  KISS
     *
     * Cons -
     *  Strict coupling - Assumes data in col 1. Assumes CSV format. Does not handle exceptions properly
     *  Violates SRP - Loads file, parses columns, calculates result and shows result i.e more than 1 reason to change GOD class
     */
    public Double getPnL() throws IOException {
        BankAnalyzerCSVParser csvParser = new BankAnalyzerCSVParser(fileName);
        double ans = 0;
        for (BankTransaction bankTransaction : csvParser.parse()) {
            ans += bankTransaction.getAmount();
        }
        return ans;
    }

    /**
     * Hmm, copying the 1st 2 lines to load and read the file
     * Lets see if its a pattern
     *
     */
    public int numberOfTransactions(Month month) throws Exception{
        BankAnalyzerCSVParser csvParser = new BankAnalyzerCSVParser(fileName);
        int count = 0;
        for (BankTransaction bankTransaction : csvParser.parse()) {
            if (bankTransaction.getDate().getMonth().equals(Month.from(month))){
                count++;
            }
        }
        return count;
    }
}