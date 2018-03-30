import javax.swing.JOptionPane;
import java.util.Scanner;

public class AssignmentTwo {

public static void main(String args[])
{
//Part one. 
String firstName, lastName;
int grossIncome, numberChild, depExemption, taxIncome;
double taxDueString;
//part two
Scanner Input = new Scanner(System.in);

System.out.println("Enter your first name");
firstName = Input.nextLine();

System.out.println("Enter your first Last Name");
	lastName = Input.nextLine();

System.out.println("Enter your Gross Income");
	grossIncome = Input.nextInt();

System.out.println("Enter your Enter your Number of Children");
	numberChild = Input.nextInt();

depExemption = numberChild * 2000;
taxIncome = grossIncome - depExemption;
//String taxDueString  = String.format("%.2f%n", taxIncome); I Could not get this working
taxDueString = taxIncome * .15; 
 System.out.println("Name: " + firstName + lastName + "\nGross Income: $"+ grossIncome + "\nNumber of Children: " + numberChild + "\nDependency Exemption: $ " + depExemption + "\nTaxable Income: $"+ taxIncome + "\nTax DUe: $" + taxDueString);

 //part three
firstName = JOptionPane.showInputDialog(null, "Enter your First Name; ");

lastName = JOptionPane.showInputDialog(null, "Enter your Last Name: ");

grossIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Gross Income")); 
numberChild = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Number of Children")); 

 depExemption = numberChild * 2000;
 taxIncome = grossIncome - depExemption; 
 taxDueString = taxIncome * .15; 
//String taxDueString  = String.format("%.2f%n", taxIncome);  I Could not get this working.


JOptionPane.showMessageDialog(null, "Name: " + firstName + lastName + "\nGross Income: $"+ grossIncome + "\nNumber of Children: " + numberChild + "\nDependency Exemption: $ " + depExemption + "\nTaxable Income: $"+ taxIncome + "\nTax DUe: $" + taxDueString);
//part four 
JOptionPane.showMessageDialog(null, "Goodbye from Ronald Santos");

}//End of main
}//end of class 
