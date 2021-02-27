package application.utils.math;

public class Vector2i {

    public int x;
    public int y;

    public Vector2i(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double CalculateMagnitude(){

        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));

    }

    public double CalculateAngle(){

        return Math.asin( this.y / CalculateMagnitude());

    }

}
