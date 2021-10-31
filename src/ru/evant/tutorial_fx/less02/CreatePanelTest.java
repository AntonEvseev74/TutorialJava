package ru.evant.tutorial_fx.less02;

// Создание Панелей и управление Панелями
// BorderPane - панель с отступами с четырех сторон (верх, низ, лево, право)
// HBox - горизонтальная панель
// VBox - вертикальная панель


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreatePanelTest extends Application {

    // Все что тут будет написано - это наше приложение
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane(); // Создать главную панель
        HBox hBox = new HBox(10); // Создать горизонтальную панель (10(пикселей) - отступы между элементами)
        VBox vBox = new VBox(10); // Создать вертикальную панель (10(пикселей) - отступы между элементами)
        hBox.setAlignment(Pos.CENTER); // выровнять по центру

        Button btn1 = addButton("1");
        Button btn2 = addButton("2");
        Button btn3 = addButton("3");
        Button btn4 = addButton("4");
        Button btn5 = addButton("5");
        Button btn6 = addButton("6");

        vBox.getChildren().addAll(btn1, btn2, btn3); // установить 6 кнопок на vBox
        hBox.getChildren().addAll(btn4, btn5, btn6); // установить 6 кнопок на hBox

        root.setTop(hBox); // установить на главную панель на верх - горизонтальную панель
        root.setLeft(vBox); // установить на главную панель слева - вертикальную панель

        Scene scene = new Scene(root, 300, 250); // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Создать кнопку
    private Button addButton(String name) {
        Button btn = new Button(name);
        btn.setPrefSize(70, 20);
        return btn;
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}
