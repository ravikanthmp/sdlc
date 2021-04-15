package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionProcessor {

    /**
     * What is the total profit and loss from a list of bank statements? Is it positive or negative?
     *
     * How many bank transactions are there in a particular month?
     *
     * What are his top-10 expenses?
     *
     * Which category does he spend most of his money on?
     */

    private List<BankTransaction> bankTransactions;

    public BankTransactionProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public Double getPnL() {
        double ans = 0;
        for (BankTransaction bankTransaction : this.bankTransactions) {
            ans += bankTransaction.getAmount();
        }
        return ans;
    }

    /**
     */
    public int numberOfTransactions(Month month) {
        int count = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth().equals(Month.from(month))){
                count++;
            }
        }
        return count;
    }
}
