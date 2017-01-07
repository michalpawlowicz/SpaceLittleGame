package model.gameobjects;

/**
 * Created by michal on 07.01.17.
 */
public class EnemyFactory {
    private EnemyFactory(){}
    public static SceneObjects createEnemy(Pixel position){
        double tmp = Math.random();
        if(tmp < 0.33){
            return new EnemyOne(position,1);
        } else if(tmp > 0.66){
            return new EnemyTwo(position,1);
        } else {
            return new EnemyThree(position,1);
        }
    }
}
