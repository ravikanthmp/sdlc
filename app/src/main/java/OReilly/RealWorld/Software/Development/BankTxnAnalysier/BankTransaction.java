package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.time.LocalDate;
import java.util.Date;

public class BankTransaction {
    private final LocalDate date;
    private final Double amount;
    private final String location;

    public BankTransaction(LocalDate date, Double amount, String location) {
        this.date = date;
        this.amount = amount;
        this.location = location;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
