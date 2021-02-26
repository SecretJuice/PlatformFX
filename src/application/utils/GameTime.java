package application.utils;

public class GameTime {

    private static GameTime instance = null;

    private double deltaTime = 0;
    private double lastTime = System.nanoTime();

    public double getDeltaTime() {
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
            double time = System.nanoTime();
            deltaTime = (double) ((time - lastTime) / 1000000000);
            lastTime = time;
        }

        //System.out.println(deltaTime);

    }

}
