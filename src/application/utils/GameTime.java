package application.utils;

public class GameTime {

    private static GameTime instance = null;

    private int deltaTime = 0;
    private long lastTime = System.nanoTime();

    public long getDeltaTime() {
        return deltaTime;
    }

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


        if (true) {
            long time = System.nanoTime();
            deltaTime = (int) ((time - lastTime) / 10000000);
            lastTime = time;
        }

        //System.out.println(deltaTime);

    }

}
