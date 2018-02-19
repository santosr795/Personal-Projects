import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AccountFx extends Application {
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	
		public void start(Stage primaryStage)
		{

			primaryStage.setTitle("Account information");

			GridPane panel = new GridPane();

			Scene firscene = new Scene(panel, 400,400);

			primaryStage.setScene(firscene);


//Labels and TextFields with instructions.

			Label instructionLb = new Label("Create an Account");

			Label nameLb = new Label("Name");
			TextField nameTxt = new TextField();


			Label lastLb = new Label("Last Name");
			TextField lastTxt = new TextField();
		

			Label ageLb = new Label("Age");
			TextField ageTxt = new TextField();

			Label dobLb = new Label("Date of Birth");
			TextField dobTxt = new TextField();
			

			Label emailLb = new Label("Email");
			TextField emailTxt = new TextField();

		

			Button createdBt = new Button("Create");
//Making the a functional button.[MaY4

			createdBt.setOnAction(new EventHandler<ActionEvent>(){
				
				
			

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
				int age = Integer.parseInt(ageTxt.getText());
				String name = nameTxt.getText();
				String last = lastTxt.getText();
				String dob = dobTxt.getText();
				String email = emailTxt.getText();
				System.out.println(last);
				
				primaryStage.setScene(resultScene(primaryStage, age, name, last, dob, email));
					
				}

				
			
				});
// this will make Label and TextField to appear in the panel.

		panel.add(instructionLb, 1, 0);

		panel.add(nameLb,0,1);
		panel.add(nameTxt, 1,1);

		panel.add(lastLb, 0,2);
		panel.add(lastTxt,1,2);
		
		panel.add(ageLb,0,3);
		panel.add(ageTxt, 1,3);
		
		panel.add(dobLb, 0,4);
		panel.add(dobTxt, 1,4);

		panel.add(emailLb,0,5);
		panel.add(emailTxt,1,5);


		panel.add(createdBt, 1,6);

		
		primaryStage.show();
				
		}

	Scene	resultScene(Stage primaryStage, int age, String name, String last, String dob, String email){
	GridPane grid = new GridPane();

	Label nameLb = new Label("Name: " + name);
	Label lastLb = new Label("Last Name: " + last);
	Label ageLb = new Label("age: " + age);
	Label dobLb = new Label("Date of Birthday: " + dob );
	Label emailLb = new Label("Email: " + email);


	grid.add( nameLb, 0,0);
	grid.add( lastLb, 0,1);
	grid.add(ageLb, 0,2);
	grid.add(dobLb, 0,3);
	grid.add(emailLb,0,4);

	Scene myScene = new Scene(grid, 400,400);
	return myScene;
	
	
	





}
}
