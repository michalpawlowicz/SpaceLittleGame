import exceptions.CouldNotCreateGameWindow;
import exceptions.CouldNotStartWindowException;
import view.Aplication;

public class Main {
    public static void main(String[] args) {
        Aplication app;
        try {
            app = new Aplication();
            while(app.startAplication()){}
            app.close();
        } catch (CouldNotCreateGameWindow e){
            System.err.println("Could not create game window - " + e.getMessage());
            System.exit(1);
        } catch (CouldNotStartWindowException e){
            System.err.println("Could not start window - " + e.getMessage());
            System.exit(1);
        }
    }

}
