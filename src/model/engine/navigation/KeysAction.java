package model.engine.navigation;

import java.io.IOException;

/**
 * Created by michal on 07.12.16.
 */
public interface KeysAction {
    public void leftArrowAction();
    public void rightarrowAction();
    public void arrowUpAction();
    public void EscAction();
    public void eofAction();
    public void arrowDownAction();
    public void enterKeyAction();
}
