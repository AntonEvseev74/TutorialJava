package ru.evant.tutorial_fx.less09;

/*
Домашнее задание:
        Сделайте форму регистрации
        Форма включает в себя:
        1) поля: Логин, Пароль,  возраст
        2 )выбор пола(или м или ж)
        3) Какие языки вы изучаете?(Используйте CheckBox. Добавьте 3 языка.)
        4)Кнопки "Отправить" и "Очистить"

        При нажатии на кнопку "Отправить, вся информация с формы должна вывестись в консоли.
        Пример:
        Login: введённый логин.
        Pass: пароль
        Пол: ваш пол.
        Языки: тут через пробел языки, которые вы выбрали


        ***
        Сделаете проверку в поле возраста, если в поле указана НЕ ЦИФРЫ, вывести ошибку.
        Если какие-то данные не введены, вывести ошибку.

        String agestring = age.getText();
        try{
        int a = Integet.parseInt(....
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TaskTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane(); // создать контейнер - таблица
        root.setPadding(new Insets(10, 10, 10, 10)); // отступы
        root.setHgap(5); // горизонтальные отступы между строками
        root.setVgap(5); // вертикальные отступы между столбцами

        TextField login = new TextField(); // Создать текстовое поле
        login.setPromptText("Логин"); // Текст подсказка
        GridPane.setConstraints(login, 0, 0); // установить позицию текстового поля в таблице
        root.getChildren().add(login); // добавить текстово поле в таблицу

        PasswordField pass = new PasswordField(); // Создать текстовое поле
        pass.setPromptText("Пароль"); // Текст подсказка
        GridPane.setConstraints(pass, 0, 1); // установить позицию текстового поля в таблице
        root.getChildren().add(pass); // добавить текстово поле в таблицу

        TextField age = new TextField(); // Создать текстовое поле
        age.setPromptText("Возраст"); // Текст подсказка
        GridPane.setConstraints(age, 0, 2); // установить позицию текстового поля в таблице
        root.getChildren().add(age); // добавить текстово поле в таблицу

        // Пол. Перключатель.
        GridPane rootGender = new GridPane(); // создать контейнер - таблица
        rootGender.setPadding(new Insets(10, 10, 10, 10)); // отступы
        rootGender.setHgap(15); // горизонтальные отступы между строками
        rootGender.setVgap(5); // вертикальные отступы между столбцами
        GridPane.setConstraints(rootGender, 0, 3);
        root.getChildren().add(rootGender);
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("м");
        RadioButton rb2 = new RadioButton("ж");
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb1.setSelected(true);
        GridPane.setConstraints(rb1, 0, 0);
        rootGender.getChildren().add(rb1);
        GridPane.setConstraints(rb2, 1, 0);
        rootGender.getChildren().add(rb2);

        // CheckBox. Какие языки вы изучаете
        GridPane rootLang = new GridPane(); // создать контейнер - таблица
        rootLang.setPadding(new Insets(10, 10, 10, 10)); // отступы
        rootLang.setHgap(5); // горизонтальные отступы между строками
        rootLang.setVgap(5); // вертикальные отступы между столбцами
        GridPane.setConstraints(rootLang, 0, 4);
        root.getChildren().add(rootLang);
        CheckBox[] checkBoxes = new CheckBox[]{
                new CheckBox("C++"),
                new CheckBox("Java"),
                new CheckBox("Python")
        };
        StringBuilder selectedLang = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            CheckBox cb = checkBoxes[i];
            int rowIndex = 0;
            int columnIndex = i;
            GridPane.setConstraints(cb, columnIndex, rowIndex);
            rootLang.getChildren().add(cb);
            cb.selectedProperty().addListener(event -> {
                if (cb.isSelected()) {
                    selectedLang.append(cb.getText() + " ");
                }
            });
        }

        // Кнопки (начало):
        // Контейнер для кнопок
        GridPane containerButtons = new GridPane(); // создать контейнер - таблица
        containerButtons.setPadding(new Insets(10, 10, 10, 10)); // отступы
        containerButtons.setHgap(5); // горизонтальные отступы между строками
        containerButtons.setVgap(5); // вертикальные отступы между столбцами
        GridPane.setConstraints(containerButtons, 0, 5);
        root.getChildren().add(containerButtons);

        // Кнопка - проверяет форму
        Button send = new Button("Отправить"); // Создать кнопку
        GridPane.setConstraints(send, 0, 0);
        containerButtons.getChildren().add(send);

        // Кнопка - очищает форму
        Button clear = new Button("Очистить"); // Создать кнопку
        GridPane.setConstraints(clear, 1, 0);
        containerButtons.getChildren().add(clear);

        Label label = new Label();
        GridPane.setConstraints(label, 0, 2);
        containerButtons.getChildren().addAll(label);

        // Обработчики событий нажатия кнопок
        send.setOnAction(event -> {
            String gen = "";
            if (rb1.isSelected()) gen = rb1.getText();
            if (rb2.isSelected()) gen = rb1.getText();

            String ageString = age.getText();
            try {
                String outText = "";
                if (!login.getText().isEmpty() && !pass.getText().isEmpty() && !age.getText().isEmpty()) {
                    int ageInt = Integer.parseInt(ageString);
                    outText = "Login: " + login.getText() +
                            "\nPassword: " + pass.getText() +
                            "\nAge: " + ageInt +
                            "\nGender: " + gen +
                            "\nLang: " + selectedLang;
                    label.setText(outText);
                    System.out.println(outText);
                } else {
                    label.setText("Заполните все поля");
                }
            } catch (Exception e) {
                label.setText("Ошибка! Некорректные данные в поле Age");
                System.out.println("Ошибка! Некорректные данные в поле Age");
            }
        });

        clear.setOnAction(event -> {
            login.clear();
            pass.clear();
            age.clear();

            label.setText(null);
        });
        // Кнопки (конец)


        Scene scene = new Scene(root, 600, 400);  // Создать сцену
        primaryStage.setScene(scene);   // установить сцену для нашего окна
        primaryStage.show();            // отобразить окно на экране
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch(args);
    }
}
