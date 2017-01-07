package model.engine;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

/**
 * Created by michal on 07.01.17.
 */
public class CustomTerminal {
    Terminal terminal;
    public CustomTerminal(){
        terminal = TerminalFacade.createTerminal();
    }
    public Terminal getTerminal(){
        return terminal;
    }
    public void setResizeListener(Terminal.ResizeListener resizeListener){
        terminal.addResizeListener(resizeListener);
    }
}
