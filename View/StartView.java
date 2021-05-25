package View;

import Model.Audio;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartView {
    private Stage stage;
    private AnchorPane pane;
    private Scene scene;
    private Label title;
    private Button pvp;
    private Button pvai;
    private Button scoresB;
    private Button storeB;

    public StartView(){
        stage = new Stage();
        pane = new AnchorPane();
        scene = new Scene(pane,490,270);
        stage.setScene(scene);
        stage.setResizable(false);
        createGif();
        if(!Audio.isMusicPlaying()){
            Audio.playMusic("/View/Assets/GameAudio.mp3");
        }
        Audio.setPlaying(true);
        createTitleLabel();
        createButtons();
        buttonActions();
        scene.getStylesheets().addAll("/View/stylesheet.css");
        stage.show();

    }
    /*Creates a title label for the game*/
    public void createTitleLabel(){
        title = new Label("Welcome to Rock Paper Scissors Battle\n\t   Choose who to play with");
        title.setLayoutX(45);
        title.setLayoutY(10);
        pane.getChildren().addAll(title);
    }
    /*Creates a gif of moving rock, paper, and scissors*/
    public void createGif(){
        Image fis = new Image(getClass().getResourceAsStream("/View/Assets/MainGif.gif"));
        ImageView waitGifView = new ImageView(fis);
        pane.getChildren().add(waitGifView);
    }
    /*Creates the main menu buttons. The player vs. player, player vs. ai,
     *scores, and store buttons
     */
    public void createButtons(){
        pvp = new Button("Player v. Player");
        pvp.setLayoutX(7);
        pvp.setLayoutY(215);
        pvp.setPrefSize(132,50);

        pvai = new Button("Player v. AI");
        pvai.setLayoutX(147);
        pvai.setLayoutY(215);
        pvai.setPrefSize(125,50);

        scoresB = new Button("Scores");
        scoresB.setLayoutX(279);
        scoresB.setLayoutY(215);
        scoresB.setPrefSize(100,50);

        storeB = new Button("Store");
        storeB.setLayoutX(387);
        storeB.setLayoutY(215);
        storeB.setPrefSize(100,50);

        pane.getChildren().addAll(pvp,pvai,scoresB,storeB);
    }
    /*Sets the actions for the main menu buttons*/
    public void buttonActions(){
        pvp.setOnAction(event -> {
            stage.close();
            GamePVPView gv1 = new GamePVPView();
        });
        pvai.setOnAction(event -> {
            stage.close();
            GamePVAIView gv2 = new GamePVAIView();
        });
        scoresB.setOnAction(event -> {
            ScoresView sv = new ScoresView(GamePVAIView.getAIGamesPlayed(), GamePVAIView.getAIGamesWon(), GamePVAIView.getAIGamesLost(),GamePVAIView.getAIRoundsWon(),GamePVAIView.getAIRoundsLost(),
                    GamePVPView.getPlayerGamesPlayed(),GamePVPView.getPlayer1RoundsWon(),GamePVPView.getPlayer1RoundsLost(),GamePVPView.getPlayer2RoundsWon(),
                    GamePVPView.getPlayer2RoundsLost(), GamePVPView.getPlayer1GamesWon(), GamePVPView.getPlayer1GamesLost(),
                    GamePVPView.getPlayer2GamesWon(),GamePVPView.getPlayer2GamesLost(),GamePVPView.getPlayerGamesTied(),GamePVAIView.getAIGamesTied());
            System.out.println(GamePVPView.getPlayer1RoundsWon());
            stage.close();

        });
        storeB.setOnAction(event -> {
            StoreView st = new StoreView(GamePVAIView.getUser1());
            stage.close();
        });
    }
}
