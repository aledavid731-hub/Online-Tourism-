package view;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HomeScreenView {

    public void show(Stage stage) {

        BorderPane root = new BorderPane();

        // ================= NAVBAR =================
        HBox navbar = new HBox(20);
        navbar.setPadding(new Insets(15));
        navbar.setAlignment(Pos.CENTER_LEFT);
        navbar.setStyle("-fx-background-color: #f5f5f5;");

        Label logo = new Label("Nepal Travel");
        logo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c5364;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button homeBtn = new Button("Home");
        Button packageBtn = new Button("Packages");

        navbar.getChildren().addAll(logo, spacer, homeBtn, packageBtn);

        // ================= CENTER =================
        VBox center = new VBox(20);
        center.setPadding(new Insets(40));
        center.setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Discover Nepal");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        Label subtitle = new Label("Your journey starts here");
        subtitle.setStyle("-fx-text-fill: gray;");

        Label tagline = new Label("Explore mountains, culture, and adventure like never before!");
        tagline.setStyle("-fx-font-size: 16px;");

        TextField search = new TextField();
        search.setPromptText("Search destinations...");
        search.setPrefWidth(350);

        // Quick Buttons
        HBox quickButtons = new HBox(15);
        quickButtons.setAlignment(Pos.CENTER);

        Button exploreBtn = new Button("Explore");
        Button dealsBtn = new Button("Top Deals");

        quickButtons.getChildren().addAll(exploreBtn, dealsBtn);

        // Stats
        HBox stats = new HBox(40);
        stats.setAlignment(Pos.CENTER);

        stats.getChildren().addAll(
                createStat("50+", "Destinations"),
                createStat("1000+", "Travelers"),
                createStat("30+", "Packages")
        );

        // Features
        VBox features = new VBox(8);
        features.setAlignment(Pos.CENTER);

        Label featureTitle = new Label("Why Choose Us?");
        featureTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        Label f1 = new Label("✔ Affordable prices");
        Label f2 = new Label("✔ Experienced guides");
        Label f3 = new Label("✔ Safe & reliable");

        features.getChildren().addAll(featureTitle, f1, f2, f3);

        center.getChildren().addAll(title, subtitle, tagline, search, quickButtons, stats, features);

        root.setTop(navbar);
        root.setCenter(center);

        // ================= BUTTON ACTION =================
        packageBtn.setOnAction(_ -> {
            PackageView pv = new PackageView();
            pv.show(stage);
        });

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }

    private VBox createStat(String number, String text) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);

        Label num = new Label(number);
        num.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label txt = new Label(text);
        txt.setStyle("-fx-text-fill: gray;");

        box.getChildren().addAll(num, txt);
        return box;
    }
}