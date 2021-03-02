package application.game.level;

import application.events.UpdateEventHandler;
import application.game.physics.BBHandler;
import application.game.world.World;
import application.game.world.WorldBuilder;
import application.utils.math.Vector2i;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {

    private static LevelManager instance = null;

    public World currentWorld = null;
    public int currentLevelIndex = 27;
    public Vector2i gameSize = new Vector2i(1280, 704);

    private static List<String> levelData = new ArrayList<String>();

    public static void InitializeLevelData(){

        levelData.add(0, "1111111111111111111111111111111111111111100000000000000000000000000000000000000110000000000000000000000000000000000000011005000000000000000000000000000000000001100000000000000000000000000000000000000112222222000000000000000000000000000000011000000000000000000000000000000000000001100000000000222220000000000000000000000110000000000000000000000000000000000000011000000000000000000000222200000000000001100000000000000000000000000000000000000110000000000000000000000000000022220000011000000000000000000000000000000000000001100000000000000000000000000000000000000110000000000000000000000000000000002222211000002222200000000000000000000000000001100000000000000000000000000000000000000110000000000000000000000000000000000000011000000000000000000022222200000000000001100000000000000000000000000000000000000110000000000000000000000000000000000000011222222222222222200000000000002222222221");

    }

    public static LevelManager getInstance(){
        if (instance == null){
            instance = new LevelManager();
        }
        return instance;
    }

    private World LoadWorld(String levelToLoad){

        WorldBuilder worldBuilder = new WorldBuilder(gameSize, 32);

        UpdateEventHandler.getInstance().getListeners().clear();
        BBHandler.getInstance().getAabbs().clear();

        return worldBuilder.BuildWorld(levelToLoad);

    }

    public void SetLevel(int levelIndexToLoad){

        currentWorld = LoadWorld(levelData.get(levelIndexToLoad));
        currentLevelIndex = levelIndexToLoad;

    }



}
