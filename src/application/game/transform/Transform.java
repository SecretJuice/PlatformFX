package application.game.transform;

import application.game.GameBehavior;
import application.game.GameObject;
import application.utils.math.Vector2d;
import com.sun.javafx.geom.Vec2d;

public class Transform extends GameBehavior {

    private Vector2d position;
    private Vector2d scale;
    private double rotation;

    public Vector2d getPosition (){
        return position;
    }
    public void setPosition(Vector2d position){
        this.position = position;
    }
    public Vector2d getScale(){
        return scale;
    }
    public void setScale(Vector2d scale){
        this.scale = scale;
    }
    public double getRotation(){
        return rotation;
    }
    public void setRotation(double rotation){
        this.rotation = rotation;
    }


    public Transform (GameObject gameObject, Vector2d position, Vector2d scale, double rotation){
        super(gameObject, Transform.class);
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }

    public Transform (){
        super(null, Transform.class);
        this.position = null;
        this.scale = null;
        this.rotation = 0;
    }



}
