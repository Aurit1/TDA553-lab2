import java.awt.*;

class Saab95 extends Cars{

    private boolean turboOn;
    float turbo = 1;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95"); 
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }
    
    public void setTurboOff(){
	    turboOn = false;
    } 
    
    @Override
    float getSpeedFactor(){
        if(turboOn) turbo = 1.3f;
        return getEnginePower() * 0.01f * turbo;        
    }
}