import domain.ObjectOfPolicy;
import domain.Policy;
import domain.RiskType;
import domain.SubObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;

class PremiumCalculatorImpl implements PremiumCalculator{

    @Override
    public BigDecimal calculate(Policy policy) {
        BigDecimal premiumForAllRisks = BigDecimal.ZERO;
        for (RiskType riskType : RiskType.values()){
            BigDecimal premiumForSpecificRisk = calculatePremiumForSpecificRisk(policy, riskType);
            premiumForAllRisks = premiumForAllRisks.add(premiumForSpecificRisk);
        }
        return premiumForAllRisks.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculatePremiumForSpecificRisk(Policy policy, RiskType riskType){
        BigDecimal sumOfInsuredSubObjectsForSpecificRisk =
                getSumOfInsuredSubObjectsForSpecificRisk(policy.getObjects(), riskType);
        BigDecimal coefficientForSpecificRisk =
                getCoefficientForSpecificRisk (sumOfInsuredSubObjectsForSpecificRisk, riskType);
        return sumOfInsuredSubObjectsForSpecificRisk.multiply(coefficientForSpecificRisk);
    }

    private BigDecimal getCoefficientForSpecificRisk (BigDecimal sumOfInsuredSubObjectsForSpecificRisk,
                                                      RiskType riskType){
        RiskCoefficientSelection coefficientSelection = new RiskCoefficientSelection();
        return coefficientSelection.getCoefficientForSpecificRisk(sumOfInsuredSubObjectsForSpecificRisk, riskType);
    }

    private BigDecimal getSumOfInsuredSubObjectsForSpecificRisk (List<ObjectOfPolicy> listOfObjects, RiskType riskType){
        return listOfObjects.stream()
                .map(ObjectOfPolicy::getSubObjects)
                .flatMap(Collection::stream)
                .filter(subObject -> subObject.isSpecificRisk(riskType))
                .map(SubObject::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
