package ru.evant.tutorial_fx.less05;

// Переключатель - RadioButton
// Кнопки типа - вкл/выкл
// Включена может быть только одна
// Показать картинку по включеной кнопке

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateRadioButtonTest3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);

        HBox pic = new HBox(10);
        pic.setAlignment(Pos.CENTER);

        ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("1");
        RadioButton rb2 = new RadioButton("2");
        RadioButton rb3 = new RadioButton("3");

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        rb1.setUserData("1");
        rb2.setUserData("2");
        rb3.setUserData("3");

        ImageView img = new ImageView();
        group.selectedToggleProperty().addListener(event ->{
            Image image = new Image(getClass().getResourceAsStream(group.getSelectedToggle().getUserData() + ".png"));
            img.setImage(image);
            img.setFitWidth(300);
            img.setFitHeight(300);
        });

        rb1.setSelected(true);

        buttons.getChildren().addAll(rb1, rb2, rb3);
        pic.getChildren().addAll(img);
        root.setTop(buttons);
        root.setCenter(pic);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
