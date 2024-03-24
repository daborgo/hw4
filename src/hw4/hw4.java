package hw4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
        Label errorLabel = new Label();
        save.setFont(Font.font("Verdana", 16));
        save.setMinWidth(100);
        save.setMinHeight(30);
        save.setOnAction(e -> {
        	if(fnField.getText().isEmpty() || lnField.getText().isEmpty() || emailField.getText().isEmpty() || pnField.getText().isEmpty() || hhField.getText().isEmpty() || idField.getText().isEmpty()) {
        		errorLabel.setText("Error: One or more fields are empty.");
        	} else {
        		Random r = new Random();
            	String patientID = String.valueOf(r.nextInt(90000)+10000);
            	FileWriter fw;
				try {
					fw = new FileWriter(patientID + "_PatientInfo.txt");
	            	fw.write(fnField.getText() + "\n");
	            	fw.write(lnField.getText() + "\n");
	            	fw.write(emailField.getText() + "\n");
	            	fw.write(pnField.getText() + "\n");
	            	fw.write(hhField.getText() + "\n");
	            	fw.write(idField.getText() + "\n");
	            	fw.close();
	            	save.setDisable(true);
	            	save.setVisible(false);
				} catch (IOException e1) {
					System.out.println("Error: Write failed.");
					e1.printStackTrace();
				}
            	errorLabel.setText("Saved data! Patient ID: " + patientID);
                System.out.println("- Saved data!");
        	}
        });

        intakeUI.getChildren().addAll(columns, save, errorLabel);

        Scene scene = new Scene(intakeUI, 400, 400);
        primStage.setScene(scene);
    }

    private void ctScanTechView() {
        System.out.println("Opening CT Scan...");
        primStage.setTitle("Technician View");
        
        VBox scanUI = new VBox(10);
        scanUI.setSpacing(5);

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
        
        Text header = new Text("    Vessel Level Agatston CAC score");
        header.setFont(Font.font("Verdana", 14));
        
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
        Label errorLabel = new Label();
        save.setFont(Font.font("Verdana", 16));
        save.setMinWidth(100);
        save.setMinHeight(30);
        save.setOnAction(e -> {
        	if(idField.getText().isEmpty() || scoreField.getText().isEmpty() || lmField.getText().isEmpty() || ladField.getText().isEmpty() || lcxField.getText().isEmpty() || rcaField.getText().isEmpty() || pdaField.getText().isEmpty()) {
        		errorLabel.setText("Error: One or more fields are empty.");
        	} else {
        		FileWriter fw;
				try {
					fw = new FileWriter(idField.getText() + "CTResults.txt");
	            	fw.write(scoreField.getText() + "\n");
	            	fw.write(lmField.getText() + "\n");
	            	fw.write(ladField.getText() + "\n");
	            	fw.write(lcxField.getText() + "\n");
	            	fw.write(rcaField.getText() + "\n");
	            	fw.write(pdaField.getText() + "\n");
	            	fw.close();
	            	save.setDisable(true);
	            	save.setVisible(false);
				} catch (IOException e1) {
					System.out.println("Error: Write failed.");
					e1.printStackTrace();
				}
        		errorLabel.setText("Saved scan results!");
        		System.out.println("- Saved scan results!");
        	}
        });
        saveBox.getChildren().addAll(save, errorLabel);

        scanUI.getChildren().addAll(columns1, header, columns2, saveBox);

        Scene scene = new Scene(scanUI, 470, 400);
        primStage.setScene(scene);
    }

    private void patientView() {
        System.out.println("Opening Patient View...");
        primStage.setTitle("Patient View");
        
        VBox patientUI = new VBox(10);
        patientUI.setSpacing(5);
        
        HBox titleBox = new HBox(10);
        titleBox.setAlignment(Pos.CENTER);
        Text title = new Text("Hello <Patient Name>");
        title.setFont(Font.font("Verdana", 14));
        titleBox.getChildren().add(title);
        
        HBox scoreBox = new HBox(20);
        Label scoreLabel = new Label("The total Agatston CAC score");
        TextArea scoreField = new TextArea();
        scoreField.setEditable(false);
        scoreField.setPrefWidth(240);
        scoreField.setPrefHeight(5);
        scoreBox.setPadding(new Insets(20,0,10,20));
        scoreBox.getChildren().addAll(scoreLabel, scoreField);
        
        VBox labels = new VBox(20);
        Label lmLabel = new Label("LM:");
        Label ladLabel = new Label("LAD:");
        Label lcxLabel = new Label("LCX:");
        Label rcaLabel = new Label("RCA:");
        Label pdaLabel = new Label("PDA:");
        labels.getChildren().addAll(lmLabel, ladLabel, lcxLabel, rcaLabel, pdaLabel);
        
        VBox fields = new VBox(10);
        TextField lmField = new TextField();
        TextField ladField = new TextField();
        TextField lcxField = new TextField();
        TextField rcaField = new TextField();
        TextField pdaField = new TextField();
        fields.getChildren().addAll(lmField, ladField, lcxField, rcaField, pdaField);
        
        HBox columns = new HBox(20);
        columns.setPadding(new Insets(10,0,10,20));
        columns.getChildren().addAll(labels, fields);
        
        patientUI.getChildren().addAll(titleBox, scoreBox, columns);
        patientUI.setAlignment(Pos.CENTER);

        Scene scene = new Scene(patientUI, 470, 400);
        primStage.setScene(scene);
    }
}