import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Lab3_CTest {

    @Test
    public void DistanceTest() {
        Lab3_C.ComplexPoint Test1 = new Lab3_C.ComplexPoint(2, 2);
        Lab3_C.ComplexPoint Test2 = new Lab3_C.ComplexPoint(-6, 2);

        double actual = Lab3_C.distance(Test1, Test2);
        double expected = 8;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void Distance_btw0_Test(){
        Lab3_C.ComplexPoint Test = new Lab3_C.ComplexPoint(2, 0);
        double actual = Lab3_C.distance_start(Test);
        double expected = 2;
        Assert.assertEquals(actual, expected);
    }
}
