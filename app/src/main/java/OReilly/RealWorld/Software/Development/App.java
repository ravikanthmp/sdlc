/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package OReilly.RealWorld.Software.Development;

import java.time.Month;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{

        String fileName = "bank-data-simple.csv";
        BankTransactionAnalyzerSimple bta = new BankTransactionAnalyzerSimple(fileName);
        Double pnL = bta.getPnL();
        System.out.println(pnL);
        System.out.println(bta.numberOfTransactions(Month.JANUARY));
    }
}
