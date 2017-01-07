package model.gameobjects;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 07.12.16.
 */
public class BulletsGrid {
    private List<SceneObjects> listOfBullets;

    public BulletsGrid(List<SceneObjects> listOfBullets ){
        this.listOfBullets = listOfBullets;
    }
    public BulletsGrid(){
        listOfBullets = new LinkedList<>();
    }

    public synchronized List<SceneObjects> getlistOfBullets(){ return listOfBullets; }

    public synchronized void addBullet(Pixel position, int direction){
        listOfBullets.add(new Bullet(position, direction));
    }
    public synchronized void setBulletList(List<SceneObjects> listOfBullets){ this.listOfBullets = listOfBullets; }
}
