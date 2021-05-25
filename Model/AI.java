package Model;

public class AI {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    private int chosen;

    /*Returns the current value of the chosen variable*/
    public int getChosen(){
        return chosen;
    }

    /*Returns the value of the chosen(either rock paper or scissors) as a String*/
    public String getChosenAsString(){
        if(chosen == 1){
            return "Rock";
        }
        else if(chosen == 2){
            return "Paper";
        }
        return "Scissors";
    }

    /*Sets the value of the chosen to a random value between 1 and 3,
     *where 1 is rock, 2 is paper, and 3 is scissors
     */
    public void setChosen(){
        chosen = (int)((Math.random()*3)+1);
    }


}
