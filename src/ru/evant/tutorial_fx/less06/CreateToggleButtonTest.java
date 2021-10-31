package ru.evant.tutorial_fx.less06;

// ToggleButton
// https://www.youtube.com/watch?v=uzOGRRItAaU&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=6

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CreateToggleButtonTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);

        ToggleGroup group = new ToggleGroup(); // Создать группу для ToggleButton

        ToggleButton tb1 = new ToggleButton("Red");
        ToggleButton tb2 = new ToggleButton("Yellow");
        ToggleButton tb3 = new ToggleButton("Green");

        tb1.setToggleGroup(group); // Установить кнопку в группу
        tb2.setToggleGroup(group); // Установить кнопку в группу
        tb3.setToggleGroup(group); // Установить кнопку в группу

        tb1.setUserData(Color.RED); // Свойства перключателя
        tb2.setUserData(Color.YELLOW); // Свойства перключателя
        tb3.setUserData(Color.GREEN); // Свойства перключателя

        Circle circle = new Circle(100);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.DARKGOLDENROD); // Обвести контур фигуры (круга)
        circle.setStrokeWidth(2); // ширина контура

        Rectangle rectLeft = new Rectangle(100, 100);
        rectLeft.setFill(Color.WHITE);
        rectLeft.setStroke(Color.DARKGOLDENROD); // Обвести контур фигуры (круга)
        rectLeft.setStrokeWidth(2); // ширина контура
        rectLeft.setArcWidth(50); // закруглить края прямоугольника
        rectLeft.setArcHeight(50); // закруглить края прямоугольника

        Rectangle rectRight = new Rectangle(100, 100);
        rectRight.setFill(Color.WHITE);
        rectRight.setStroke(Color.DARKGOLDENROD); // Обвести контур фигуры (круга)
        rectRight.setStrokeWidth(2); // ширина контура
        rectRight.setArcWidth(50); // закруглить края прямоугольника
        rectRight.setArcHeight(50); // закруглить края прямоугольника

        // Обработчик событий нажатия на кнопки
        group.selectedToggleProperty().addListener(event ->{
            if(group.getSelectedToggle() != null){
                circle.setFill((Color)group.getSelectedToggle().getUserData());
                rectLeft.setFill((Color)group.getSelectedToggle().getUserData());
                rectRight.setFill((Color)group.getSelectedToggle().getUserData());
            } else {
                circle.setFill(Color.WHITE);
                rectLeft.setFill(Color.WHITE);
                rectRight.setFill(Color.WHITE);
            }
        });

        // Установить стиль кнопок
        tb1.setStyle("-fx-base: red");
        tb2.setStyle("-fx-base: yellow");
        tb3.setStyle("-fx-base: green");

        tb3.setSelected(true); // кнопка которая активна при запуске

        buttons.getChildren().addAll(tb1, tb2, tb3);
        root.setTop(buttons);
        root.setCenter(circle);
        root.setLeft(rectLeft);
        root.setRight(rectRight);
        Scene scene = new Scene(root, 600, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
