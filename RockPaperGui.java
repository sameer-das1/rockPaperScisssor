
// This is the RockPaperGui frontend

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// ...existing code...

import javax.swing.*;

public class RockPaperGui extends JFrame implements ActionListener {
    // Player buttons
    JButton rockButton , paperButton , scissorButton;
    // will display the choice of computer 
    JLabel computerChoice;

    // Labels to display scores
    JLabel playerScoreLabel,computerScoreLabel;

    //rockPaperScissor object to play the game
    RockPaperScissor rockPaperScissor;

    public RockPaperGui(){
        // This is the constructor for the RockPaperGui class which we will 
        // instantiate in the main method of the app class.
        
        //now we will set the title of the window
        // Instead of setTitle he used super to set the title of the JFrame , because it sets the title using the JFrame constructor
        super("Rock Paper Scissors Game");// We can give any name to the title
        // Set the size of the GUI
        setSize(450,574);
        
        // Setting layout to null to disable layout management so that we can use absolute positioning of the elements
        // (ex: setting x,y coordinates and width , height)
        setLayout(null);

        // Terminate the program when closing the gui
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // To load the GUI in the center of the screen everytime we run 
        setLocationRelativeTo(null);

        // Instantiate the RockPaperScissor object
        rockPaperScissor = new RockPaperScissor();

        //add gui components in the addGuiComponents method
        addGuiComponents();

        
        
    }
    private void addGuiComponents(){


        // CREATING COMPUTER SCORE LABEL

        computerScoreLabel = new JLabel("Computer: 0");
        // Add the computer score label to the JFrame
        add(computerScoreLabel);
        // set x and y coordinates and width and height values
        computerScoreLabel.setBounds(0,43,450,30);
        // Setting font-family of Dialog and font-size to 20 and bold
        computerScoreLabel.setFont(new Font("Dialog",Font.BOLD,20));
        // Place the text in center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);



        // CREATING COMPUTER CHOICE LABEL

        computerChoice = new JLabel("?");// i set the default value to ? to hide computers choice after each round
        // Add the computer choice label to the JFrame
        add(computerChoice);
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,20));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        // Creating a black border aroung
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        // CREATING PLAYER SCORE LABEL

        playerScoreLabel = new JLabel("Player: 0");
        add(playerScoreLabel);
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);



        // CREATING PLAYER CHOICE BUTTONS

        // Rock button
        rockButton = new JButton("Rock");
        add(rockButton);
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.addActionListener(this);

        // Paper button
        paperButton = new JButton("Paper");
        add(paperButton);
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.addActionListener(this);

        // Scissor button
        scissorButton = new JButton("Scissor");
        add(scissorButton);
        scissorButton.setBounds(290,387,105,81);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(this);

    }

    // This method is used to display the result of the game
    // This will show the winner and a try again button to play again
    private void showDialog(String message){ // there are three outcomes: player wins, computer wins, and draw

        
        JDialog resultDialog = new JDialog(this,"Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // Adding message label
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Dialog",Font.BOLD,18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(messageLabel,BorderLayout.CENTER);

        // Try again button    
        JButton tryAgainButton = new JButton("Try Again?");
        // Adding some functionality
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Reset computer choice
                computerChoice.setText("?");

                //close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get player choice
        String playerChoice = e.getActionCommand().toString();

        // Play rock paper sissor and store result into string var
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        //Computer choice 
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        // Update scores
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());
        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());

        // Display result dialog
        showDialog(result);
    }
}