package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.UUID;

public class BookingConfirmationView {

    public void show(Stage stage, String packageName, String price, String duration, String userName) {

        stage.setTitle("Booking Confirmation");

        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        // Generate booking ID
        String bookingID = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Labels
        Label thankYouLabel = new Label("Thank you " + userName + "!");
        thankYouLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        Label confirmedLabel = new Label("Your booking is confirmed.");
        confirmedLabel.setStyle("-fx-font-size: 16px;");

        Label packageLabel = new Label("Package: " + packageName);
        Label priceLabel = new Label("Price: " + price);
        Label durationLabel = new Label("Duration: " + duration);
        Label bookingIDLabel = new Label("Booking ID: " + bookingID);

        // Buttons
        Button homeBtn = new Button("Back to Home");

        homeBtn.setOnAction(_ -> {
            try {
                HomeScreenView home = new HomeScreenView();
                home.show(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout
        root.getChildren().addAll(
                thankYouLabel,
                confirmedLabel,
                packageLabel,
                priceLabel,
                durationLabel,
                bookingIDLabel,
                homeBtn
        );

        Scene scene = new Scene(root, 450, 450);
        stage.setScene(scene);
        stage.show();
    }
}