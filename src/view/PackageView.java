package view;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PackageView {

    public void show(Stage stage) {

        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.TOP_CENTER);

        // 🔙 BACK BUTTON
        Button backBtn = new Button("⬅ Back to Home");

        backBtn.setOnAction(_ -> {
            HomeScreenView home = new HomeScreenView();
            home.show(stage);
        });

        Label title = new Label("Available Packages");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        HBox cards = new HBox(20);
        cards.setAlignment(Pos.CENTER);

        cards.getChildren().addAll(
                createCard("Everest Base Camp Trek", "Khumbu", "12 Days", "292500",
                        "🏔 Everest Base Camp\n🚶 Guided trek\n🏕 Mountain stay\n📸 Views"),

                createCard("Pokhara Retreat", "Pokhara", "5 Days", "77870",
                        "🚤 Boating\n🌄 Sunrise\n🧘 Relaxation\n🏞 Nature"),

                createCard("Kathmandu Tour", "Kathmandu", "3 Days", "51870",
                        "🛕 Temples\n🎭 Culture\n🛍 Markets")
        );

        root.getChildren().addAll(backBtn, title, cards);

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Packages");
        stage.show();
    }

    private VBox createCard(String title, String location, String duration, String price, String details) {

        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setPrefWidth(250);
        card.setStyle("-fx-background-color: white; -fx-border-color: #ddd;");

        Label t = new Label(title);
        t.setStyle("-fx-font-weight: bold;");

        Label l = new Label("📍 " + location);
        Label d = new Label("📅 " + duration);
        Label p = new Label("Rs. " + price + "/-");

        Label detail = new Label(details);
        detail.setWrapText(true);

        Button bookBtn = new Button("Book Now");

        bookBtn.setOnAction(_ -> {
            BookingConfirmationView booking = new BookingConfirmationView();
            booking.show(new Stage(), title, price, duration, "User");
        });

        card.getChildren().addAll(t, l, d, p, detail, bookBtn);

        return card;
    }
}