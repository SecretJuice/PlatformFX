package application.game.movement;

import application.game.GameBehavior;
import application.game.GameObject;
import application.game.transform.Transform;

public class CharacterMovementHandler extends GameBehavior {

    private Transform characerTransform;

    public CharacterMovementHandler(GameObject gameObject){
        super(gameObject, CharacterMovementHandler.class);

        Transform transform = new Transform();

        transform = (Transform) gameObject.getBehavior(transform.getClass());

        this.characerTransform = transform;
    }

    public CharacterMovementHandler(){
        super(null, CharacterMovementHandler.class);
    }




}
