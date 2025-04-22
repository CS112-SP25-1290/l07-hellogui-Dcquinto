package edu.miracosta.cs112.lab07;//package name here depending on your IDE

import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.event.Event;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key press

public class HelloApplication extends Application implements EventHandler  { //inheriting core functionality + this class will handle events
    /*** GUI COMPONENTS ***/
    // TODO: follow step 25 in README.md to create reference variables

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args); //method from Application class, must be called to setup javafx application
    }
    Label label1;
    Label label2;
    Button button1;
    Button button2;

    // TODO: follow steps 2-9 in README.md to create a start method
    public void start (Stage primaryStage) {
        primaryStage.setTitle("Hello GUI: I am David Quinto.");

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        // TODO: follow steps 10-21 in README.md to add objects to your layout (inside start)
        Label label1 = new Label("Hello GUI!");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setTopAnchor(label1, 5.0);
        anchorPane.setLeftAnchor(label1, 5.0);
        anchorPane.getChildren().add(label1);

        Label label2 = new Label("Also Hi!");

        anchorPane.setBottomAnchor(label2, 5.0);
        anchorPane.setRightAnchor(label2, 5.0);
        anchorPane.getChildren().add(label2);

        Button button1 = new Button("Click me if it's you");
        button1.setOnAction(this);
        anchorPane.setBottomAnchor(button1, 5.0);
        anchorPane.setLeftAnchor(button1, 5.0);
        anchorPane.getChildren().add(button1);

        Button button2 = new Button("Click this button if it's not you.");
        button2.setOnAction(this);
        anchorPane.setTopAnchor(button2, 5.0);
        anchorPane.setRightAnchor(button2, 5.0);
        anchorPane.getChildren().add(button2);

        layout.getChildren().add(anchorPane);

    }
    int buttonPresses;

    @Override
    public void handle(Event event) {
        if(event.getSource() == button1) {
            label1.setText("New text!");
        }
        if(event.getSource() == button2) {
            label2.setText("" + ++buttonPresses);
        }
    }

}