package ru.evant.tutorial_fx.less09;

// PasswordField - Поле для пароля

// https://www.youtube.com/watch?v=5ym4zr5Dexk&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=9

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreatePasswordField extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();

        PasswordField pass = new PasswordField();
        pass.setPromptText("Введите пароль");
        GridPane.setConstraints(pass,0,0);

        Label label = new Label();
        GridPane.setConstraints(label,0,1);

        Button btn = new Button("Печать в консоль");
        GridPane.setConstraints(btn,1,0);

        // Обработчик нажатия кнопки
        btn.setOnAction(event -> {
            System.out.println(pass.getText());
        });

        // Обработчик нажатия клавиши Enter в поле PasswordField
        pass.setOnAction(event -> {
            if (!pass.getText().equals("123456")){
                label.setText("Пароль не правильный");
                label.setTextFill(Color.RED);
            } else {
                label.setText("Пароль правильный");
                label.setTextFill(Color.GREEN);
            }

            pass.clear();
        });

        root.getChildren().addAll(pass, label, btn);
        Scene scene = new Scene(root, 600, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}
