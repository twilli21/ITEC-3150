package ch15a.javafxEventProcessing;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class TextFieldDemo_7a extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		
		Text text = new Text(50, 50, "JavaFX Programming");
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		

		FlowPane paneForTextField = new FlowPane();
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.CENTER_LEFT);
		tf.setOnAction(e -> text.setText(tf.getText()));
		paneForTextField.getChildren().addAll(new Label("Enter a new message: "), tf);


		BorderPane pane = new BorderPane();
		pane.setTop(paneForTextField);
		pane.setCenter(paneForText);

		
		Scene scene = new Scene(pane, 450, 200);
		primaryStage.setTitle("ButtonDemo"); // Set the stage title
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
