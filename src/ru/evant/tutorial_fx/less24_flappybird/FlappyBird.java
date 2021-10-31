package ru.evant.tutorial_fx.less24_flappybird;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends Application {

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public static ArrayList<Wall> walls = new ArrayList<>();
    Bird bird = new Bird();
    public static int score = 0;
    public Label scoreLabel = new Label("Score : " + score);

    public Pane createContent() {
        gameRoot.setPrefSize(600, 600);

        for (int i = 0; i < 100; i++) {
            int enter = (int) (Math.random() * 100 + 50); // 50 - 150
            int height = new Random().nextInt(600 - enter);
            Wall wall = new Wall(height);
            wall.setTranslateX(i * 350 + 600);
            wall.setTranslateY(0);
            walls.add(wall);

            Wall wall2 = new Wall(600 - enter - height);
            wall2.setTranslateX(i * 350 + 600);
            wall2.setTranslateY(height + enter);
            walls.add(wall2);

            gameRoot.getChildren().addAll(wall, wall2);
        }

        gameRoot.getChildren().add(bird);
        appRoot.getChildren().addAll(gameRoot, scoreLabel);
        return appRoot;
    }

    public void update() {
        // граыитация
        if (bird.velocity.getY() < 5) bird.velocity = bird.velocity.add(0, 1);

        // движение птички
        bird.moveX((int) bird.velocity.getX());
        bird.moveY((int) bird.velocity.getY());
        scoreLabel.setText("Score : " + score);

        // смещение экрана
        bird.translateXProperty().addListener((ov,oldValue,newValue) -> {
            int offset = newValue.intValue();
            if (offset>200) gameRoot.setLayoutX(-(offset-200));
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());  // Создать сцену
        scene.setOnMouseClicked(event -> bird.jump());

        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}