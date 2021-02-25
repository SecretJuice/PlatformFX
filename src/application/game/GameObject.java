package application.game;

import application.game.physics.AxisAlignedBoundingBox;
import application.game.rendering.SpriteRenderer;
import application.game.transform.Transform;

public class GameObject {

    private Transform transform;
    private SpriteRenderer spriteRenderer;
    private AxisAlignedBoundingBox axisAlignedBoundingBox;

    public Transform getTransform() {
        return transform;
    }

    public SpriteRenderer getSpriteRenderer() {
        return spriteRenderer;
    }

    public AxisAlignedBoundingBox getAxisAlignedBoundingBox() {
        return axisAlignedBoundingBox;
    }

    public GameObject(Transform transform, SpriteRenderer spriteRenderer, AxisAlignedBoundingBox axisAlignedBoundingBox){
        this.transform = transform;
        this.spriteRenderer = spriteRenderer;
        this.axisAlignedBoundingBox = axisAlignedBoundingBox;
    }
}
