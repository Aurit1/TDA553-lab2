import java.util.ArrayList;

public class Workshop<T extends Cars> {
    
    private int maxNrOfCars;
    private ArrayList<T> carsInWorkshop;
    

    Workshop(int MaxNrOfCars){
        maxNrOfCars = MaxNrOfCars;
        carsInWorkshop = new ArrayList<>(MaxNrOfCars);

    }

    public void loadCar (T car){
        
        if(carsInWorkshop.size() < maxNrOfCars){
            carsInWorkshop.add(car);
        }
        

    }
}
