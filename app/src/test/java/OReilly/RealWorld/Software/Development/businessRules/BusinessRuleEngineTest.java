package OReilly.RealWorld.Software.Development.businessRules;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BusinessRuleEngineTest {

    @Test
    public void shouldHaveNoRulesInitially() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertEquals(0, businessRuleEngine.count());
    }
}