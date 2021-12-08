package OReilly.RealWorld.Software.Development.BankTxnAnalysier;

@FunctionalInterface
public interface BankTransactionFilter {
    public boolean test(BankTransaction txn);
}
