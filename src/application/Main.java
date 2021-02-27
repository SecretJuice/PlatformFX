package application;

import application.events.UpdateEventHandler;
import application.game.input.PlayerInputHandler;
import application.game.world.World;
import application.game.world.WorldBuilder;
import application.rendering.WorldRenderer;
import application.utils.GameTime;
import application.utils.math.Vector2i;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private Group mainGroup;

    private World gameWorld;
   // private WorldRenderer worldRenderer = new WorldRenderer();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Vector2i gameSize = new Vector2i(1280, 704);

        Group staticGroup = new Group();
        Group nonStaticGroup = new Group();

//        GameObject firstObject = new GameObject(new ArrayList<GameBehavior>());
//        firstObject.getGameBehaviors().add(new Transform(firstObject, new Vector2d(400, 400), new Vector2d(1, 1), 0D));
//        firstObject.getGameBehaviors().add(new SpriteRenderer(firstObject, new Image("assets/player/dude.png", 64, 64, true, false), 1));
//        firstObject.getGameBehaviors().add(new AABB(firstObject, new Vector2d(0, 0), new Vector2d(32, 32)));
//
//        GameObject secondObject = new GameObject(new ArrayList<GameBehavior>());
//
//        secondObject.getGameBehaviors().add(new Transform(secondObject, new Vector2d(400, 400), new Vector2d(1, 1), 0D));
//        secondObject.getGameBehaviors().add(new SpriteRenderer(secondObject, new Image("assets/tiles/grass.png", 64, 64, true, false), 0));
//        secondObject.getGameBehaviors().add(new AABB(secondObject, new Vector2d(0, 0), new Vector2d(32, 32)));
//
//        List<GameObject> firstWorldGameObjects = new ArrayList<GameObject>();
//
//        firstWorldGameObjects.add(firstObject);
//        firstWorldGameObjects.add(secondObject);
//
//        World world = new World(firstWorldGameObjects);

        WorldBuilder worldBuilder = new WorldBuilder(gameSize, 64);

        gameWorld = worldBuilder.BuildWorld();

        WorldRenderer.RenderStaticWorldObjects(staticGroup, gameWorld);

        Scene scene = new Scene(staticGroup,gameSize.x, gameSize.y, new Color(0.212D, 0.306D, 0.341D, 1.0D));

        Text text = new Text("Yeetombolis");

        text.setX(50);
        text.setY(50);

        staticGroup.getChildren().add(text);
        staticGroup.getChildren().add(nonStaticGroup);

        mainGroup = staticGroup;

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case A:
                    PlayerInputHandler.getInstance().isLeftKeyDown = true;
                    break;
                case D:
                    PlayerInputHandler.getInstance().isRightKeyDown = true;
                    break;
                case W:
                    PlayerInputHandler.getInstance().isUpKeyDown = true;
                    break;
                case S:
                    PlayerInputHandler.getInstance().isDownKeyDown = true;
                    break;
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()){
                case A:
                    PlayerInputHandler.getInstance().isLeftKeyDown = false;
                    break;
                case D:
                    PlayerInputHandler.getInstance().isRightKeyDown = false;
                    break;
                case W:
                    PlayerInputHandler.getInstance().isUpKeyDown = false;
                    break;
                case S:
                    PlayerInputHandler.getInstance().isDownKeyDown = false;
                    break;
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        timer.start();


        Image icon = new Image("assets/koolaidman.png");

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("PlatformFX");

        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);

    }

    private void update() {

        //WorldRenderer.ClearNonStaticWorldObjects(mainGroup, gameWorld);
        mainGroup.getChildren().clear();

        GameTime.getInstance().CalculateDeltaTime();

        UpdateEventHandler.getInstance().Update();

        WorldRenderer.RenderStaticWorldObjects(mainGroup, gameWorld);
        WorldRenderer.RenderWorldObjects(mainGroup, gameWorld);

    }
}
