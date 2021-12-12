package OReilly.RealWorld.Software.Development.businessRules;

@FunctionalInterface
public interface Action {
    public void perform(Facts facts);
}
