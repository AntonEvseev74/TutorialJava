package ru.evant.tutorial_fx.less21_animation_sprite;

// Sprite - анимация спрайтом

// https://www.youtube.com/watch?v=T3MYVzCzaw0&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=21

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public class AnimationSpriteTest extends Application {

    private static final int COUNT = 3;
    private static final int COLUMNS = 3;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 32;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private static final int DIRECTION = 0; // 0 - к пользователю, 1- в лево, 2- в право, 3 - от пользователя

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image IMAGE = new Image(new FileInputStream("assets/sprites_knight.png"));
        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(400),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT,
                DIRECTION);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        primaryStage.setScene(new Scene(new Group(imageView), 100, 100));   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }

    private class SpriteAnimation extends Transition {

        private final ImageView imageView;  // картинка
        private final int count;            // количество кадров в анимации
        private final int columns;          // количество столбцов
        private final int offsetX;          // смещение по оси Х
        private final int offsetY;          // смещение по оси У
        private final int width;            // ширина кадра
        private final int height;           // высота кадра
        private final int direction;        // в данном случае направление движения (от 0 до 3 (четыре строки с картинками: 0,1,2,3))

        public SpriteAnimation(
                ImageView imageView,
                Duration duration,
                int count, int columns,
                int offsetX, int offsetY,
                int width, int height,
                int direction) {
            this.imageView = imageView;
            this.count = count;
            this.columns = columns;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.width = width;
            this.height = height;
            this.direction = direction;
            setCycleDuration(duration);
        }

        // метод вызывается в каждом кадре анимации пока она действует
        // он определяет поведение анимации
        // входящий параметр может принимать значение от 0(начало анимации) до 1(конец анимации)
        @Override
        protected void interpolate(double condition) {
            final int index = Math.min((int) Math.floor(condition * count), count - 1); // индекс картинки в спрайте
            final int x = (index % columns) * width + offsetX;  // координата отрисовки Х
            final int y = (index / columns) * height + offsetY * direction;  // координата отрисовки У
            imageView.setViewport(new Rectangle2D(x, y, width, height)); // нарисовать картинку из спрайта
        }
    }
}

