package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {
    public Document importFile(File file) throws IOException;
}
