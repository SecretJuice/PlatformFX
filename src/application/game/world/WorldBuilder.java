package application.game.world;

import application.game.GameObject;
import application.game.GameObjectFabricator;
import application.game.level.LevelStringHolder;
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

    public World BuildWorld(String levelString){
        GameObjectFabricator gameObjectFabricator = new GameObjectFabricator();

        List<GameObject> worldGameObjects = new ArrayList<GameObject>();

        int tileIndex = 0;

        for (int i = 0; i < gridSize.y; i++){
            for (int j = 0; j < gridSize.x; j++){

                char tileChar = levelString.charAt(tileIndex);



//                GameObject dirty = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricateDirtTile(), new Vector2i(j, i));
//                if (dirty != null){
//                    worldGameObjects.add(dirty);
//                }

                switch (tileChar){
                    case '0':
                        break;
                    case '1':
                        GameObject dirt = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricateDirtTile(), new Vector2i(j, i));
                        if (dirt != null){
                            worldGameObjects.add(dirt);
                        }
                        break;
                    case '2':
                        GameObject grass = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricateGrassTile(), new Vector2i(j, i));
                        if (grass != null){
                            worldGameObjects.add(grass);
                        }
                        break;
                    case '3':
                        GameObject spikes = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricateSpikes(), new Vector2i(j, i));
                        if (spikes != null){
                            worldGameObjects.add(spikes);
                        }
                        break;
                    case '4':
                        GameObject star = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricateStar(), new Vector2i(j, i));
                        if (star != null){
                            worldGameObjects.add(star);
                        }
                        break;
                    case '5':
                        GameObject player = InstantiateGameObjectOnGrid(gameObjectFabricator.FabricatePlayer(), new Vector2i(j, i));
                        if (player != null){
                            worldGameObjects.add(player);
                        }
                        break;
                    default:
                        System.out.println("TileIDNotFound");
                }

                tileIndex++;



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
