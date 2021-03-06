import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import Pong.PongGame;
import Roulette.Roulette;
import TTT.TicTacToe;
import Hangman.Hangman;
import FacultyGuess.FacultyGuess;

/**
 *
 * @author Pratik
 */
public class gameFrame extends javax.swing.JFrame {

        public static gameFrame heroFrame;
        PongGame pong;
        Roulette roulette;
        TicTacToe tictactoe;
        Hangman hangman;
        FacultyGuess fg;

        /**
         * Creates new form gameFrame
         */
        public gameFrame() {
                initComponents();
        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                title = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                Pong = new javax.swing.JButton();
                Roulette = new javax.swing.JButton();
                TTT = new javax.swing.JButton();
                Hangman = new javax.swing.JButton();
                Game5 = new javax.swing.JLabel();
                FacultyGuess = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setForeground(java.awt.Color.lightGray);
                setPreferredSize(new java.awt.Dimension(700, 550));
                setResizable(false);

                jPanel1.setBackground(new java.awt.Color(20, 61, 89));
                jPanel1.setPreferredSize(new java.awt.Dimension(695, 530));

                jPanel2.setBackground(new java.awt.Color(244, 180, 25));
                jPanel2.setPreferredSize(new java.awt.Dimension(700, 100));

                title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 55)); // NOI18N
                title.setText("Game Library");

                jLabel8.setIcon(new javax.swing.ImageIcon("img\\Title Logo.png")); // NOI18N

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap(125, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addGap(510, 510,
                                                                                                                                510))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel8,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                77,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(title,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                409,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(77, 77, 77)))));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(25, 25, 25)
                                                                                                .addComponent(jLabel8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                48,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(17, 17, 17))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addComponent(title,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                64,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                                .addComponent(jLabel1)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jLabel2.setIcon(new javax.swing.ImageIcon(
                                "img\\hangman.png")); // NOI18N

                jLabel3.setIcon(new javax.swing.ImageIcon(
                                "img\\Tic tac toe.png")); // NOI18N

                jLabel4.setIcon(new javax.swing.ImageIcon(
                                "img\\Roulette.png")); // NOI18N

                jLabel5.setIcon(new javax.swing.ImageIcon(
                                "img\\Pong.png")); // NOI18N

                Pong.setText("Pong");

                Roulette.setText("Roulette");

                TTT.setText("Tic Tac Toe");
                Pong.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                PongActionPerformed(evt);
                        }
                });
                Roulette.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                RouletteActionPerformed(evt);
                        }
                });
                TTT.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                TTTActionPerformed(evt);
                        }
                });

                Hangman.setText("Guess It");
                Hangman.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                HangmanActionPerformed(evt);
                        }
                });

                Game5.setIcon(new javax.swing.ImageIcon(
                                "img\\FacultyGuess.png")); // NOI18N

                FacultyGuess.setText("FQuest");
                FacultyGuess.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                FacultyGuessActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 695,
                                                                Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(167, 167, 167)
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                132,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(191, 191, 191)
                                                                                                .addComponent(Hangman)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(94, 94, 94)
                                                                                                .addComponent(Game5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                132,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(132, 132, 132)
                                                                                                .addComponent(FacultyGuess)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                132,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(65, 65, 65)
                                                                .addComponent(jLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                132,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(74, 74, 74)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                132,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(72, 72, 72))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(122, 122, 122)
                                                                .addComponent(Pong)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(Roulette)
                                                                .addGap(120, 120, 120)
                                                                .addComponent(TTT)
                                                                .addGap(90, 90, 90)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                132,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                132,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                132,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(Pong)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                132,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(Hangman))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(TTT)
                                                                                                                                .addComponent(Roulette))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(Game5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                132,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(FacultyGuess,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                25,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(51, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                pack();
                setLocationRelativeTo(null);
        }

        private void PongActionPerformed(java.awt.event.ActionEvent evt) {
                heroFrame.setVisible(false);
                pong = new PongGame();
                PongGame.getFrame().setAlwaysOnTop(true);
                heroFrame.setVisible(true);
        }

        private void RouletteActionPerformed(java.awt.event.ActionEvent evt) {
                heroFrame.setVisible(false);
                roulette = new Roulette();
                roulette.runGAME();
                heroFrame.setVisible(true);
        }

        private void TTTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TTTActionPerformed
                heroFrame.setVisible(false);
                tictactoe = new TicTacToe();
                tictactoe.play();
                heroFrame.setVisible(true);
        }

        private void HangmanActionPerformed(java.awt.event.ActionEvent evt) {

                heroFrame.setVisible(false);
                hangman = new Hangman();
                hangman.runHangman();
                heroFrame.setVisible(true);
        }

        private void FacultyGuessActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_game5ActionPerformed
                heroFrame.setVisible(false);
                fg = new FacultyGuess();
                heroFrame.setVisible(true);
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {

                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(gameFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(gameFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(gameFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(gameFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                heroFrame = new gameFrame();
                                heroFrame.setVisible(true);
                                heroFrame.setLocationRelativeTo(null);
                                heroFrame.addWindowListener(new WindowAdapter() {
                                        public void windowClosing(WindowEvent evt) {
                                                int resp = JOptionPane.showConfirmDialog(null,
                                                                "Are you sure you want to exit?",
                                                                "Exit?", JOptionPane.YES_NO_OPTION);

                                                if (resp == JOptionPane.YES_OPTION) {
                                                        heroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                        heroFrame.dispose();
                                                        System.exit(0);
                                                } else {
                                                        heroFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                                                        return;
                                                }
                                        }
                                });
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel Game5;
        private javax.swing.JButton Hangman;
        private javax.swing.JButton Pong;
        private javax.swing.JButton Roulette;
        private javax.swing.JButton TTT;
        private javax.swing.JButton FacultyGuess;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        public javax.swing.JLabel title;
        // End of variables declaration//GEN-END:variables
}
