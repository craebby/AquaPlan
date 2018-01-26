package de.craebby.aquaplan.view;

import de.craebby.aquaplan.MainApp;
import de.craebby.aquaplan.model.Tank;
import de.craebby.aquaplan.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TankOverviewController {
	@FXML
	private TableView<Tank> tankTable;
	@FXML
	private TableColumn<Tank, String> nameCol;
	@FXML
	private TableColumn<Tank, String> locationCol;
	@FXML
	private TableColumn<Tank, Number> sizeCol;
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label locationLabel;
	@FXML
	private Label sizeLabel;
	@FXML
	private Label dimLabel;
	@FXML
	private Label lightLabel;
	@FXML
	private Label filterLabel;
	@FXML
	private Label heaterLabel;
	@FXML
	private Label operatingLabel;
	/*
	@FXML
	private Label nameLabel;
	@FXML
	private Label nameLabel;
	*/
	
	private MainApp mainApp;
	
	public TankOverviewController() {
		
	}
	
	@FXML
	private void initialize() {
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		locationCol.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
		sizeCol.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());
		
		//Clear tank details
		showTankDetails(null);
		
		
		//Listen for selection changes
		tankTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showTankDetails(newValue));
	}
	
	
	private void showTankDetails(Tank tank) {
		if (tank != null) {
			//Fill the labels from the tank object
			nameLabel.setText(tank.getName());
			locationLabel.setText(tank.getLocation());
			sizeLabel.setText(Integer.toString(tank.getSize()));
			dimLabel.setText(tank.getDimensions());
			lightLabel.setText(tank.getLight());
			filterLabel.setText(tank.getFilter());
			heaterLabel.setText(tank.getHeater());
			operatingLabel.setText(DateUtil.format(tank.getOperatingDate()));
		} else {
			nameLabel.setText("");
			locationLabel.setText("");
			sizeLabel.setText("");
			dimLabel.setText("");
			lightLabel.setText("");
			filterLabel.setText("");
			heaterLabel.setText("");
			operatingLabel.setText("");
		}
		
		
		
	}
	
	@FXML
	private void handleDeleteTank() {
		int selectedIndex = tankTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >=0) {
			tankTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("Kein Aquarium ausgewählt");
			alert.setContentText("Bitte wähle ein Aquarium in der Liste aus.");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleNewTank() {
	    Tank tempTank = new Tank();
	    boolean okClicked = mainApp.showTankEditDialog(tempTank);
	    if (okClicked) {
	        mainApp.getTankData().add(tempTank);
	    }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditTank() {
	    Tank selectedTank = tankTable.getSelectionModel().getSelectedItem();
	    if (selectedTank != null) {
	        boolean okClicked = mainApp.showTankEditDialog(selectedTank);
	        if (okClicked) {
	            showTankDetails(selectedTank);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("Keine Auswahl");
	        alert.setHeaderText("Kein Aquarium ausgewählt");
	        alert.setContentText("Wähle ein Aquarium aus der Liste.");

	        alert.showAndWait();
	    }
	}
	
	//Called by MainApp to give reference back to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		
		//Add observable list data to the Table
		tankTable.setItems(mainApp.getTankData());
	}
	

}
