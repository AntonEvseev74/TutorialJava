package ru.evant.tutorial_fx.less20_gamemenu2.menu;

// Класс блок подменю
// Содержит блок подменю со своими пунктами меню

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuBox extends Pane {
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
