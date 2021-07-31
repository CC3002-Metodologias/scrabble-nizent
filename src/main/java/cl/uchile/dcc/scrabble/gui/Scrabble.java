package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.controller.ASTController;
import cl.uchile.dcc.scrabble.controller.ScrabbleTypes;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

/**
 * The app for Scrabble. Run it and the program will execute
 */
public class Scrabble extends Application {
    Scene scene;
    Pane root;
    Map<String, Integer> counts = new HashMap<>();
    Map<String, String> symbols = new HashMap<>();
    ASTController astController;

    public static void main(String[] args) {
    launch(args);
  }
    @Override
    public void start(Stage primaryStage) {
        astController = new ASTController();
        counts.put(ScrabbleTypes.ADD_ID, 0);
        counts.put(ScrabbleTypes.DIV_ID, 0);
        counts.put(ScrabbleTypes.MULT_ID, 0);
        counts.put(ScrabbleTypes.SUB_ID, 0);
        counts.put(ScrabbleTypes.STR_ID, 0);
        counts.put(ScrabbleTypes.BIN_ID, 0);
        counts.put(ScrabbleTypes.BOOL_ID, 0);
        counts.put(ScrabbleTypes.INT_ID, 0);
        counts.put(ScrabbleTypes.FLOAT_ID, 0);
        counts.put(ScrabbleTypes.AND_ID, 0);
        counts.put(ScrabbleTypes.OR_ID, 0);
        counts.put(ScrabbleTypes.NOT_ID, 0);
        symbols.put(ScrabbleTypes.ADD_ID, "+");
        symbols.put(ScrabbleTypes.SUB_ID, "-");
        symbols.put(ScrabbleTypes.MULT_ID, "*");
        symbols.put(ScrabbleTypes.DIV_ID,"/");
        symbols.put(ScrabbleTypes.AND_ID, "&");
        symbols.put(ScrabbleTypes.OR_ID, "|");
        symbols.put(ScrabbleTypes.NOT_ID,"~");

        primaryStage.setTitle("Scrabble");
        root = new Pane();
        Label opLabel = new Label("OPERATORS");
        opLabel.setStyle("-fx-text-fill: slategray;" +
                "-fx-font-size: 140%;");
        opLabel.setTranslateX(10);
        Label arithmeticLabel = new Label("ARITHMETIC");
        arithmeticLabel.setStyle("-fx-text-fill: slategray;" +
                "-fx-font-size: 100%;");
        arithmeticLabel.setTranslateX(10);
        Label logicalLabel = new Label("LOGICAL");
        logicalLabel.setStyle("-fx-text-fill: slategray;" +
                "-fx-font-size: 100%;");
        logicalLabel.setTranslateX(10);
        Node addCreator = operationCreator(ScrabbleTypes.ADD_ID);
        Node subCreator = operationCreator(ScrabbleTypes.SUB_ID);
        Node mulCreator = operationCreator(ScrabbleTypes.MULT_ID);
        Node divCreator = operationCreator(ScrabbleTypes.DIV_ID);
        Node andCreator = operationCreator(ScrabbleTypes.AND_ID);
        Node orCreator = operationCreator(ScrabbleTypes.OR_ID);
        Node notCreator = singleOperationCreator(ScrabbleTypes.NOT_ID);

        Label consLabel = new Label("CONSTANTS");
        consLabel.setStyle("-fx-text-fill: slategray;" +
                "-fx-font-size: 140%;");
        consLabel.setTranslateX(10);
        Node stringCreator = constantCreator(ScrabbleTypes.STR_ID);
        Node floatCreator = constantCreator(ScrabbleTypes.FLOAT_ID);
        Node binCreator = constantCreator(ScrabbleTypes.BIN_ID);
        Node boolCreator = constantCreator(ScrabbleTypes.BOOL_ID);
        Node intCreator = constantCreator(ScrabbleTypes.INT_ID);
        VBox menu = new VBox(20, opLabel, arithmeticLabel,addCreator, subCreator, mulCreator, divCreator,
                logicalLabel, andCreator, orCreator, notCreator,
                consLabel, floatCreator,intCreator,binCreator,boolCreator,stringCreator);
        menu.setFillWidth(false);
        ScrollPane menuContainer = new ScrollPane();
        menuContainer.setContent(menu);
        menuContainer.setPrefWidth(200);
        menuContainer.setPrefHeight(600);
        menuContainer.setStyle("-fx-background-color: white;" +
                "-fx-background: white;");

        Pane board = new Pane();

    root.getChildren().add(menuContainer);
    root.getChildren().add(board);
    Circle basket = new Circle();
    basket.setCenterX(600);
    basket.setCenterY(600);
    basket.setRadius(50);
    basket.setFill(Color.RED);
    basket.setOpacity(0.7);
    Label deleteText = new Label("DROP & DELETE");
    deleteText.relocate(557,580);
    deleteText.setStyle("-fx-text-fill: white;");
    basket.setOnMouseDragReleased(event -> {
        Node source = (Node) event.getGestureSource();
        root.getChildren().remove(source.getParent());
    });
    root.getChildren().add(basket);
    root.getChildren().add(deleteText);

    scene = new Scene(root, 1000, 600);
    root.setStyle("-fx-background-color: white");

    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private Node makeDraggable(final Node node) {
    final DragContext dragContext = new DragContext();
    final Group wrapGroup = new Group(node);

      wrapGroup.setOnDragDetected(event -> {
          node.startFullDrag();
          event.consume();
      });

      wrapGroup.setOnMouseReleased(event -> {
          node.setMouseTransparent(false);
          if(event.getClickCount()==2){
              Label value = new Label(astController.evaluate(node.getId()));
              Bounds b = wrapGroup.localToScene(wrapGroup.getBoundsInLocal());
              value.relocate(b.getMinX()-250,b.getMinY()-20-200);
              PauseTransition ps = new PauseTransition(Duration.seconds(2));
              ps.setOnFinished(event1 -> value.setVisible(false));
              value.setStyle("-fx-background-color: greenyellow");
              wrapGroup.getChildren().add(value);
              ps.play();
          }
          event.consume();
      });

      wrapGroup.setOnMousePressed(event -> {
          node.setMouseTransparent(true);
          ((Node) event.getSource()).toFront();
          dragContext.mouseAnchorX = event.getX();
          dragContext.mouseAnchorY = event.getY();
          dragContext.initialTranslateX =
                  node.getTranslateX();
          dragContext.initialTranslateY =
                  node.getTranslateY();
          event.consume();
      });

      wrapGroup.addEventFilter(
              MouseEvent.MOUSE_DRAGGED,
              mouseEvent -> {
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
              });
    return wrapGroup;
  }

    private Node makeOperationInput(final Pane node) {
      final Group wrapGroup = new Group(node);
      
      wrapGroup.setOnMouseDragReleased(event -> {
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
      });
      return wrapGroup;
    }

  private Node createConstantPanel(String type) {
    final TextField textField = new TextField();
    textField.setPrefWidth(40);
    Label typeLabel = new Label(type+":");
    typeLabel.setStyle("-fx-text-fill: white;");
    final HBox panel = createHBox(typeLabel, textField);
    // setId
      String id = type+counts.get(type);
      panel.setId(id);
      astController.add(id);
      counts.put(type, counts.get(type)+1);
    final Node constantPanel = makeDraggable(panel);
    configureBorderConstant(panel);
      textField.textProperty().addListener((observable, oldValue, newValue) -> astController.updateConstant(panel.getId(), newValue));
    return constantPanel;
  }

  private Node createOperationPanel(String type) {
        Label typeLabel = new Label(symbols.get(type));
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
        final HBox panel = createHBox(izqWrapper, typeLabel, derWrapper);
        configureBorderOperation(panel);
        panel.setAlignment(Pos.CENTER);
      panel.setId(id);
      astController.add(id);
      counts.put(type, counts.get(type)+1);
      return makeDraggable(panel);
  }

  public Node singleOperation(String type){
      Label typeLabel = new Label(symbols.get(type));
      typeLabel.setStyle("-fx-text-fill: white;");
      String id = type + counts.get(type);
      Pane izq = new Pane();
      izq.setPrefSize(50, 30);
      izq.setStyle("-fx-background-color: white");
      izq.setId(id+"izq");
      Node izqWrapper = makeOperationInput(izq);
      final HBox panel = createHBox(typeLabel, izqWrapper);
      configureBorderOperation(panel);
      panel.setAlignment(Pos.CENTER);
      panel.setId(id);
      astController.add(id);
      counts.put(type, counts.get(type)+1);
      return makeDraggable(panel);
  }

  public Node constantCreator(String type){
      final TextField textField = new TextField();
      textField.setPrefWidth(40);
      Label typeLabel = new Label(type+":");
      typeLabel.setStyle("-fx-text-fill: white;");
      final HBox panel = createHBox(typeLabel, textField);
      configureBorderConstant(panel);
      panel.setStyle("-fx-background-color: orangered;"
              + "-fx-border-color: orangered;"
              + "-fx-border-width: 1;"
              + "-fx-border-radius: 10;"
              + "-fx-padding: 6;");
      panel.setTranslateX(10);
      panel.setOnMouseClicked(event -> {
          if(event.getClickCount()==2){
              Node newConstant = createConstantPanel(type);
              newConstant.setTranslateX(250);
              newConstant.setTranslateY(200);
              root.getChildren().add(newConstant);
          }
      });
      return panel;
  }

  public Node operationCreator(String type){
      Label typeLabel = new Label(symbols.get(type));
      typeLabel.setStyle("-fx-text-fill: white;");
      Pane izq = new Pane();
      Pane der = new Pane();
      izq.setPrefSize(50, 30);
      der.setPrefSize(50, 30);
      izq.setStyle("-fx-background-color: white");
      der.setStyle("-fx-background-color: white");
      final HBox panel = createHBox(izq, typeLabel, der);
      panel.setAlignment(Pos.CENTER);
      configureBorderOperation(panel);
      panel.setTranslateX(10);
      panel.setOnMouseClicked(event -> {
          if(event.getClickCount()==2){
              Node newConstant = createOperationPanel(type);
              newConstant.setTranslateX(250);
              newConstant.setTranslateY(200);
              root.getChildren().add(newConstant);
          }
      });
      return panel;
  }

    public Node singleOperationCreator(String type){
        Label typeLabel = new Label(symbols.get(type));
        typeLabel.setStyle("-fx-text-fill: white;");
        Pane izq = new Pane();
        izq.setPrefSize(50, 30);
        izq.setStyle("-fx-background-color: white");
        final HBox panel = createHBox(typeLabel, izq);
        panel.setAlignment(Pos.CENTER);
        configureBorderOperation(panel);
        panel.setTranslateX(10);
        panel.setOnMouseClicked(event -> {
            if(event.getClickCount()==2){
                Node newConstant = singleOperation(type);
                newConstant.setTranslateX(250);
                newConstant.setTranslateY(200);
                root.getChildren().add(newConstant);
            }
        });
        return panel;
    }

  private static void configureBorderConstant(final Region region) {
    region.setStyle("-fx-background-color: orangered;"
            + "-fx-border-color: orangered;"
            + "-fx-border-width: 1;"
            + "-fx-border-radius: 10;"
            + "-fx-padding: 6;");
  }

    private static void configureBorderOperation(final Region region) {
        region.setStyle("-fx-background-color: dodgerblue;"
                + "-fx-border-color: dodgerblue;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 10;"
                + "-fx-padding: 6;");
    }

  private static HBox createHBox(final Node... children) {
    final HBox hbox = new HBox(6);
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