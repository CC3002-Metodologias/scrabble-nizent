package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class Scrabble extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Scrabble");

    Button addButton = new Button("Create an Add");
    TilePane root = new TilePane();
    root.setAlignment(Pos.CENTER);

    Label label = new Label();

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        label.setText("new Add(7,0)");
      }
    };

    addButton.setOnAction(event);
    root.getChildren().add(addButton);
    root.getChildren().add(label);
    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 400, 200);
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}