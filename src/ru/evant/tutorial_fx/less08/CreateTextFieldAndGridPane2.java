package ru.evant.tutorial_fx.less08;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateTextFieldAndGridPane2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane(); // создать контейнер - таблица
        root.setPadding(new Insets(10,10,10,10)); // отступы
        root.setHgap(5); // горизонтальные отступы между строками
        root.setVgap(5); // вертикальные отступы между столбцами

        TextField name = new TextField(); // Создать текстовое поле
        name.setPromptText("Ваше имя"); // Текст подсказка
        GridPane.setConstraints(name,0,0); // установить позицию текстового поля в таблице
        root.getChildren().add(name); // добавить текстово поле в таблицу

        TextField lastName = new TextField(); // Создать текстовое поле
        lastName.setPromptText("Ваша фамилия"); // Текст подсказка
        GridPane.setConstraints(lastName,0,1); // установить позицию текстового поля в таблице
        root.getChildren().add(lastName); // добавить текстово поле в таблицу

        TextField comment = new TextField(); // Создать текстовое поле
        comment.setPromptText("Напишите комментарий"); // Текст подсказка
        GridPane.setConstraints(comment,0,2); // установить позицию текстового поля в таблице
        root.getChildren().add(comment); // добавить текстово поле в таблицу



        // Кнопки (начало):
        // Контейнер для кнопок
        GridPane containerButtons = new GridPane(); // создать контейнер - таблица
        containerButtons.setPadding(new Insets(10,10,10,10)); // отступы
        containerButtons.setHgap(5); // горизонтальные отступы между строками
        containerButtons.setVgap(5); // вертикальные отступы между столбцами
        GridPane.setConstraints(containerButtons,0,4);
        root.getChildren().add(containerButtons);

        // Кнопка - проверяет форму
        Button submit = new Button("Проверить"); // Создать кнопку
        GridPane.setConstraints(submit,0,0);
        containerButtons.getChildren().add(submit);

        // Кнопка - очищает форму
        Button clear = new Button("Очистить"); // Создать кнопку
        GridPane.setConstraints(clear,1,0);
        containerButtons.getChildren().add(clear);

        Label label = new Label();
        GridPane.setConstraints(label,0,2);
        containerButtons.getChildren().addAll(label);

        // Обработчики событий нажатия кнопок
        submit.setOnAction(event -> {
            if (!comment.getText().isEmpty()){
                if (!name.getText().isEmpty() && !lastName.getText().isEmpty()) {
                    label.setText(name.getText() + " " + lastName.getText() + ": " + comment.getText());
                }
                if (!name.getText().isEmpty() && lastName.getText().isEmpty()) {
                    label.setText(name.getText() + ": " + comment.getText());
                }
                if (name.getText().isEmpty() && !lastName.getText().isEmpty()) {
                    label.setText(lastName.getText() + ": " + comment.getText());
                }
                if (name.getText().isEmpty() && lastName.getText().isEmpty()) {
                    label.setText("Гость: " + comment.getText());
                }
            } else {
                label.setText("Вы не оставили комментарий!");
            }
        });

        clear.setOnAction(event -> {
            name.clear();
            lastName.clear();
            comment.clear();
            label.setText(null);
        });
        // Кнопки (конец)



        Scene scene = new Scene(root, 600, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args){
        launch(args);
    }
}