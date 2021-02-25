package application.game.rendering;

import application.game.GameBehavior;
import application.game.GameObject;
import javafx.scene.image.Image;

import java.lang.reflect.Type;

public class SpriteRenderer extends GameBehavior {

    private Image sprite;
    private int sortingOrder;

    public Image getSprite(){
        return this.sprite;
    }

    public int getSortingOrder(){
        return this.sortingOrder;
    }

    public SpriteRenderer(GameObject gameObject, Image rendererSprite, int rendererSortingOrder){
        super(gameObject, SpriteRenderer.class);
        this.sprite = rendererSprite;
        this.sortingOrder = rendererSortingOrder;
    }

    public SpriteRenderer(){
        super(null, SpriteRenderer.class);
        this.sprite = null;
        this.sortingOrder = 0;
    }

}
