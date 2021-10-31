package ru.evant.tutorial_fx.less26_modal_window;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalWindow {

    public static void newWindow (String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); // пока не закрыто это окно(модальное), остальные окна заблокированы

        Pane pane = new Pane();

        Button button = new Button("Закрыть");
        button.setOnAction(event -> {
            window.close();
        });

        pane.getChildren().add(button);
        Scene scene = new Scene(pane, 300,300);
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait(); // отобразить и заблокировать предыдущие окна
    }
}
