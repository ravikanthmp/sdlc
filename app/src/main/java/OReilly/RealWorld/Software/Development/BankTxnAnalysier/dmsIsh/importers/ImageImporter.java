package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.importers;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Attributes;
import OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh.Attributes.*;

public class ImageImporter implements Importer {
    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(Attributes.PATH, file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "IMAGE");

        return new Document(attributes);
    }
}
