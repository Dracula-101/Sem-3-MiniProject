package Pong;

import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;

public class GameFrame extends JFrame {

    static GamePanel panel;
    static String playerPos;
    static boolean gameExit = false;

    public GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public static void resetPanel(int playerNo) {

        if (playerNo == 1)
            playerPos = "Left ";
        else
            playerPos = "Right ";
        PongGame.getFrame().setAlwaysOnTop(false);
        PongGame.getFrame().toFront();
        JFrame dialogBox = new JFrame();
        dialogBox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int resp = JOptionPane.showConfirmDialog(dialogBox,
                GameFrame.playerPos + "player has won the Game.\nDo you want to play again?",
                "Exit?", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.NO_OPTION) {
            PongGame.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            PongGame.endPong();
            GamePanel.endGame = true;
        } else {
            PongGame.getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            GamePanel.gameFlag = true;
            return;
        }
        // JOptionPane.showMessageDialog(dialogBox, GameFrame.playerPos + "player has
        // won the Game");
        // dialogBox.dispose();
        // GamePanel.gameFlag = true;
    }

}

class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    static int Borders = 25;
    static boolean gameFlag = false;
    static boolean endGame = false;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT, Borders);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
                BALL_DIAMETER, BALL_DIAMETER);
    }

    public void centerBall() {
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2 - BALL_DIAMETER), BALL_DIAMETER,
                BALL_DIAMETER);
    }

    public void newPaddles() {
        paddle1 = new Paddle(Borders, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH - Borders, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH,
                PADDLE_HEIGHT, 2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {

        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void checkCollision() {

        // bounce ball off top & bottom window edges
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        // bounce ball off paddles
        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        // stops paddles at window edges
        if (paddle1.y <= 0)
            paddle1.y = 0;
        if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if (paddle2.y <= 0)
            paddle2.y = 0;
        if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
        // give a player 1 point and creates new paddles & ball
        if (ball.x <= 0) {
            score.player2.pop();
            // System.out.print("player 2: ");
            // score.player2.display();
            newPaddles();
            newBall();
            System.out.println("Player 2: " + score.player2.peek());
        } else if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1.pop();
            // System.out.print("\nPlayer 1: ");
            // score.player1.display();
            newPaddles();
            newBall();
            System.out.println("Player 1: " + score.player1.peek());
        }
    }

    public void run() {
        // game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 120.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            // System.out.println("Delta :" + delta);
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (gameFlag) {
                System.out.println("Replaying");
                centerBall();
                repaint();
                score.ScoreReset();
                repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                score.ScoreReset();
                gameFlag = false;
            } else if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                score.checkScore();
                delta--;
            }
            if (endGame)
                return;
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
