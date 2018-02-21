import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class rectangle extends Application{ 

	public static void main(String []args){
	launch(args);
	
	}
	@Override
	public void start(Stage primaryStage)	{
	
		primaryStage.setTitle("Area and Perimeter of rectangle");
		
		GridPane grid = new GridPane();

		Scene firstScene = new Scene(grid, 400,400);

		primaryStage.setScene(firstScene);

		Label instructionLb = new Label("Finding  the Area and the peritemer of a rectangle");
		Label lengthLb = new Label("Lenght");

		TextField lengthTxt = new TextField();
		lengthTxt.setMinWidth(4);

		Label widthLb = new Label("Width");
		TextField widthTxt = new TextField(); 

		Button findBt = new Button("Find");

		findBt.setOnAction(new EventHandler<ActionEvent>(){
		

				@Override
				public void handle(ActionEvent arg0) {
					
					// TODO Auto-generated method stub
					int length = Integer.parseInt(lengthTxt.getText());
					int width = Integer.parseInt(widthTxt.getText());

					
					primaryStage.setScene(resultScene(primaryStage, length, width));
				
				}
	});
	grid.add(instructionLb, 1,0);
	
	grid.add(lengthLb, 0,1);
	grid.add(lengthTxt,1,1);

	grid.add(widthLb,0,2);
	grid.add(widthTxt,1,2);

	grid.add(findBt,1,3);

	primaryStage.show();
	
	}
Scene resultScene(Stage primaryStage, int width, int length) {
GridPane grid = new GridPane();

 int area = width * length;
 int perimeter = 2*width + 2 * length;
 
Label areaLB = new Label("The area of rectangle: " + area);
Label perimeterLb = new Label("The perimeter of rectangle: " + perimeter);

grid.add(perimeterLb, 0, 1);
grid.add(areaLB, 0, 2);

Scene myScene = new Scene(grid, 300, 200);
return myScene;
}
	}	
