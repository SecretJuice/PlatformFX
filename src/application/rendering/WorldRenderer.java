package application.rendering;

import application.game.GameObject;
import application.game.world.World;
import application.game.rendering.SpriteRenderer;
import application.game.transform.Transform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorldRenderer {

    public static void RenderStaticWorldObjects(Group worldGroup, World world){

        List<GameObject> worldGameObjects = world.getWorldGameObjects();

        SortRenderersBySortingOrder(worldGameObjects);

        for (GameObject gameObject : worldGameObjects) {

            SpriteRenderer renderer = new SpriteRenderer();
            renderer = (SpriteRenderer) gameObject.getBehavior(renderer.getClass());

            if (renderer == null){
                continue;
            }

            if (!renderer.isStatic()){
                continue;
            }

            Transform transform = new Transform();
            transform = (Transform) gameObject.getBehavior(transform.getClass());

            if (transform == null){
                continue;
            }

            ImageView imageView = new ImageView(renderer.getSprite());

            imageView.setX(transform.getPosition().x);
            imageView.setY(transform.getPosition().y);

            //imageView.setScaleX(transform.getScale().x);
            //imageView.setScaleY(transform.getScale().y);

            imageView.setRotate(transform.getRotation());

            imageView.smoothProperty().set(false);

            worldGroup.getChildren().add(imageView);

        }

    }

    public static void RenderWorldObjects(Group worldGroup, World world){

        List<GameObject> worldGameObjects = world.getWorldGameObjects();

        SortRenderersBySortingOrder(worldGameObjects);

        for (GameObject gameObject : worldGameObjects) {

            SpriteRenderer renderer = new SpriteRenderer();
            renderer = (SpriteRenderer) gameObject.getBehavior(renderer.getClass());

            if (renderer == null){
                continue;
            }

            if (renderer.isStatic()){
                continue;
            }

            Transform transform = new Transform();
            transform = (Transform) gameObject.getBehavior(transform.getClass());

            if (transform == null){
                continue;
            }

            ImageView imageView = new ImageView(renderer.getSprite());

            imageView.setX(transform.getPosition().x);
            imageView.setY(transform.getPosition().y);

            imageView.setScaleX(transform.getScale().x);
            imageView.setScaleY(transform.getScale().y);

            imageView.setRotate(transform.getRotation());

            imageView.smoothProperty().set(false);

            worldGroup.getChildren().add(imageView);

        }

    }

    public static void ClearNonStaticWorldObjects(Group group, World world){

        List<GameObject> worldGameObjects = world.getWorldGameObjects();

        SortRenderersBySortingOrder(worldGameObjects);

        for (int i = 0; i < worldGameObjects.size(); i++){

            GameObject gameObject = worldGameObjects.get(i);

            SpriteRenderer renderer = new SpriteRenderer();
            renderer = (SpriteRenderer) gameObject.getBehavior(renderer.getClass());

            if (renderer.isStatic()){
                continue;
            }
            group.getChildren().remove(i);

        }

//        for (GameObject gameObject : worldGameObjects){
//
//            SpriteRenderer renderer = new SpriteRenderer();
//            renderer = (SpriteRenderer) gameObject.getBehavior(renderer.getClass());
//
//            ImageView imageView = new ImageView(renderer.getSprite());
//
//            if (renderer.isStatic()){
//                continue;
//            }
//
//            group.getChildren().remove(imageView);
//        }

    }

    private static void SortRenderersBySortingOrder(List<GameObject> gameObjects){
        Collections.sort(gameObjects, new Comparator<GameObject>() {
            @Override
            public int compare(GameObject o1, GameObject o2) {
                SpriteRenderer firstRenderer = new SpriteRenderer();
                firstRenderer = (SpriteRenderer) o1.getBehavior(firstRenderer.getClass());

                SpriteRenderer secondRenderer = new SpriteRenderer();
                secondRenderer = (SpriteRenderer) o2.getBehavior(secondRenderer.getClass());

                return firstRenderer.getSortingOrder() - secondRenderer.getSortingOrder();
            }
        });
    }


}
