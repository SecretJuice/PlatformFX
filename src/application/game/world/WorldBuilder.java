package application.game.world;

import application.game.GameObject;
import application.game.GameObjectFabricator;
import application.game.transform.Transform;
import application.utils.math.Vector2d;
import application.utils.math.Vector2i;

import java.util.ArrayList;
import java.util.List;

public class WorldBuilder {

    private int tileSize;
    private Vector2i gridSize = new Vector2i(0, 0);

    public WorldBuilder(Vector2i gameSize, int tileSize){
        this.gridSize.x = Math.round(gameSize.x / tileSize);
        this.gridSize.y = Math.round(gameSize.y / tileSize);
        this.tileSize = tileSize;
    }

    public World BuildWorld(){
        GameObjectFabricator gameObjectFabricator = new GameObjectFabricator();

        List<GameObject> worldGameObjects = new ArrayList<GameObject>();

        for (int i = 0; i < gridSize.y; i++){
            for (int j = 0; j < gridSize.x; j++){

                GameObject gameObject = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricateGrassTile(), new Vector2i(j, i));

                if (gameObject != null){

                    worldGameObjects.add(gameObject);

                }

            }
        }

        return new World(worldGameObjects);

    }

    private GameObject InstantiateGameObjectOnGrid(GameObject gameObject, Vector2i gridPosition){
        try {
            GameObject instantiatedGameObject = (GameObject) gameObject.clone();

            Transform transform = new Transform();
            transform = (Transform) instantiatedGameObject.getBehavior(transform.getClass());

            transform.setPosition(new Vector2d(gridPosition.x * tileSize, gridPosition.y * tileSize));
            return instantiatedGameObject;
        } catch (CloneNotSupportedException c){
            return null;
        }
    }

}
