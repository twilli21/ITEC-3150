

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BSTAnimation extends Application {

  SimpleBSTMap tree;
  BTView view;
	
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	tree = new SimpleBSTMap(); // Create a tree
    tree.put(60, 6);
    tree.put(20, 2);
    tree.put(70, 7);
    tree.put(80, 8);
    tree.put(10, 1);
    tree.put(40, 4);
    tree.put(30, 3);
    tree.put(50, 5);

    BorderPane pane = new BorderPane();
    view = new BTView(tree); // Create a View
    pane.setCenter(view);

    TextField tfKey = new TextField();
    tfKey.setPrefColumnCount(3);
    tfKey.setAlignment(Pos.BASELINE_RIGHT);
    TextField tfValue = new TextField();
    tfValue.setPrefColumnCount(3);
    tfValue.setAlignment(Pos.BASELINE_RIGHT);
    Button btGet = new Button("Get");
    Button btPut = new Button("Put");
    Button btSort = new Button("Sort");
    Button btClear = new Button("Clear Text");
    Button btClearTree = new Button("Clear Tree");
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(new Label("Enter Key: "),
            tfKey, new Label("Value: "), 
            tfValue, btGet, btPut, btSort, btClear, btClearTree);
    hBox.setAlignment(Pos.CENTER);
    pane.setBottom(hBox);

    btPut.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      int value = Integer.parseInt(tfValue.getText());
      tree.put(key, value);
      view.displayTree();
    });
    
    
    btGet.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      try {
    	  Integer value = tree.get(key);
    	  if (value == null)
    		  throw new java.util.NoSuchElementException();
    	  tfValue.setText(Integer.toString(value));
    	  view.displayTree();
      }
      catch (java.util.NoSuchElementException ex) {
    	  tfValue.setText("NA");
      }
    });
    
    
    btSort.setOnAction(e -> {
    	System.out.println("In-Order: " + tree.inOrder());
    });
    
    btClear.setOnAction(e -> {
    	tfKey.clear();
    	tfValue.clear();
    });
    
    btClearTree.setOnAction(e -> {
    	tfKey.clear();
    	tfValue.clear();
    	tree = new SimpleBSTMap();
    	view = new BTView(tree);
    	pane.setCenter(view);
    	view.displayTree();
    });

    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 1000, 600);
    primaryStage.setTitle("BSTAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    view.displayTree();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
