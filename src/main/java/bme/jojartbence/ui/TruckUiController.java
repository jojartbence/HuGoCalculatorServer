package bme.jojartbence.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bme.jojartbence.service.TruckService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * Controller class of the java fx UI.
 */
@Component
public class TruckUiController implements Initializable {
	
	/**
	 * FXML field with the text "Trucks"
	 */
	@FXML private Text trucksText;
	
	/**
	 * FXML list view with the license plate numbers of the trucks.
	 */
	@FXML private ListView<String> trucks;
		
	/**
	 * Service to obtain the list of trucks.
	 */
	@Autowired
	private TruckService truckService;
	
	/**
	 * Refreshes UI in a separate UI thread.
	 */
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

	/**
	 * Called after initializing java fx UI.
	 * Refreshes UI.
	 * 
	 * @param location Not used
	 * @param resources Not used
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refresh();
	}
}
