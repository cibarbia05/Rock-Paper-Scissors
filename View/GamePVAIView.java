package View;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Model.AI;
import Model.User1;

import java.util.Optional;

public class GamePVAIView {

    private static User1 user1 = new User1();
    private AI ai;
    private Stage stage;
    private static Stage stage2 = new Stage();
    private AnchorPane pane;
    private static AnchorPane pane2 = new AnchorPane();
    private Scene scene;
    private static Scene scene2 = new Scene(pane2,500,500);
    private ToggleButton rockB;
    private ToggleButton paperB;
    private ToggleButton scissorsB;
    private Button backB;
    private static Button helpB2;
    private Button helpB;
    private ToggleGroup tg;
    private Label label;
    private Label ply1CurScore;
    private Label aiCurScore;
    private Button okButton;
    private static Button myItems = new Button("My Items",new ImageView(new Image(GamePVAIView.class.getResourceAsStream("/View/Assets/ItemIcon.png"))));
    private static Button witchHat;
    private static Button iceFlame;
    private static Button candy;
    private static Button pickaxe;
    private static Button cloud;
    private int ply1WinCount;
    private int aiWinCount;
    private int clickCount;
    private static int AIGamesPlayed;
    private static int AIGamesWon;
    private static int AIGamesLost;
    private static int AIGamesTied;
    private static int AIRoundsWon;
    private static int AIRoundsLost;
    private static String winner;
    private static String looser;
    private static int plyStreak;
    private static int AIStreak;
    private int i;

    public static User1 getUser1() {
        return user1;
    }
    public static int getPlyStreak() {
        return plyStreak;
    }
    public static int getAIStreak() {
        return AIStreak;
    }
    public static int getAIGamesPlayed(){
        return AIGamesPlayed;
    }
    public static int getAIGamesWon(){
        return AIGamesWon;
    }
    public static int getAIGamesLost(){
        return AIGamesLost;
    }
    public static int getAIGamesTied() {
        return AIGamesTied;
    }
    public static String getWinner() {
        return winner;
    }
    public static int getAIRoundsWon() {
        return AIRoundsWon;
    }
    public static int getAIRoundsLost() {
        return AIRoundsLost;
    }
    public void setWinner(String s){
        winner = s;
    }
    public void setLooser(String s){
        looser = s;
    }

