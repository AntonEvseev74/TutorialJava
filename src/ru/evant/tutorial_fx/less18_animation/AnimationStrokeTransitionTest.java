package ru.evant.tutorial_fx.less18_animation;

// StrokeTransition - смена цвета контура объекта.

// https://www.youtube.com/watch?v=bmVY4LAXzHo&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=18

import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationStrokeTransitionTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Rectangle rect = new Rectangle(100,100, Color.RED);
        rect.setX(100);
        rect.setY(100);
        rect.setStroke(Color.BLUE); // Обвести контур
        rect.setStrokeWidth(6); // Толщина линии обводки контура

        // Обработчик зажатия кнопки мыши на объекте (setOnMousePressed)
        rect.setOnMousePressed(event -> {
            StrokeTransition st = new StrokeTransition(Duration.seconds(1), rect);
            st.setFromValue(Color.BLUE); // для какого цвета
            st.setToValue(Color.BLACK); // к какому цвету привести
            st.play();
        });

        // Обработчик отжатия кнопки мыши на объекте (setOnMousePressed)
        rect.setOnMouseReleased(event -> {
            StrokeTransition st = new StrokeTransition(Duration.seconds(1), rect);
            st.setFromValue(Color.BLACK); // для какого цвета
            st.setToValue(Color.BLUE); // к какому цвету привести
            st.play();
        });

        root.getChildren().addAll(rect);
        Scene scene = new Scene(root, 300, 300);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}