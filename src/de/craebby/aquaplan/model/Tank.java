package de.craebby.aquaplan.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tank {
	//Tank Variables
	private final StringProperty name;
	private final StringProperty location;
	private final IntegerProperty size; //Liter
	private final StringProperty dimensions; //LxBxH
	private final StringProperty light;
	private final StringProperty filter;
	private final StringProperty heater;
	private final ObjectProperty<LocalDate> operatingDate;
	
	public Tank() {
		this.name = new SimpleStringProperty();
		this.location = new SimpleStringProperty();
		this.size = new SimpleIntegerProperty();
		this.dimensions = new SimpleStringProperty();
		this.light = new SimpleStringProperty();
		this.filter = new SimpleStringProperty();
		this.heater = new SimpleStringProperty();
		this.operatingDate = new SimpleObjectProperty<LocalDate>();
	}
	
	public Tank(String name, String location,Integer size) {
		this.name = new SimpleStringProperty(name);
		this.location = new SimpleStringProperty(location);
		this.size = new SimpleIntegerProperty(size);
		this.dimensions = new SimpleStringProperty();
		this.light = new SimpleStringProperty();
		this.filter = new SimpleStringProperty();
		this.heater = new SimpleStringProperty();
		this.operatingDate = new SimpleObjectProperty<LocalDate>();
	}
	
	
	
	public final StringProperty nameProperty() {
		return this.name;
	}
	
	public final String getName() {
		return this.nameProperty().get();
	}
	
	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	
	public final StringProperty locationProperty() {
		return this.location;
	}
	
	public final String getLocation() {
		return this.locationProperty().get();
	}
	
	public final void setLocation(final String location) {
		this.locationProperty().set(location);
	}
	
	public final IntegerProperty sizeProperty() {
		return this.size;
	}
	
	public final int getSize() {
		return this.sizeProperty().get();
	}
	
	public final void setSize(final int size) {
		this.sizeProperty().set(size);
	}
	
	public final StringProperty dimensionsProperty() {
		return this.dimensions;
	}
	
	public final String getDimensions() {
		return this.dimensionsProperty().get();
	}
	
	public final void setDimensions(final String dimensions) {
		this.dimensionsProperty().set(dimensions);
	}
	
	public final StringProperty lightProperty() {
		return this.light;
	}
	
	public final String getLight() {
		return this.lightProperty().get();
	}
	
	public final void setLight(final String light) {
		this.lightProperty().set(light);
	}
	
	public final StringProperty filterProperty() {
		return this.filter;
	}
	
	public final String getFilter() {
		return this.filterProperty().get();
	}
	
	public final void setFilter(final String filter) {
		this.filterProperty().set(filter);
	}
	
	public final StringProperty heaterProperty() {
		return this.heater;
	}
	
	public final String getHeater() {
		return this.heaterProperty().get();
	}
	
	public final void setHeater(final String heater) {
		this.heaterProperty().set(heater);
	}
	
	public final ObjectProperty<LocalDate> operatingDateProperty() {
		return this.operatingDate;
	}
	
	public final LocalDate getOperatingDate() {
		return this.operatingDateProperty().get();
	}
	
	public final void setOperatingDate(final LocalDate operatingDate) {
		this.operatingDateProperty().set(operatingDate);
	}
	
	
		

}
