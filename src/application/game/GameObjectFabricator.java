package application.game;

import application.game.physics.AABB;
import application.game.rendering.SpriteRenderer;
import application.game.transform.Transform;
import application.utils.math.Vector2d;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class GameObjectFabricator {

//    public GameObjectFabricator(){
//
//    }

    public GameObject FabricatePlayer(){

        GameObject PLAYER = new GameObject(new ArrayList<GameBehavior>());

        PLAYER.getGameBehaviors().add(new Transform(PLAYER, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        PLAYER.getGameBehaviors().add(new SpriteRenderer(PLAYER, new Image("assets/player/dude.png", 64, 64, true, false), 1));
        PLAYER.getGameBehaviors().add(new AABB(PLAYER, new Vector2d(0, 0), new Vector2d(64, 64)));

        return PLAYER;

    }

    public GameObject FabricateGrassTile(){

        GameObject GRASS_TILE = new GameObject(new ArrayList<GameBehavior>());

        GRASS_TILE.getGameBehaviors().add(new Transform(GRASS_TILE, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        GRASS_TILE.getGameBehaviors().add(new SpriteRenderer(GRASS_TILE, new Image("assets/tiles/grass.png", 64, 64, true, false), 0));
        GRASS_TILE.getGameBehaviors().add(new AABB(GRASS_TILE, new Vector2d(0, 0), new Vector2d(64, 64)));

        return GRASS_TILE;

    }

    public GameObject FabricateDirtTile(){

        GameObject DIRT_TILE = new GameObject(new ArrayList<GameBehavior>());

        DIRT_TILE.getGameBehaviors().add(new Transform(DIRT_TILE, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        DIRT_TILE.getGameBehaviors().add(new SpriteRenderer(DIRT_TILE, new Image("assets/tiles/dirt.png", 64, 64, true, false), 0));
        DIRT_TILE.getGameBehaviors().add(new AABB(DIRT_TILE, new Vector2d(0, 0), new Vector2d(64, 64)));

        return DIRT_TILE;

    }


}