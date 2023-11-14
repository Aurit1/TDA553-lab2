import java.awt.*;

class Scania extends Cars{

    private float trailerAngle;

    
    public Scania(){
        super(2, Color.white, 100, "Scania"); 
	    trailerAngle = 0;

    }
    public Scania(int nrDoors, Color color, int enginepower, String Modelname){
        super(nrDoors, color, enginepower, Modelname); 
	    trailerAngle = 0;

    }

    /**
    * Increases the trailers angle by x.
    *
    * @param  x   the amount the trailer's angle should be increased with
    
    */
    public void RaiseTrailer(float x) {
        if(getCurrentSpeed() == 0) {
            trailerAngle = Math.min(70, trailerAngle += x);
        }
    }

    /**
    * Decreases the trailers angle by x.
    *
    * @param  x   the amount the trailer's angle should be decreased with
    
    */
    public void LowerTrailer(float x) {
        if(getCurrentSpeed() == 0) {
            trailerAngle = Math.max(0, trailerAngle -= x);
        }
    }

    @Override
    float getSpeedFactor(){
        if(trailerAngle == 0) {
            return getEnginePower() * 0.01f;
        }
        else {
            return 0;
        }
        
    }

    public float GetTrailerAngle() {
        return trailerAngle;
    }
    
}