    /*On instantiation, creates a player vs. ai game*/
    public GamePVAIView() {
        ai = new AI();
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
        itemActions();
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
        aiCurScore  = new Label("AI Score: " + aiWinCount);
        aiCurScore.setLayoutX(30);
        aiCurScore.setLayoutY(360);

        pane.getChildren().addAll(ply1CurScore,aiCurScore);

    }
    /*On call updates the score of both players to their designated counter values*/
    public void changeScoreLabels(){
        ply1CurScore.setText("Player 1 Score: " + ply1WinCount);
        aiCurScore.setText("AI Score: " + aiWinCount);
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
    /*Creates the items, help, back buttons*/
    public void createButtons() {
        backB = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB.setId("back-button");
        backB.setLayoutX(20);
        backB.setLayoutY(390);

        helpB = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Question.png"))));
        helpB.setId("help-button2");
        helpB.setLayoutX(750);
        helpB.setLayoutY(410);

        helpB2 = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Question.png"))));
        helpB2.setId("help-button2");
        helpB2.setLayoutX(325);
        helpB2.setLayoutY(490);

        myItems.setPrefSize(140,40);
        myItems.setLayoutX(735);
        myItems.setLayoutY(345);

        witchHat = new Button("Witch Hat",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/WitchHat.png"))));
        witchHat.setLayoutX(20);
        witchHat.setLayoutY(20);

        iceFlame = new Button("Ice Flame",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/IceFlame.png"))));
        iceFlame.setLayoutX(20);
        iceFlame.setLayoutY(130);

        candy = new Button("Candy",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Candy.png"))));
        candy.setLayoutX(20);
        candy.setLayoutY(290);

        pickaxe = new Button("Axe",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Axe.png"))));
        pickaxe.setLayoutX(20);
        pickaxe.setLayoutY(410);

        cloud = new Button("Cloud",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Cloud.png"))));
        cloud.setLayoutX(20);
        cloud.setLayoutY(500);

        pane.getChildren().addAll(backB,helpB,myItems);
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
        okButton.setLayoutY(405);
        okButton.setPrefSize(60,30);
        pane.getChildren().addAll(okButton);
    }
    /*Sets help, back, ok, and items buttons actions*/
    public void setButtonActions(){
        okButton.setOnAction(event -> {
            if(clickCount>0){
                clickCount=0;
            }
            clickCount++;
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
                ai.setChosen();
                setCurWinner();
                rockB.setSelected(false);

            }
            else if(tg.getSelectedToggle() == paperB && clickCount == 1){
                user1.setChosen(2);
                ai.setChosen();
                setCurWinner();
                paperB.setSelected(false);

            }
            else if(tg.getSelectedToggle() == scissorsB && clickCount == 1){
                user1.setChosen(3);
                ai.setChosen();
                setCurWinner();
                scissorsB.setSelected(false);
            }

        });
        backB.setOnAction(event -> {
            StartView sv = new StartView();
            stage.close();
            if(stage2.isShowing()) {
                stage2.close();
            }
            resetCounters();
        });
        helpB.setOnAction(event -> {
            createHelpAlert();
        });
        myItems.setOnAction(event -> {
            createItemStage();
        });
    }
    /*Sets the current winner od the round according to the rules of rock, paper, and scissors*/
    public void setCurWinner() {
        if (user1.getChosen() == ai.getChosen() && clickCount == 1) {
            displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString() +"\n\nTie \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);
            AIGamesTied++;
        }
        if (user1.getChosen() == User1.ROCK && ai.getChosen() == ai.PAPER) {
            setWinner("AI");
            setLooser("Player 1");
            aiWinCount++;
            AIGamesLost++;
            if (aiWinCount != 0) {
                displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString() +"\n\nThe AI has won this match \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);

            }
            if (ply1WinCount == 3 || aiWinCount == 3) {
                displayTotalScores();
            }
        }
        if (user1.getChosen() == User1.ROCK && ai.getChosen() == ai.SCISSORS) {
            setWinner("Player 1");
            setLooser("AI");
            ply1WinCount++;
            AIGamesWon++;
            if (ply1WinCount != 0) {
                displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString() +"\n\nPlayer 1 has won this match \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);

            }
            if (ply1WinCount == 3 || aiWinCount == 3) {
                displayTotalScores();
            }
        }
        if (user1.getChosen() == User1.PAPER && ai.getChosen() == ai.ROCK) {
            setWinner("Player 1");
            setLooser("AI");
            ply1WinCount++;
            AIGamesWon++;
            if (ply1WinCount != 0) {
                displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString()+"\n\nPlayer 1 has won this match \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);

            }
            if (ply1WinCount == 3 || aiWinCount == 3) {
                displayTotalScores();
            }
        }
        if (user1.getChosen() == User1.PAPER && ai.getChosen() == ai.SCISSORS) {
            setWinner("AI");
            setLooser("Player 1");
            aiWinCount++;
            AIGamesLost++;
            if (aiWinCount != 0) {
                displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString() +"\n\nThe AI has won this match \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);

            }
            if (ply1WinCount == 3 || aiWinCount == 3) {
                displayTotalScores();
            }
        }
        if (user1.getChosen() == User1.SCISSORS && ai.getChosen() == ai.ROCK) {
            setWinner("AI");
            setLooser("Player 1");
            aiWinCount++;
            AIGamesLost++;
            if (aiWinCount != 0) {
                displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString() +"\n\nThe AI has won this match \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);

            }
            if (ply1WinCount == 3 || aiWinCount== 3) {
                displayTotalScores();
            }
        }
        if (user1.getChosen() == User1.SCISSORS && ai.getChosen() == ai.PAPER) {
            setWinner("Player 1");
            setLooser("AI");
            ply1WinCount++;
            AIGamesWon++;
            if (ply1WinCount != 0) {
                displayCurScores("You chose " + user1.getChosenAsString()+"\nThe AI chose "+ ai.getChosenAsString() +"\n\nPlayer 1 has won this match \n\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);

            }
            if (ply1WinCount == 3 || aiWinCount == 3) {
                displayTotalScores();
            }
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
    /*Changes the scores labels and creates an alert with the winner and the image of a coin*/
    public void displayCurScoresGraphic(String s){
        changeScoreLabels();
        Alert alert = new Alert(Alert.AlertType.NONE, s);
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");
        alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/CoinGif.gif"))));

        ButtonType alertButton1 = new ButtonType("Ok");
        alert.getButtonTypes().setAll(alertButton1);
        alert.showAndWait();
    }
    /*Once either player has won three rounds an alert with the scores is created.
     *The game counters are changed accordingly
     */
    public void displayTotalScores(){
        if(ply1WinCount == 3){
            Alert alert = new Alert(Alert.AlertType.NONE, "Player 1 has won \nPlayer 1 score: " + ply1WinCount +"\nAI score: " + aiWinCount);
            alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");
            createEndAlert(alert);
            plyStreak++;
            AIStreak=0;
            AIGamesPlayed++;
            AIRoundsWon++;
        }
        else if(aiWinCount == 3){
            Alert alert = new Alert(Alert.AlertType.NONE, "The AI has won\nPlayer 1 score: " + ply1WinCount +"\nAI score: " + aiWinCount);
            alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");
            createEndAlert(alert);
            plyStreak = 0;
            AIStreak++;
            AIGamesPlayed++;
            AIRoundsLost++;
        }
    }
    /*Creates an alert signaling that the game has ended. Shows the winner.
     *Gives option to continue playing or exit the game
     */
    public void createEndAlert(Alert alert){
        if(getWinner().equals("Player 1")) {

            ButtonType alertButton1 = new ButtonType("Ok");

            alert.getButtonTypes().setAll(alertButton1);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == alertButton1 && getWinner().equals("Player 1")) {

                createRewardAlert();
            }
        }
        else{
            alert = new Alert(Alert.AlertType.NONE,  "The AI has won\nPlayer 1 score: " + ply1WinCount +"\nAI score: " + aiWinCount);
            alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

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
    }
    /*On call resets the AI games track counters*/
    public void resetCounters(){
        AIGamesWon = 0;
        AIGamesLost = 0;
        AIGamesTied = 0;
    }
    /*On call, creates an alert to guide the user when playing*/
    public void createHelpAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE, "Chose either Rock Paper or Scissors and press ok, if you reach 3 wins you get a coin that you can use in the store");
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

        ButtonType alertButton1 = new ButtonType("Ok");
        alert.getButtonTypes().setAll(alertButton1);
        alert.showAndWait();
    }
    /*Gives a coin to the winner of the game. Creates an alert
     *with a Coin gif animation and options to go to the store,
     *head back to the menu, or exit
     */
    public void createRewardAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE, "Congratulations " + getWinner()+ " you have earned a coin");
        if(getWinner().equals("Player 1")){
            user1.addCoin();
        }
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");
        alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/CoinGif.gif"))));

        ButtonType alertButton1 = new ButtonType("Store");
        ButtonType alertButton2 = new ButtonType("Go Back");
        ButtonType alertButton3 = new ButtonType("Exit");
        alert.getButtonTypes().setAll(alertButton1,alertButton2,alertButton3);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == alertButton1){
           StoreView sv = new StoreView(user1);
           stage.close();
        }
        if (result.get() == alertButton2){
            StartView sv = new StartView();
            stage.close();
        }
        if (result.get() == alertButton3){
            stage.close();
        }

    }
    /*On call, creates a stage in which the user will have
     *all of his/her bought items from the store, and is able
     *to use them in the game
     */
    public static void createItemStage(){
        stage2 = new Stage();
        pane2 = new AnchorPane();
        scene2 = new Scene(pane2,435,600);
        scene2.getStylesheets().addAll("/View/stylesheet.css");
        stage2.setScene(scene2);
        stage2.setResizable(false);

        pane2.getChildren().addAll(witchHat,iceFlame,candy,pickaxe,cloud,helpB2);
        stage2.show();


    }
    /*Sets the actions for each of the items represented by buttons in the store
    * When an item is clicked the user will be informed on its effect on the game
    * and the scores tracking the game will be updated accordingly.
    * When the item is hovered, the user will be informed how many items of that
    * type he or she owns.
    */
    public void itemActions(){
        witchHat.setOnAction(event -> {
            if(StoreView.getWitchHatNum()>0){
                if(ply1WinCount<3) {
                    ply1WinCount++;
                    AIGamesWon++;
                }
                user1.addCoin();
                StoreView.setWitchHatNum(StoreView.getWitchHatNum()-1);
                displayCurScoresGraphic("You have added one win to yourself and have earned a free coin\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);
                stage2.close();
                System.out.println("ai "+aiWinCount);
                System.out.println("pl " + ply1WinCount);
                displayTotalScores();
            }
            else{
                createNoItemAlert();
            }
        });
        witchHat.setOnMouseEntered(event -> {
            witchHat.setText("You have " + StoreView.getWitchHatNum() + " item(s) of this type");
        });
        witchHat.setOnMouseExited(event -> {
            witchHat.setText("Witch Hat");
        });

        iceFlame.setOnAction(event -> {
            if(StoreView.getIceFlameNum()>0){
                if(aiWinCount>0) {
                    aiWinCount--;
                    if(i==0){
                        AIGamesWon++;
                        AIGamesLost--;
                        i++;
                    }
                }
                if(ply1WinCount<3) {
                    if(i==0){
                        AIGamesWon++;
                        AIGamesLost--;
                    }
                    ply1WinCount++;
                }
                StoreView.setIceFlameNum(StoreView.getIceFlameNum()-1);
                displayCurScores("You have stolen a win from the AI\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);
                stage2.close();
                displayTotalScores();
            }
            else{
                createNoItemAlert();
            }
        });
        iceFlame.setOnMouseEntered(event -> {
            iceFlame.setText("You have " + StoreView.getIceFlameNum() + " item(s) of this type");

        });
        iceFlame.setOnMouseExited(event -> {
            iceFlame.setText("Ice Flame");
        });

        candy.setOnAction(event -> {
            if(StoreView.getCandyNum()>0){
                if(aiWinCount<3) {
                    aiWinCount++;
                    AIGamesLost++;
                }
                StoreView.setCandyNum(StoreView.getCandyNum()-1);
                displayCurScores("You have added one win to the AI\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);
                stage2.close();displayTotalScores();

            }
            else{
                createNoItemAlert();
            }
        });
        candy.setOnMouseEntered(event -> { candy.setText("You have " + StoreView.getCandyNum() + " item(s) of this type");

        });
        candy.setOnMouseExited(event -> {
            candy.setText("Candy");
        });

        pickaxe.setOnAction(event -> {
            if(StoreView.getPickaxeNum()>0 ){
                if(aiWinCount>0) {
                    aiWinCount--;
                    AIGamesLost--;
                }
                StoreView.setPickaxeNum(StoreView.getPickaxeNum()-1);
                displayCurScores("You have decreased the AI's wins by one\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);
                stage2.close();
                displayTotalScores();
            }
            else{
                createNoItemAlert();
            }

        });
        pickaxe.setOnMouseEntered(event -> {
            pickaxe.setText("You have " + StoreView.getPickaxeNum() + " item(s) of this type");
        });
        pickaxe.setOnMouseExited(event -> {
            pickaxe.setText("Axe");
        });

        cloud.setOnAction(event -> {
            if(StoreView.getCloudNum()>0){
                aiWinCount = 0;
                AIGamesLost = 0;
                StoreView.setCloudNum(StoreView.getCandyNum()-1);
                displayCurScores("You have reset the AI's wins to 0\nPlayer 1 score: " + ply1WinCount + "\nAI score: " + aiWinCount);
                stage2.close();
                displayTotalScores();
            }
            else{
                createNoItemAlert();
            }
        });
        cloud.setOnMouseEntered(event -> {
            cloud.setText("You have " + StoreView.getCloudNum() + " item(s) of this type");
        });
        cloud.setOnMouseExited(event -> {
            cloud.setText("Cloud");
        });

        helpB2.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.NONE, "Use any items that you have, if you wish to buy items head to the store");
            alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

            ButtonType alertButton1 = new ButtonType("Ok");
            alert.getButtonTypes().setAll(alertButton1);
            alert.showAndWait();
        });
    }
    /*On call, creates an alert that tells the user that he or she
     *has no items of type shown by the button he or she clicked
     */
    public void createNoItemAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE, "You don't have any items of this type");
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

        ButtonType alertButton1 = new ButtonType("Ok");
        alert.getButtonTypes().setAll(alertButton1);
        alert.showAndWait();

    }
}
