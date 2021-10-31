package ru.evant.tutorial_fx.less16_animation;

// RotateTransition - анимация вращения.

// https://www.youtube.com/watch?v=ghuRyzkz1wE&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=16

// Доп. материалы:
// http://ru.tmsoftstudio.com/javafx-api...

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationRotateTransitionTest2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        rectangle.setX(100);
        rectangle.setY(100);

        // обработчик клика мышки по прямоугольнику
        rectangle.setOnMouseClicked(event -> {
            RotateTransition rt = new RotateTransition(Duration.seconds(1), rectangle); // время вращения, объект вращения
            rt.setByAngle(180); // угол вращения
            rt.setCycleCount(2); // цикл количества вращений
            rt.setAutoReverse(true); // включить реверс вращения
            rt.play(); // запустить анимацию
        });

        root.getChildren().addAll(rectangle);
        Scene scene = new Scene(root, 300, 300);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}