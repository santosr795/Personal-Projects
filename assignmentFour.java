import javax.swing.JOptionPane; 
 
public class assignmentFour {
	public static void main(String []args){
	String dogMessage;
	int numDog = Integer.parseInt(JOptionPane.showInputDialog(null,"How many dogs you have"));
	if (numDog < 0) {
		dogMessage = "Not valid input";
	}//End if
	else if (numDog == 0){
	dogMessage = "You really should get a dog. They're great pets.";
	}//End else if
	else{
	switch(numDog) {
		case 1:dogMessage = "Glad you have a dog";break;
		case 2:dogMessage ="Two dogs are better than one."; break; 
		case 3:dogMessage = "Three dogs is a lot.";  break; 
		case 4:dogMessage = "Four Dogs  is too many Dogs"; break;
		case 5:dogMessage = "Five dogs means you are a crazy person,"; break;
		default:dogMessage = "That is totally unblieveable";	break;
	}//End Switch
	}//End else
	
JOptionPane.showMessageDialog(null, dogMessage);
JOptionPane.showMessageDialog(null, "Good by from Ronald Santos");
	
		}//end main 
}//end class
