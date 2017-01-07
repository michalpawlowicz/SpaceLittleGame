package model.gameobjects;

/**
 * Created by michal on 06.12.16.
 */
public class Pixel {
    private int x;
    private int y;
    public Pixel(){
        x = 0;
        y = 0;
    }
    public Pixel(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void addX(int i){ x = x + i; }
    public void addY(int i){ y = y + i; }

    /**
     * Created by michal on 20.12.16.
     */
    public static class BottomBar {
    }
}
