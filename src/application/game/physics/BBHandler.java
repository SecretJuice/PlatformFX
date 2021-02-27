package application.game.physics;

import application.game.transform.Transform;
import application.utils.GameTime;

import java.util.ArrayList;
import java.util.List;

public class BBHandler {

    private static BBHandler instance = null;

    private List<AABB> aabbs = new ArrayList<AABB>();

    public List<AABB> getAabbs() {
        return aabbs;
    }


    public static BBHandler getInstance(){
        if (instance == null){
            instance = new BBHandler();
        }
        return instance;
    }

}
