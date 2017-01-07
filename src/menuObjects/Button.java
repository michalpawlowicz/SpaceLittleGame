package menuObjects;

import com.googlecode.lanterna.terminal.Terminal;
import model.gameobjects.Pixel;
import model.gameobjects.PlainText;
import model.gameobjects.SceneObjects;

/**
 * Created by michal on 20.12.16.
 */
public class Button implements SceneObjects, ButtonInterface{
    private String text;
    private String selectedText;
    private boolean isSelected = false;
    private Pixel position;
    private Terminal.Color color = Terminal.Color.WHITE;


    public Button(String text){
        this.text = text;
        selectedText = "**" + text;
        position = new Pixel(0,0);
    }
    public Button(Pixel position){
        text = "";
        selectedText = "";
        this.position = position;
    }
    public Button(String text,Pixel position){
        this.text = text;
        this.selectedText = "**" + this.text;
        this.position = position;
    }
    public void setText(String text){
        this.text = text;
        this.selectedText = "**" + text;
    }
    @Override
    public String getBody() {
        if(isSelected){
            return selectedText;
        } else {
            return text;
        }
    }
    @Override
    public Pixel getPosition() {
        if(isSelected){
            return position;
        } else {
            return new Pixel(position.getX()+2, position.getY());
        }
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
        if(isSelected){
            return selectedText.length();
        } else return text.length();
    }
    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public Terminal.Color getColor() {
        return color;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }
    @Override
    public void selected(boolean isSelected){ this.isSelected = isSelected; }
    @Override
    public void setPosition(Pixel position) { this.position = position; }
}
