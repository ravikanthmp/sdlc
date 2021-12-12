package OReilly.RealWorld.Software.Development.businessRules;

@FunctionalInterface
public interface Condition {
    public boolean evaluate(Facts facts);
}
