package application.game.rendering;

import javafx.scene.image.Image;

public class SpriteRenderer {

    private Image sprite;
    private int sortingOrder;

    public Image getSprite(){
        return this.sprite;
    }

    public int getSortingOrder(){
        return this.sortingOrder;
    }

    public SpriteRenderer(Image rendererSprite, int rendererSortingOrder){
        this.sprite = rendererSprite;
        this.sortingOrder = rendererSortingOrder;
    }

}
