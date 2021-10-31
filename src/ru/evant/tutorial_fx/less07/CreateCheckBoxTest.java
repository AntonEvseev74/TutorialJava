package ru.evant.tutorial_fx.less07;

// Флаг - CheckBox
// https://www.youtube.com/watch?v=Zg09mDW0XHw&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=7

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CreateCheckBoxTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        VBox buttons = new VBox(10);
        HBox rects = new HBox();

        // флажки
        CheckBox[] checkBoxes = new CheckBox[]{
          new CheckBox("Red"),
          new CheckBox("Yellow"),
          new CheckBox("Green")
        };

        // прямоугольники
        Rectangle[] rectangles = new Rectangle[]{
          new Rectangle(100, 100, Color.RED),
          new Rectangle(100, 100, Color.YELLOW),
          new Rectangle(100, 100, Color.GREEN)
        };

        for (int i = 0; i < 3; i++) {
            CheckBox cb = checkBoxes[i];
            Rectangle rect = rectangles[i];
            buttons.getChildren().addAll(cb);
            cb.selectedProperty().addListener(event->{
                if (cb.isSelected()){
                    rects.getChildren().add(rect);
                } else {
                    rects.getChildren().remove(rect);
                }
            });
        }

        root.setCenter(rects);
        root.setLeft(buttons);
        Scene scene = new Scene(root, 600, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
