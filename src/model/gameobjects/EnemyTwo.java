package model.gameobjects;

/**
 * Created by michal on 06.12.16.
 */
public class EnemyTwo implements SceneObjects {
    private String bodyOne = "-O_";
    private String bodyTwo = "_O-";

    @Override
    public String getBody() {
        return bodyOne;
    }

    @Override
    public Pixel getPosition() {
        return null;
    }

    @Override
    public void addIntToPositionX(int i) {

    }

    @Override
    public void addIntToPositionY(int i) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
