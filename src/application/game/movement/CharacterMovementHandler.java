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
    private float speed = 100;

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

        double deltaTime = GameTime.getInstance().getDeltaTime();

        Vector2d newPosition = new Vector2d(
                characterTransform.getPosition().x + (direction.x * speed * deltaTime),
                characterTransform.getPosition().y + (direction.y * speed * deltaTime));


        if (deltaTime < 0.5d){
            characterTransform.setPosition(newPosition);
        }

        System.out.println("X POS: " + characterTransform.getPosition().x);
        System.out.println("Y POS: " + characterTransform.getPosition().y);

        System.out.println("X VEL: " + direction.x * speed * deltaTime);
        System.out.println("Y VEL: " + direction.y * speed * deltaTime);

        System.out.println("DeltaTime: " + deltaTime);
    }


}
