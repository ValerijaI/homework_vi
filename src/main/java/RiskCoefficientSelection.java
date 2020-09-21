import domain.RiskType;

import java.math.BigDecimal;


class RiskCoefficientSelection {

    BigDecimal getCoefficientForSpecificRisk(BigDecimal sum, RiskType riskType) {
        if (riskType == RiskType.FIRE) {
            return new GetCoefficientOfFireRisk().getCoefficient(sum);
            } else if (riskType == RiskType.THEFT){
                return new GetCoefficientOfTheftRisk().getCoefficient(sum);
                } else{
                    return BigDecimal.ZERO;
                    }
    }
}
