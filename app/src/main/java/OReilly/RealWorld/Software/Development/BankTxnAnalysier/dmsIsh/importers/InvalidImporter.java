package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Document;

import java.io.File;
import java.io.IOException;

public class InvalidImporter implements Importer {
    @Override
    public Document importFile(File file) throws IOException {
        throw new IOException("Invalid file");
    }
}
