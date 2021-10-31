package ru.evant.tutorial_fx.less15;

// ProgressBar - панель прогресса
// ProgressIndicator - индикатор прогресса.

// https://www.youtube.com/watch?v=etBBNafAqfI&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=15

// Доп. материал на русском языке:
// http://ru.tmsoftstudio.com/file/page/...

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProgressBarAndProgressIndicatorTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);

        // Всплывающие подсказки
        Tooltip ttProgressBar = new Tooltip("Это ProgressBar");
        Tooltip ttProgressIndicator = new Tooltip("Это ProgressIndicator");
        Tooltip ttSlider = new Tooltip("Это Slider");

        // ProgressBar и ProgressIndicator - Могут иметь всего два значения состояния 0 или 1.
        // 0 - не загружено(не выполнено)
        // 1 - загружено(выполнено)
        ProgressBar progressBar = new ProgressBar(0); // Создать прогресс панель с состоянием не загружено
        progressBar.setTooltip(ttProgressBar);
        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressIndicator.setTooltip(ttProgressIndicator);

        // Создадим слайдер для изменения значения для ProgressBar и ProgressIndicator
        Slider slider = new Slider(0, 50, 0);
        slider.setTooltip(ttSlider);

        GridPane.setConstraints(slider,0,0);
        GridPane.setConstraints(progressBar,1,0);
        GridPane.setConstraints(progressIndicator,2,0);

        // обработчик событий для slider
        slider.valueProperty().addListener((ov,oldValue,newValue) -> {
            progressBar.setProgress(newValue.doubleValue()/50);
            progressIndicator.setProgress(newValue.doubleValue()/50);
            // делим на 50, потому что максимальное значение slider = 50, а максимальное значение для ProgressBar = 1
        });

        root.getChildren().addAll(slider,progressBar,progressIndicator);
        Scene scene = new Scene(root, 300, 100);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
