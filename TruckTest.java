import java.awt.Color;
import org.junit.*;


public class TruckTest {
    Scania myScania = new Scania();
    
    @Test
    public void TrailerDriveTest() {
        myScania.startEngine();
        myScania.brake(1);
        myScania.RaiseTrailer(15);
        myScania.gas(1);
        
        Assert.assertEquals(0, myScania.getCurrentSpeed(), 0);
    }

    @Test
    public void TrailerWhileDrivingTest() {
        // You should not be able to raise the trailer while the car is moving.
        // this test is built on the fact that the car starts moving once the engine is turned on
        myScania.startEngine();
        myScania.RaiseTrailer(10);
        Assert.assertEquals(0, myScania.GetTrailerAngle(), 0);
    }

    @Test
    public void trailerAngleAndRaiseTrailerTest() {
        myScania.startEngine();
        myScania.brake(1);
        myScania.RaiseTrailer(18);
        
        Assert.assertEquals(18, myScania.GetTrailerAngle(), 0);
    }

    @Test
    public void LowerTrailerTest() {
        float expectedDifference = 5;

        myScania.startEngine();
        myScania.brake(1);
        myScania.RaiseTrailer(18);

        float beforeLowering = myScania.GetTrailerAngle(); 

        myScania.LowerTrailer(expectedDifference);

        float afterLowering = myScania.GetTrailerAngle();
        float difference = beforeLowering - afterLowering;

        Assert.assertEquals(expectedDifference, difference, 0);
    }
}
