package ru.evant.tutorial_fx.less05;

// Переключатель - RadioButton
// Кнопки типа - вкл/выкл

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateRadioButtonTest1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);

        RadioButton rb1 = new RadioButton("1");
        RadioButton rb2 = new RadioButton("2");
        RadioButton rb3 = new RadioButton("3");

        buttons.getChildren().addAll(rb1, rb2, rb3);
        root.setTop(buttons);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
