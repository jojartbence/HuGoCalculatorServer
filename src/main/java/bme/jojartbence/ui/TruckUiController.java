package bme.jojartbence.ui;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bme.jojartbence.service.MovementService;
import bme.jojartbence.service.TruckService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

@Component
public class TruckUiController {
	
	@FXML private Text trucksText;
	@FXML private ListView<String> trucks;
		
	@Autowired
	private TruckService truckService;
	
	public void refresh() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ArrayList<String> licensePlateNumbers = new ArrayList<String>();
				truckService.getAllTrucks().forEach(truck -> licensePlateNumbers.add(truck.getLicensePlateNumber()));
				
				ObservableList<String> truckLicensePlateNumbers = FXCollections.observableArrayList(licensePlateNumbers);
				trucks.setItems(truckLicensePlateNumbers);
			}
		});
	}
}
