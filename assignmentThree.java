import javax.swing.JOptionPane;

public class assignmentThree {
public static void main(String []args) {
//part one 
	
String userName, passWord,passWordTwo, access;  

userName =  JOptionPane.showInputDialog(null, "Enter your Username");
passWord = JOptionPane.showInputDialog(null, "Enter Password");
passWordTwo = JOptionPane.showInputDialog(null, "Enter Password Again");

if(passWord.equals("Ron123") && passWordTwo.equals(passWord)) {
	access = "Your passwords match. Your password is: " + passWord;
}
else {
	access = "Oops, the passwords do not match. \n The first password you entered was " + passWord;
}//End of IF
JOptionPane.showMessageDialog(null, access); 

//part two

String ageMessage;
int age;
age = Integer.parseInt(JOptionPane.showInputDialog(null,"What it is your age"));
if(age <= 0) {
	ageMessage = "You're not even born yet.";
}
else if(age <= 13){
	ageMessage = "You're a mere child.";
}
else if(age <= 20) {
	ageMessage = "You're a Teenage.";
}
else if(age == 20) {
	ageMessage = "No longer a teenager but not quite an adult.";
}
else if(age <= 65) {
	ageMessage = "You're an adult.";
}
else {
	ageMessage = "Ready to retire.";
}//end of if 
JOptionPane.showMessageDialog(null, ageMessage);

//part Three 


int numCredit; 
String creditMessage;
numCredit = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your amount of credits"));
if(numCredit <= 0) {
	creditMessage = "No Valid Input";

}
else if(numCredit <= 29){
	creditMessage = "You're a Freshman.";

}
else if(numCredit <= 59){
	creditMessage = "You're a Sophomore.";
}
else if(numCredit <= 89){
	creditMessage = "You're a Junior";
}
else if(numCredit <= 119){
	creditMessage = "you're a senior"; 
}
else{
	creditMessage = "You have Graduted!!";
}//End of if
JOptionPane.showMessageDialog(null, creditMessage); 
JOptionPane.showMessageDialog(null, "Goodbye from Ronald Santos");


}//End main
}//End class

