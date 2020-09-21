
import java.math.BigDecimal;

class GetCoefficientOfFireRisk implements GetCoefficientOfRiskType{

    @Override
    public BigDecimal getCoefficient(BigDecimal sum) {

            if (sum.compareTo(new BigDecimal("100")) > 0){
                return new BigDecimal ("0.024");
            }else{
                return new BigDecimal ("0.014");
            }

    }
}
