package model.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;

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
    private Terminal.Color color = Terminal.Color.YELLOW;
    private int animationEveryNmove = 5;
    private int currentAnimation = 0;

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

    @Override
    public Terminal.Color getColor() {
        return color;
    }

    public int getWidth(){ return width; }
    public int getDirection() {
        return direction;
    }
    public void animateBody() {
        if(currentAnimation == animationEveryNmove) {
            if (body.equals(bodyOne)) {
                body = bodyTwo;
            } else {
                body = bodyOne;
            }
            currentAnimation = 0;
        } else currentAnimation++;
    }
}
