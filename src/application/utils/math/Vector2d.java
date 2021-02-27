package application.utils.math;

public class Vector2d {

    public double x;
    public double y;

    public Vector2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double CalculateMagnitude(){

        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));

    }

    public double CalculateAngle(){

        return Math.atan2( this.y, this.x) * 180 / Math.PI;

    }
}
