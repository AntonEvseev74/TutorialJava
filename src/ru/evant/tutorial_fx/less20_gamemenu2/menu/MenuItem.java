package ru.evant.tutorial_fx.less20_gamemenu2.menu;

// Класс для создания пунктов меню
// Пункт меню содержит: фон, текст, анимацию фона при наведении и снятии наведения курсора мыши

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MenuItem extends StackPane {
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
