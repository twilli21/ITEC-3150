package Homework7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BSTAnimation extends Application {

  BSTMap<Integer, String> tree;
  BTView<Integer, String> view;
	
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	tree = new BSTMap<>(); // Create a tree
    tree.put(60, "cat");
    tree.put(20, "dog");
    tree.put(70, "a");
    tree.put(80, "b");
    tree.put(10, "c");
    tree.put(40, "d");
    tree.put(30, "e");
    tree.put(50, "f");

    BorderPane pane = new BorderPane();
    view = new BTView<>(tree); // Create a View
    pane.setCenter(view);

    TextField tfKey = new TextField();
    tfKey.setPrefColumnCount(3);
    tfKey.setAlignment(Pos.BASELINE_RIGHT);
    TextField tfValue = new TextField();
    tfValue.setPrefColumnCount(3);
    tfValue.setAlignment(Pos.BASELINE_RIGHT);
    Button btPut = new Button("Put");
    Button btGet = new Button("Get");
    //Button btRemove = new Button("Remove");
    Button btSort = new Button("Sort");
    Button btReverse = new Button("Reverse Sort");
    Button btKSmallest = new Button("K Smallest");
    //Button btPredecessor = new Button("Predecessor");
    //Button btSuccessor = new Button("Successor");
    Button btClear = new Button("Clear Text");
    Button btClearTree = new Button("Clear Tree");
    VBox vBox = new VBox(10);
    HBox hBox1 = new HBox(5);
    hBox1.getChildren().addAll(new Label("Enter Key: "),
            tfKey, new Label("Value: "), 
            tfValue, btPut, btGet, btClear, btClearTree);
    hBox1.setAlignment(Pos.CENTER);
    HBox hBox2 = new HBox(5);
    hBox2.getChildren().addAll(btSort, btReverse, btKSmallest/*,btPredecessor, btSuccessor*/);
    hBox2.setAlignment(Pos.CENTER);
    vBox.getChildren().addAll(hBox1, hBox2);
    pane.setBottom(vBox);

    btPut.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      String value = tfValue.getText();
      tree.put(key, value);
      view.displayTree();
    });
    
    
    btGet.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      try {
    	  String value = tree.get(key);
    	  tfValue.setText(value);
    	  view.displayTree();
      }
      catch (java.util.NoSuchElementException ex) {
    	  tfValue.setText("NA");
      }
    });
    
//    btRemove.setOnAction(e -> {
//        int key = Integer.parseInt(tfKey.getText());
//        try {
//      	  String value = tree.remove(key);
//      	  tfValue.setText(value);
//      	  view.displayTree();
//        }
//        catch (java.util.NoSuchElementException ex) {
//      	  tfValue.setText("NA");
//        }
//      });
    
    
    btSort.setOnAction(e -> {
    	System.out.println("In-Order: " + tree.inOrder());
    });
    
    btReverse.setOnAction(e -> {
    	System.out.println("Reverse-Order: " + tree.reverseOrder());
    });
    
    btKSmallest.setOnAction(e -> {
    	int k = Integer.parseInt(tfKey.getText());
    	System.out.println("k smallest: " + tree.kSmallest(k));
    });
    /*
    btPredecessor.setOnAction(e -> {
    	int k = Integer.parseInt(tfKey.getText());
    	System.out.println("Predecessor: " + tree.predecessor(k));
    });
    
    btSuccessor.setOnAction(e -> {
    	int k = Integer.parseInt(tfKey.getText());
    	System.out.println("Successor: " + tree.successor(k));
    });
    */
    btClear.setOnAction(e -> {
    	tfKey.clear();
    	tfValue.clear();
    });
    
    btClearTree.setOnAction(e -> {
    	tfKey.clear();
    	tfValue.clear();
    	tree = new BSTMap<>();
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
