package Model;

public class User1 {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    private int chosen;
    private int coins = 10;

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

    /*Returns the current value of the chosen variable*/
    public int getChosen(){
        return chosen;
    }

    /*Sets the value of the chosen variable to the parameter*/
    public void setChosen(int theChosen){
        chosen = theChosen;
    }

    /*Returns the number of coins owned by the user*/
    public int getCoins(){
        return coins;

    }

    /*Increments the number of coins the user has by one*/
    public void addCoin(){
        coins++;

    }

    /*Decrements the number of coins the user has by one*/
    public void removeCoin(int r){
        coins-=r;
    }
}
