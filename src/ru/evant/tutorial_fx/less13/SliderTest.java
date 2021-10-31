package ru.evant.tutorial_fx.less13;

// Slider - компонент слайдер

// https://www.youtube.com/watch?v=GuL3qzisn5U&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=13

// Дополнительные материалы:
// http://ru.tmsoftstudio.com/javafx-api...
//
// Небольшой редактор картинки, в котором сможем менять прозрачность, сепию и размер картинки.
// Так же рассмотрим компонент Slider.(слайдер).
// Показывается как используются некоторые компоненты в реальных приложениях.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class SliderTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10)); // отступ
        root.setAlignment(Pos.CENTER); // выравнивание по центру
        root.setVgap(10); // интервал между строками
        root.setHgap(70); // интервал между столбцами

        // Эффект сепии
        SepiaTone effectSepia = new SepiaTone(); // эффект сепии

        // Картинка
        Image image = new Image(new FileInputStream("assets/img1.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(580);
        imageView.setFitHeight(450);
        imageView.setEffect(effectSepia);
        GridPane.setConstraints(imageView,0,0);
        GridPane.setColumnSpan(imageView, 3); // объединить столбцы
        root.getChildren().add(imageView);

        /* Панель управления эффектами */
        // Названия эффектов
        Label opacityLabel = new Label("Opacity");
        Label sepiaLabel = new Label("Sepia");
        Label sizeLabel = new Label("Size");

        // слайдеры изменения значений эффектов
        Slider opacitySlider = new Slider(0, 1, 1);
        Slider sepiaSlider = new Slider(0, 1, 1);
        Slider sizeSlider = new Slider(0, 1, 1);

        // значения эффектов
        Label opacityValue = new Label(Double.toString(opacitySlider.getValue()));
        Label sepiaValue = new Label(Double.toString(sepiaSlider.getValue()));
        Label sizeValue = new Label(Double.toString(sizeSlider.getValue()));

        /* размещение в таблице(GridPane) на экране */
        GridPane.setConstraints(opacityLabel,0,1);
        GridPane.setConstraints(sepiaLabel,0,2);
        GridPane.setConstraints(sizeLabel,0,3);

        GridPane.setConstraints(opacitySlider,1,1);
        GridPane.setConstraints(sepiaSlider,1,2);
        GridPane.setConstraints(sizeSlider,1,3);

        GridPane.setConstraints(opacityValue,2,1);
        GridPane.setConstraints(sepiaValue,2,2);
        GridPane.setConstraints(sizeValue,2,3);

        /* обработчики событий слайдеров */
        opacitySlider.valueProperty().addListener((ov,oldVal,newVal) -> {
            imageView.setOpacity(newVal.doubleValue());
            opacityValue.setText(String.format("%.2f", newVal));
        });

        sepiaSlider.valueProperty().addListener((ov,oldVal,newVal) -> {
            effectSepia.setLevel(newVal.doubleValue());
            sepiaValue.setText(String.format("%.2f", newVal));
        });

        sizeSlider.valueProperty().addListener((ov,oldVal,newVal) -> {
            imageView.setScaleX(newVal.doubleValue());
            imageView.setScaleY(newVal.doubleValue());
            sizeValue.setText(String.format("%.2f", newVal));
        });

        /* добавить все элементы на строек на экран */
        root.getChildren().addAll(opacityLabel, opacitySlider, opacityValue);
        root.getChildren().addAll(sepiaLabel,sepiaSlider,sepiaValue);
        root.getChildren().addAll(sizeLabel,sizeSlider,sizeValue);

        Scene scene = new Scene(root, 600, 600);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}