import javax.swing.JFrame;

public class App extends JFrame {
    final private static int BOARD_WIDTH = 600;
    final private static int BOARD_HEIGHT = BOARD_WIDTH;
    public static void main(String[] args) {
        JFrame app = new JFrame("Board");
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);

        app.add(board);
        app.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        app.setResizable(false);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
    }
}