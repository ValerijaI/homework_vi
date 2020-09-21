import domain.Policy;

import java.math.BigDecimal;


interface PremiumCalculator {

    BigDecimal calculate (Policy policy);

}
