package ru.evant.tutorial_fx.less10;

// ScrollBar - полоса прокрутки

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CreateScrollBar extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        ScrollBar scrollX = new ScrollBar();
        scrollX.setMin(0);
        scrollX.setMax(260);
        scrollX.setValue(100);
        scrollX.setTranslateX(20);

        ScrollBar scrollY = new ScrollBar();
        scrollY.setMin(0);
        scrollY.setMax(260);
        scrollY.setValue(100);
        scrollY.setOrientation(Orientation.VERTICAL);
        scrollY.setTranslateY(20);

        ScrollBar scrollOpacity = new ScrollBar();
        scrollOpacity.setMin(0);
        scrollOpacity.setMax(10);
        scrollOpacity.setValue(10);
        scrollOpacity.setTranslateX(120);

        Rectangle rect = new Rectangle(100, 100, Color.RED);
        rect.setTranslateX(20);
        rect.setTranslateY(20);

        // Обработчик событий scrollX
        scrollX.valueProperty().addListener(event -> {
            rect.setTranslateX(20 + scrollX.getValue());
        });

        scrollY.valueProperty().addListener(event -> {
            rect.setTranslateY(20 + scrollY.getValue());
        });

        scrollOpacity.valueProperty().addListener(event -> {
            rect.setOpacity(scrollOpacity.getValue() / 10);
        });

        root.getChildren().addAll(scrollX, scrollY, scrollOpacity, rect);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}