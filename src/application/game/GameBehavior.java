package application.game;

public class GameBehavior<T> {

    private T type;
    private GameObject gameObject;

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public T getType() {
        return type;
    }

    public GameBehavior (GameObject gameObject, T type){
        this.gameObject = gameObject;
        this.type = type;
    }

}
