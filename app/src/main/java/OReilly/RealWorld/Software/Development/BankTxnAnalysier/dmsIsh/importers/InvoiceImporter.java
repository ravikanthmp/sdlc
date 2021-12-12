package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Attributes;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Document;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.TextFile;

import java.io.File;
import java.io.IOException;

public class InvoiceImporter implements Importer{


    private static final String NAME_PREFIX = "Dear";
    private static final String AMOUNT_PREFIX = "Amount:";
    private static final String PATIENT = "Patient";
    private static final String AMOUNT = "Amount";
    private static final String TYPE = "Invoice";

    @Override
    public Document importFile(File file) throws IOException {
        TextFile textFile = new TextFile(file);
        textFile.addLine(NAME_PREFIX, PATIENT);
        textFile.addLine(AMOUNT_PREFIX, AMOUNT);

        textFile.getAttributes().put(Attributes.TYPE, TYPE);
        return new Document(textFile.getAttributes());
    }
}
