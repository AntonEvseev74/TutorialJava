package ru.evant.tutorial_fx.less20_gamemenu2.menu;

// Класс для хранения пунктов меню (блок пунктов меню в виде списка)

import javafx.scene.layout.VBox;

public class SubMenu extends VBox {
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
