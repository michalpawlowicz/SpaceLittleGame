package model.gameobjects;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 06.12.16.
 */

public class EnemiesGrid{
    private List<SceneObjects> listOfEnemies;

    public EnemiesGrid(List<SceneObjects> listOfBullets ){
        this.listOfEnemies = listOfBullets;
    }
    public EnemiesGrid(){
        listOfEnemies = new LinkedList<>();
    }

    public synchronized void addEnemy(SceneObjects e){
        if(listOfEnemies.size() < 2)listOfEnemies.add(e);
    }
    public synchronized void setEnemiesList(List<SceneObjects> listOfEmemies){ this.listOfEnemies = listOfEmemies; }

    public List<SceneObjects> getlistOfEnemies() {
        return listOfEnemies;
    }
}
