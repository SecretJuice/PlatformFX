package application.game;

import application.game.physics.AABB;
import application.game.rendering.SpriteRenderer;
import application.game.transform.Transform;

import java.lang.reflect.Type;
import java.util.List;

public class GameObject implements Cloneable{

    private List<GameBehavior> gameBehaviors;

    public List<GameBehavior> getGameBehaviors() {
        return gameBehaviors;
    }

    public GameObject(List<GameBehavior> gameBehaviors){
        this.gameBehaviors = gameBehaviors;
    }

    public GameObject(GameObject another){
        this.gameBehaviors = another.getGameBehaviors();
    }

    public <T> GameBehavior<T> getBehavior(Class<? extends GameBehavior> t){
        for (GameBehavior behavior : gameBehaviors){
            if (behavior.getType().equals(t)){
                return t.cast(behavior);
            }
        }
        return null;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
