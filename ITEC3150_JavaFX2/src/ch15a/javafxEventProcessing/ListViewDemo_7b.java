package ch15a.javafxEventProcessing;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ListViewDemo_7b extends Application {
  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"Canada", "China", "Denmark",
    "France", "Germany", "India", "Norway", "United Kingdom",
    "United States of America"};
  
  private String[] flagDetails = {"Canada Canada Canada Canada", "China China China", "Denmark2",
		    "France2", "Germany2", "India2", "Norway2", "United Kingdom2",
		    "United States of America2"};

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ListView<String> lv = new ListView<>
      (FXCollections.observableArrayList(flagTitles));
    lv.setPrefSize(200, 400);
    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    
    ScrollPane listPane = new ScrollPane(lv);

    lv.getSelectionModel().selectedItemProperty().addListener(
      ov -> { 
        //rightPane.getChildren().clear();
        //for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
        //  rightPane.getChildren().add(new Label(flagDetails[i]));
        //}
         int i = lv.getSelectionModel().getSelectedIndices().get(0);
         FlowPane rightPane = new FlowPane(10, 10);
         rightPane.getChildren().add(new Label(flagDetails[i]));
         Stage stage = new Stage(); // Create a new stage
         stage.setTitle("Second Stage"); // Set the stage title
         // Set a scene with a button in the stage
         stage.setScene(new Scene(rightPane));        
         stage.show(); // Display the stage
        
    });
    

    // Create a scene and place it in the stage
    Scene scene = new Scene(listPane);
    primaryStage.setTitle("ListViewDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
