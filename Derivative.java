import java.util.*;
public class Derivative {
	private String Derivative; 
	private String f_Of_X; 
	private String f_Of_G;
	
	public static void main(String args[]) {
		Derivative first = new Derivative("1"); 
		Derivative second = null; 
		String you = "(4x^1)(12X^3)";
		
		 second = first.typeOfDerivative(you);
		
		
	}
	Derivative() {
		
	}
	Derivative(String fX, String fG){
		this.f_Of_X = fX; 
		this.f_Of_G = fG;
	}
	Derivative(String derivative){
		this.Derivative = derivative; 
		
	}
	
	public Derivative typeOfDerivative(String input) {
		int secondIndex = 1; 
		String answer = ""; 
		int in =0; 
		String firstPartOfDerivative = null; 
		String secondPartOfDerivative = null;
		for(int index = 0; index < input.length(); index++) {
			
			
			//System.out.println(input.substring(index,secondIndex));
			answer = input.substring(index, secondIndex);
			 if(input.substring(index,secondIndex).equals(")") && in==0) {
				firstPartOfDerivative = input.substring(1, secondIndex-1); 
				System.out.println(firstPartOfDerivative);
				in = secondIndex;
			 }
			
			
			else if(in > 1 && answer.equals("(") ) {
				if(answer.equals("(") && input.substring(index-1, secondIndex-1).equals(")")){
				secondPartOfDerivative = input.substring(secondIndex, input.length()-1); 
				System.out.println(secondPartOfDerivative);
					Derivative product = null; 
					product = productRule(firstPartOfDerivative,secondPartOfDerivative);
				}
				//System.out.println(input.substring(in+1, input.length()-1));
				
			}
			
		//	System.out.println(input.substring(index,secondIndex));
			
			secondIndex++;
		//	System.out.println("re");
		}
		Derivative answer3 = new Derivative(answer);
		return answer3; 
	}
	/*
	 * The formula for product rule f(X) = (f(x))(f(g)). The Derivative will be 
	 * f(x) = d/dx(f^1(x)(f(g)) + f(x)d/dx(f^1(g))
	 */
	private static Derivative productRule(String fX, String fG) {
		int secondIndex =1; 
		String aSubString, derivativeFX = null, derivativeFG =null;
		System.out.println("Testing in ProductRule One " + fX + " "  + fG);
		for(int firstIndex = 0; firstIndex < fX.length(); firstIndex++) {
			 aSubString = fX.substring(firstIndex, secondIndex);
			 System.out.println("Testing in ProductRule Two " + fX.substring(firstIndex));
			 if(aSubString.equals("^")) {
				 
				 derivativeFX = powerRule(fX.substring(0, secondIndex -2), fX.substring(secondIndex));
				//This line will Finish the For Loop as it doesnt need to continue as we have 
				//Answer.
				//System.out.println("Product rule Testing Three " + fX );
				firstIndex = fX.length(); 
			 }
			 secondIndex++; 
			}
		secondIndex = 1; 
		for(int firstIndex = 0; firstIndex < fG.length(); firstIndex++) {
			 aSubString = fG.substring(firstIndex, secondIndex);
			 System.out.println("Testing in ProductRule Two " + fG.substring(firstIndex));
			 if(aSubString.equals("^")) {
				 
				 derivativeFG = powerRule(fG.substring(0, secondIndex -2), fG.substring(secondIndex));
				//This line will Finish the For Loop as it doesnt need to continue as we have 
				//Answer.
				//System.out.println("Product rule Testing Four " + fG );
				firstIndex = fG.length(); 
			 }
			 secondIndex++;
		}
		String derivative = "("+derivativeFX + ")("+fG + ") + (" + fX +")("+derivativeFG +")";
		System.out.println("Testing Power Rule Four "+derivative);
		Derivative answer = new Derivative(derivative); 
		
		return answer ; 
	}
	/*
	 * PowerRule Method.
	 * This method is the simulation of the power rule when finding the 
	 * derivative of f(x). 
	 * 	f(x) = 4x^3
	 * 	4 * 3 = 12
	 * 	3 - 1 = 2
	 * 	f^1(xf) = 12x^2
	 * 
	 * 1)This method will ask the user for two String, but the string must 
	 * 	be able to convert to Integers. 
	 * 2)The Method will Convert both of them into Integer. leadingCoeffincient will
	 * intLeadingCoeffincient and powerConstant will become intPowerConstant. 
	 * 3)The method will Multiple the intLeadingCoeffincient and intPowerConstant this will 
	 * be the new intLeadingCoeffincient.
	 * 4)The method will also subtract one from intPowerConstant. This will become the new 
	 * intPowerConstant.
	 * 5)The method will Convert intLeadingCoeffient and intPowerConstant back to String into 
	 * LeadingCoeffincient and PowerConstant.
	 * 6)if intPowerConstant is equals to Zero, the method will return just the leadingCoefficient.
	 * else this step will be skip.
	 * 7) The method will return as follow (leadingCoeffincient + "X^" + powerConstant). This 
	 * will come out as "12x^2".
	 */
	private static String powerRule(String leadingCoeffincient, String powerConstant) {
		String answer = null;
		System.out.println("Testing PowerRule One" + leadingCoeffincient + " " + powerConstant );
		int intLeadingCoeffincient = Integer.parseInt(leadingCoeffincient), intPowerConstant = Integer.parseInt(powerConstant);
		intLeadingCoeffincient = intLeadingCoeffincient * intPowerConstant; 
		intPowerConstant =intPowerConstant - 1; 
		
		leadingCoeffincient = String.valueOf(intLeadingCoeffincient); 
		powerConstant = String.valueOf(intPowerConstant); 
		if(intPowerConstant == 0) {
			return leadingCoeffincient; 
		}
		
		
		return leadingCoeffincient + "x^" + powerConstant ; 
	}
	public String getF_Of_X() {
		return this.f_Of_X;
	}
	public String getF_Of_G() {
		return this.f_Of_G;
	}
	
}
//}
