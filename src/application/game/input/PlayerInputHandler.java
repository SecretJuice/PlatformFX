package application.game.input;

public class PlayerInputHandler {

    public boolean isLeftKeyDown = false;
    public boolean isRightKeyDown = false;
    public boolean isUpKeyDown = false;
    public boolean isDownKeyDown = false;

    private static PlayerInputHandler instance = null;

    private PlayerInputHandler(){}

    public static PlayerInputHandler getInstance(){
        if (instance == null){
            instance = new PlayerInputHandler();
        }
        return instance;
    }

}
