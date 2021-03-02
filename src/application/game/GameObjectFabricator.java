package application.game;

import application.game.movement.CharacterMovementHandler;
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
        PLAYER.getGameBehaviors().add(new SpriteRenderer(PLAYER, new Image("assets/player/dude.png", 32, 32, true, false), 1));
        PLAYER.getGameBehaviors().add(new AABB(PLAYER, new Vector2d(16, 16), new Vector2d(32, 32), false, false));
        PLAYER.getGameBehaviors().add(new CharacterMovementHandler(PLAYER));

        return PLAYER;

    }

    public GameObject FabricateSpikes(){

        GameObject SPIKES = new GameObject(new ArrayList<GameBehavior>());

        SPIKES.getGameBehaviors().add(new Transform(SPIKES, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        SPIKES.getGameBehaviors().add(new SpriteRenderer(SPIKES, new Image("assets/objects/spikes.png", 32, 32, true, false), 1));
        SPIKES.getGameBehaviors().add(new AABB(SPIKES, new Vector2d(16, 16), new Vector2d(32, 32), true , false));

        return SPIKES;
    }

    public GameObject FabricateStar(){

        GameObject STAR = new GameObject(new ArrayList<GameBehavior>());

        STAR.getGameBehaviors().add(new Transform(STAR, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        STAR.getGameBehaviors().add(new SpriteRenderer(STAR, new Image("assets/objects/star.png", 32, 32, true, false), 1));
        STAR.getGameBehaviors().add(new AABB(STAR, new Vector2d(16, 16), new Vector2d(32, 32), false, true));

        return STAR;
    }

    public GameObject FabricateGrassTile(){

        GameObject GRASS_TILE = new GameObject(new ArrayList<GameBehavior>());

        GRASS_TILE.getGameBehaviors().add(new Transform(GRASS_TILE, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        GRASS_TILE.getGameBehaviors().add(new SpriteRenderer(GRASS_TILE, new Image("assets/tiles/grass.png", 32, 32, true, false), 0, true));
        GRASS_TILE.getGameBehaviors().add(new AABB(GRASS_TILE, new Vector2d(16, 16), new Vector2d(32, 32), false, false));

        return GRASS_TILE;

    }

    public GameObject FabricateDirtTile(){

        GameObject DIRT_TILE = new GameObject(new ArrayList<GameBehavior>());

        DIRT_TILE.getGameBehaviors().add(new Transform(DIRT_TILE, new Vector2d(0, 0), new Vector2d(1, 1), 0D));
        DIRT_TILE.getGameBehaviors().add(new SpriteRenderer(DIRT_TILE, new Image("assets/tiles/dirt.png", 32, 32, true, false), 0, true));
        DIRT_TILE.getGameBehaviors().add(new AABB(DIRT_TILE, new Vector2d(16, 16), new Vector2d(32, 32), false, false));

        return DIRT_TILE;

    }


}
