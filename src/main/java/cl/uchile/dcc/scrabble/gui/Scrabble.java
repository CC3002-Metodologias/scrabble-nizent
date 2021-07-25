package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.controller.ASTController;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

/**
 * Aaa
 */
public class Scrabble extends Application {
    Scene scene;
    Pane root;
    Map<String, Integer> counts = new HashMap<>();
    ASTController astController;
    private static String STR_ID = "String";
    String FLOAT_ID = "Float";
    String BIN_ID = "Bin";
    String BOOL_ID = "Bool";
    String INT_ID = "Int";
    private static String ADD_ID = "Add";
    String MULT_ID = "Mult";
    String DIV_ID = "Div";
    String SUB_ID = "Sub";

    public static void main(String[] args) {
    launch(args);
  }
    @Override
    public void start(Stage primaryStage) {
        astController = new ASTController();
        counts.put(ADD_ID, 0);
        counts.put(DIV_ID, 0);
        counts.put(MULT_ID, 0);
        counts.put(SUB_ID, 0);
        counts.put(STR_ID, 0);
        counts.put(BIN_ID, 0);
        counts.put(BOOL_ID, 0);
        counts.put(INT_ID, 0);
        counts.put(FLOAT_ID, 0);
        primaryStage.setTitle("Scrabble");
        root = new Pane();
        Node addCreator = operationCreator(ADD_ID);
        Node subCreator = operationCreator(SUB_ID);
        Node mulCreator = operationCreator(MULT_ID);
        Node divCreator = operationCreator(DIV_ID);
        Node stringCreator = constantCreator(STR_ID);
        Node floatCreator = constantCreator(FLOAT_ID);
        Node binCreator = constantCreator(BIN_ID);
        Node boolCreator = constantCreator(BOOL_ID);
        Node intCreator = constantCreator(INT_ID);
        VBox menu = new VBox(20,addCreator, subCreator, mulCreator, divCreator,
                floatCreator,intCreator,binCreator,boolCreator,stringCreator);

        Pane board = new Pane();

    root.getChildren().add(menu);
    root.getChildren().add(board);

    scene = new Scene(root, 1000, 600);
    root.setStyle("-fx-background-color: white");

    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private Node makeDraggable(final Node node) {
    final DragContext dragContext = new DragContext();
    final Group wrapGroup = new Group(node);

      wrapGroup.setOnDragDetected(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              node.startFullDrag();
              event.consume();
          }
      });

