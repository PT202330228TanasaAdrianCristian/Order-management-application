package com.adi;
import com.adi.Views.MainWindow;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try {
        MainWindow aMainWindow = new MainWindow();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
