package ch15a.javafxEventProcessing;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandleEventLambdaExpression_4 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		HBox pane = new HBox(10);
		pane.setAlignment(Pos.CENTER);

		Button btOK = new Button("OK");
		Button btOK1 = new Button("OK1");
		Button btOK2 = new Button("OK2");
		Button btOK3 = new Button("OK3");
		Button btOK4 = new Button("OK4");
		Button btCancel = new Button("Cancel");

		// anonymous inner class
//		btOK.setOnAction(new EventHandler<ActionEvent> () {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("OK button clicked");
//			}
//		});
		
		btOK.setOnAction(e -> System.out.println("OK button clicked"));

		// lambda expression
		btOK1.setOnAction((ActionEvent e) -> {
			System.out.println("OK1 button clicked");
		});

		// lambda expression: Since SetOnAction's handler takes ActionEvent parameter,
		// and compiler can infer that the type is ActionEvent, so the parameter type ActionEvent can be omitted
		btOK2.setOnAction((e) -> {
			System.out.println("OK2 button clicked");
		});

		// lambda expression: if only one parameter and type can be omitted, 
		// () around the parameter can also be omitted.
		btOK3.setOnAction(e -> {
			System.out.println("OK3 button clicked");
		});

		// lambda expression: if the method has only one statement, {} can be omitted.
		btOK4.setOnAction(e -> System.out.println("OK4 button clicked"));


		// anonymous inner class
//		btCancel.setOnAction(new EventHandler<ActionEvent> () {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("Cancel button clicked");
//			}
//		});
		
		btCancel.setOnAction(e -> System.out.println("Cancel button clicked"));


		pane.getChildren().addAll(btOK, btOK1, btOK2, btOK3, btOK4, btCancel);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("HandleEvent"); // Set the stage title
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



