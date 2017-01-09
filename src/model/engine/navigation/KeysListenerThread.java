package model.engine.navigation;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;

/**
 * Created by michal on 07.12.16.
 */
public class KeysListenerThread extends Thread {
    private boolean isListening;
    private Screen screen;
    private KeysAction keysAction;
    public KeysListenerThread(Screen screen, KeysAction keysAction){
        super();
        this.screen = screen;
        this.keysAction = keysAction;
        isListening = false;
    }
    @Override
    public void run() {
            Key k = null;
            while (isListening){
                k = (Key) screen.readInput();
                if(k != null) {
                    if (k.getKind() == Key.Kind.ArrowLeft) {
                        keysAction.leftArrowAction();
                    } else if (k.getKind() == Key.Kind.ArrowRight) {
                        keysAction.rightarrowAction();
                    } else if (k.getKind() == Key.Kind.ArrowUp) {
                        keysAction.arrowUpAction();
                    } else if (k.getKind() == Key.Kind.Escape) {
                        keysAction.EscAction();
                    } else if (k.getKind() == Key.Kind.EOF) {
                        keysAction.eofAction();
                    } else if (k.getKind() == Key.Kind.ArrowDown) {
                        keysAction.arrowDownAction();
                    } else if (k.getKind() == Key.Kind.Enter) {
                        keysAction.enterKeyAction();
                    }
                    k = null;
                }
            }
        //} catch (IOException e) {
         //   e.printStackTrace();
        //}
    }
    public synchronized void setKeysEvents(KeysAction keysEvents){ this.keysAction = keysEvents; }
    public synchronized void stopListening(){
        isListening = false;
    }
    public synchronized void startListening(){
        isListening = true;
    }

    public boolean listern(){ return isListening; }

}
