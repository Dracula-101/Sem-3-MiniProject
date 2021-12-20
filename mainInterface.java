
// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Pong.GameFrame;
import Roulette.Roulette;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainInterface extends MainFrame {
    public static void main(String[] args) {
        new MainFrame();
    }

    public static void endPong() {
        pongGame.dispose();
    }

}

class MainFrame {

    static GameFrame pongGame;
    static JFrame mainFrame;
    Dimension windowSize = new Dimension(400, 400);
    JButton pong, Roulette;
    ButtonListener action = new ButtonListener();

    MainFrame() {
        mainFrame = new JFrame("Game Library");
        mainFrame.setSize(windowSize);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        // mainFrame.setResizable(false);

        pong = new JButton("Click");
        JLabel pongLabel = new JLabel("Pong Game");
        Roulette = new JButton("Click");
        JLabel RouletteLabel = new JLabel("\nRoulette Game");
        JPanel mainPanel = new JPanel();
        JTextArea heArea = new JTextArea("Hello");

        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(pong, BorderLayout.EAST);
        mainPanel.add(pongLabel);
        mainPanel.add(Roulette, BorderLayout.WEST);
        mainPanel.add(RouletteLabel);
        mainPanel.add(heArea);

        // mainFrame.add(new JLabel(new ImageIcon("PongIcon.jpeg")));
        // pong.addActionListener(this);

        pong.addActionListener(action);
        Roulette.addActionListener(action);

        mainFrame.pack();

    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == pong) {
                pongGame = new GameFrame();
                mainFrame.setFocusable(true);
            } else if (e.getSource() == Roulette) {
                mainFrame.setVisible(false);
                Roulette roulette = new Roulette();
                roulette.runGAME();
                mainFrame.setVisible(true);

            }

        }

    }
}
