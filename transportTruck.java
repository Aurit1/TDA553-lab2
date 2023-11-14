import java.awt.*;

public class transportTruck extends Cars {
    private Boolean BedDown;

    transportTruck() {
        super(2, Color.red, 100, "ScaniaTransport");
        BedDown = false; 
    }

    public void RaiseBed() {
        BedDown = false;
    }

    public void LowerBed() {
        BedDown = true;
    }
}
