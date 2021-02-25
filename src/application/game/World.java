package application.game;

import java.util.List;

public class World {

    public List<GameObject> worldGameObjects;

    public List<GameObject> getWorldGameObjects(){
        return worldGameObjects;
    }

    public World(List<GameObject> worldGameObjects){
        this.worldGameObjects = worldGameObjects;
    }


}
