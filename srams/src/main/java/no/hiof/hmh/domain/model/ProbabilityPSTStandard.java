package no.hiof.hmh.domain.model;

public class ProbabilityPSTStandard implements Probability {

    private int numericValue;
    private String percentage;

    public ProbabilityPSTStandard(int numericValue,
                                  String percentage) {

        if(numericValue > 1)
        this.numericValue = numericValue;
        this.percentage = percentage;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public String getPercentage() {
        return percentage;
    }

    
}
