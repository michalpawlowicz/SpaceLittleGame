package view;
/**
 * Created by michal on 06.12.16.
 */

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import model.CouldNotCreateGameWindow;
import model.engine.*;
import model.engine.navigation.AbstractCKeysEvent;
import model.engine.navigation.KeysListenerThread;
import model.gameobjects.EnemyOne;
import model.gameobjects.Pixel;
import model.scenes.EndScene;
import model.scenes.MainScene;
import model.scenes.Scene;
import model.scenes.StartScene;
import java.io.IOException;

public class Aplication {
    private TerminalSize defaultTerminalSize;
    private KeysListenerThread keysListenersThread;
    private GameWindow gameWindow;
    private MainScene mainScene;
    private StartScene startScene;
    private EndScene endScene;

    public Aplication() throws CouldNotCreateGameWindow{
        Terminal terminal = TerminalFacade.createTerminal();
        try {
            gameWindow = new GameWindow(terminal);
        } catch(IOException e){
            throw new CouldNotCreateGameWindow();
        }
        defaultTerminalSize = terminal.getTerminalSize();
    }

    public boolean startAplication() throws CouldNotStartWindowException{

        startScene = new StartScene(new Pixel(defaultTerminalSize.getColumns()/2,
                defaultTerminalSize.getRows()/2));

        mainScene = new MainScene(gameWindow.getDefaultTerminalSize(),
                new Pixel(gameWindow.getDefaultTerminalSize().getColumns() / 2,
                        gameWindow.getDefaultTerminalSize().getRows()-3));

        try{
            gameWindow.startWindow(startScene);
        } catch (IOException e){
            throw new CouldNotStartWindowException();
        }
        gameWindow.readInput();
        menuService();

        keysListenersThread = new KeysListenerThread(gameWindow, new AbstractCKeysEvent() {
            @Override
            public void leftArrowAction() {
                mainScene.changlePlayerPosition(-3);
                refreshScreen(mainScene);
            }

            @Override
            public void rightarrowAction() {
                mainScene.changlePlayerPosition(3);
                refreshScreen(mainScene);
            }

            @Override
            public void arrowUpAction() {
                mainScene.addPlayerShoot();
                refreshScreen(mainScene);
            }

            @Override
            public void EscAction() {
                keysListenersThread.stopListening();
                gameWindow.stopScreen();
                System.exit(0);
            }

            @Override
            public void eofAction() {
                keysListenersThread.stopListening();
                gameWindow.stopScreen();
                System.exit(0);
            }
        });
        keysListenersThread.startListening();
        keysListenersThread.start();

        //Creating maing game thread
        while(mainScene.getPlayerLives() > 0) {
            //Rand enemies
            if((int)Math.round(Math.random()) == 1) {
                int tmp;
                do{
                    tmp = (int)(Math.random() * defaultTerminalSize.getColumns());
                } while(tmp + 5 > defaultTerminalSize.getColumns());
                mainScene.addEnemy(new EnemyOne(
                        new Pixel(tmp, 0), 1));
            }
            mainScene.detectCollisions();
            mainScene.updateBullets();
            mainScene.updateEnemies();
            try {
                refreshScreen(mainScene);
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        keysListenersThread.setKeysEvents(new AbstractCKeysEvent() {
            @Override
            public void arrowUpAction() {
                endScene.setPrevSelected();
                refreshScreen(endScene);
            }
            @Override
            public void eofAction() {
                System.exit(0);
            }

            @Override
            public void arrowDownAction() {
                endScene.setNextSelected();
                refreshScreen(endScene);
            }

            @Override
            public void enterKeyAction() {
                synchronized (endScene) {
                    endScene.setEnterPressed(true);
                    keysListenersThread.stopListening();
                    endScene.notify();
                }
            }
        });
        endScene = new EndScene(mainScene.getScore());
        refreshScreen(endScene);
        synchronized (endScene){
            try {
                endScene.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(endScene.getSelected() == 0){
            return true;
        }
        return false;
    }
    private synchronized void refreshScreen(Scene scene){
        gameWindow.refreshGameWindow(scene);
    }
    private void menuService() {
        boolean drawMenu = true;
        Key k = null;
        while (drawMenu){
            k = gameWindow.readInput();
            if(k != null) {
                if (k.getKind() == Key.Kind.ArrowUp) {
                    startScene.setPrevSelected();
                    refreshScreen(startScene);
                } else if (k.getKind() == Key.Kind.EOF) {
                    drawMenu = false;
                    System.exit(0);
                } else if (k.getKind() == Key.Kind.ArrowDown) {
                    startScene.setNextSelected();
                    refreshScreen(startScene);
                } else if (k.getKind() == Key.Kind.Enter) {
                    if (startScene.getSelected() == 1) {
                        gameWindow.stopScreen();
                        System.exit(0);
                    }
                    drawMenu = false;
                }
            }
        }
    }
    public void close() {
        gameWindow.stopScreen();
        System.exit(0);
    }
}
