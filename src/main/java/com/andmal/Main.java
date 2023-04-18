package com.andmal;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage mainStage;
    private Color baseColor;
    private BorderPane outerRoot;

    static {
        System.getProperties().put("javafx.pseudoClassOverrideEnabled", "true");
    }

    public static void main(String[] args) {
        launch();
    }

    private Parent createContent() {
        Rectangle box = new Rectangle(100, 50, Color.BLUE);
        transform(box);
        return new Pane(box);
    }

    private void transform(Rectangle box) {
        box.setTranslateX(100);
        box.setTranslateY(200);
    }

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField("input url");

        Scene scene = new Scene(createContent(), 1024, 768);

        Box box1 = new Box(100,100,2);
        box1.setOpacity(20);
        stage.setTitle("My App");

        stage.setScene(scene);
        stage.show();
    }

}