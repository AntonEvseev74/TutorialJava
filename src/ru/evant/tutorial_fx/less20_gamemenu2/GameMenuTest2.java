package ru.evant.tutorial_fx.less20_gamemenu2;

// Game Menu - меню игры
// мини приложение

// Небольшой рефакторинг
// Попытка подогнать под ООП

// https://www.youtube.com/watch?v=Czv7Ggu1JBg&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=20

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.evant.tutorial_fx.less20_gamemenu2.image.BackgroundImage;
import ru.evant.tutorial_fx.less20_gamemenu2.menu.MenuBox;
import ru.evant.tutorial_fx.less20_gamemenu2.menu.MenuItem;
import ru.evant.tutorial_fx.less20_gamemenu2.menu.SubMenu;
import ru.evant.tutorial_fx.less20_gamemenu2.scene.CreateScene;

public class GameMenuTest2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        // Картинка. Задний фон.
        BackgroundImage bg = new BackgroundImage("assets/img1.jpg");
        root.getChildren().addAll(bg);

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

        CreateScene scene = new CreateScene(root, 900,600, menuBox); // Создать сцену

        // Настройки главного окна
        primaryStage.setTitle("Пауза");
        primaryStage.setScene(scene.get());   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}

