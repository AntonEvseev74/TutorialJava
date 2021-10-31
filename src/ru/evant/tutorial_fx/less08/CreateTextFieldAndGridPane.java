package ru.evant.tutorial_fx.less08;

// Небольшую форма отправки отзыва.
// TextField - текстовое поле
// GridPane.

// https://www.youtube.com/watch?v=Hmp8BZDrBv8&list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa&index=8

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CreateTextFieldAndGridPane extends Application {
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

        Label label = new Label();
        GridPane.setConstraints(label,0,3);
        root.getChildren().addAll(label);

        // Кнопки (начало):
        // Кнопка - проверяет форму
        Button submit = new Button("Проверить"); // Создать кнопку
        GridPane.setConstraints(submit,1,2);
        root.getChildren().add(submit);

        // Кнопка - очищает форму
        Button clear = new Button("Очистить"); // Создать кнопку
        GridPane.setConstraints(clear,2,2);
        root.getChildren().add(clear);

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