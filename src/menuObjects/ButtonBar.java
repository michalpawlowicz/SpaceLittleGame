package menuObjects;
import model.gameobjects.Pixel;
import model.gameobjects.SceneObjects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 20.12.16.
 */
public class ButtonBar{
    private List<Button> list = new ArrayList<>();
    private Pixel position;
    private int currentSelected = 0;
    private int width;

    public ButtonBar(Pixel position){
        this.position = position;
        width = 0;
    }
    public ButtonBar(){
        width = 0;
        this.position = new Pixel(0,0);
    }
    public void addButton(ButtonInterface button){
        button.setPosition(new Pixel(position.getX(), position.getY()+list.size()));
        list.add((Button) button);
        width = Math.max(width, ((Button) button).getWidth());
    }
    public synchronized List<SceneObjects> getButtonBarObjects(){
        List<SceneObjects> tmp = new LinkedList<>();
        tmp.addAll(list);
        return tmp;
    }
    public synchronized void setNextSelected(){
        list.get(currentSelected).selected(false);
        if(currentSelected < list.size()-1){
            list.get(++currentSelected).selected(true);
        } else {
            currentSelected = 0;
            list.get(currentSelected).selected(true);
        }
    }
    public synchronized void setPrevSelected(){
        list.get(currentSelected).selected(false);
        if(currentSelected > 0){
            list.get(--currentSelected).selected(true);
        } else {
            currentSelected = list.size()-1;
            list.get(currentSelected).selected(true);
        }
    }
    public int getSelected(){ return currentSelected; }
    public void updateButtonsPosition(Pixel vector){
        for(Button x: list){
            x.addIntToPositionX(vector.getX());
            x.addIntToPositionY(vector.getY());
        }
    }
    public void setButtonsPosition(Pixel position){
        int i = 0;
        for(Button x: list){
            x.setPosition(new Pixel(
                    position.getX(),
                    position.getY()+i
            ));
            i++;
        }
    }
    public int getWidth(){ return width; }
    public void setPosition(Pixel position){
        setButtonsPosition(position);
        this.position = position;
    }
}