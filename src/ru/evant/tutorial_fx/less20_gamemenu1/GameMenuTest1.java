package ru.evant.tutorial_fx.less20_gamemenu1;

// Game Menu - меню игры
// мини приложение

// https://www.youtube.com/watch?v=Czv7Ggu1JBg&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=20

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public class GameMenuTest1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        // Картинка. Задний фон.
        Image image = new Image(new FileInputStream("assets/img1.jpg"));
        ImageView img = new ImageView(image);
        img.setFitWidth(900);
        img.setFitHeight(600);
        root.getChildren().add(img);

        // Создаем главное меню
        MenuItem newGame = new MenuItem("НОВАЯ ИГРА");
        MenuItem options = new MenuItem("НАСТРОЙКИ");
        MenuItem exitGame = new MenuItem("ВЫХОД");
        SubMenu mainMenu = new SubMenu(newGame, options, exitGame);

        // Создаем меню настройки
        MenuItem sound = new MenuItem("ЗВУК");
        MenuItem video = new MenuItem("ВИДЕО");
        MenuItem keys = new MenuItem("УПРАВЛЕНИЕ");
        MenuItem optionBack = new MenuItem("НАЗАД");
        SubMenu optionsMenu = new SubMenu(sound, video, keys, optionBack);

        // Создаем меню новой игры
        MenuItem NG1 = new MenuItem("ТУРНИР");
        MenuItem NG2 = new MenuItem("ОДИН ЗАЕЗД");
        MenuItem NG3 = new MenuItem("2 ИГРОКА");
        MenuItem NG4 = new MenuItem("НАЗАД");
        SubMenu newGameMenu = new SubMenu(NG1, NG2, NG3, NG4);

        MenuBox menuBox = new MenuBox(mainMenu);
        newGame.setOnMouseClicked(event -> menuBox.setSubMenu(newGameMenu));
        options.setOnMouseClicked(event -> menuBox.setSubMenu(optionsMenu));
        exitGame.setOnMouseClicked(event -> System.exit(0));
        optionBack.setOnMouseClicked(event -> menuBox.setSubMenu(mainMenu));
        NG4.setOnMouseClicked(event -> menuBox.setSubMenu(mainMenu));
        root.getChildren().addAll(menuBox);

        // Создать сцену
        Scene scene = new Scene(root, 900, 600);  // Создать сцену
        // обработчик нажатия кнопки Escape
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE){
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
                if (!menuBox.isVisible()){
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                } else {
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(event1 -> menuBox.setVisible(false));
                    ft.play();
                }
            }
        });

        // Настройки главного окна
        primaryStage.setTitle("Пауза");
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Класс для создания пунктов меню
    // Пункт меню содержит: фон, текст, анимацию фона при наведении и снятии наведения курсора мыши
    private static class MenuItem extends StackPane {
        public MenuItem(String name) {

            // Рамка для пункта меню
            Rectangle bg = new Rectangle(200, 20, Color.WHITE);
            bg.setOpacity(0.5); // прозрачность

            // Текст пункта меню
            Text text = new Text(name);
            text.setFill(Color.WHITE); // цвет текста
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14)); // шрифт текста

            setAlignment(Pos.CENTER); // выравнивание по центру
            getChildren().addAll(bg, text);

            // Анимация смены цвета фона пункта меню
            FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
            // при наведении курсора мыши
            setOnMouseEntered(event -> {
                st.setFromValue(Color.DARKGRAY); // от серого
                st.setToValue(Color.DARKGOLDENROD); // к золотому
                st.setCycleCount(Animation.INDEFINITE); // цикл, бесконечно
                st.setAutoReverse(true); // автореверс анимации
                st.play();
            });
            // при снятии наведения курсора мыши
            setOnMouseExited(event -> {
                st.stop();
                bg.setFill(Color.WHITE); // установить цвет фона пункта - белый
            });
        }
    }

    // Класс для хранения пунктов меню (блок пунктов меню в виде списка)
    private static class SubMenu extends VBox {
        public SubMenu(MenuItem... items) { // в качестве параметров принимает пункты меню
            setSpacing(15); // отступы между пунктами меню

            // координаты начала отрисовки блока меню
            setTranslateX(100);
            setTranslateY(50);

            // Добавить на экран пункты меню
            for (MenuItem item : items) {
                getChildren().addAll(item);
            }
        }
    }

    // Класс блок подменю
    // Содержит блок подменю со своими пунктами меню
    private static class MenuBox extends Pane {
        static SubMenu subMenu;

        public MenuBox(SubMenu subMenu) {
            MenuBox.subMenu = subMenu;

            setVisible(false);

            Rectangle bg = new Rectangle(900, 600, Color.LIGHTBLUE);
            bg.setOpacity(0.4);
            getChildren().addAll(bg, subMenu);
        }

        // Показать другое меню, подменю
        public void setSubMenu(SubMenu subMenu) {
            getChildren().remove(MenuBox.subMenu); // удалить предыдущее меню
            MenuBox.subMenu = subMenu; // получить новое меню
            getChildren().add(subMenu); // добавить на экран новое меню
        }
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}

