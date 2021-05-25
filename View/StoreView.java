package View;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Model.User1;

public class StoreView {
    private Stage stage;
    private AnchorPane pane;
    private Scene scene;
    private User1 user1;
    private Label coinsL;
    private Button backB;
    private Button witchHat;
    private Button iceFlame;
    private Button candy;
    private Button pickaxe;
    private Button cloud;

    private static int witchHatNum;
    private static int iceFlameNum;
    private static int candyNum;
    private static int pickaxeNum;
    private static int cloudNum;

    public static int getWitchHatNum() {
        return witchHatNum;
    }

    public static int getIceFlameNum() {
        return iceFlameNum;
    }

    public static int getCandyNum() {
        return candyNum;
    }

    public static int getPickaxeNum() {
        return pickaxeNum;
    }

    public static int getCloudNum() {
        return cloudNum;
    }

    public static void setWitchHatNum(int witchHatNum) {
        StoreView.witchHatNum = witchHatNum;
    }

    public static void setIceFlameNum(int iceFlameNum) {
        StoreView.iceFlameNum = iceFlameNum;
    }

    public static void setCandyNum(int candyNum) {
        StoreView.candyNum = candyNum;
    }

    public static void setPickaxeNum(int pickaxeNum) {
        StoreView.pickaxeNum = pickaxeNum;
    }

    public static void setCloudNum(int cloudNum) {
        StoreView.cloudNum = cloudNum;
    }

    public StoreView(User1 user1){
        this.user1 = user1;
        stage = new Stage();
        pane = new AnchorPane();
        scene = new Scene(pane,800,500);
        scene.getStylesheets().addAll("/View/stylesheet.css");
        stage.setScene(scene);
        stage.setResizable(false);
        createBackground(new Image(getClass().getResourceAsStream("/View/Assets/InGameBackImage.jpg")));
        createCoinLabel();
        createButtons();
        buttonActions();
        stage.show();
    }

    /*Sets the background for the pane of the store*/
    public void createBackground(Image f) {
        BackgroundImage backImage = new BackgroundImage(f, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background back = new Background(backImage);
        pane.setBackground(back);
    }
    /*Creates all the buttons to place in the pane of the store,
     *including a back button and buttons for the five items that will be in the store
     *(witch hat, ice flame, candy, pickaxe, cloud)
     */
    public void createButtons(){
        backB = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/BackButtonImage.png"))));
        backB.setId("back-button");
        backB.setLayoutX(20);
        backB.setLayoutY(400);
        witchHat = new Button("Witch Hat",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/WitchHat.png"))));
        witchHat.setLayoutX(20);
        witchHat.setLayoutY(60);
        iceFlame = new Button("Ice Flame",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/IceFlame.png"))));
        iceFlame.setLayoutX(20);
        iceFlame.setLayoutY(180);
        candy = new Button("Candy",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Candy.png"))));
        candy.setLayoutX(400);
        candy.setLayoutY(300);
        pickaxe = new Button("Axe",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Axe.png"))));
        pickaxe.setLayoutX(400);
        pickaxe.setLayoutY(60);
        cloud = new Button("Cloud",new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Cloud.png"))));
        cloud.setLayoutX(400);
        cloud.setLayoutY(180);

        pane.getChildren().addAll(witchHat,iceFlame,pickaxe,candy,cloud,backB);
    }
    /*Sets the actions for the back button and for all the items in the store,
     *so that the scores and the number of coins owned are updated accordingly.
     *On hover over an item, the user can see the description for each item
     *and how many the own
     */
    public void buttonActions(){
        backB.setOnAction(event -> {
            StartView sv = new StartView();
            stage.close();
        });
        witchHat.setOnAction(event -> {
            if(user1.getCoins()-3>=0) {
                user1.removeCoin(3);
                coinsL.setText("Player 1 you have: " + user1.getCoins() + " coins");
                witchHatNum++;
            }
            else{
                createNotEnoughAlert();
            }

        });
        witchHat.setOnMouseEntered(event -> {
            witchHat.setText("Add 1 win to yourself and get a free coin\nCoins needed: 3 Coins\nYou currently own " + getWitchHatNum() + " item(s) of this type");
        });
        witchHat.setOnMouseExited(event -> {
            witchHat.setText("Witch Hat");
        });
        iceFlame.setOnAction(event -> {
            if(user1.getCoins()-12>=0) {
                user1.removeCoin(12);
                coinsL.setText("Player 1 you have: " + user1.getCoins() + " coins");
                iceFlameNum++;
            }
            else{
                createNotEnoughAlert();
            }

        });
        iceFlame.setOnMouseEntered(event -> {
            iceFlame.setText("Steal one point from your opponent\nCoins needed: 12 Coins\nYou currently own " + getIceFlameNum() + " item(s) of this type");
        });
        iceFlame.setOnMouseExited(event -> {
            iceFlame.setText("Ice Flame");
        });
        candy.setOnAction(event -> {
            if(user1.getCoins()-2>=0) {
                user1.removeCoin(2);
                coinsL.setText("Player 1 you have: " + user1.getCoins() + " coins");
                candyNum++;
            }
            else{
                createNotEnoughAlert();
            }

        });
        candy.setOnMouseEntered(event -> {
            candy.setText("Add 1 win to your opponent\nCoins needed: 2 Coins\nYou currently own " + getCandyNum() + " item(s) of this type");
        });
        candy.setOnMouseExited(event -> {
            candy.setText("Candy");
        });
        pickaxe.setOnAction(event -> {
            if(user1.getCoins()-5>=0) {
                user1.removeCoin(5);
                coinsL.setText("Player 1 you have: " + user1.getCoins() + " coins");
                pickaxeNum++;
            }
            else{
                createNotEnoughAlert();
            }

        });
        pickaxe.setOnMouseEntered(event -> {
            pickaxe.setText("Decrease your opponents win count by 1\nCoins needed: 5 Coins\nYou currently own " + getPickaxeNum() + " item(s) of this type");
        });
        pickaxe.setOnMouseExited(event -> {
            pickaxe.setText("Axe");
        });
        cloud.setOnAction(event -> {
            if(user1.getCoins()-15>=0) {
                user1.removeCoin(15);
                coinsL.setText("Player 1 you have: " + user1.getCoins() + " coins");
                cloudNum++;
            }
            else{
                createNotEnoughAlert();
            }

        });
        cloud.setOnMouseEntered(event -> {
            cloud.setText("Reset your opponents win count to 0\nCoins needed: 15 Coins\nYou currently own " + getCloudNum() + " item(s) of this type");
        });
        cloud.setOnMouseExited(event -> {
            cloud.setText("Cloud");
        });
    }

    /*Creates a label that will show the current number of coins owned by the user*/
    public void createCoinLabel(){
        coinsL = new Label("Player 1 you have: " + user1.getCoins() + " coins");
        coinsL.setLayoutX(270);
        coinsL.setLayoutY(10);
        pane.getChildren().addAll(coinsL);
    }
    /*On call, creates an alert that tells the user that they don't
     *have enough coins to buy the item in which they clicked
     */
    public void createNotEnoughAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE, "You don't have enough coins to buy this item");
        alert.getDialogPane().getStylesheets().add("/View/stylesheet.css");

        ButtonType alertButton1 = new ButtonType("Ok");
        alert.getButtonTypes().setAll(alertButton1);
        alert.showAndWait();

    }


}
