import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * Esta classe representa o quadro onde estará contido os desenhos
 */

public class Board extends JPanel implements ActionListener {
  private class Square {
    int posX;
    int posY;
    Color color;
    int velocityX = 2;
    int velocityY = 3;

    Square(int x, int y, int velocityX, int velocityY, Color color) {
      this.posX = x;
      this.posY = y;
      this.velocityX = velocityX;
      this.velocityY = velocityY;
      this.color = color;
    }
  }

  ArrayList<Square> squares = new ArrayList<>();

  int boardWidth;
  int boardHeight;
  int squareSides = 25;

  Timer timer;

  /**
   * Configura o quadro onde será feito os desenhos e chama a função que desenha
   * os quadrados
   * 
   * @param boardWidth  - largura da tela de conteúdo
   * @param boardHeight - altura da tela de conteúdo
   */
  Board(int boardWidth, int boardHeight) {
    this.boardWidth = boardWidth;
    this.boardHeight = boardHeight;
    setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
    setBackground(Color.DARK_GRAY);

    timer = new Timer(10, this);
    timer.start();

    // Chama o método para criar blocos
    addSquare(5, 2, Color.WHITE);
    addSquare(2, 5, Color.RED);
    addSquare(8, 8, Color.MAGENTA);
    addSquare(8, 8, Color.GREEN);
    addSquare(8, 8, Color.ORANGE);
    addSquare(8, 8, Color.PINK);
    addSquare(8, 8, Color.YELLOW);
    addSquare(8, 8, Color.BLUE);

    for (int i = 0; i < 20; i++) {
      System.out.println(randomNumber());
    }

  }

  /**
   * Método que adiciona blocos ao ArrayList "squares"
   * 
   * @param velocityX - velocidade x do bloco
   * @param velocityY - velocidade y do bloco
   * @param color - cor do bloco
   */
  public void addSquare(int velocityX, int velocityY, Color color) {
    squares.add(new Square(squareSides * randomNumber(), squareSides * randomNumber(), velocityX, velocityY, color));
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    draw(g);
  }

  /**
   * Método para desenhar blocos no Board
   * 
   * @param g - Objeto Graphics usado para desenhar
   */
  public void draw(Graphics g) {
    for (Square square : squares) {
      g.setColor(square.color);
      g.fillRect(square.posX, square.posY, squareSides, squareSides);

    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (Square square : squares) {

      if (square.posX > boardWidth - squareSides || square.posX < 0) {
        square.velocityX = square.velocityX * -1;
      }
      square.posX += square.velocityX;

      if (square.posY > boardHeight - squareSides || square.posY < 0) {
        square.velocityY = square.velocityY * -1;
      }
      square.posY += square.velocityY;
    }
    repaint();
  }

  public int randomNumber() {
    return (int) (Math.random() * 24);
  }

}
