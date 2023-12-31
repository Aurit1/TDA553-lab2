import java.awt.*;
import java.util.ArrayList;

public class transportTruck extends Cars{
    private Boolean bedDown;
    private int maxNrCars;
    ArrayList<Cars> carLoad;

    transportTruck(int maxNrCars) {
        super(2, Color.magenta, 100, "TransportTruck", 1000);
        bedDown = false; 
        this.maxNrCars = maxNrCars;
        carLoad = new ArrayList<>(maxNrCars);
    }

    public int getMaxNrCars(){
        return maxNrCars;
    }

    public ArrayList<Cars> getLoad(){
        return carLoad;
    }

    public Boolean getBedState() {
        return bedDown;
    }
    
    public void RaiseBed() {
        bedDown = false;
    }

    public void LowerBed() {
        if(getCurrentSpeed() == 0) {
            bedDown = true;
        }
    }

    //Q HERE
    public void loadCar(Cars car) {
        
        Boolean _canBeLoaded = true;


        if (CarPosition.calcDistance(this,car) > 1f || !bedDown || car.getCarSize() > 100 || this.getCurrentSpeed() > 0) { //This
            System.out.print("Hello");
            _canBeLoaded = false;
        }

        if (_canBeLoaded && carLoad.size() < maxNrCars) {
            carLoad.add(car);
        }
        
    }
    
    public void unloadCar() {
        if(carLoad.size() > 0 || this.getCurrentSpeed() == 0) {
            Cars car = carLoad.get((carLoad.size() - 1));
            carLoad.remove((carLoad.size() - 1));

            car.setPosition(this.getPosition().x, this.getPosition().y - 1);
        }
    }
    
    public void unloadCar(int amount) {
        if(amount <= carLoad.size()) {
            for (int i = 0; i < amount; i++) {
                if(carLoad.size() > 0) {
                    Cars car = carLoad.get((carLoad.size() - 1));
                    carLoad.remove((carLoad.size() - 1));

                    car.setPosition(this.getPosition().x, this.getPosition().y - 1);
                }
            }
        }
    }
    
    @Override
    public void move() {
        super.move();
        for (Cars car : carLoad) {
            car.setPosition(this.getPosition().x, this.getPosition().y);
        }
    }

    @Override
    float getSpeedFactor() {
        if(bedDown) {
            return 0;
        } 
        else {
            return (0.01f*getEnginePower());
        }
    }
}
