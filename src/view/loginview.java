package view;

import controller.LoginControl;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class loginview {

    public void show(Stage stage) {
        stage.setTitle("Login");

        // LEFT SIDE
        VBox leftPane = new VBox(10);
        leftPane.setPadding(new Insets(50));
        leftPane.setAlignment(Pos.CENTER_LEFT);
        leftPane.setStyle("-fx-background-color: #2c5364;");

        Label titleLeft = new Label("Discover Nepal");
        titleLeft.setStyle("-fx-text-fill: white; -fx-font-size: 36px; -fx-font-weight: bold;");

        Label subtitleLeft = new Label("Your gateway to the Himalayas and beyond");
        subtitleLeft.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");

        leftPane.getChildren().addAll(titleLeft, subtitleLeft);

        // RIGHT SIDE
        VBox rightPane = new VBox(15);
        rightPane.setPadding(new Insets(40));
        rightPane.setAlignment(Pos.CENTER);

        Label title = new Label("Online Tourism Booking");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        CheckBox adminCheck = new CheckBox("Login as Admin");

        Button loginBtn = new Button("Sign In");
        loginBtn.setPrefWidth(200);

        Button registerBtn = new Button("Register");
        registerBtn.setPrefWidth(200);

        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(loginBtn, registerBtn);

        // CONTROLLER
        LoginControl loginControl = new LoginControl();

        // ✅ FIXED LOGIN ACTION
        loginBtn.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            boolean isValid = loginControl.validateUser(username, password);

            if (isValid) {

                // ✅ SUCCESS MESSAGE (ADDED)
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Login Successful!");
                alert.showAndWait();

                // Go to Home Screen
                HomeScreenView home = new HomeScreenView();
                home.show(stage);

            } else {

                // ❌ ERROR MESSAGE
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password!");
                alert.showAndWait();
            }
        });

        // REGISTER ACTION
        registerBtn.setOnAction(e -> {
            RegisterView reg = new RegisterView();
            reg.show(stage);
        });

        rightPane.getChildren().addAll(
                title,
                new Label("Username"), usernameField,
                new Label("Password"), passwordField,
                adminCheck,
                buttonBox
        );

        // MAIN LAYOUT
        HBox root = new HBox();
        root.getChildren().addAll(leftPane, rightPane);

        HBox.setHgrow(leftPane, Priority.ALWAYS);
        HBox.setHgrow(rightPane, Priority.ALWAYS);

        Scene scene = new Scene(root, 900, 500);
        stage.setScene(scene);
        stage.show();
    }
}