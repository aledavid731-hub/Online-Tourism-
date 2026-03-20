package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView {

    public void show(Stage stage) {

        Label title = new Label("Register");

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerBtn = new Button("Submit");
        Button backBtn = new Button("Back to Login");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                title,
                nameField,
                emailField,
                usernameField,
                passwordField,
                registerBtn,
                backBtn
        );

        Scene scene = new Scene(layout, 400, 400);

        stage.setTitle("Register");
        stage.setScene(scene);

        // --- Button Actions ---
        registerBtn.setOnAction(_ -> {
            System.out.println("Registered: " + usernameField.getText());
        });

        backBtn.setOnAction(_ -> {
            loginview login = new loginview();
            login.show(stage);   // 🔙 BACK TO LOGIN
        });
    }
}