package Entity.Immoveable.RoadExtend;import Entity.Immoveable.Road;public class Spawn extends Road {    private static int info = 2;    private static int posX, posY;    public void setPosXY(int posX, int posY) {        Spawn.posX = posX;        Spawn.posY = posY;    }    public int getPosX() {        return posX;    }    public int getPosY() {        return posY;    }    @Override    public void setRoadInfo(int[][] roadTileMap) {        roadTileMap[posY][posX] = info;    }}