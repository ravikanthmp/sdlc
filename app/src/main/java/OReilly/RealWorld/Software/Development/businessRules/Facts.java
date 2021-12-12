package OReilly.RealWorld.Software.Development.businessRules;

import java.util.HashMap;
import java.util.Map;

public class Facts {

    private  Map<String, String> facts;

    public Facts() {
        facts = new HashMap<>();
    }

    public String getFact(String k){
        return facts.get(k);
    }

    public void setFact(String k, String v){
        facts.put(k, v);
    }
}
