package model.engine.drawing;

import model.gameobjects.SceneObjects;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by michal on 21.12.16.
 */
public class Collisions <T extends SceneObjects,M extends SceneObjects>{
    private List<T> firstList;
    private List<M> secondList;
    private CollisionAction collisionAction;
    public Collisions(List<T> firstList, List<M> secondList, CollisionAction collisionAction){
        this.firstList = firstList;
        this.secondList = secondList;
        this.collisionAction = collisionAction;
    }
    public synchronized void detectCollisions(){
            if(!(firstList == null || secondList == null)) {
                Iterator<T> firstIt = firstList.iterator();
                Iterator<M> secondIt = secondList.iterator();
                while (firstIt.hasNext()) {
                    T x = firstIt.next();
                    while (secondIt.hasNext()) {
                        M y = secondIt.next();
                        if (detectCollision(x, y)) {
                            collisionAction.action();
                            firstIt.remove();
                            secondIt.remove();
                            break;
                        }
                    }
                    secondIt = secondList.iterator();
                }
            }
    }
    public synchronized boolean detectCollision(T x, M y){
        return  (Math.abs(x.getPosition().getY() - y.getPosition().getY()) == 1 ||
                x.getPosition().getY() == y.getPosition().getY()) &&
                intervalsCollision(
                x.getPosition().getX(),
                x.getPosition().getX() + x.getWidth(),
                y.getPosition().getX(),
                y.getPosition().getX() + y.getWidth()
        );
    }
    public static boolean intervalsCollision(int a1, int b1, int a2, int b2){
        return ((a1 <= a2 && a2 < b1) || (a2 <= a1 && a1 < b2));
    }
}
