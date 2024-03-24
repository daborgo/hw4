package hw4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class hw4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    private Stage primStage;

    public void start(Stage primaryStage) {
    	System.out.println("Running application...");
        this.primStage = primaryStage;
        primStage.setTitle("Application");
        
        Text title = new Text("Welcome to Heart Health Imaging and Recording System");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 16));

        VBox mainUI = new VBox(10);
        mainUI.setAlignment(Pos.CENTER);
        mainUI.setSpacing(30);
        mainUI.getChildren().add(title);

        Button patIntButton = new Button("Patient Intake");
        patIntButton.setFont(Font.font("Verdana", 16));
        patIntButton.setMinWidth(200);
        patIntButton.setMinHeight(60);
        patIntButton.setOnAction(e -> patientIntake());

        Button ctScanTechButton = new Button("CT Scan Tech View");
        ctScanTechButton.setFont(Font.font("Verdana", 16));
        ctScanTechButton.setMinWidth(200);
        ctScanTechButton.setMinHeight(60);
        ctScanTechButton.setOnAction(e -> ctScanTechView());

        Button patViewButton = new Button("Patient View");
        patViewButton.setFont(Font.font("Verdana", 16));
        patViewButton.setMinWidth(200);
        patViewButton.setMinHeight(60);
        patViewButton.setOnAction(e -> patientView());

        mainUI.getChildren().addAll(patIntButton, ctScanTechButton, patViewButton);

        Scene scene = new Scene(mainUI, 600, 400);
        primStage.setScene(scene);
        primStage.show();
    }

    private void patientIntake() {
        System.out.println("Opening Patient Intake...");
        primStage.setTitle("Receptionist View");
        
        Text title = new Text("Patient Intake Form");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        
        VBox intakeUI = new VBox(10);
        intakeUI.setAlignment(Pos.CENTER);
        intakeUI.setSpacing(5);
        intakeUI.getChildren().add(title);

        VBox labels = new VBox(20);
        Label fnLabel = new Label("First Name:");
        Label lnLabel = new Label("Last Name:");
        Label emailLabel = new Label("Email:");
        Label pnLabel = new Label("Phone Number:");
        Label hhLabel = new Label("Health History:");
        Label idLabel = new Label("Insurance ID:");
        labels.getChildren().addAll(fnLabel, lnLabel, emailLabel, pnLabel, hhLabel, idLabel);
        
        VBox fields = new VBox(10);
        TextField fnField = new TextField();
        fnField.setMinWidth(240);
        TextField lnField = new TextField();
        lnField.setMinWidth(240);
        TextField emailField = new TextField();
        emailField.setMinWidth(240);
        TextField pnField = new TextField();
        pnField.setMinWidth(240);
        TextField hhField = new TextField();
        hhField.setMinWidth(240);
        TextField idField = new TextField();
        idField.setMinWidth(240);
        fields.getChildren().addAll(fnField, lnField, emailField, pnField, hhField, idField);
        
        HBox columns = new HBox(20);
        columns.setPadding(new Insets(10,0,10,20));
        columns.getChildren().addAll(labels, fields);
        
        
        Button save = new Button("Save");
        save.setFont(Font.font("Verdana", 16));
        save.setMinWidth(100);
        save.setMinHeight(30);
        save.setOnAction(e -> {
            System.out.println("- Saved data!");
        });

        intakeUI.getChildren().addAll(columns, save);

        Scene scene = new Scene(intakeUI, 400, 400);
        primStage.setScene(scene);
    }

    private void ctScanTechView() {
        System.out.println("Opening CT Scan...");
        primStage.setTitle("Technician View");
        
        VBox intakeUI = new VBox(10);
        intakeUI.setSpacing(5);

        VBox labels1 = new VBox(20);
        Label idLabel = new Label("Patient ID:");
        Label scoreLabel = new Label("The total Agatston CAC score");
        labels1.getChildren().addAll(idLabel, scoreLabel);
        
        VBox fields1 = new VBox(10);
        TextField idField = new TextField();
        idField.setMinWidth(240);
        TextField scoreField = new TextField();
        scoreField.setMinWidth(240);
        fields1.getChildren().addAll(idField, scoreField);
        
        HBox columns1 = new HBox(20);
        columns1.setPadding(new Insets(40,0,10,20));
        columns1.getChildren().addAll(labels1, fields1);
        
        Text title = new Text("    Vessel Level Agatston CAC score");
        title.setFont(Font.font("Verdana", 14));
        
        VBox labels2 = new VBox(20);
        Label lmLabel = new Label("LM:");
        Label ladLabel = new Label("LAD:");
        Label lcxLabel = new Label("LCX:");
        Label rcaLabel = new Label("RCA:");
        Label pdaLabel = new Label("PDA:");
        labels2.getChildren().addAll(lmLabel, ladLabel, lcxLabel, rcaLabel, pdaLabel);
        
        VBox fields2 = new VBox(10);
        TextField lmField = new TextField();
        TextField ladField = new TextField();
        TextField lcxField = new TextField();
        TextField rcaField = new TextField();
        TextField pdaField = new TextField();
        fields2.getChildren().addAll(lmField, ladField, lcxField, rcaField, pdaField);
        
        HBox columns2 = new HBox(20);
        columns2.setPadding(new Insets(10,0,10,20));
        columns2.getChildren().addAll(labels2, fields2);
        
        HBox saveBox = new HBox(20);
        saveBox.setAlignment(Pos.CENTER);
        Button save = new Button("Save");
        save.setFont(Font.font("Verdana", 16));
        save.setMinWidth(100);
        save.setMinHeight(30);
        save.setOnAction(e -> {
            System.out.println("- Saved data!");
        });
        saveBox.getChildren().add(save);

        intakeUI.getChildren().addAll(columns1, title, columns2, saveBox);

        Scene scene = new Scene(intakeUI, 470, 400);
        primStage.setScene(scene);
    }

    private void patientView() {
        System.out.println("Opening Patient View...");
    }
}