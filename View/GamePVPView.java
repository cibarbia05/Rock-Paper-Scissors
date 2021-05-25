package View;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Model.User1;
import Model.User2;

import java.util.Optional;

public class GamePVPView {
    private User1 user1;
    private User2 user2;
    private Stage stage;
    private AnchorPane pane;
    private Scene scene;
    private Label label;
    private ToggleButton rockB;
    private ToggleButton paperB;
    private ToggleButton scissorsB;
    private Button backB;
    private ToggleGroup tg;
    private Button okButton;
    private Button helpB;
    private Label ply1CurScore;
    private Label ply2CurScore;
    private int clickCount;
    private int ply1WinCount;
    private int ply2WinCount;

    private static int playerGamesPlayed;
    private static int player1GamesWon;
    private static int player1GamesLost;
    private static int player2GamesWon;
    private static int player2GamesLost;

    private static int player1RoundsWon;
    private static int player1RoundsLost;
    private static int player2RoundsWon;
    private static int player2RoundsLost;
    private static int playerGamesTied;
    private static String winner;
    private static String looser;
    private static int ply1Streak;
    private static int ply2Streak;

    public static int getPly1Streak() {
        return ply1Streak;
    }

    public static int getPly2Streak() {
        return ply2Streak;
    }

    public static int getPlayerGamesPlayed() {
        return playerGamesPlayed;
    }

    public static int getPlayer1GamesWon() {
        return player1GamesWon;
    }

    public static int getPlayer1GamesLost() {
        return player1GamesLost;
    }

    public static int getPlayer2GamesWon() {
        return player2GamesWon;
    }

    public static int getPlayer2GamesLost() {
        return player2GamesLost;
    }

    public static int getPlayerGamesTied() {
        return playerGamesTied;
    }

    public static String getWinner() {
        return winner;
    }

    public static String getLooser() {
        return looser;
    }

    public static int getPlayer1RoundsWon() {
        return player1RoundsWon;
    }

    public static int getPlayer1RoundsLost() {
        return player1RoundsLost;
    }

    public static int getPlayer2RoundsWon() {
        return player2RoundsWon;
    }

    public static int getPlayer2RoundsLost() {
        return player2RoundsLost;
    }

