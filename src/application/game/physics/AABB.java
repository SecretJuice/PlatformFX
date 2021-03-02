package application.game.physics;

import application.game.GameBehavior;
import application.game.GameObject;
import application.game.transform.Transform;
import application.utils.math.Vector2d;
import com.sun.javafx.geom.Vec2d;

public class AABB extends GameBehavior {

    private Vector2d offset;
    private Vector2d boundingBoxLengths;
    private boolean isSpike;
    private boolean isStar;

    private Transform transform;

    public Transform getTransform() {
        return transform;
    }

    public Vector2d getOffset() {
        return offset;
    }

    public Vector2d getBoundingBoxLengths() {
        return boundingBoxLengths;
    }

    public boolean isSpike() {
        return isSpike;
    }

    public boolean isStar() {
        return isStar;
    }

    public AABB(GameObject gameObject, Vector2d offset, Vector2d boundingBoxLengths, boolean isSpike, boolean isStar){
        super(gameObject, AABB.class);
        this.offset = offset;
        this.boundingBoxLengths = boundingBoxLengths;
        this.isSpike = isSpike;
        this.isStar = isStar;

        Transform transform = new Transform();
        this.transform = (Transform) gameObject.getBehavior(transform.getClass());

        BBHandler.getInstance().getAabbs().add(this);
    }

    public AABB(){
        super(null, AABB.class);
        this.offset = null;
        this.boundingBoxLengths = null;
        this.isSpike = false;
        this.isStar = false;
    }
}
