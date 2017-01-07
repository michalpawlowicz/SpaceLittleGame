package model.gameobjects;

/**
 * Created by michal on 06.12.16.
 */
public class EnemyOne implements SceneObjects, Enemy {
    private String bodyOne = "-,^,-";
    private String bodyTwo = ",-,";
    private final int height = 2;
    private final int width = 5;
    private int direction = 1;

    private Pixel position;

    public EnemyOne(Pixel position, int direction){
        this.position = position;
        this.direction = direction;
    }

    @Override
    public String getBody() {
        return bodyOne;
    }

    @Override
    public Pixel getPosition() {
        return position;
    }
    public void setPosition(Pixel position) { this.position = position; }
    public int getHeight(){ return height; }
    public int getWidth(){ return width; }
    public void addIntToPositionX(int p){
        position.addX(p);
    }
    public void addIntToPositionY(int p){ position.addY(p); }


    @Override
    public int getDirection() {
        return direction;
    }
}
