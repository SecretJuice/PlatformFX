package application;

import application.game.GameObject;
import application.game.World;
import application.game.physics.AxisAlignedBoundingBox;
import application.game.rendering.SpriteRenderer;
import application.game.transform.Transform;
import application.rendering.WorldRenderer;
import application.utils.math.Vector2d;
import com.sun.javafx.geom.Vec2d;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();

        GameObject firstObject = new GameObject(new Transform(new Vector2d(0, 0), new Vector2d(1, 1), 0D),
                new SpriteRenderer(new Image("assets/player/dude.png"), 0),
                new AxisAlignedBoundingBox(new Vector2d(0, 0), new Vector2d(32, 32)));
        GameObject secondObject = new GameObject(new Transform(new Vector2d(0, 0), new Vector2d(1, 1), 0D),
                new SpriteRenderer(new Image("assets/tiles/grass.png"), 1),
                new AxisAlignedBoundingBox(new Vector2d(0, 0), new Vector2d(32, 32)));

        List<GameObject> firstWorldGameObjects = new ArrayList<GameObject>();

        firstWorldGameObjects.add(firstObject);
        firstWorldGameObjects.add(secondObject);

        World world = new World(firstWorldGameObjects);

        WorldRenderer worldRenderer = new WorldRenderer();
        worldRenderer.RenderWorldObjects(root, world);

        Scene scene = new Scene(root,1280, 720, new Color(0.212D, 0.306D, 0.341D, 1.0D));

        Text text = new Text("Yeetombolis");

        text.setX(50);
        text.setY(50);

        root.getChildren().add(text);



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
}
