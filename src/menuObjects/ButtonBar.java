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
    public ButtonBar(Pixel position){
        this.position = position;
    }
    public void addButton(ButtonInterface button){
        button.setPosition(new Pixel(position.getX(), position.getY()+list.size()));
        list.add((Button) button);
    }
    //synchronized??
    public synchronized List<SceneObjects> getButtonBarObjects(){
        List<SceneObjects> tmp = new LinkedList<>();
        tmp.addAll(list);
        return tmp;
    }
    //synchronized??
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
}