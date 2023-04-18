package com.andmal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private final ChoiceBox<Pair<String, String>> choiceBox = new ChoiceBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

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
        GridPane gridPane = new GridPane();

        Label select1 = new Label("Select");
        Button save = new Button("Save");
        save.setOnAction(event -> {
            try {
                DbData dbData = new DbData();
                List<String> comments = dbData.comments();
                for (int a = 5; a < 20; a++) {
                    Label comm = new Label(comments.get(a));
                    gridPane.add(comm, 0, a);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        List<Pair<String, String>> dbOptions = new ArrayList<>();

        choiceBox.setPrefWidth(200);
        dbOptions.add(new Pair<>("Postgres", "Postgres"));
        dbOptions.add(new Pair<>("MySQL", "MySQL"));
        dbOptions.add(new Pair<>("Mongo", "Mongo"));
        choiceBox.getItems().add(EMPTY_PAIR);
        choiceBox.getItems().addAll(dbOptions);

        gridPane.add(pane1, 0, 0);
        gridPane.add(select1, 0, 2);
        gridPane.add(choiceBox, 1, 2);
        gridPane.add(save, 2, 2);

        HBox hbox = new HBox(gridPane);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10.0d);
        hbox.setPadding(new Insets(40));

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