package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ScoresView {
    private Stage stage;
    private AnchorPane pane;
    private AnchorPane pane2;
    private AnchorPane pane3;
    private AnchorPane pane4;
    private Scene scene;
    private int AIGamesPlayed;
    private int AIGamesWon;
    private int AIGamesLost;
    private int playerGamesTied;
    private int AIGamesTied;
    private int playerGamesPlayed;
    private int player1GamesWon;
    private int player1GamesLost;
    private int player2GamesWon;
    private int player2GamesLost;
    private int AIRoundsWon;
    private int AIRoundsLost;
    private int player1RoundsWon;
    private int player1RoundsLost;
    private int player2RoundsWon;
    private int player2RoundsLost;


    private Label playerGamesTiedL;
    private Label AIGamesTiedL;
    private Label AIGamesPlayedL;
    private Label AIGamesWonL;
    private Label AIGamesLostL;
    private Label playerGamesPlayedL;
    private Label player1RoundsWonL;
    private Label player1RoundsLostL;
    private Label player2RoundsWonL;
    private Label player2RoundsLostL;
    private Label player1GamesWonL;
    private Label player1GamesLostL;
    private Label player2GamesWonL;
    private Label player2GamesLostL;
    private Label AIRoundsWonL;
    private Label AIRoundsLostL;
    private Label PVPGamesStreak;
    private Label PVAIGameStreak;
    private Button backB;
    private Button backB2;
    private Button backB3;
    private Button backB4;
    private Button playerAIScoresB;
    private Button playerPlayerScoresB;
    private Button highestScoreB;




    public ScoresView(int AiGamesPlayedd, int AIGamesWond, int AIGamelostd, int AIRoundsWon, int AIRoundsLost, int playerGamesPlayed, int player1RoundsWon,int player1RoundsLost,int player2RoundsWon,int player2RoundsLost, int player1GamesWon, int player1GamesLost, int player2GamesWon, int player2GamesLost, int playerGamesTied, int AIGamesTied) {
        stage = new Stage();
        pane = new AnchorPane();
        createBackground(pane,new Image(getClass().getResourceAsStream("/View/Assets/InGameBackImage.jpg")));
        pane2 = new AnchorPane();
        createBackground(pane2,new Image(getClass().getResourceAsStream("/View/Assets/InGameBackImage.jpg")));
        pane3 = new AnchorPane();
        createBackground(pane3,new Image(getClass().getResourceAsStream("/View/Assets/InGameBackImage.jpg")));
        pane4 = new AnchorPane();
        createBackground(pane4,new Image(getClass().getResourceAsStream("/View/Assets/InGameBackImage.jpg")));
        scene = new Scene(pane, 600, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().addAll("/View/stylesheet.css");

        AIGamesPlayed = AiGamesPlayedd;
        AIGamesWon = AIGamesWond;
        AIGamesLost = AIGamelostd;
        this.playerGamesPlayed = playerGamesPlayed;
        this.player1GamesWon = player1GamesWon;
        this.player1GamesLost = player1GamesLost;
        this.player2GamesWon = player2GamesWon;
        this.player2GamesLost = player2GamesLost;
        this.playerGamesTied = playerGamesTied;
        this.AIGamesTied = AIGamesTied;
        this.AIRoundsWon = AIRoundsWon;
        this.AIRoundsLost = AIRoundsLost;
        this.player1RoundsWon = player1RoundsWon;
        this.player1RoundsWon = player1RoundsWon;
        this.player1RoundsLost = player1RoundsLost;
        this.player2RoundsWon = player2RoundsWon;
        this.player2RoundsLost = player2RoundsLost;
        createBackButton1();
        createBackButton1Action();
        createScoreOptionsButtons();
        createScoreOptionButtonActions();
        stage.show();
    }
    /*Sets a background for the scores pane*/
    public void createBackground(AnchorPane p, Image f) {
        BackgroundImage backImage = new BackgroundImage(f, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background back = new Background(backImage);
        p.setBackground(back);
    }
    /*Creates three buttons each. One for the scores in the player vs. player games,
     *another one for the scores in the player vs. ai games, and the last one for the
     *highest scores
     */
    public void createScoreOptionsButtons(){
        playerAIScoresB = new Button("Player v. AI Scores");
        playerAIScoresB.setLayoutX(50);
        playerAIScoresB.setLayoutY(100);

        playerPlayerScoresB = new Button("Player v. Player Scores");
        playerPlayerScoresB.setLayoutX(240);
        playerPlayerScoresB.setLayoutY(100);

        highestScoreB = new Button("Highest Scores");
        highestScoreB.setLayoutX(450);
        highestScoreB.setLayoutY(100);

        pane.getChildren().addAll(playerAIScoresB,playerPlayerScoresB,highestScoreB);

    }
    /*Sets the actions for three buttons previously created
     *so that the scores are shown when they are clicked
     */
    public void createScoreOptionButtonActions(){
        playerAIScoresB.setOnAction(event -> {
            scene = new Scene(pane2,600,320);
            scene.getStylesheets().addAll("/View/stylesheet.css");
            stage.setScene(scene);
            createLabels1();
            createBackButton2();
            createBackButton2Action();

        });
        playerPlayerScoresB.setOnAction(event -> {
            scene = new Scene(pane3,600,470);
            scene.getStylesheets().addAll("/View/stylesheet.css");
            stage.setScene(scene);
            createLabels2();
            createBackButton3();
            createBackButton3Action();


        });
        highestScoreB.setOnAction(event -> {
            scene = new Scene(pane4,600,360);
            scene.getStylesheets().addAll("/View/stylesheet.css");
            stage.setScene(scene);
            createLabels3();
            createBackButton4();
            createBackButton4Action();

        });
    }
    /*Creates a back button for the pane in whcih the three scores buttons are located*/
    public void createBackButton1(){
        backB = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB.setId("back-button");
        backB.setLayoutX(20);
        backB.setLayoutY(230);
        pane.getChildren().addAll(backB);

    }
    /*Creates a back button for the pane for the player vs. player  scores*/
    public void createBackButton2(){
        backB2 = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB2.setId("back-button");
        backB2.setLayoutX(20);
        backB2.setLayoutY(240);
        pane2.getChildren().addAll(backB2);

    }
    /*Creates a back button for the pane for the player vs. ai scores*/
    public void createBackButton3(){
        backB3 = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB3.setId("back-button");
        backB3.setLayoutX(20);
        backB3.setLayoutY(380);
        pane3.getChildren().addAll(backB3);

    }
    /*Creates a back button for the pane for the highest scores*/
    public void createBackButton4(){
        backB4 = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB4.setId("back-button");
        backB4.setLayoutX(20);
        backB4.setLayoutY(270);
        pane4.getChildren().addAll(backB4);

    }
    /*Sets the actions for the back button in the pane
     *where the three score buttons are located
     */
    public void createBackButton1Action(){
        backB.setOnAction(event -> {
            StartView sv = new StartView();
            stage.close();
        });
    }
    /*Sets the actions for the back button in the pane
     *where the player vs. player scores are located
     */
    public void createBackButton2Action(){
        backB2.setOnAction(event -> {
            ScoresView sv = new ScoresView(AIGamesPlayed,AIGamesWon,AIGamesLost, AIRoundsWon, AIRoundsLost,playerGamesPlayed,player1RoundsWon,player1RoundsLost,player2RoundsWon,player2RoundsLost,player1GamesWon,player1GamesLost,player2GamesWon,player2GamesLost,playerGamesTied,AIGamesTied);
            stage.close();
        });
    }
    /*Sets the actions for the back button in the pane
     *where the player vs. ai scores are located
     */
    public void createBackButton3Action(){
        backB3.setOnAction(event -> {
            ScoresView sv = new ScoresView(AIGamesPlayed,AIGamesWon,AIGamesLost, AIRoundsWon, AIRoundsLost,playerGamesPlayed,player1RoundsWon,player1RoundsLost,player2RoundsWon,player2RoundsLost,player1GamesWon,player1GamesLost,player2GamesWon,player2GamesLost,playerGamesTied,AIGamesTied);
            stage.close();
        });
    }
    /*Sets the actions for the back button in the pane
     *where the highest scores are located
     */
    public void createBackButton4Action(){
        backB4.setOnAction(event -> {
            ScoresView sv = new ScoresView(AIGamesPlayed,AIGamesWon,AIGamesLost, AIRoundsWon, AIRoundsLost,playerGamesPlayed,player1RoundsWon,player1RoundsLost,player2RoundsWon,player2RoundsLost,player1GamesWon,player1GamesLost,player2GamesWon,player2GamesLost,playerGamesTied,AIGamesTied);
            stage.close();
        });
    }

    /*Creates the score labels for the player vs. player scores,
     *which will show the number of games played, won,
     * lost, and tied
     */
    public void createLabels1(){
        AIGamesPlayedL = new Label("Games played against AI: " + AIGamesPlayed);
        AIGamesPlayedL.setLayoutX(20);
        AIGamesPlayedL.setLayoutY(30);
        AIRoundsWonL = new Label("Games won against AI: " + AIRoundsWon);
        AIRoundsWonL.setLayoutX(20);
        AIRoundsWonL.setLayoutY(60);
        AIRoundsLostL = new Label("Games lost against AI: " + AIRoundsLost);
        AIRoundsLostL.setLayoutX(20);
        AIRoundsLostL.setLayoutY(90);
        AIGamesWonL = new Label("Rounds won against AI: " + AIGamesWon);
        AIGamesWonL.setLayoutX(20);
        AIGamesWonL.setLayoutY(140);
        AIGamesLostL = new Label("Rounds lost against AI: " + AIGamesLost);
        AIGamesLostL.setLayoutX(20);
        AIGamesLostL.setLayoutY(170);
        AIGamesTiedL = new Label("Rounds tied against AI: " + AIGamesTied);
        AIGamesTiedL.setLayoutX(20);
        AIGamesTiedL.setLayoutY(200);
        pane2.getChildren().addAll(AIGamesPlayedL,AIRoundsWonL,AIRoundsLostL,AIGamesWonL,AIGamesLostL,AIGamesTiedL);
    }
    /*Creates the score labels for the player vs. ai scores,
     *which will show the number of games played, won,
     * lost, and tied
     */
    public void createLabels2(){
        playerGamesPlayedL = new Label("Games played Player v. Player: " + playerGamesPlayed);
        playerGamesPlayedL.setLayoutX(20);
        playerGamesPlayedL.setLayoutY(30);
        player1RoundsWonL = new Label("Player 1 Games won: " + player1RoundsWon);
        player1RoundsWonL.setLayoutX(20);
        player1RoundsWonL.setLayoutY(60);
        player1RoundsLostL = new Label("Player 1 Games lost: " + player1RoundsLost);
        player1RoundsLostL.setLayoutX(20);
        player1RoundsLostL.setLayoutY(90);
        player2RoundsWonL = new Label("Player 2 Games won: " + player2RoundsWon);
        player2RoundsWonL.setLayoutX(20);
        player2RoundsWonL.setLayoutY(120);
        player2RoundsLostL = new Label("Player 2 Games lost: " + player2RoundsLost);
        player2RoundsLostL.setLayoutX(20);
        player2RoundsLostL.setLayoutY(150);
        player1GamesWonL = new Label("Player 1 Rounds won: " + player1GamesWon);
        player1GamesWonL.setLayoutX(20);
        player1GamesWonL.setLayoutY(200);
        player1GamesLostL = new Label("Player 1 Rounds lost: " + player1GamesLost);
        player1GamesLostL.setLayoutX(20);
        player1GamesLostL.setLayoutY(230);
        player2GamesWonL = new Label("Player 2 Rounds won: " + player2GamesWon);
        player2GamesWonL .setLayoutX(20);
        player2GamesWonL .setLayoutY(260);
        player2GamesLostL = new Label("Player 2 Rounds lost: " + player2GamesLost);
        player2GamesLostL.setLayoutX(20);
        player2GamesLostL.setLayoutY(290);
        playerGamesTiedL = new Label("Player v. Player Rounds tied: " + playerGamesTied);
        playerGamesTiedL.setLayoutX(20);
        playerGamesTiedL.setLayoutY(320);
        pane3.getChildren().addAll(playerGamesPlayedL,player1RoundsWonL,player1RoundsLostL,player2RoundsWonL,player2RoundsLostL,player1GamesWonL,player1GamesLostL,player2GamesWonL,player2GamesLostL,playerGamesTiedL);

    }
    /*Creates the score labels for the highest scores,
     *which will show the highest score in the player
     *vs. player, and the player vs. ai
     */
    public void createLabels3(){
        PVPGamesStreak = new Label("Highest win streak in Player v. Player:\nPlayer 1: " + GamePVPView.getPly1Streak() + "\nPlayer 2: " + GamePVPView.getPly2Streak());
        PVPGamesStreak.setLayoutX(20);
        PVPGamesStreak.setLayoutY(30);
        PVAIGameStreak = new Label("Highest win streak in Player v. AI:\nPlayer 1: " + GamePVAIView.getPlyStreak() + "\nAI: " + GamePVAIView.getAIStreak());
        PVAIGameStreak.setLayoutX(20);
        PVAIGameStreak.setLayoutY(150);
        pane4.getChildren().addAll(PVPGamesStreak,PVAIGameStreak);

    }

}
