//import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;

public class TruckTest {

    
    
    Scania myScania = new Scania();
    transportTruck myTruck = new transportTruck(4);
    
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

    @Test
    public void LoadCars() {
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();

        myTruck.LowerBed();


        myTruck.loadCar(saab1);
        myTruck.loadCar(volvo1);
        myTruck.loadCar(saab2);
        myTruck.loadCar(volvo2);

        ArrayList<Cars> expectedList = new ArrayList<>(Arrays.asList(saab1, volvo1, saab2, volvo2));

        Assert.assertEquals(expectedList, myTruck.getLoad());

    }

    @Test
    public void MaxNrOfCars() {
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();

        transportTruck myTruck = new transportTruck(3);
        myTruck.LowerBed();

        myTruck.loadCar(saab1);
        myTruck.loadCar(volvo1);
        myTruck.loadCar(saab2);
        myTruck.loadCar(volvo2);

        Assert.assertFalse(myTruck.getLoad().contains(volvo2));
    }

    @Test
    public void UnloadCar() {
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();

        transportTruck myTruck = new transportTruck(4);
        myTruck.LowerBed();
        myTruck.loadCar(saab1);
        myTruck.loadCar(volvo1);
        myTruck.loadCar(saab2);
        myTruck.loadCar(volvo2);

        myTruck.unloadCar();

        Assert.assertFalse(myTruck.getLoad().contains(volvo2));
    }

    @Test
    public void MoveLoad() {
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();

        myTruck.LowerBed();


        myTruck.loadCar(saab1);
        myTruck.loadCar(volvo1);
        myTruck.loadCar(saab2);
        myTruck.loadCar(volvo2);

        myTruck.RaiseBed();
        myTruck.gas(1);
        myTruck.move();

        CarPosition loadPosition = myTruck.getLoad().get(0).getPosition();

        
        // Car only moves in the Y axis so we only need to test this
        Assert.assertEquals(loadPosition.y, myTruck.getPosition().y, 0);
    }
}
