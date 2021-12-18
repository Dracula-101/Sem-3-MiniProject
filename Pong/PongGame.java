package Pong;

public class PongGame {
    static GameFrame pongGame = new GameFrame();

    public static void endPong() {
        pongGame.dispose();
    }

    public static GameFrame getFrame() {
        return pongGame;
    }

    public PongGame() {
        System.out.println("The Pong Game has Started!!");
    }
}
