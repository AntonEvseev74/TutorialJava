package ru.evant.tutorial_fx.less19_animation;

// FillTransition - анимация изменения цвета

// https://www.youtube.com/watch?v=c8EvUqCWQ_Y&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=19

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationFillTransitionTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        rectangle.setX(100);
        rectangle.setY(100);

        // Обработчик наведения курсора мыши на объект (setOnMouseEntered)
        rectangle.setOnMouseEntered(event -> {
            FillTransition ft = new FillTransition(Duration.seconds(1), rectangle);
            ft.setFromValue(Color.RED); // начальный цвет
            ft.setToValue(Color.GREEN); // конечный цвет

            // обработчик окончания анимации (что будет выполнено после анимации)
            ft.setOnFinished(event1 -> {
                System.out.println("Анимация закончена. Новый цвет установлен");
            });

            ft.play();
        });

        // обработчик снятия курсора мыши с объекта (setOnMouseExited)
        rectangle.setOnMouseExited(event -> {
            FillTransition ft = new FillTransition(Duration.seconds(1), rectangle);
            ft.setFromValue(Color.GREEN); // начальный цвет
            ft.setToValue(Color.RED); // конечный цвет

            // обработчик окончания анимации (что будет выполнено после анимации)
            ft.setOnFinished(event1 -> {
                System.out.println("Анимация закончена. Возвращен начальный цвет");
            });

            ft.play();
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