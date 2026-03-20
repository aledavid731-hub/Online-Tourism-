package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

import view.loginview;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			loginview loginView = new loginview();
	        loginView.show(primaryStage); // call the login view
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}