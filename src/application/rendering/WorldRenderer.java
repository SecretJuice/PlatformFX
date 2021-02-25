package application.rendering;

import application.game.GameObject;
import application.game.World;
import application.game.rendering.SpriteRenderer;
import application.game.transform.Transform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorldRenderer {

    public static void RenderWorldObjects(Group worldGroup, World world){

        List<GameObject> worldGameObjects = world.getWorldGameObjects();

        SortRenderersBySortingOrder(worldGameObjects);

        for (GameObject gameObject : worldGameObjects) {

            SpriteRenderer renderer = gameObject.getSpriteRenderer();
            Transform transform = gameObject.getTransform();

            ImageView imageView = new ImageView(renderer.getSprite());

            imageView.setX(transform.getPosition().x);
            imageView.setY(transform.getPosition().y);

            imageView.setScaleX(transform.getScale().x);
            imageView.setScaleY(transform.getScale().y);

            imageView.setRotate(transform.getRotation());

            worldGroup.getChildren().add(imageView);

        }

    }

    private static void SortRenderersBySortingOrder(List<GameObject> gameObjects){
        Collections.sort(gameObjects, new Comparator<GameObject>() {
            @Override
            public int compare(GameObject o1, GameObject o2) {
                return o1.getSpriteRenderer().getSortingOrder() - o2.getSpriteRenderer().getSortingOrder();
            }
        });
    }


}
