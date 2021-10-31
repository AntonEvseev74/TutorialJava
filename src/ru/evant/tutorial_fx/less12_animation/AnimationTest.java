package ru.evant.tutorial_fx.less12_animation;

// Animation - Анимация
// ListView - список

// https://www.youtube.com/watch?v=RDzSo4Po4go&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=12

// Как сделать анимацию в Java.
// Используем класс FadeTransition.
// Ещё метода данного класса:
// http://ru.tmsoftstudio.com/javafx-api...

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        ListView<Double> list = new ListView<>();
        ObservableList<Double> items = FXCollections.observableArrayList(
                0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0
        );

        list.setItems(items);
        list.setPrefSize(100, 70);

        Circle circle = new Circle(200,200,100, Color.RED);

        list.getSelectionModel().selectedItemProperty().addListener(
                (ov,oldValue,newValue) -> {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5),circle); // FadeTransition - отвечает вза прозрачность
                    if (oldValue == null){
                        ft.setFromValue(1); // установить начальное значение прозрачности
                    } else {
                        ft.setFromValue(oldValue.doubleValue());
                    }

                    ft.setToValue(newValue.doubleValue()); // установить конечное значение прозрачности, то которое мы выбрали
                    ft.play();
                }
        );

        root.getChildren().addAll(list, circle);
        Scene scene = new Scene(root, 400, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}
