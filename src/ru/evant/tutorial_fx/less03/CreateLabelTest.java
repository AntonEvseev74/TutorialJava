package ru.evant.tutorial_fx.less03;

// Метка - LABEL

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class CreateLabelTest extends Application {

    // Все что тут будет написано - это наше приложение
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        Label label = new Label(); // Создать метку
        label.setText("Это метка"); // Установить текст

        Image image = new Image(new FileInputStream("assets/img1.jpg")); // Создать картинку
        ImageView img = new ImageView(image); // Создать контейнер для каринки и поместить в него картинку
        img.setFitHeight(200); // установить высоту контейнера
        img.setFitWidth(250); // установить ширину контейнера

        Label labelImg = new Label();   // Создать метку
        labelImg.setGraphic(img);       // Установить в метку контейнер с картинкой
        labelImg.setTranslateX(75);     // Установить координату х
        labelImg.setTranslateY(100);    // Установить координату у

        labelImg.setText("Текст к картинке"); // установить текст
        labelImg.setGraphicTextGap(20); // Установить отступ текста от картинки
        labelImg.setContentDisplay(ContentDisplay.TOP); // Установить расположение картинки относительно текста


        // мека которая реагирует на курсор
        Label cursorMouseLabel = new Label();
        cursorMouseLabel.setText("Наведи КУРСОР");
        cursorMouseLabel.setTranslateX(160);
        cursorMouseLabel.setTranslateY(350);
        // Обработчик события наведения курсора мыши на метку
        cursorMouseLabel.setOnMouseEntered(event -> {
            cursorMouseLabel.setScaleX(1.5); // увеличить текст в 1.5 раза
            cursorMouseLabel.setScaleY(1.5); // увеличить текст в 1.5 раза
            cursorMouseLabel.setTextFill(Color.GREEN); // Изменить цвет текста
        });
        // Обработчик события ухода курсора мыши с метки
        cursorMouseLabel.setOnMouseExited(event -> {
            cursorMouseLabel.setScaleX(1); // увеличить текст в 1.5 раза
            cursorMouseLabel.setScaleY(1); // увеличить текст в 1.5 раза
            cursorMouseLabel.setTextFill(Color.BLACK); // Изменить цвет текста
        });


        root.getChildren().addAll(label, labelImg, cursorMouseLabel);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