      wrapGroup.setOnMouseReleased(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              node.setMouseTransparent(false);
              if(event.getClickCount()==2){
                  Label value = new Label(astController.evaluate(node.getId()));
                  Bounds b = wrapGroup.localToScene(wrapGroup.getBoundsInLocal());
                  value.relocate(b.getMinX(),b.getMinY()-20);
                  PauseTransition ps = new PauseTransition(Duration.seconds(2));
                  ps.setOnFinished(new EventHandler<ActionEvent>() {
                      @Override
                      public void handle(ActionEvent event) {
                          value.setVisible(false);
                      }
                  });
                  value.setStyle("-fx-background-color: greenyellow");
                  wrapGroup.getChildren().add(value);
                  ps.play();
              }
              event.consume();
          }
      });

      wrapGroup.setOnMousePressed(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              node.setMouseTransparent(true);
              dragContext.mouseAnchorX = event.getX();
              dragContext.mouseAnchorY = event.getY();
              dragContext.initialTranslateX =
                      node.getTranslateX();
              dragContext.initialTranslateY =
                      node.getTranslateY();
              event.consume();
          }
      });

      wrapGroup.addEventFilter(
              MouseEvent.MOUSE_DRAGGED,
              new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(final MouseEvent mouseEvent) {
                          // shift node from its initial position by delta
                          // calculated from mouse cursor movement
                          node.setTranslateX(
                                  dragContext.initialTranslateX
                                          + mouseEvent.getX()
                                          - dragContext.mouseAnchorX);
                          node.setTranslateY(
                                  dragContext.initialTranslateY
                                          + mouseEvent.getY()
                                          - dragContext.mouseAnchorY);
                  }
              });
    return wrapGroup;
  }

    private Node makeOperationInput(final Pane node) {
      final Group wrapGroup = new Group(node);
      
      wrapGroup.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
          @Override
          public void handle(MouseDragEvent event) {
              Node source = (Node) event.getGestureSource();
              Node inserted = makeDraggable(source);
              inserted.relocate(0,0);
              String inserted_id = source.getId();
              node.getChildren().add(0, inserted);
              String id = node.getId();
              String op_id = node.getParent().getParent().getId();
              if(id.contains("izq")){
                  astController.addLeftOperand(op_id, inserted_id);
              } else if (id.contains("der")){
                  astController.addRightOperand(op_id, inserted_id);
              }
              event.consume();
          }
      });
      return wrapGroup;
    }

  private Node createConstantPanel(String type) {
    final TextField textField = new TextField();
    textField.setPrefWidth(40);
    Label typeLabel = new Label(type+":");
    typeLabel.setStyle("-fx-text-fill: white;");
    final HBox panel = createHBox(6, typeLabel, textField);
    // setId
      String id = type+counts.get(type);
      panel.setId(id);
      astController.add(id);
      counts.put(type, counts.get(type)+1);
    final Node constantPanel = makeDraggable(panel);
    configureBorder(panel);
      textField.textProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              astController.updateConstant(panel.getId(), newValue);
          }
      });
    return constantPanel;
  }

  private Node createOperationPanel(String type) {
        Label typeLabel = new Label(type+":");
        typeLabel.setStyle("-fx-text-fill: white;");
        String id = type + counts.get(type);
        Pane izq = new Pane();
        Pane der = new Pane();
        izq.setPrefSize(50, 30);
        der.setPrefSize(50, 30);
        izq.setStyle("-fx-background-color: white");
        der.setStyle("-fx-background-color: white");
        izq.setId(id+"izq");
        der.setId(id+"der");
        Node izqWrapper = makeOperationInput(izq);
        Node derWrapper = makeOperationInput(der);
        final HBox panel = createHBox(6, typeLabel, izqWrapper, derWrapper);
        configureBorder(panel);
      panel.setId(id);
      astController.add(id);
      counts.put(type, counts.get(type)+1);
        final Node opPanel = makeDraggable(panel);
        return opPanel;
  }

  public Node constantCreator(String type){
      final TextField textField = new TextField();
      textField.setPrefWidth(40);
      Label typeLabel = new Label(type+":");
      typeLabel.setStyle("-fx-text-fill: white;");
      final HBox panel = createHBox(6, typeLabel, textField);
      configureBorder(panel);
      panel.setPrefWidth(80);
      panel.setTranslateX(10);
      panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              if(event.getClickCount()==2){
                  Node newConstant = createConstantPanel(type);
                  newConstant.setTranslateX(200);
                  newConstant.setTranslateY(200);
                  root.getChildren().add(newConstant);
              }
          }
      });
      return panel;
  }

  public Node operationCreator(String type){
      Label typeLabel = new Label(type+":");
      typeLabel.setStyle("-fx-text-fill: white;");
      Pane izq = new Pane();
      Pane der = new Pane();
      izq.setPrefSize(50, 30);
      der.setPrefSize(50, 30);
      izq.setStyle("-fx-background-color: white");
      der.setStyle("-fx-background-color: white");
      final HBox panel = createHBox(6, typeLabel, izq, der);
      configureBorder(panel);
      panel.setTranslateX(10);
      panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              if(event.getClickCount()==2){
                  Node newConstant = createOperationPanel(type);
                  newConstant.setTranslateX(200);
                  newConstant.setTranslateY(200);
                  root.getChildren().add(newConstant);
              }
          }
      });
      return panel;
  }

  private static void configureBorder(final Region region) {
    region.setStyle("-fx-background-color: darkcyan;"
            + "-fx-border-color: darkcyan;"
            + "-fx-border-width: 1;"
            + "-fx-border-radius: 10;"
            + "-fx-padding: 6;");
  }

  private static HBox createHBox(final double spacing,
                                 final Node... children) {
    final HBox hbox = new HBox(spacing);
    hbox.getChildren().addAll(children);
    return hbox;
  }

  private static final class DragContext {
    public double mouseAnchorX;
    public double mouseAnchorY;
    public double initialTranslateX;
    public double initialTranslateY;
  }
}