package com.andmal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.io.InputStream;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static final String IMAGE_LOC = "/";
    private final ChoiceBox<Pair<String, String>> choiceBox = new ChoiceBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

    static {
        System.getProperties().put("javafx.pseudoClassOverrideEnabled", "true");
    }

    public static void main(String[] args) {
        launch();
    }

    private Parent createContent() {
//        Rectangle box = new Rectangle(100, 50, Color.BLUE);
//        transform(box);
//        Pane pane1 = new StackPane(box);

        GridPane gridPane = new GridPane();

        Image mainImage = new Image(IMAGE_LOC, 360.0d, 360.0d, true, true);

        Label select1 = new Label("Select");
        Button save = new Button("Save");
        TableView<Comment> tableView = new TableView<>();

        save.setOnAction(event -> {
            try {
                DbData dbData = new DbData();
                List<Comment> comments = dbData.comments(20);

                tableView.setPrefWidth(800);
                tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

                TableColumn<Comment, String> column1 = new TableColumn<>("Id");
                TableColumn<Comment, String> column2 = new TableColumn<>("Date");
                TableColumn<Comment, String> column3 = new TableColumn<>("Body");

                column1.setCellValueFactory(new PropertyValueFactory<>("id"));
                column2.setCellValueFactory(new PropertyValueFactory<>("date"));
                column3.setCellValueFactory(new PropertyValueFactory<>("body"));

                comments.forEach(c -> {
//                    System.out.println(c);
                    tableView.getItems().add(c);
                });

                tableView.getColumns().addAll(column1, column2, column3);

//                gridPane.add(tableView, 0, 6);

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

        gridPane.add(select1, 0, 2);
//        gridPane.add(choiceBox, 1, 2);
//        gridPane.add(save, 2, 2);

        VBox vBox = new VBox(gridPane);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10.0d);
        vBox.setPadding(new Insets(40));

        vBox.getChildren().addAll(
                choiceBox,
                save,
                new Separator(),
                tableView
        );

        return vBox;
    }

    private void transform(Rectangle box) {
        box.setTranslateX(100);
        box.setTranslateY(200);
        box.setRotate(30);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(), 1200, 900);
        drawChart();
        stage.setTitle("My App");
        stage.setScene(scene);
        stage.show();
    }

    void drawChart() {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0.0, 0.0));
        series.getData().add(new XYChart.Data<>(0.7, 0.5));
        series.getData().add(new XYChart.Data<>(1.0, 0.632));
        series.getData().add(new XYChart.Data<>(2.0, 0.865));
        series.getData().add(new XYChart.Data<>(3.0, 0.95));
        series.getData().add(new XYChart.Data<>(4.0, 0.982));
        series.getData().add(new XYChart.Data<>(5.0, 0.993));
    }

}