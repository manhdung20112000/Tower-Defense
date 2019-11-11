package core;

/*
|===================================================|
|   This class manages every object in the field    |
|===================================================|
 */

import Entity.Immoveable.Road;
import Entity.Moveable.Enemy.Enemy;
import Entity.Moveable.Enemy.NormalEnemy;
import Graphic.ImageSheet;
import Graphic.Render;
import Graphic.TileMap;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class GameField {
    private static ImageSheet imageSheet = new ImageSheet(); //tiled sheet

    private static TileMap background = new TileMap(); //first layer
    private static TileMap road = new TileMap();       //second layer
    private static TileMap rockTree = new TileMap();   //third layer
    private static TileMap spawn = new TileMap();      //final layer

    private static Road roadInfo = new Road();

    private static ArrayList<Enemy> enemies = new ArrayList<>(); //Enemies array

    public GameField (){
        loadMap();
        loadGameplay();
    }

    public static ImageSheet getImageSheet(){
        return imageSheet;
    }

    public TileMap getBackground (){
        return background;
    }

    public TileMap getRoad (){
        return road;
    }

    public TileMap getRockTree() {
        return rockTree;
    }

    public TileMap getSpawn() {
        return spawn;
    }

    public static Road getRoadInfo() {
        return roadInfo;
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        GameField.enemies.add(enemy);
    }

    public static void loadMap(){
        //input layer data
        background.readFile("Map/background.txt");
        road.readFile("Map/road.txt");
        rockTree.readFile("Map/rockTree.txt");
        spawn.readFile("Map/spawn.txt");

        //print to check
        background.printMapData();
        road.printMapData();
        rockTree.printMapData();
        spawn.printMapData();

        //load tiled sheet
        imageSheet.loadImageViewSheet("Graphic/towerDefense_tilesheet.png");
        // render to check
        // Render.renderMap(background.getTileMap(), imageSheet);

        //load road information
        roadInfo.setRoadInfo(road.getTileMap());
        roadInfo.printTestRoadInfo();
    }

    public static void loadGameplay(){

    }

    public void update(long time){
        System.out.println("time = " + time);

        if (time/1000000000 > enemies.size()){
            Enemy enemy = new NormalEnemy();
            System.out.println("new Enemy");
            enemy.setDirection(Enemy.Direction.UP);
            enemies.add(enemy);
        }
        for (Enemy enemy : enemies){
            enemy.update();
        }
    }

    public void draw(GraphicsContext gc, GameField gameField){
        //render 4 layers: background -> road -> treeRock -> spawn
        Render.renderMap(gc, gameField);
        //draw tower
        /*
        for (Tower tower:towers) {
            tower.draw(root);
        }
         */

        /**
         * Draw Enemy
         */
        for(Enemy enemy:enemies){
            enemy.draw(gc);
        }

        /**
         * Draw Enemy HP bar
         */
//        for (Enemy enemy:enemies){
//            enemy.drawHPBar(root);
//        }

        /**
         * Draw bullets
         */

    }
}
