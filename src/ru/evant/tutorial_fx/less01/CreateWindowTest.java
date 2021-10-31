package ru.evant.tutorial_fx.less01;

// Создать окно
// Установить в окно кнопку и прямоугольник
// Обработка нажатия кнопки: изменить цвет прямоугольника, вывести текст в консоль


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CreateWindowTest extends Application {

    // Все что тут будет написано - это наше приложение
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Окно");  // заголовок
        primaryStage.setWidth(300);     // ширина окна
        primaryStage.setHeight(300);    // высота окна

        Pane root = new Pane();     // Создать корневой узел(где будет всё находиться: кнопки, поля и т.д.)

        /* Кнопка - начало */
        Button btn = new Button();                  // Создать кнопку
        btn.setText("Нажми");                       // Установить кнопке текст
        btn.setTranslateX(110);                     // установить координату х для отрисовки кнопки
        btn.setTranslateY(200);                     // установить координату у для отрисовки кнопки
        btn.setPrefSize(70, 20);  // установить размер кнопки

        Rectangle rect = new Rectangle(50, 50); // Создать прямоугольник
        rect.setFill(Color.RED);                            // установить цвет - красный
        rect.setTranslateX(120);                     // установить координату х для отрисовки
        rect.setTranslateY(100);                     // установить координату у для отрисовки

        /* Нажатие кнопки - начало */
        btn.setOnAction(event -> {
            System.out.print("\nКнопка нажата");    // вывести в текст в консоль
            if (rect.getFill() == Color.RED) {
                rect.setFill(Color.YELLOW);           // установить цвет - синий
                System.out.print(" - сейчас квадрат желтый");
            } else if (rect.getFill() == Color.YELLOW){
                rect.setFill(Color.GREEN);
                System.out.print(" - сейчас квадрат зелёный");
            } else {
                rect.setFill(Color.RED);
                System.out.print(" - сейчас квадрат красный");
            }
        }); // Обработчик события - нажатия кнопки (Слушатель нажатия кнопки)
        /* Нажатие кнопки - конец */
        /* Кнопка - конец */


        Scene scene = new Scene(root); // Создать сцену, принимает корневой узел(где будет всё находиться: кнопки, поля и т.д.)

        root.getChildren().addAll(btn, rect); // Добавить объеккты(кнопка, прямоугольник)  на корневой узел root
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}
