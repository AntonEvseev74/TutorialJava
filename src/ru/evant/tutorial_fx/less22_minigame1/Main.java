package ru.evant.tutorial_fx.less22_minigame1;

// Мини игра
// Пользователь управляет персонажем и собирает квадраты

// https://www.youtube.com/watch?v=-3bay3Fq0C0&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=22

//Простая мини игра:)
//код: https://github.com/Kawun/tutorials

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static ArrayList<Rectangle> bonuses = new ArrayList<>();

    Image image;
    {
        try {
            image = new Image(new FileInputStream("assets/1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ImageView imageView = new ImageView(image);
    Character player = new Character(imageView);
    static Pane root = new Pane();

    public void bonus(){
        int random = (int)Math.floor(Math.random()*100);
        int x = (int)Math.floor(Math.random()*(SCREEN_WIDTH - 20));
        int y = (int)Math.floor(Math.random()*(SCREEN_HEIGHT - 20));
        if(random == 5){
            Rectangle rect = new Rectangle(20,20,Color.RED);
            rect.setX(x);
            rect.setY(y);
            bonuses.add(rect);
            root.getChildren().addAll(rect);
        }
    }
    public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(96);
            player.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(64);
            player.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(32);
            player.moveX(-2);
        }
        else{
            player.animation.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        root.setPrefSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        root.getChildren().addAll(player);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event->keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event-> {
            keys.put(event.getCode(), false);
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                bonus();
            }
        };
        timer.start();
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }


}
