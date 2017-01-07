package model.engine.navigation;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

/**
 * Created by michal on 07.12.16.
 */
public class KeysListenerThread extends Thread {
    private boolean isListening;
    private Screen screen;
    private KeysEvent keysEvent;
    public KeysListenerThread(Screen screen, KeysEvent keysEvent){
        super();
        this.screen = screen;
        this.keysEvent = keysEvent;
        isListening = false;
    }
    @Override
    public void run() {
        //try {
            Key k = null;
            while (isListening){
                k = (Key) screen.readInput();
                if(k != null) {
                    if (k.getKind() == Key.Kind.ArrowLeft) {
                        keysEvent.leftArrowAction();
                    } else if (k.getKind() == Key.Kind.ArrowRight) {
                        keysEvent.rightarrowAction();
                    } else if (k.getKind() == Key.Kind.ArrowUp) {
                        keysEvent.arrowUpAction();
                    } else if (k.getKind() == Key.Kind.Escape) {
                        keysEvent.EscAction();
                    } else if (k.getKind() == Key.Kind.EOF) {
                        keysEvent.eofAction();
                    } else if (k.getKind() == Key.Kind.ArrowDown) {
                        keysEvent.arrowDownAction();
                    } else if (k.getKind() == Key.Kind.Enter) {
                        keysEvent.enterKeyAction();
                    }
                    k = null;
                }
            }
        //} catch (IOException e) {
         //   e.printStackTrace();
        //}
    }
    public synchronized void setKeysEvents(KeysEvent keysEvents){ this.keysEvent = keysEvents; }
    public synchronized void stopListening(){
        isListening = false;
    }
    public synchronized void startListening(){
        isListening = true;
    }

    public boolean listern(){ return isListening; }

}
