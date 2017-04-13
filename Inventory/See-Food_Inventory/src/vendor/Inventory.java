package vendor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Inventory extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bp = new BorderPane();
		MyPane mp = new MyPane();
		bp.setCenter(mp);
		Scene scene = new Scene (bp, 400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("See-Food ");
		primaryStage.show();
		mp.requestFocus();
		
		
	}
	


public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}

class MyPane extends Pane {
	
	
}
}