    /*On instantiation, creates a player vs. player game*/
    public GamePVPView() {
        user1 = new User1();
        user2 = new User2();
        stage = new Stage();
        pane = new AnchorPane();
        scene = new Scene(pane,900,500);
        stage.setScene(scene);
        stage.setResizable(false);
        createBackground(new Image(getClass().getResourceAsStream("/View/Assets/InGameBackImage.jpg")));
        createChooseLabel();
        createToggleButtons();
        createButtons();
        createToggleGroup();
        createOkButton();
        setButtonActions();
        resetCounters();
        scoreLabels();
        scene.getStylesheets().addAll("/View/stylesheet.css");
        stage.show();
    }
    /*Sets the background for the pane of the game*/
    public void createBackground(Image f) {
        BackgroundImage backImage = new BackgroundImage(f, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background back = new Background(backImage);
        pane.setBackground(back);
    }
    /*Creates a label that will show whose turn it is*/
    public void createChooseLabel(){
        label = new Label("Player 1 choose");
        label.setId("title-label");
        label.setLayoutX(345);
        pane.getChildren().addAll(label);

    }
    /*Creates two score labels that will show the current scores of player 1 and 2*/
    public void scoreLabels(){
        ply1CurScore = new Label("Player 1 Score: " + ply1WinCount);
        ply1CurScore.setLayoutX(30);
        ply1CurScore.setLayoutY(330);
        ply2CurScore  = new Label("Player 2 Score: " + ply2WinCount);
        ply2CurScore.setLayoutX(30);
        ply2CurScore.setLayoutY(360);

        pane.getChildren().addAll(ply1CurScore,ply2CurScore);

    }
    /*On call updates the score of both players to their designated counter values*/
    public void changeScoreLabels(){
        ply1CurScore.setText("Player 1 Score: " + ply1WinCount);
        ply2CurScore.setText("Player 2 Score: " + ply2WinCount);
    }
    /*Creates the rock, paper, and scissor buttons*/
    private void createToggleButtons(){
        rockB = new ToggleButton();
        rockB.setLayoutX(20);
        rockB.setLayoutY(60);
        rockB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Rock.jpg"))));

        paperB = new ToggleButton();
        paperB.setLayoutX(315);
        paperB.setLayoutY(60);
        paperB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Paper.jpg"))));

        scissorsB = new ToggleButton();
        scissorsB.setLayoutX(615);
        scissorsB.setLayoutY(60);
        scissorsB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Scissors.jpg"))));
        pane.getChildren().addAll(rockB,paperB,scissorsB);
    }
    /*Creates the help, back buttons*/
    public void createButtons()  {
        backB = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB.setId("back-button");
        backB.setLayoutX(20);
        backB.setLayoutY(400);

        helpB = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Question.png"))));
        helpB.setId("help-button2");
        helpB.setLayoutX(750);
        helpB.setLayoutY(390);

        pane.getChildren().addAll(backB,helpB);
    }
    /*Creates a toggle group and adds the toggle buttons (rock, paper, and scissors) to it*/
    public void createToggleGroup(){
        tg = new ToggleGroup();
        rockB.setToggleGroup(tg);
        paperB.setToggleGroup(tg);
        scissorsB.setToggleGroup(tg);
    }
    /*Creates a ok button for user with the current turn to click
     *once they have selected either rock, paper, or scissors
     */
    public void createOkButton(){
        okButton = new Button("Ok");
        okButton.setLayoutX(430);
        okButton.setLayoutY(410);
        okButton.setPrefSize(60,30);
        pane.getChildren().addAll(okButton);
    }
    public void setWinner(String s){
        winner = s;

    }
    public void setLooser(String s){
        looser = s;
    }

    /*Sets help, back, ok, and items buttons actions*/
    public void setButtonActions(){
        okButton.setOnAction(event -> {
            if(clickCount==2){
                clickCount=0;
            }
            clickCount++;
            if(tg.getSelectedToggle()!=null && clickCount == 1){
                label.setText("Player 2 choose");

            }
            if(tg.getSelectedToggle()!=null && clickCount == 2){
                label.setText("Player 1 choose");
            }
            if(tg.getSelectedToggle()==null){
                if(clickCount>0) {
                    clickCount--;
                }
                Alert alert = new Alert(Alert.AlertType.NONE, "Please choose Rock, Paper, or Scissors");
                alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

                ButtonType alertButton1 = new ButtonType("Ok");
                alert.getButtonTypes().setAll(alertButton1);
                alert.showAndWait();
            }
            else if(tg.getSelectedToggle() == rockB && clickCount == 1){
                user1.setChosen(1);
                user2.setChosen(0);
                setCurWinner();
                tg.getSelectedToggle().setSelected(false);
            }
            else if(tg.getSelectedToggle() == paperB && clickCount == 1){
                user1.setChosen(2);
                user2.setChosen(0);
                setCurWinner();
                tg.getSelectedToggle().setSelected(false);
            }
            else if(tg.getSelectedToggle() == scissorsB && clickCount == 1){
                user1.setChosen(3);
                user2.setChosen(0);
                setCurWinner();
                tg.getSelectedToggle().setSelected(false);
            }
            else if(tg.getSelectedToggle() == rockB && clickCount == 2){
                user2.setChosen(1);
                user1.setChosen(user1.getChosen());
                setCurWinner();
                tg.getSelectedToggle().setSelected(false);
            }
            else if(tg.getSelectedToggle() == paperB && clickCount == 2){
                user2.setChosen(2);
                user1.setChosen(user1.getChosen());
                setCurWinner();
                tg.getSelectedToggle().setSelected(false);
            }
            else if(tg.getSelectedToggle() == scissorsB && clickCount == 2){
                user2.setChosen(3);
                user1.setChosen(user1.getChosen());
                setCurWinner();
                tg.getSelectedToggle().setSelected(false);
            }
        });
        backB.setOnAction(event -> {
            StartView sv = new StartView();
            resetCounters();
            stage.close();
        });
        helpB.setOnAction(event -> {
            createHelpAlert();
        });
    }
    /*Sets the current winner od the round according to the rules of rock, paper, and scissors*/
    public void setCurWinner(){
        if(user1.getChosen() == user2.getChosen() && clickCount>1){
            displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\n\nTie \n\nPlayer 1 score: " + ply1WinCount +" \nPlayer 2 score: "  + ply2WinCount);
            playerGamesTied++;
        }
        else if(user1.getChosen()==User1.ROCK && user2.getChosen() == User2.PAPER){
            setWinner("Player 2");
            setLooser("Player 1");
            ply2WinCount++;
            if(ply2WinCount!=0){
                displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\nPlayer 2 has won this match \n\nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);

            }
            if(ply1WinCount==3 || ply2WinCount==3){
                displayTotalScores();
            }
            player2GamesWon++;
            player1GamesLost++;
        }
        else if(user1.getChosen()==User1.ROCK && user2.getChosen() == User2.SCISSORS){
            setWinner("Player 1");
            setLooser("Player 2");
            ply1WinCount++;
            if(ply1WinCount!=0){
                displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\n\nPlayer 1 has won this match \n\nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);

            }
            if(ply1WinCount==3 || ply2WinCount==3){
                displayTotalScores();
            }
            player1GamesWon++;
            player2GamesLost++;
        }
        else if(user1.getChosen()==User1.PAPER && user2.getChosen() == User2.ROCK){
            setWinner("Player 1");
            setLooser("Player 2");
            ply1WinCount++;
            if(ply1WinCount!=0){
                displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\n\nPlayer 1 has won this match \n\nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);

            }
            if(ply1WinCount==3 || ply2WinCount==3){
                displayTotalScores();
            }
            player1GamesWon++;
            player2GamesLost++;
        }
        else if(user1.getChosen()==User1.PAPER && user2.getChosen() == User2.SCISSORS){
            setWinner("Player 2");
            setLooser("Player 1");
            ply2WinCount++;
            if(ply2WinCount!=0){
                displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\n\nPlayer 2 has won this match \n\nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);

            }
            if(ply1WinCount==3 || ply2WinCount==3){
                displayTotalScores();
            }
            player2GamesWon++;
            player1GamesLost++;
        }
        else if(user1.getChosen()==User1.SCISSORS && user2.getChosen() == User2.ROCK){
            setWinner("Player 2");
            setLooser("Player 1");
            ply2WinCount++;
            if(ply2WinCount!=0){
                displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\n\nPlayer 2 has won this match \n\nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);

            }
            if(ply1WinCount==3 || ply2WinCount==3){
                displayTotalScores();
            }
            player2GamesWon++;
            player1GamesLost++;
        }
        else if(user1.getChosen()==User1.SCISSORS && user2.getChosen() == User2.PAPER){
            setWinner("Player 1");
            setLooser("Player 2");
            ply1WinCount++;
            if(ply1WinCount!=0){
                displayCurScores("Player 1 chose "+ user1.getChosenAsString() + "\nPlayer 2 chose " + user2.getChosenAsString() + "\n\nPlayer 1 has won this match \n\nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);

            }
            if(ply1WinCount==3 || ply2WinCount==3){
                displayTotalScores();
            }
            player1GamesWon++;
            player2GamesLost++;
        }
    }
    /*Changes the scores labels and creates an alert with the winner of the current round*/
    public void displayCurScores(String s){
        changeScoreLabels();
        Alert alert = new Alert(Alert.AlertType.NONE, s);
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

        ButtonType alertButton1 = new ButtonType("Ok");
        alert.getButtonTypes().setAll(alertButton1);
        alert.showAndWait();
    }
    /*Once either player has won three rounds an alert with the scores is created.
     *The game counters are changed accordingly
     */
    public void displayTotalScores(){
        if(ply1WinCount == 3){
            Alert alert = new Alert(Alert.AlertType.NONE, "Player 1 has won \nPlayer 1 score: " + ply1WinCount +"\nPlayer 2 score: " + ply2WinCount);
            alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");
            createEndAlert(alert);
            playerGamesPlayed++;
            ply1Streak++;
            player1RoundsWon++;
            player2RoundsLost++;
            System.out.println(player1RoundsWon+", " + player2RoundsLost);
            ply2Streak=0;
        }
        if(ply2WinCount == 3) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Player 2 has won\nPlayer 1 score: " + ply1WinCount + "\nPlayer 2 score: " + ply2WinCount);
            alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");
            createEndAlert(alert);
            playerGamesPlayed++;
            ply2Streak++;
            player1RoundsLost++;
            player2RoundsWon++;
            System.out.println(player1RoundsLost+", " + player2RoundsWon);
            ply1Streak=0;
        }
    }
    /*Creates an alert signaling that the game has ended. Shows the winner.
     *Gives option to continue playing or exit the game
     */
    public void createEndAlert(Alert alert){
        ButtonType alertButton1 = new ButtonType("Go Back");
        ButtonType alertButton2 = new ButtonType("Exit");
        alert.getButtonTypes().setAll(alertButton1,alertButton2);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == alertButton1){
            StartView sv = new StartView();
            stage.close();
        }
        if (result.get() == alertButton2){
            stage.close();
        }
    }
    /*On call resets the AI games track counters*/
    public void resetCounters(){
        player1GamesWon = 0;
        player1GamesLost = 0;
        player2GamesWon = 0;
        player2GamesLost = 0;
        playerGamesTied = 0;
    }
    /*On call, creates an alert to guide the user when playing*/
    public void createHelpAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE, "Player 1 select your choice and press ok, then Player 2 select your choice and press ok");
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

        ButtonType alertButton1 = new ButtonType("Ok");
        alert.getButtonTypes().setAll(alertButton1);
        alert.showAndWait();
    }
}