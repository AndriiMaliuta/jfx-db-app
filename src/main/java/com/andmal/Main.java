package com.andmal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Main extends Application {
    private final ChoiceBox<Pair<String,String>> choiceBox = new ChoiceBox<>();

    static {
        System.getProperties().put("javafx.pseudoClassOverrideEnabled", "true");
    }

    public static void main(String[] args) {
        launch();
    }

    private Parent createContent() {
        Rectangle box = new Rectangle(100, 50, Color.BLUE);
        transform(box);

        Pane pane1 = new StackPane(box);

        Label select1 = new Label("Select");
        Button save = new Button("Save");
        save.setOnAction(event -> {
            System.out.println(">> saving");
        });

        choiceBox.setPrefWidth(200);
        choiceBox.setValue(new Pair<>("Sumy", "Sumy"));
        choiceBox.setValue(new Pair<>("Kyiv", "Kyiv"));

        GridPane gridPane = new GridPane();
        gridPane.add(pane1, 0,0);
        gridPane.add(new Label("aa"), 0,1);
        gridPane.add(new Label("bb"), 1,1);
        gridPane.add(select1, 0,2);
        gridPane.add(choiceBox, 1,2);
        gridPane.add(save, 2,2);

        HBox hbox = new HBox(gridPane);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10.0d);
        hbox.setPadding( new Insets(40) );

        return new Pane(hbox);
    }

    private void transform(Rectangle box) {
        box.setTranslateX(100);
        box.setTranslateY(200);
        box.setRotate(30);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(), 1200, 900);
        stage.setTitle("My App");
        stage.setScene(scene);
        stage.show();
    }

}