package ru.evant.tutorial_fx.less26_modal_window;

// Моальное окно

// https://www.youtube.com/watch?v=4XZR8Vgd_oU&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=26

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ModalWindowTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Button button = new Button("Новое окно");
        button.setOnAction(event -> {
            ModalWindow.newWindow("Модальное окно");
        });

        root.getChildren().add(button);
        Scene scene = new Scene(root, 600, 600);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.setTitle("Основное окно");
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}