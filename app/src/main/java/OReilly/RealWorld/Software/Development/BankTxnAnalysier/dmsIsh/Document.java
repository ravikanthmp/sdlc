package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    public Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String attr){
        return attributes.get(attr);
    }

    @Override
    public String toString() {
        return "Document{" +
                "attributes=" + attributes +
                '}';
    }
}
