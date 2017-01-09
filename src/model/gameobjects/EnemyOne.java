package model.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by michal on 06.12.16.
 */
public class EnemyOne implements SceneObjects, Enemy {
    private String bodyOne = "-,^,-";
    private String bodyTwo = "_,-,_";
    private String body = bodyOne;
    private final int height = 2;
    private final int width = 5;
    private int direction = 1;
    private Terminal.Color color = Terminal.Color.YELLOW;
    private int animationEveryNmove = 5;
    private int currentAnimation = 0;

    private Pixel position;

    public EnemyOne(Pixel position, int direction){
        this.position = position;
        this.direction = direction;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public Pixel getPosition() {
        return position;
    }
    public void setPosition(Pixel position) { this.position = position; }
    public int getHeight(){ return height; }

    @Override
    public Terminal.Color getColor() {
        return color;
    }

    public int getWidth(){ return width; }
    public void addIntToPositionX(int p){
        position.addX(p);
    }
    public void addIntToPositionY(int p){ position.addY(p); }
    public int getDirection() {
        return direction;
    }

    @Override
    public void animateBody() {
        if(currentAnimation == animationEveryNmove) {
            if (body.equals(bodyOne) && currentAnimation == animationEveryNmove) {
                body = bodyTwo;
                currentAnimation = 0;
            } else body = bodyOne;
            currentAnimation = 0;
        } else currentAnimation++;
    }
}
