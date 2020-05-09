package bme.jojartbence;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.*;
import javafx.scene.Parent;
import javafx.stage.Stage;


@SpringBootApplication
public class UtdijKalkulatorApplication extends Application {
	
	private ConfigurableApplicationContext springContext;
	private Parent rootNode;

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(UtdijKalkulatorApplication.class);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
