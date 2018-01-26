package de.craebby.aquaplan.view;

import de.craebby.aquaplan.model.Tank;
import de.craebby.aquaplan.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TankEditDialogController {
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField locationField;
	@FXML
	private TextField sizeField;
	@FXML
	private TextField dimensionField;
	@FXML
	private TextField lightField;
	@FXML
	private TextField filterField;
	@FXML
	private TextField heaterField;
	@FXML
	private TextField operatingField;
	
	private Stage dialogStage;
	private Tank tank;
	private boolean okClicked = false;
	
	
	@FXML
	private void initalize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setTank(Tank tank) {
		this.tank = tank;
		nameField.setText(tank.getName());
		locationField.setText(tank.getLocation());
		sizeField.setText(Integer.toString(tank.getSize()));
		dimensionField.setText(tank.getDimensions());
		lightField.setText(tank.getLight());
		filterField.setText(tank.getFilter());
		heaterField.setText(tank.getHeater());
		operatingField.setText(DateUtil.format(tank.getOperatingDate()));
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOK() {
		if (isInputValid()) {
			tank.setName(nameField.getText());
			tank.setSize(Integer.parseInt(sizeField.getText()));
			tank.setLocation(locationField.getText());
			tank.setDimensions(dimensionField.getText());
			tank.setFilter(filterField.getText());
			tank.setLight(lightField.getText());
			tank.setHeater(heaterField.getText());
			if (operatingField.getText() != null && operatingField.getText().length() > 0) {
				tank.setOperatingDate(DateUtil.parse(operatingField.getText()));
			}
			
			okClicked = true;
			dialogStage.close();
		}
	}
	
	/**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
	
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (nameField.getText() == null || nameField.getText().length() == 0) {
			errorMessage += "Kein gültiger Name!\n";
		}
		
		if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
	}

}
