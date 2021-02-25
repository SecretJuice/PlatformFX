package application.game.physics;

import application.utils.math.Vector2d;
import com.sun.javafx.geom.Vec2d;

public class AxisAlignedBoundingBox {

    private Vector2d offset;
    private Vector2d boundingBoxLengths;

    public Vector2d getOffset() {
        return offset;
    }

    public Vector2d getBoundingBoxLengths() {
        return boundingBoxLengths;
    }

    public AxisAlignedBoundingBox(Vector2d offset, Vector2d boundingBoxLengths){
        this.offset = offset;
        this.boundingBoxLengths = boundingBoxLengths;
    }
}
