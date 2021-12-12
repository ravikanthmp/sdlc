package OReilly.RealWorld.Software.Development.businessRules;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    List<Rule> rules;
    Facts facts;

    public BusinessRuleEngine() {
        rules = new ArrayList<>();
        facts = new Facts();
    }

    public BusinessRuleEngine(Facts facts) {
        rules = new ArrayList<>();
        this.facts = facts;
    }


    public void addRule(Rule rule){
        rules.add(rule);
    }

    public int count(){
        return rules.size();
    }

    public void run() {

        rules.forEach(rule -> rule.run(facts));

    }

    public static void main(String[] args) {

        Facts myFacts = new Facts();
        myFacts.setFact("jobTitle", "CEO");
        myFacts.setFact("stage", "LEAD");
        myFacts.setFact("name", "Ishaan");

        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(myFacts);

        Rule rule = RuleBuilder.builder()
                .when((facts) -> facts.getFact("jobTitle").equals("CEO"))
                .then((facts) -> System.out.println("Sending Email to " + facts.getFact("name")))
                .createRule();

        businessRuleEngine.addRule(rule);

        businessRuleEngine.run();
    }
}
