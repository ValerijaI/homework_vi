package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubObject {

    private String name;
    private BigDecimal cost;
    private List <RiskType> risks;

    public SubObject (String name, BigDecimal cost, RiskType...risks){
        this.name = name;
        this.cost = cost;
        this.risks = new ArrayList<>(Arrays.asList(risks));
    }

    public boolean isSpecificRisk (RiskType riskType){
        return risks.contains(riskType);
    }

    public BigDecimal getCost (){
        return cost;
    }

}
