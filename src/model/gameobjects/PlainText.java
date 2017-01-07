package model.gameobjects;

/**
 * Created by michal on 20.12.16.
 */
public class PlainText implements SceneObjects {
    private String body;
    private Pixel position;
    public PlainText(String body, Pixel position){
        this.body = body;
        this.position = position;
    }
    //Constructor with default position 0,0
    public PlainText(String body){ this.body = body; position = new Pixel(0,0);}
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
        return body.length();
    }

    @Override
    public int getHeight() {
        return 1;
    }
    public void setPosition(Pixel position){ this.position = position; }
}
