package application.utils;

public class GameTime {

    private static GameTime instance = null;

    private float deltaTime = 0;

    private GameTime(){
        deltaTime = 0;
        CalculateDeltaTime();
    }

    public static GameTime getInstance(){
        if (instance == null){
            instance = new GameTime();
        }
        return instance;
    }

    public void CalculateDeltaTime(){
        float last_time = System.nanoTime();

        if (true) {
            float time = System.nanoTime();
            float deltaTime = (float) ((time - last_time) / 1000000);
            last_time = time;
        }
        System.out.println(deltaTime);

    }

}
