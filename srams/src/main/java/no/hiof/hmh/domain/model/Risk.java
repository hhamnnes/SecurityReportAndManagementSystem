package no.hiof.hmh.domain.model;

public class Risk {

    private Scenario scenario;
    private Probability probability;
    private Consequence consequence;
    private int numericValue;

    public Risk() {}

    public Risk(Scenario scenario,
                Probability probability,
                Consequence consequence) {

        if(probability == null || consequence == null || scenario == null) 
        throw new IllegalArgumentException();

        this.scenario = scenario;
        this.probability = probability;
        this.consequence = consequence;
        this.numericValue = probability.getNumericValue() * consequence.getNumericValue();
    }


    public Scenario getScenario() {
        return scenario;
    }

    public Probability getProbability() {
        return probability;
    }

    public Consequence getConsequence() {
        return consequence;
    }

    public int getNumericValue() {
        return numericValue;
    }


    
}
