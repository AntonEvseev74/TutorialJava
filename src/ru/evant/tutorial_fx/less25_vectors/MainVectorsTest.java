package ru.evant.tutorial_fx.less25_vectors;


// На основе векторов строится большая часть физики игры.
// В этом уроке мы будем подробнее знакомиться с ними, а в частности как повернуть объект, как его двигать по вектору.
//
// https://www.youtube.com/watch?v=BDyb2G8l7qU&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=25
//
//Доп. литература
//Линейная алгебра для разработчика игр:
//http://habrahabr.ru/post/131931/
//(Довольно интересная статья, много чего узнаете или вспомните:) )
//http://ru.tmsoftstudio.com/javafx-api...
//http://ru.tmsoftstudio.com/javafx-api...

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainVectorsTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400);  // Создать сцену

        Bullet bullet = new Bullet();
        root.getChildren().add(bullet);

        scene.setOnMouseMoved(event -> {
            bullet.setTarget(event.getSceneX(), event.getSceneY());
        });

        scene.setOnMouseClicked(event -> {
            bullet.velocity = new Point2D(0, 0);
        });

        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bullet.move();
            }
        };
        timer.start();
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}