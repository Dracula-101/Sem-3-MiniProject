package Pong;

import java.awt.*;

public class Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    static int Border;
    Stack player1;
    Stack player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT, int Border) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
        Score.Border = Border;
        player1 = new Stack();
        player2 = new Stack();
    }

    public void ScoreReset() {
        player1 = new Stack();
        player2 = new Stack();
    }

    public void checkScore() {
        if (player1.isEmpty()) {
            GameFrame.resetPanel(1);
        } else if (player2.isEmpty()) {
            GameFrame.resetPanel(2);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Verdana", Font.PLAIN, 60));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
        // g.drawLine(0, Border, GAME_WIDTH, Border);
        // g.drawLine(0, GAME_HEIGHT - Border, GAME_WIDTH, GAME_HEIGHT - Border);

        g.drawString(String.valueOf(player1.peek() / 10) + String.valueOf(player1.peek() % 10),
                (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2.peek() / 10) + String.valueOf(player2.peek() % 10),
                (GAME_WIDTH / 2) + 20, 50);
    }

}