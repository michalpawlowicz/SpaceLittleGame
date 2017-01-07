package model.scenes;

import model.gameobjects.SceneObjects;
import java.util.List;

/**
 * Created by michal on 06.12.16.
 */
public interface Scene {
    public List<List<SceneObjects>> returnSceneObjects();
}
