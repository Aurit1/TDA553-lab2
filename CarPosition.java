public class CarPosition {
    float x;
    float y;

    CarPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static float calcDistance(Cars car1, Cars car2) {
        float _distanceX = (car1.getPosition().x - car2.getPosition().x);
        
        float _distanceY = car1.getPosition().y - car2.getPosition().y;
        
        float _diagonalSquared = (_distanceX*_distanceX) + (_distanceY*_distanceY);

        return _diagonalSquared;
    }
}