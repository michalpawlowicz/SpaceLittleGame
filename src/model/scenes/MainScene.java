package model.scenes;

import com.googlecode.lanterna.terminal.TerminalSize;
import model.engine.drawing.CollisionAction;
import model.engine.drawing.Collisions;
import model.gameobjects.*;
import java.util.*;
import java.util.List;

/**
 * Created by michal on 06.12.16.
 */

public class MainScene implements Scene {

    private PlayerObject player;
    private EnemiesGrid enemiesGrid;
    private BulletsGrid bulletsGrid;
    private TerminalSize resolution;
    private BottomBar bottomBar;

    public MainScene(TerminalSize resolution, Pixel playerPosition){
        player = new PlayerObject(playerPosition);
        player.setLives(30);
        bulletsGrid = new BulletsGrid();
        enemiesGrid = new EnemiesGrid();
        this.resolution = resolution;
        bottomBar = new BottomBar(0, 3, new Pixel(0,0));
    }

    @Override
    //why synchronized?
    public synchronized List<List<SceneObjects>> returnSceneObjects() {
        List<List<SceneObjects>> group = new LinkedList<List<SceneObjects>>();
        group.add(player.getPlayersList());
        group.add(bulletsGrid.getlistOfBullets());
        group.add(enemiesGrid.getlistOfEnemies());
        group.add(bottomBar.getListOfObjects());
        return group;
    }

    @Override
    public void setResolution(TerminalSize terminalSize) {
        resolution = terminalSize;
    }
    public void changlePlayerPosition(int i){
        if(i < 0 && player.getPosition().getX() + i > 0) {
            player.addIntToPositionX(i);
        } else if(i < 0){
            player.addIntToPositionX((-1)*player.getPlayerPosition().getX());
        }
        else if(i > 0 && player.getPosition().getX() + player.getWidth() + 2 < resolution.getColumns()){
            player.addIntToPositionX(i);
        } else if(i > 0){
            player.addIntToPositionX(resolution.getColumns() - player.getPosition().getX() - player.getWidth());
        }
    }
    public void addPlayerShoot(){
        bulletsGrid.addBullet(new Pixel(player.getPlayerPosition().getX()+2,
                player.getPlayerPosition().getY()-1), -1);
    }
    public synchronized void updateBullets(){
        try{
            List<SceneObjects> list = bulletsGrid.getlistOfBullets();
            Iterator<SceneObjects> i = list.iterator();
            while(i.hasNext()){
                SceneObjects tmp = i.next();
                tmp.addIntToPositionY(((Bullet)tmp).getDirection());
                if(tmp.getPosition().getY() < 0){
                    i.remove();
                }
            }
            bulletsGrid.setBulletList(list);
        } catch (NullPointerException e){}
    }
    public synchronized void updateEnemies(){
        List<SceneObjects> list = enemiesGrid.getlistOfEnemies();
        Iterator<SceneObjects> it = list.iterator();
        while (it.hasNext()){
            SceneObjects tmp = it.next();
            tmp.addIntToPositionY(((Enemy)tmp).getDirection());
            ((Enemy) tmp).animateBody();
            if(tmp.getPosition().getY() > resolution.getRows()){
                it.remove();
                subPlayerLives(1);
                bottomBar.setLives(player.getLives());
            }
        }
        enemiesGrid.setEnemiesList(list);
    }
    public void addEnemy(SceneObjects e){
        enemiesGrid.addEnemy(e);
    }
    public void detectCollisions(){
        Collisions<SceneObjects, SceneObjects> collisions = new Collisions<SceneObjects, SceneObjects>(
                enemiesGrid.getlistOfEnemies(),
                bulletsGrid.getlistOfBullets(),
                new CollisionAction() {
                    @Override
                    public void action() {
                        player.addPoints(1);
                        bottomBar.setScore(player.getScore());
                    }
                }
        );
        collisions.detectCollisions();
    }
    public int getPlayerLives(){ return player.getLives(); }
    public void subPlayerLives(int l){ player.subLives(l); }
    public int getScore(){ return player.getScore(); }
    public void resizeAction(TerminalSize terminalSize){
        resolution = terminalSize;
        player.setPlayerPosition(new Pixel(player.getPlayerPosition().getX(), terminalSize.getRows()-2));
    }
}
