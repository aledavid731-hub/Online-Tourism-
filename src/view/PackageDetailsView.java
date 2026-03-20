package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PackageDetailsView {

    // Full method
    public void show(Stage stage, String packageName, String description, String price, String duration) {

        stage.setTitle("Package Details - " + packageName);

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        // Package Name
        Label nameLabel = new Label(packageName);
        nameLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Description
        Label descLabel = new Label(description);
        descLabel.setWrapText(true);
        descLabel.setMaxWidth(400);

        // Price
        Label priceLabel = new Label("Price: " + price);
        priceLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Duration
        Label durationLabel = new Label("Duration: " + duration);
        durationLabel.setStyle("-fx-font-size: 16px;");

        // Book Button
        Button bookBtn = new Button("Book Now");
        bookBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        bookBtn.setOnAction(_ -> {
            BookingConfirmationView confirmPage = new BookingConfirmationView();
            confirmPage.show(stage, packageName, price, duration, "David Ale");
        });

        root.getChildren().addAll(
                nameLabel,
                descLabel,
                durationLabel,
                priceLabel,
                bookBtn
        );

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    // Default method (for testing)
    public void show(Stage stage) {
        show(stage,
                "Everest Base Camp Trek",
                "8 days trek to Everest Base Camp",
                "USD 1200",
                "8 days"
        );
    }
}