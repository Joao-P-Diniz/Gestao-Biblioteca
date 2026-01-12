import util.DatabaseInitializer;
import view.BibliotecaView;

public class Main{
    public static void main(String[] args) {
        DatabaseInitializer.initialize();
        new BibliotecaView();
    }
}
