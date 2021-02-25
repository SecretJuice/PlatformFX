package application.game.physics;

import application.game.GameBehavior;
import application.game.GameObject;
import application.utils.math.Vector2d;
import com.sun.javafx.geom.Vec2d;

public class AABB extends GameBehavior {

    private Vector2d offset;
    private Vector2d boundingBoxLengths;

    public Vector2d getOffset() {
        return offset;
    }

    public Vector2d getBoundingBoxLengths() {
        return boundingBoxLengths;
    }

    public AABB(GameObject gameObject, Vector2d offset, Vector2d boundingBoxLengths){
        super(gameObject, AABB.class);
        this.offset = offset;
        this.boundingBoxLengths = boundingBoxLengths;
    }
    public AABB(){
        super(null, AABB.class);
        this.offset = null;
        this.boundingBoxLengths = null;
    }
}
