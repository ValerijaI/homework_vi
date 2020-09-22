import domain.ObjectOfPolicy;
import domain.Policy;
import domain.RiskType;
import domain.SubObject;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PremiumCalculatorImplTest {


    PremiumCalculator calculator = new PremiumCalculatorImpl();

    @Test
    public void acceptanceTest1(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("100"), RiskType.FIRE);
        SubObject subObject2 = new SubObject("PC", new BigDecimal("8"), RiskType.THEFT);
        ObjectOfPolicy objectOfPolicy = new ObjectOfPolicy("A House", subObject1, subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "REGISTERED", objectOfPolicy);

        BigDecimal expectedPolicyPremium = new BigDecimal("2.28");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void acceptanceTest2(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("200"), RiskType.FIRE);
        SubObject subObject2 = new SubObject("TV", new BigDecimal("300"), RiskType.FIRE);
        SubObject subObject3 = new SubObject("PC", new BigDecimal("100.51"), RiskType.THEFT);
        SubObject subObject4 = new SubObject("PC", new BigDecimal("2"), RiskType.THEFT);
        ObjectOfPolicy objectOfPolicy1 = new ObjectOfPolicy("A House", subObject1, subObject3);
        ObjectOfPolicy objectOfPolicy2 = new ObjectOfPolicy("A Flat", subObject4, subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "APPROVED", objectOfPolicy1, objectOfPolicy2);

        BigDecimal expectedPolicyPremium = new BigDecimal("17.13");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testNoSubObjects(){
        ObjectOfPolicy objectOfPolicy1 = new ObjectOfPolicy("A House");
        ObjectOfPolicy objectOfPolicy2 = new ObjectOfPolicy("A Flat");
        Policy policy = new Policy("LV20-02-100000-5", "APPROVED", objectOfPolicy1, objectOfPolicy2);

        BigDecimal expectedPolicyPremium = new BigDecimal("0.00");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testTwoObjectsOneSubObjectWithRiskTypeFire(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("200"), RiskType.FIRE);
        ObjectOfPolicy objectOfPolicy1 = new ObjectOfPolicy("A House", subObject1);
        ObjectOfPolicy objectOfPolicy2 = new ObjectOfPolicy("A Flat");
        Policy policy = new Policy("LV20-02-100000-5", "APPROVED", objectOfPolicy1, objectOfPolicy2);

        BigDecimal expectedPolicyPremium = new BigDecimal("4.80");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testTwoObjectsOneSubObjectWithRiskTypeTheft(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("200"), RiskType.THEFT);
        ObjectOfPolicy objectOfPolicy1 = new ObjectOfPolicy("A House");
        ObjectOfPolicy objectOfPolicy2 = new ObjectOfPolicy("A Flat", subObject1);
        Policy policy = new Policy("LV20-02-100000-5", "APPROVED", objectOfPolicy1, objectOfPolicy2);

        BigDecimal expectedPolicyPremium = new BigDecimal("10.00");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testOneObjectTwoSubObjectsBothRisks(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("100"), RiskType.FIRE, RiskType.THEFT);
        SubObject subObject2 = new SubObject("PC", new BigDecimal("8"), RiskType.THEFT, RiskType.FIRE);
        ObjectOfPolicy objectOfPolicy = new ObjectOfPolicy("A House", subObject1, subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "REGISTERED", objectOfPolicy);

        BigDecimal expectedPolicyPremium = new BigDecimal("7.99");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testOneObjectOneSubObjectLowFireRisk(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("52"), RiskType.FIRE);
        SubObject subObject2 = new SubObject("PC", new BigDecimal("48"), RiskType.FIRE);
        ObjectOfPolicy objectOfPolicy = new ObjectOfPolicy("A House", subObject1, subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "REGISTERED", objectOfPolicy);

        BigDecimal expectedPolicyPremium = new BigDecimal("1.40");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testOneObjectOneSubObjectHighFireRisk(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("152"), RiskType.FIRE);
        SubObject subObject2 = new SubObject("PC", new BigDecimal("148"), RiskType.FIRE);
        ObjectOfPolicy objectOfPolicy = new ObjectOfPolicy("A House", subObject1, subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "REGISTERED", objectOfPolicy);

        BigDecimal expectedPolicyPremium = new BigDecimal("7.20");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testTwoObjectOneSubObjectLowTheftRisk(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("10"), RiskType.THEFT);
        SubObject subObject2 = new SubObject("PC", new BigDecimal("4"), RiskType.THEFT);
        ObjectOfPolicy objectOfPolicy1 = new ObjectOfPolicy("A House", subObject1);
        ObjectOfPolicy objectOfPolicy2 = new ObjectOfPolicy("A Flat", subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "REGISTERED", objectOfPolicy1, objectOfPolicy2);

        BigDecimal expectedPolicyPremium = new BigDecimal("1.54");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

    @Test
    public void testTwoObjectOneSubObjectHighTheftRisk(){
        SubObject subObject1 = new SubObject("TV", new BigDecimal("100"), RiskType.THEFT);
        SubObject subObject2 = new SubObject("PC", new BigDecimal("400"), RiskType.THEFT);
        ObjectOfPolicy objectOfPolicy1 = new ObjectOfPolicy("A House", subObject1);
        ObjectOfPolicy objectOfPolicy2 = new ObjectOfPolicy("A Flat", subObject2);
        Policy policy = new Policy("LV20-02-100000-5", "REGISTERED", objectOfPolicy1, objectOfPolicy2);

        BigDecimal expectedPolicyPremium = new BigDecimal("25.00");
        BigDecimal calculatedPolicyPremium = calculator.calculate(policy);
        assertEquals(expectedPolicyPremium, calculatedPolicyPremium);
    }

}