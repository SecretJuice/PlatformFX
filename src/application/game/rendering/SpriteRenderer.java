package application.game.rendering;

import application.game.GameBehavior;
import application.game.GameObject;
import javafx.scene.image.Image;

import java.lang.reflect.Type;

public class SpriteRenderer extends GameBehavior {

    private Image sprite;
    private int sortingOrder;
    private boolean isStatic = false;

    public Image getSprite(){
        return this.sprite;
    }

    public int getSortingOrder(){
        return this.sortingOrder;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public SpriteRenderer(GameObject gameObject, Image rendererSprite, int rendererSortingOrder){
        super(gameObject, SpriteRenderer.class);
        this.sprite = rendererSprite;
        this.sortingOrder = rendererSortingOrder;
        this.isStatic = false;
    }

    public SpriteRenderer(GameObject gameObject, Image rendererSprite, int rendererSortingOrder, boolean isStatic){
        super(gameObject, SpriteRenderer.class);
        this.sprite = rendererSprite;
        this.sortingOrder = rendererSortingOrder;
        this.isStatic = isStatic;
    }

    public SpriteRenderer(){
        super(null, SpriteRenderer.class);
        this.sprite = null;
        this.sortingOrder = 0;
    }

}
