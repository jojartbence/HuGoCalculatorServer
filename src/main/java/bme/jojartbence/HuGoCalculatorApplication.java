package bme.jojartbence;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * Base class of the application.
 * Handles java fx UI initialization.
 * Uses Spring framework.
 */
@SpringBootApplication
public class HuGoCalculatorApplication extends Application {
	
	private ConfigurableApplicationContext springContext;
	private Parent rootNode;

	/**
	 * Main method. 
	 * 
	 * @param args Args to java fx framework.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	/**
	 * Has to be implemented in case of java fx application.
	 * Initialises components so spring and java fx framework can work together.
	 * 
	 * @throws Exception in case of error. In this case the application stops.
	 */
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(HuGoCalculatorApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/javafx/movements.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
	}

	/**
	 * Has to be implemented in case of java fx application.
	 * 
	 * @param stage Stage received from the java fx framework.
	 * @throws Exception in case of error. In this case the application stops.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(rootNode));
		stage.show();
	}

	/**
	 * Has to be implemented in case of java fx application.
	 * 
	 * @throws Exception in case of error. In this case the application stops.
	 */
	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
