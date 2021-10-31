package ru.evant.tutorial_fx.less17_animation;

// ScaleTransition - анимация изменения размера

// https://www.youtube.com/watch?v=n8gqEmLhkF4&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=17

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationScaleTransitionTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Rectangle rectangle = new Rectangle(100,100, Color.RED);
        rectangle.setX(100);
        rectangle.setY(100);

        // обработчик наведения курсора мыши на объект (setOnMouseEntered)
        rectangle.setOnMouseEntered(event -> {
            ScaleTransition st = new ScaleTransition(Duration.seconds(1), rectangle);
            st.setToX(2); // масштабируемост, увеличить размер по иксу в 2 раза(увеличить длину в 2 раза)
            st.setToY(2); // масштабируемост, увеличить размер по игрику в 2 раза(увеличить высоту в 2 раза)
            st.play();
        });

        // обработчик снятия наведения курсора мыши на объект (setOnMouseExited)
        rectangle.setOnMouseExited(event -> {
            ScaleTransition st = new ScaleTransition(Duration.seconds(1), rectangle);
            st.setFromX(2); // значение с какого масштаба начинаем работать
            st.setFromY(2); // значение с какого масштаба начинаем работать
            st.setToX(1); // значение к какому масштабу привести объект
            st.setToY(1); // значение к какому масштабу привести объект
            st.play();
        });

        root.getChildren().addAll(rectangle);
        Scene scene = new Scene(root, 300, 300);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}