package ru.evant.tutorial_fx.less11;

// ChoiceBox - кнопка со списком значений

// https://www.youtube.com/watch?v=HLo6SHVGhH0&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=11

// Литература:
//         Шилдт 2015 год. (Полное руководство)
//         Глава 14 - обобщённые классы.
//         Глава 15 - Лямбда-выражения(lambda expressions)
//         Так же в конце книги есть несколько глав по JavaFX.
//
//         Ссылки:
//         ChoiceBox - http://ru.tmsoftstudio.com/javafx-api...
//         ObservableValue - http://ru.tmsoftstudio.com/javafx-api...
//         ChangeListener - http://ru.tmsoftstudio.com/javafx-api...

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CreateChoiceBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        ChoiceBox choiceBox = new ChoiceBox(); // Создать кнопку
        // Создать всплывающие список кнопки
        choiceBox.setItems(FXCollections.observableArrayList(
                "Red", "Yellow", "Green"
        ));
        Color[] colors = new Color[]{
                Color.RED, Color.YELLOW, Color.GREEN
        };

        Circle circle = new Circle(200, 200, 100, Color.WHITE);

        // слушатель кнопки. реализация выбранного элемента
        /* ВАРИАНТ 1 - АНОНИМНЫЙ КЛАСС
         *  choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
         *    @Override
         *    public void changed(ObservableValue observable, Number oldValue, Number newValue) {
         *        // Реализация метода
         *    }
         *  });
         *
         * ВАРИАНТ 2 - ЛЯМБДА ВЫРАЖЕНИЕ
         * choiceBox.getSelectionModel().selectedIndexProperty().addListener(
         *        (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
         *        // Реализация метода
         *        }
         * );
         */

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    circle.setFill(colors[newValue.intValue()]);
                }
        );

        root.getChildren().addAll(choiceBox, circle);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}
