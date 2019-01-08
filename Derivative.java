import java.util.*;
public class Derivative {
	private String Derivative; 
	private String f_Of_X; 
	private String f_Of_G;
	 
	public static void main(String args[]) {
		Derivative first = new Derivative("1"); 
		Derivative second = null; 
		String you = "(4x^2-+ 2x + 2)";
		
	//	System.out.println(you.substring(0,2));
		//testingPowerRule(you);
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
			//	System.out.println("Test number first typeOfDerivative" +firstPartOfDerivative);
				in = secondIndex;
			 }
			else if(in > 1 && answer.equals("(") ) {
				if(answer.equals("(") && input.substring(index-1, secondIndex-1).equals(")")){
					secondPartOfDerivative = input.substring(secondIndex, input.length()-1); 
				//	System.out.println("Test number second typeOfDerivative" +secondPartOfDerivative);
					Derivative product = null; 
					product = productRule(firstPartOfDerivative,secondPartOfDerivative);
				}
			}
			else if(in > 1 && answer.equals("/")) {
				//	System.out.println("Three");
					if(answer.equals("/") && input.substring(index -1, secondIndex-1).equals(")") ) {
						secondPartOfDerivative = input.substring(secondIndex + 1, input.length()-1); 
						Derivative quotient; 
						quotient = quotientRule(firstPartOfDerivative, secondPartOfDerivative); 
						System.out.println("Test number third typeOfDerivative" + secondPartOfDerivative);
					}
					
				}
			secondIndex++;
		}
		if(secondPartOfDerivative ==null) {
			
			String power = powerRule(firstPartOfDerivative);
			System.out.println(power);
		}
		/*
		 * The Instance variable answer is not a valid 
		 * answer. Change it once all this method is complete 
		 * 
		 */
		
		return null; 
	}
	private static Derivative chainRule(String fX) {
		return null;
		
	}
	/*
	 * The formula for product rule f(X) = (f(x))(f(g)). The Derivative will be 
	 * f(x) = d/dx(f^1(x)(f(g)) + f(x)d/dx(f^1(g))
	 */
	private static Derivative productRule(String fX, String fG) {
		int secondIndex =1; 
		String  derivativeFX = null, derivativeFG =null;
		derivativeFX = powerRule(fX);
		derivativeFG = powerRule(fG); 
//		System.out.println("Testing in ProductRule One " + fX + " "  + fG);
		
//		for(int firstIndex = 0; firstIndex < fX.length(); firstIndex++) {
//			 aSubString = fX.substring(firstIndex, secondIndex);
//			 System.out.println("Testing in ProductRule Two " + fX.substring(firstIndex));
//			 if(aSubString.equals("^")) {
//				 
//				 derivativeFX = powerRule(fX.substring(0, secondIndex -2), fX.substring(secondIndex));
//				//This line will Finish the For Loop as it doesnt need to continue as we have 
//				//Answer.
//				//System.out.println("Product rule Testing Three " + fX );
//				firstIndex = fX.length(); 
//			 }
//			 secondIndex++; 
//			}
//		secondIndex = 1; 
//		for(int firstIndex = 0; firstIndex < fG.length(); firstIndex++) {
//			 aSubString = fG.substring(firstIndex, secondIndex);
//			 System.out.println("Testing in ProductRule Two " + fG.substring(firstIndex));
//			 if(aSubString.equals("^")) {
//				 
//				 derivativeFG = powerRule(fG.substring(0, secondIndex -2), fG.substring(secondIndex));
//				//This line will Finish the For Loop as it doesnt need to continue as we have 
//				//Answer.
//				//System.out.println("Product rule Testing Four " + fG );
//				firstIndex = fG.length(); 
//			 }
//			 secondIndex++;
//		}
		String derivative = "("+derivativeFX + ")("+fG + ") + (" + fX +")("+derivativeFG +")";
		System.out.println("Testing Power Rule Four "+derivative);
		Derivative answer = new Derivative(derivative); 
		
		return answer ; 
	}
	/*
	 * Quotient Rule Formula fx = f(x)/f(g). fx^1 = (d/dx f(x)(f(g)) - f(x)d/dx f(g))/f(g)^2
	 */
	private static Derivative quotientRule(String fX, String fG) {
		String derivativeFX = null, derivativeFG = null,  FINAL_DERIVATIVE = null;
		derivativeFX = powerRule(fX); 
		derivativeFG = powerRule(fG);
//		int secondIndex = 1; 
//		for(int index = 0; index < fX.length(); index++) {
//			aSubString = fX.substring(index, secondIndex); 
//			if(aSubString.equals("^")) {
//				//Write Things here 
//				 derivativeFX = powerRule(fX.substring(0, secondIndex -2), fX.substring(secondIndex));
//
//			}
//			secondIndex++; 
//		}
//		secondIndex =1 ; 
//		for(int index = 0; index < fG.length(); index++) {
//			aSubString = fG.substring(index, secondIndex);
//			if(aSubString.equals("^")) {
//				 derivativeFG = powerRule(fG.substring(0, secondIndex -2), fG.substring(secondIndex));
//
////			}
////			secondIndex++;
////		}	
		FINAL_DERIVATIVE = "(("+ derivativeFX+")" + fG + " - " + fX + "("  + derivativeFG+"))\n" +"        (" + fG+ ")^2";
		System.out.println(FINAL_DERIVATIVE);
		Derivative answer = null;
		return answer = new Derivative(FINAL_DERIVATIVE); 
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
//	private static String powerRule(String leadingCoeffincient, String powerConstant) {
//		String answer = null;
//		System.out.println("Testing PowerRule One" + leadingCoeffincient + " " + powerConstant );
//		int intLeadingCoeffincient = Integer.parseInt(leadingCoeffincient), intPowerConstant = Integer.parseInt(powerConstant);
//		intLeadingCoeffincient = intLeadingCoeffincient * intPowerConstant; 
//		intPowerConstant =intPowerConstant - 1; 
//		
//		leadingCoeffincient = String.valueOf(intLeadingCoeffincient); 
//		powerConstant = String.valueOf(intPowerConstant); 
//		if(intPowerConstant == 0) {
//			return leadingCoeffincient; 
//		}
//		
//	
//		return leadingCoeffincient + "x^" + powerConstant ; 
//	}
	/*
	 * powerRule Method Doc
	 * When this method is call it will asked for a String. 
	 * This String will be test by converting it to a integer. 
	 * If it converts to a string than the method will return zero.
	 * Else the method will continue running, the method will check if 
	 * the string Contains a "^" inside the String. If the String contains
	 * a "^" than the program will convert all the numbers that the string contains
	 * into integers. The numbers in front of the String will be into the instance 
	 * variable leadingCoeffincient, and the numbers after "^" put into powerOf.
	 * The program will make a new leadingCoeffincient by multiplying the 
	 * existing leadingCoeffincient with powerOf. Also the method will give 
	 * powerOf a new value by subtracting one out of it. once this all done the 
	 * method will check if the powerOF is equals to one, if it does the method will
	 * return the leadingCoefficient and the corresponding variable. If its greater 
	 * than one the program will return leadingCoefficient, corresponding variable, ^, 
	 * and powerOf. If the method does not find "^" in the string the method will 
	 * ignore the variable and only return the numbers in front of it. 
	 * 
	 */
	private static String powerRule(String fX) {
		System.out.println("fX is equals to " + fX);
		int integerFX, leadingCoeffincient, powerOf ,secondIndex = 1; 
		String aSubstring , constant, temporaryHolder ; 
		boolean noPowerOf = true;
		try {
			integerFX = Integer.parseInt(fX);
		}
		catch(Exception e) {
			//System.out.println("Testing Power rule one");	
				for(int index = 0; index < fX.length(); index++) {
				aSubstring = fX.substring(index, secondIndex); 
				if(aSubstring.equals("^")){
					//System.out.println("Testing Power rule second");
					leadingCoeffincient = Integer.parseInt(fX.substring(0, index-1));
					if(fX.contains("+")|| fX.contains("-")) {
						temporaryHolder = fX.substring(secondIndex+1, fX.length());
						System.out.println("Temporary Holder Value " + temporaryHolder);
						while(temporaryHolder.substring(0,1).equals("-")||temporaryHolder.substring(0,1).equals("+")||temporaryHolder.substring(0,1).equals(" ")) {
							System.out.println("Checking +,  , -");
							System.exit(0);
						}
						powerRule(fX.substring(secondIndex+1, fX.length()));
					}
					powerOf = Integer.parseInt(fX.substring(secondIndex, secondIndex+1));
					//System.out.println(leadingCoeffincient +" "+ powerOf);
					leadingCoeffincient = leadingCoeffincient *	powerOf;
					
					powerOf= powerOf - 1; 
					noPowerOf = false;
					if(powerOf == 1) {
						//System.out.println(String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1));
						return String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1);
					}
					//System.out.println(String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1) + "^"+ String.valueOf(powerOf));
					return String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1)+"^" + String.valueOf(powerOf);
				}
				else if (index == fX.length()-1 && noPowerOf == true ) {
				//	System.out.println("Testing power rule three");
					try {
						secondIndex = 1;
						for( index = 0; index < fX.length(); index++) {
							System.out.println(fX.substring(index, secondIndex));
							leadingCoeffincient = Integer.parseInt(fX.substring(index, secondIndex));
							
							secondIndex++; 
						}
					}
					catch(Exception t) {
					//	System.out.println("Testing PowerRule Forth");
						return fX.substring(0,index);
						
					}
				}
				
				secondIndex++; 
				}
		}
		System.out.println("Final Testing PowerRule");
		return "0";
	}
	public String getF_Of_X() {
		return this.f_Of_X;
	}
	public String getF_Of_G() {
		return this.f_Of_G;
	}
	
}
//}
