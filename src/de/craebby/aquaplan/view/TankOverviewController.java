package de.craebby.aquaplan.view;

import de.craebby.aquaplan.MainApp;
import de.craebby.aquaplan.model.Tank;
import javafx.fxml.FXML;
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
	}
	
	//Called by MainApp to give rederence back to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		
		//Add observable list data to the Table
		tankTable.setItems(mainApp.getTankData());
	}
	

}
