
// This class will handel all the logic of the game
//backend
import java.util.Random;

public class RockPaperScissor {
    // All of the choices the computer can make
    private static final String[] computerChoices = {"Rock","Paper","Scissor"};


    // getters for the scores and computer choice
    public int getComputerScore() {
        return computerScore;
    }
    public int getPlayerScore() {
        return playerScore;
    }
    public String getComputerChoice() {
        return computerChoice;
    }



    // // This will store the computer's choice
    private String computerChoice;

    // Stores the score 
    private int playerScore,computerScore;

    // Helps to generate random choices for the computer 
    private Random random;

    // Constructor to generate random choices
    public RockPaperScissor(){
        random = new Random();
    }

    // This method will handel the logic of a single game
    // THis will return the result of the game
    public String playRockPaperScissor(String playerChoice){
        // Generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        // will contain the result of the game
        String result;

        // Evaluate the winner
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player wins";
                playerScore++;  
            }else if(playerChoice.equals("Scissor")){
                result = "Computer wins";
                computerScore++;        
            }else{
                result ="Draw";
            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissor")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Rock")){
                result = "Computer wins";
                computerScore++;
            }else{
                result = "Draw";
            }
        }else{
            // computerChoice is Scissor
            if(playerChoice.equals("Rock")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result = "Computer wins";
                computerScore++;
            }else{
                result= "Draw";
            }
        }
        return result;    
    }
}
