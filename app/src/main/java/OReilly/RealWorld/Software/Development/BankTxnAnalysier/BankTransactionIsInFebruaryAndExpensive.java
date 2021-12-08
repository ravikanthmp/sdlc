package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction txn) {
        return (txn.getDate().getMonth().equals(Month.FEBRUARY)
                && txn.getAmount() >= 1000);
    }
}
