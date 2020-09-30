import domain.RiskType;

import java.math.BigDecimal;


class RiskCoefficientSelection {

    BigDecimal getCoefficientForSpecificRisk(BigDecimal sum, RiskType riskType) {
        switch (riskType){
            case FIRE: return new GetCoefficientOfFireRisk().getCoefficient(sum);
            case THEFT: return new GetCoefficientOfTheftRisk().getCoefficient(sum);
            default: return BigDecimal.ZERO;
        }
    }
}
