package model.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by michal on 06.12.16.
 */
public class EnemyThree implements SceneObjects, Enemy {
    private String bodyOne = "/ΔΔ\\";
    private String bodyTwo = "-oo-";
    private String body = bodyOne;
    private Pixel position;
    private final int height = 2;
    private final int width = 4;
    private int direction = 1;
    private Terminal.Color color = Terminal.Color.YELLOW;
    private int animationEveryNmove = 5;
    private int currentAnimation = 0;

    public EnemyThree(Pixel position, int direction){
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
            if (body.equals(bodyOne) && currentAnimation == animationEveryNmove) {
                body = bodyTwo;
                currentAnimation = 0;
            } else {
                body = bodyOne;
                currentAnimation++;
            }
            currentAnimation = 0;
        } else currentAnimation++;
    }
}
