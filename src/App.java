public class App {
    public static void main(String[] args) throws Exception {
        GameWindow.main();
        GameWindow window = new GameWindow();
        GamePanel panel = new GamePanel(window);

        window.add(panel);
        window.pack();
        window.setVisible(true); //Initiate the rest of the variables.

        panel.game();
    }
}