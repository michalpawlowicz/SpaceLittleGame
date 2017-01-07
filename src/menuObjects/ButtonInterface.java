package menuObjects;

import model.gameobjects.Pixel;

/**
 * Created by michal on 20.12.16.
 */
public interface ButtonInterface {
    public boolean isSelected();
    public void selected(boolean isSelected);
    public void setPosition(Pixel position);
}
