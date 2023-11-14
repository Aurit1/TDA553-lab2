import java.awt.*;

public class Volvo240 extends Cars{

    public final float trimFactor = 1.25f;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }
    
    @Override
    float getSpeedFactor(){
        return getEnginePower() * 0.01f * trimFactor;
    }
}
