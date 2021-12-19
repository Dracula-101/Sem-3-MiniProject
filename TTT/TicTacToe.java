package TTT;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	
	JFrame frame = new JFrame("Tic Tac Toe");
	
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	Random r = new Random();

	JButton[] buttons = new JButton[9];

	JButton replayButton = new JButton();
	JButton exitButton = new JButton();
	JButton nextButton = new JButton();

	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, replayButton,exitButton);
	JSplitPane top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,textfield ,nextButton);

	boolean user_turn,flag, gameover = false;
    	int winposition;

	public void play(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setResizable(false);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Arial",Font.BOLD,50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		replayButton.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		replayButton.setFocusable(false);
		replayButton.addActionListener(this);
		replayButton.setText("Replay");

		exitButton.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		exitButton.setText("Exit");

		nextButton.setFont(new Font("Roboto",Font.BOLD,16));
		nextButton.setFocusable(false);
		nextButton.setText("Next->");

		splitPane.setDividerLocation(frame.getWidth()/2);
		top.setDividerLocation(500);
		top.setDividerSize(1);

	
		title_panel.add(top);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		frame.add(splitPane,BorderLayout.SOUTH);

		replayButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					TicTacToe tictactoe = new TicTacToe();
					tictactoe.play();
					
				}
			}
		);

		exitButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					
				}
			}
		);

		nextButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(!user_turn && !gameover)
					{
						compplay();
						
					} 
					
				}
			}
		);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {

				if(user_turn) 
				{
					userplay(i);
					
				}
			}			
		}
	}

	private void userplay(int i) {

		if(buttons[i].getText()=="") {
			buttons[i].setForeground(new Color(255,0,0));
			
			buttons[i].setText("X");
			user_turn=false;
			textfield.setText("Computer's Turn");
			check();
			
		}
	}

	private void compplay() {

		if(compiswinning())
		{
			buttons[winposition].setText("O");
			buttons[winposition].setForeground(new Color(0,0,255));
			
		}
		else if (useriswinning())
		{
			buttons[winposition].setText("O");
			buttons[winposition].setForeground(new Color(0,0,255));
			
		}
		else 
		{
			int a = r.nextInt(9);
			while(buttons[a].getText() != "")
			{
				a = r.nextInt(9);
			}

			buttons[a].setText("O");
			buttons[a].setForeground(new Color(0,0,255));

		}
		user_turn=true;
		textfield.setText("Your Turn");

		check();

	}



	boolean useriswinning()
    {       
        return (checkcrosswin("X") || checkverticalwin("X") || checkhorizontalwin("X"));

    }

    boolean compiswinning()
    {
        return (checkcrosswin("O") || checkverticalwin("O") || checkhorizontalwin("O"));

    }

    private boolean checkhorizontalwin(String a) {

        for(int base = 0; base<7; base+=3)
        {
            if((buttons[base].getText()==a) && (buttons[base+1].getText()==a) && (buttons[base+2].getText()==""))
            {
                winposition = base+2;
                return true;

            }
            if((buttons[base].getText()==a) && (buttons[base+1].getText()=="") && (buttons[base+2].getText()==a))
            {
                winposition = base+1;
                return true;

            }
            if((buttons[base].getText()=="") && (buttons[base+1].getText()==a) && (buttons[base+2].getText()==a))
            {
                winposition = base;
                return true;

            }
            
        }
        return false;
    }

    private boolean checkverticalwin(String a) {

        for(int base = 0; base<3; base++)
        {
            if((buttons[base].getText()==a) && (buttons[base+3].getText()==a) && (buttons[base+6].getText()==""))
            {
                winposition = base+6;
                return true;

            }
            if((buttons[base].getText()==a) && (buttons[base+3].getText()=="") && (buttons[base+6].getText()==a))
            {
                winposition = base+3;
                return true;

            }
            if((buttons[base].getText()=="") && (buttons[base+3].getText()==a) && (buttons[base+6].getText()==a))
            {
                winposition = base;
                return true;

            }
            

        }

        return false;
    }

    public boolean checkcrosswin(String a) {

        if(buttons[0].getText()==buttons[4].getText() && buttons[4].getText()== a && buttons[8].getText()=="")
        {
            winposition = 8;
            return true;
        }
        if(buttons[0].getText()==buttons[8].getText() && buttons[8].getText() == a && buttons[4].getText() == "")
        {
            winposition = 4;
            return true;
        }
        if(buttons[4].getText()==buttons[8].getText() && buttons[8].getText()==a && buttons[0].getText() == "") 
        {
            winposition = 0;
            return true;
        }

    
        if(buttons[2].getText()==buttons[4].getText() && buttons[4].getText() == a && buttons[6].getText() == "")
        {
            winposition = 6;
            return true;
        }
        if(buttons[2].getText()==buttons[6].getText() && buttons[6].getText()== a && buttons[4].getText()== "")
        {
            winposition = 4;
            return true;
        }
        if(buttons[4].getText()==buttons[6].getText() && buttons[6].getText()==a && buttons[2].getText()== "")
        {
            winposition = 2;
            return true;
        }

        return false;
    }

    public void firstTurn() {
		
		if(r.nextInt(2)==0) {
			user_turn=true;
			textfield.setText("Your turn");
		}
		else {
			user_turn=false;
			nextButton.doClick();
		}
	}
	
	public void check() {

		if(checktie())
		{
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textfield.setText("It was a tie!");
			gameover = true;
			return;
		}

		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}

		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	
	public boolean checktie() {
		
		for(int i=0;i<9;i++)
		{
			if(buttons[i].getText()=="") 
			{
				return false;
			}
		}

		return true;
	}


	public void xWins(int a,int b,int c) {
		
		gameWin(a,b,c);
		textfield.setText("You won!");
		gameover = true;
	}

	public void oWins(int a,int b,int c) {
		
		gameWin(a,b,c);
		textfield.setText("Computer won!");
		gameover = true;
	}

	public void gameWin(int a,int b, int c) {

		buttons[a].setBackground(Color.BLUE);
		buttons[b].setBackground(Color.BLUE);
		buttons[c].setBackground(Color.BLUE);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}

	}
}
