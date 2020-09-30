import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RiskCoefficientTest {

    @Test
    public void testFireDefaultCoefficient (){
        GetCoefficientOfFireRisk getCoefficientOfFireRisk = new GetCoefficientOfFireRisk ();
        BigDecimal sum = new BigDecimal("55");
        BigDecimal expectedResult = new BigDecimal("0.014");
        BigDecimal result = getCoefficientOfFireRisk.getCoefficient(sum);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFireDefaultCoefficientIfSum100 (){
        GetCoefficientOfFireRisk getCoefficientOfFireRisk = new GetCoefficientOfFireRisk ();
        BigDecimal sum = new BigDecimal("100");
        BigDecimal expectedResult = new BigDecimal("0.014");
        BigDecimal result = getCoefficientOfFireRisk.getCoefficient(sum);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFireBigSumCoefficientCoefficient (){
        GetCoefficientOfFireRisk getCoefficientOfFireRisk = new GetCoefficientOfFireRisk ();
        BigDecimal sum = new BigDecimal("200");
        BigDecimal expectedResult = new BigDecimal("0.024");
        BigDecimal result = getCoefficientOfFireRisk.getCoefficient(sum);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTheftDefaultCoefficient (){
        GetCoefficientOfTheftRisk getCoefficientOfTheftRisk = new GetCoefficientOfTheftRisk ();
        BigDecimal sum = new BigDecimal("10");
        BigDecimal expectedResult = new BigDecimal("0.11");
        BigDecimal result = getCoefficientOfTheftRisk.getCoefficient(sum);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTheftDefaultCoefficientIfSum15 (){
        GetCoefficientOfTheftRisk getCoefficientOfTheftRisk = new GetCoefficientOfTheftRisk ();
        BigDecimal sum = new BigDecimal("15");
        BigDecimal expectedResult = new BigDecimal("0.05");
        BigDecimal result = getCoefficientOfTheftRisk.getCoefficient(sum);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTheftBigSumCoefficientCoefficient (){
        GetCoefficientOfTheftRisk getCoefficientOfTheftRisk = new GetCoefficientOfTheftRisk ();
        BigDecimal sum = new BigDecimal("165");
        BigDecimal expectedResult = new BigDecimal("0.05");
        BigDecimal result = getCoefficientOfTheftRisk.getCoefficient(sum);
        assertEquals(expectedResult, result);
    }

}