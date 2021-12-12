package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers.Importer;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers.InvalidImporter;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers.InvoiceImporter;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers.LetterImporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    Map<String, Importer> extensionToImporter = new HashMap<>();
    List<Document> store;

    public DocumentManagementSystem() {
        this.extensionToImporter = Map.of(
                "invoice", new InvoiceImporter(),
                "letter", new LetterImporter()
        );
        this.store = new ArrayList<>();
    }

    public void importFile(File file) throws IOException {
        String fileName = file.toString();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        Importer importer = extensionToImporter.getOrDefault(extension, new InvalidImporter());
        Document document = importer.importFile(file);
        store.add(document);
    }

    public List<Document> contents() {
        return store;
    }

    public static void main(String[] args) {
        String fileName = "/sample-letter1.letter";
        DocumentManagementSystem documentManagementSystem =
                new DocumentManagementSystem();
        try {
            documentManagementSystem.importFile(new File(fileName));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Document content : documentManagementSystem.contents()) {
            System.out.println(content);
        }

    }
}
