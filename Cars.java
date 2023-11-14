import java.awt.*;

public class Cars implements Movable{

    enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH
    }
    
    private int nrDoors; // Number of doors on the car
    private int enginePower; // Engine power of the car
    private float currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction facingDirection;
    private CarPosition position;
    private boolean carIsOn;
    
    Cars(int nrDoors,Color color,int enginePower,String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        facingDirection = Direction.NORTH;
        position = new CarPosition(0f,0f);
        stopEngine();
    }
    
    public final int getNrDoors(){
        return nrDoors;
    }
    public final float getEnginePower(){
        return enginePower;
    }

    public final float getCurrentSpeed(){
        return currentSpeed;
    }

    public final Color getColor(){
        return color;
    }

    public final String getModelName(){
        return modelName;
    }


    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1f;
        carIsOn = true;
    }

    public void stopEngine(){
	    currentSpeed = 0f;
        carIsOn = false;
    }
    
    float getSpeedFactor(){
        return enginePower * 0.01f;
    }

    private void incrementSpeed(float amount){
	    currentSpeed = Math.min(getCurrentSpeed() + getSpeedFactor() * amount,enginePower);
    }

    private void decrementSpeed(float amount){
        currentSpeed = Math.max(getCurrentSpeed() - getSpeedFactor() * amount,0);
    }

    public void gas(float amount){
        if(amount <= 1 && amount >= 0 && carIsOn) {
            incrementSpeed(amount);
        }
    }
    
    public void brake(float amount){
        if(amount <= 1 && amount >= 0 && carIsOn) {
            decrementSpeed(amount);
        }
    }

    public void turnLeft(){
        switch (facingDirection) {
            case NORTH:
                facingDirection = Direction.WEST;
                break;
            case EAST:
                facingDirection = Direction.NORTH;
                break;
            case SOUTH:
                facingDirection = Direction.EAST;
                break;
            case WEST:
                facingDirection = Direction.SOUTH;
                break;
        }
    }

    public void turnRight(){
        switch (facingDirection) {
            case NORTH:
                facingDirection = Direction.EAST;
                break;
            case EAST:
                facingDirection = Direction.SOUTH;
                break;
            case SOUTH:
                facingDirection = Direction.WEST;
                break;
            case WEST:
                facingDirection = Direction.NORTH;
                break;
        }
    }
    
    public void move(){
        switch (facingDirection) {
            case NORTH:
                position.y += currentSpeed;
                break;
            case WEST:
                position.x -= currentSpeed;
                break;
            case EAST:
                position.x += currentSpeed;
                break;
            case SOUTH:
                position.y -= currentSpeed;
                break;
        }
    }

    public CarPosition getPosition(){
        return position;
    }
}