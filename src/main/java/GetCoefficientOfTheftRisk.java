
import java.math.BigDecimal;


class GetCoefficientOfTheftRisk implements GetCoefficientOfRiskType{


    @Override
    public BigDecimal getCoefficient(BigDecimal sum) {

            if (sum.compareTo(new BigDecimal("15")) >= 0){
                return new BigDecimal ("0.05");
            }else{
                return new BigDecimal ("0.11");
            }
    }
}
