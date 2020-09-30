
import java.math.BigDecimal;


class GetCoefficientOfTheftRisk implements GetCoefficientOfRiskType{

    private BigDecimal coefficientByDefault = new BigDecimal ("0.11");
    private BigDecimal bigSumCoefficient = new BigDecimal ("0.05");

    @Override
    public BigDecimal getCoefficient(BigDecimal sum) {

            if (sum.compareTo(new BigDecimal("15")) >= 0){
                return bigSumCoefficient;
            }else{
                return coefficientByDefault;
            }
    }
}
