package application.game.movement;

import application.Main;
import application.events.UpdateEventHandler;
import application.events.interfaces.UpdateListener;
import application.game.GameBehavior;
import application.game.GameObject;
import application.game.input.PlayerInputHandler;
import application.game.level.LevelManager;
import application.game.physics.AABB;
import application.game.physics.BBHandler;
import application.game.transform.Transform;
import application.utils.GameTime;
import application.utils.math.Vector2d;

public class CharacterMovementHandler extends GameBehavior implements UpdateListener {

    private Transform characterTransform;
    private AABB aabb;
    private float speed = 300;
    private float gravity = 35;

    private final double jumpInputBufferTime = 0.1f;
    private double jumpInputTimer = 0;

    private final double groundedBufferTime = 0.1f;
    private double groundedTimer = 0;

    private boolean jumpIsDown = false;

    private Vector2d velocity = new Vector2d(0, 0);

    public CharacterMovementHandler(GameObject gameObject){
        super(gameObject, CharacterMovementHandler.class);

        Transform transform = new Transform();

        transform = (Transform) gameObject.getBehavior(transform.getClass());

        AABB aabb = new AABB();
        aabb = (AABB) gameObject.getBehavior(aabb.getClass());

        this.characterTransform = transform;
        this.aabb = aabb;

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

            if (!jumpIsDown){
                jumpIsDown = true;
                direction.y--;
                jumpInputTimer = jumpInputBufferTime;
            }
        }
        else{
            jumpIsDown = false;
        }
        if (PlayerInputHandler.getInstance().isDownKeyDown){
            direction.y++;
        }

        double deltaTime = GameTime.getInstance().getDeltaTime();

        jumpInputTimer -= deltaTime;
        groundedTimer -= deltaTime;

        velocity.x = Math.round(direction.x * speed * deltaTime);

        velocity.y += gravity * deltaTime;

        if (jumpInputTimer > 0 && groundedTimer > 0){
            velocity.y = -8;

            jumpInputTimer = 0f;
            groundedTimer = 0f;
        }

        if (velocity.y > 5){
            velocity.y = 5;
        }

        if (direction.x == -1){
            characterTransform.setScale(new Vector2d(-1, 1));
        }
        else if (direction.x == 1){
            characterTransform.setScale(new Vector2d(1, 1));
        }


        Vector2d newPosition = new Vector2d(
                velocity.x + characterTransform.getPosition().x,
                velocity.y + characterTransform.getPosition().y);

        for (AABB otherAABB: BBHandler.getInstance().getAabbs()) {

            if (!otherAABB.equals(aabb)){

                //Horizontal detection

                Transform otherTransform = otherAABB.getTransform();

                if (otherTransform == null){
                    continue;
                }

                Vector2d otherPosition = otherTransform.getPosition();

                if(newPosition.x < otherPosition.x + otherAABB.getBoundingBoxLengths().x &&
                newPosition.x + aabb.getBoundingBoxLengths().x > otherPosition.x &&
                newPosition.y < otherPosition.y + otherAABB.getBoundingBoxLengths().y &&
                newPosition.y + aabb.getBoundingBoxLengths().y > otherPosition.y){


                    double collisionDirection = new Vector2d((otherPosition.x + otherAABB.getOffset().x) - (characterTransform.getPosition().x + aabb.getOffset().x),
                            (otherPosition.y + otherAABB.getOffset().y) - (characterTransform.getPosition().y + aabb.getOffset().y)).CalculateAngle();

                    System.out.println("Collsion Detected at: " + collisionDirection);

                    if (collisionDirection < 45 && collisionDirection > -45){
                        newPosition.x = otherPosition.x - aabb.getBoundingBoxLengths().x;
                        velocity.x = 0;

                        System.out.println("X POS: " + newPosition.x);
                        System.out.println("Y POS: " + newPosition.y);

                        System.out.println("X VEL: " + velocity.x);
                        System.out.println("Y VEL: " + velocity.y);

                        continue;
                    }
                    else if (collisionDirection > -135 && collisionDirection < -45){
                        newPosition.y = otherPosition.y + otherAABB.getBoundingBoxLengths().y;
                        velocity.y = 0;

                        System.out.println("X POS: " + newPosition.x);
                        System.out.println("Y POS: " + newPosition.y);

                        System.out.println("X VEL: " + velocity.x);
                        System.out.println("Y VEL: " + velocity.y);

                        continue;
                    }
                    else if ((collisionDirection > 135 && collisionDirection <= 180) || (collisionDirection > -180 && collisionDirection < -135)){
                        newPosition.x = otherPosition.x + otherAABB.getBoundingBoxLengths().x;
                        velocity.x = 0;

                        System.out.println("X POS: " + newPosition.x);
                        System.out.println("Y POS: " + newPosition.y);

                        System.out.println("X VEL: " + velocity.x);
                        System.out.println("Y VEL: " + velocity.y);

                        continue;
                    }
                    else if (collisionDirection > 45 && collisionDirection < 135){
                        newPosition.y = otherPosition.y - aabb.getBoundingBoxLengths().y;
                        velocity.y = 0;

                        System.out.println("X POS: " + newPosition.x);
                        System.out.println("Y POS: " + newPosition.y);

                        System.out.println("X VEL: " + velocity.x);
                        System.out.println("Y VEL: " + velocity.y);

                        groundedTimer = groundedBufferTime;

                        continue;
                    }

                }



            }

        }

        if (deltaTime < 0.5d){
            characterTransform.setPosition(newPosition);
        }

        LevelManager levelManager = LevelManager.getInstance();

        if (characterTransform.getPosition().y > levelManager.gameSize.y + 10){

            levelManager.SetLevel(levelManager.currentLevelIndex);
            //System.out.println(levelManager.currentLevelIndex);

        }



    }


}
