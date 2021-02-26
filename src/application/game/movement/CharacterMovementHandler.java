package application.game.movement;

import application.events.UpdateEventHandler;
import application.events.interfaces.UpdateListener;
import application.game.GameBehavior;
import application.game.GameObject;
import application.game.input.PlayerInputHandler;
import application.game.transform.Transform;
import application.utils.GameTime;
import application.utils.math.Vector2d;

public class CharacterMovementHandler extends GameBehavior implements UpdateListener {

    private Transform characterTransform;
    private float speed = 5;

    public CharacterMovementHandler(GameObject gameObject){
        super(gameObject, CharacterMovementHandler.class);

        Transform transform = new Transform();

        transform = (Transform) gameObject.getBehavior(transform.getClass());

        this.characterTransform = transform;

        UpdateEventHandler.getInstance().addListener(this);
    }

    public CharacterMovementHandler(){
        super(null, CharacterMovementHandler.class);
    }

    @Override
    public void Update(){

        Vector2d direction = new Vector2d(0, 0);

        if (PlayerInputHandler.getInstance().isRightKeyDown){
            direction.x++;
        }
        if (PlayerInputHandler.getInstance().isLeftKeyDown){
            direction.x--;
        }
        if (PlayerInputHandler.getInstance().isUpKeyDown){
            direction.y--;
        }
        if (PlayerInputHandler.getInstance().isDownKeyDown){
            direction.y++;
        }

        Vector2d newPosition = new Vector2d(
                characterTransform.getPosition().x + (direction.x * speed * GameTime.getInstance().getDeltaTime()),
                characterTransform.getPosition().y + (direction.y * speed * GameTime.getInstance().getDeltaTime()));

        characterTransform.setPosition(newPosition);

        System.out.println("X: " + characterTransform.getPosition().x);
        System.out.println("Y: " + characterTransform.getPosition().y);
    }


}
