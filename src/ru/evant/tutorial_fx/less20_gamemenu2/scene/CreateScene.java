package ru.evant.tutorial_fx.less20_gamemenu2.scene;


import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import ru.evant.tutorial_fx.less20_gamemenu2.menu.MenuBox;

public class CreateScene extends Pane {
    Scene scene;

    public CreateScene(Pane root, int width, int height, MenuBox menuBox){
        // Создать сцену
        scene = new Scene(root, width, height);  // Создать сцену
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
    }

    public Scene get(){
        return scene;
    }
}
