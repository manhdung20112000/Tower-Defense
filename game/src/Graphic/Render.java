package Graphic;

import core.Config;
import core.GameField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Render {
    public static void generateWindow(Stage primaryStage, Group root, Scene theScene) {
        primaryStage.setScene(theScene);
        primaryStage.setTitle(Config.TITLE);
//        primaryStage.setResizable(false);
//        primaryStage.setMaxHeight(Config.SCREEN_HEIGHT + 35); // += 35 to remove the white bar
//        primaryStage.setMaxWidth(Config.SCREEN_WIDTH + 5);    // += 5  to remove the white bar


//      need to be inside class Render, manually add latter
//        primaryStage.show();
    }

    public static void renderMap(GraphicsContext gc, GameField gameField) {
        renderMap(gc, gameField.getBackground(), gameField.getImageSheet());
        renderMap(gc, gameField.getRoad(), gameField.getImageSheet());
        renderMap(gc, gameField.getRockTree(), gameField.getImageSheet());
        renderMap(gc, gameField.getSpawn(), gameField.getImageSheet());
    }

    public static void renderMap(GraphicsContext gc, TileMap tileMap, ImageSheet imageSheet) {
        for (int i = 0; i < Config.MAP_HEIGHT; i++) {
            for (int j = 0; j < Config.MAP_WIDTH; j++) {
                /*load index in tileMap, then find the right image -> add to imageView*/
                if(tileMap.getTileMap(i, j) == 0) continue;
                Image img = imageSheet.getImage(tileMap.getTileMap(i, j) - 1);
                gc.drawImage(img, j * Config.TILE_HORIZONTAL, i * Config.TILE_VERTICAL);
            }
        }
    }

    public static void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    public static void closeWindow(Stage primaryStage){
        primaryStage.close();
        System.out.println("Window closed");
    }

}
