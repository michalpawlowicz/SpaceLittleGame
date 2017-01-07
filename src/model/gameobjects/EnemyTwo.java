package model.gameobjects;

/**
 * Created by michal on 06.12.16.
 */
public class EnemyTwo implements SceneObjects, Enemy {
    private String bodyOne = "__O__";
    private String bodyTwo = "--O--";
    private String body = bodyOne;
    private Pixel position;
    private int height = 2;
    private int width = 5;
    private int direction;

    public EnemyTwo(Pixel position, int direction){
        this.position = position;
        this.direction = direction;
    }

    public String getBody() {
        return body;
    }
    public Pixel getPosition() {
        return position;
    }
    public void setPosition(Pixel position) { this.position = position; }
    public void addIntToPositionX(int p){
        position.addX(p);
    }
    public void addIntToPositionY(int p){ position.addY(p); }
    public int getHeight(){ return height; }
    public int getWidth(){ return width; }
    public int getDirection() {
        return direction;
    }
    public void animateBody() {
        if(body.equals(bodyOne)){
            body = bodyTwo;
        } else body = bodyOne;
    }
}
