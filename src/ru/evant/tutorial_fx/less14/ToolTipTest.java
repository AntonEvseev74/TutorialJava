package ru.evant.tutorial_fx.less14;

// ToolTip - всплывающая подсказка

// https://www.youtube.com/watch?v=SDIPK-0i-0E&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=14

// Всплывающая подсказка. Установка действия на кнопку(button).
// Ссылки:
// http://ru.tmsoftstudio.com/file/page/...
// http://ru.tmsoftstudio.com/javafx-api...

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ToolTipTest extends Application {
    Integer count = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Tooltip tooltipButton = new Tooltip("Это кнопка"); // Создать всплывающую подсказку
        Tooltip tooltipLabel = new Tooltip("Это счетчик"); // Создать всплывающую подсказку

        Button button = new Button("Нажми меня"); // Создать кнопку
        button.setTooltip(tooltipButton); // Установить на кнопку всплывающую подсказку

        Label label = new Label(count.toString());
        label.setTranslateX(100);
        label.setTranslateY(5);
        label.setTooltip(tooltipLabel); // Установить всплывающую подсказку

        button.setOnAction(event -> {
            count++;
            label.setText(count.toString());
        });

        root.getChildren().addAll(button, label);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}