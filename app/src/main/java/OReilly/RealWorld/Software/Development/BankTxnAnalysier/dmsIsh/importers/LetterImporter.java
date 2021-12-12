package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Attributes;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Document;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.TextFile;

import java.io.File;
import java.io.IOException;

public class LetterImporter implements Importer{



    private static final String NAME_PREFIX = "Dear";
    private static final String PATIENT = "Patient";;
    private static final String TYPE = "Letter";

    @Override
    public Document importFile(File file) throws IOException {
        TextFile textFile = new TextFile(file);
        textFile.addLine(NAME_PREFIX, PATIENT);

        textFile.getAttributes().put(Attributes.TYPE, TYPE);
        return new Document(textFile.getAttributes());
    }
}
