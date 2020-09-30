
import java.math.BigDecimal;


class GetCoefficientOfFireRisk implements GetCoefficientOfRiskType{

    private BigDecimal coefficientByDefault = new BigDecimal ("0.014");
    private BigDecimal bigSumCoefficient = new BigDecimal ("0.024");

    @Override
    public BigDecimal getCoefficient(BigDecimal sum) {

            if (sum.compareTo(new BigDecimal("100")) > 0){
                return bigSumCoefficient;
            }else{
                return coefficientByDefault;
            }

    }
}
