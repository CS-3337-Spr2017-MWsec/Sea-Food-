package vendor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Inventory extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(20, 20, 20, 20));
		Button Inventory = new Button("Inventory");
		bPane.setBottom(Inventory);
		Scene scene = new Scene (bPane, 400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("See-Food ");
		primaryStage.show();
	}
	


public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}

class MyPane extends Pane {
	
	
}
}