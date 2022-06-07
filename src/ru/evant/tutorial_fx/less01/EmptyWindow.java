package ru.evant.tutorial_fx.less01;

// пустое окно

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EmptyWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();


        Scene scene = new Scene(root, 600, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
        while (true){
            break;
        }
    }
}
