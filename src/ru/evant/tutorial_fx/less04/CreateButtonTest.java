package ru.evant.tutorial_fx.less04;

// Кнопка - BUTTON
// как работать с кнопкой
// как установить на неё действие
// как установить эффект.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class CreateButtonTest extends Application {

    // Все что тут будет написано - это наше приложение
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        // Кнопка 1
        Button btn1 = new Button("Кнопка 1");
        btn1.setTranslateX(10);
        btn1.setTranslateY(10);

        // Кнопка 2
        Button btn2 = new Button();
        btn2.setTranslateX(10);
        btn2.setTranslateY(50);
        Image image = new Image(new FileInputStream("assets/img2.jpg"));
        ImageView img = new ImageView(image);
        img.setFitWidth(40);
        img.setFitHeight(40);
        btn2.setGraphic(img);

        // Кнопка 3
        Button btn3 = new Button();
        btn3.setTranslateX(10);
        btn3.setTranslateY(120);
        Image image2 = new Image(new FileInputStream("assets/img2.jpg"));
        ImageView img2 = new ImageView(image2);
        img2.setFitWidth(40);
        img2.setFitHeight(40);
        btn3.setGraphic(img2);
        btn3.setStyle("-fx-base:#b6e7c9"); // Установить цвет кнопки

        // тень для кнопки 3
        DropShadow shadow = new DropShadow(); // Создать Эффект тень
        shadow.setColor(Color.GREEN); // Установить цвет тени
        shadow.setRadius(40); // Установить радиус
        btn3.setOnAction(event -> {
            btn3.setEffect(shadow); // По нажатию на кнопку установить Эффект тень
        });


        root.getChildren().addAll(btn1, btn2, btn3);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
