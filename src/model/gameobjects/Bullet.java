package model.gameobjects;

/**
 * Created by michal on 07.12.16.
 */
public class Bullet implements SceneObjects {
    private String body = "|";
    private Pixel position;
    private int direction = 1;

    public Bullet(Pixel position, int direction){ this.position = position;
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

    @Override
    public void addIntToPositionX(int i) {
        position.addX(i);
    }

    @Override
    public void addIntToPositionY(int i) {
        position.addY(i);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    public int getDirection(){ return direction; }
}
