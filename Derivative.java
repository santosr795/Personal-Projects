import java.util.*;
public class Derivative {
	private String Derivative; 
	private String f_Of_X; 
	private String f_Of_G;
	 
	public static void main(String args[]) {
		Derivative first = new Derivative("1"); 
		Derivative second = null; 
		String you = "((8x^2- 5x^3 + 2d^4 - 2x + 2))^(1212x)";
		 chainRule(you); 
	//	System.out.println(you.substring(0,2));
		//testingPowerRule(you);
		//second = first.typeOfDerivative(you);
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
	
	public static Derivative typeOfDerivative(String input) {
		int secondIndex = 1; 
		String answer = ""; 
		Derivative solution; 
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
			return solution = new Derivative(power); 
		}
		else {
			
		}
		/*
		 * The Instance variable answer is not a valid 
		 * answer. Change it once all this method is complete 
		 * 
		 */
		
		return null; 
	}
	private static Derivative chainRule(String fX) {
		Derivative outterDerivative = null;
		String aSubstring = null, innerEquation = null, outterEquation = null;
		int secondIndex =1, outterEquationInteger = 0; 
		for(int index= 0; index < fX.length(); index++) {
			if(fX.substring(index, secondIndex).equals("^")&& aSubstring.equals(")")) {
				System.out.println("Testing chainRule One");
				outterEquation = fX.substring(secondIndex, fX.length()); 
				innerEquation = fX.substring(1, index-1);
				System.out.println("InnerEquation is equals to " + innerEquation);
				System.out.println("OutterEquation is equals to "+outterEquation);
				try {
					outterEquationInteger = Integer.parseInt(outterEquation);
				}
				catch(Exception e) {
					System.out.println("It has fail ParseInt"); 
					outterDerivative = typeOfDerivative(outterEquation);
					
					System.out.println("outterEquation + "+ outterDerivative );
				}
			}
			aSubstring = fX.substring(index,secondIndex); 
			secondIndex++;
		}
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
		System.out.println("Testing product Rule Four "+derivative);
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
	//	System.out.println("fX is equals to " + fX);
		int integerFX, leadingCoeffincient, powerOf ,secondIndex = 1; 
		String aSubstring , constant, temporaryHolder = null, symbols = null ; 
		boolean noPowerOf = true;
		/*
		 * This try will try will try convert fX into 
		 * an integer. if it does than the method will
		 * return zero.
		 */
		try {
			integerFX = Integer.parseInt(fX);
		}
		/*
		 * When this catch it is trigger it will go through
		 * the String of fX and find each piece and it will 
		 * do the derivate of it. 
		 */
		catch(Exception e) {
			//System.out.println("Testing Power rule one");	
			/*
			 * This for loop will check each index of the String fX.
			 */
				for(int index = 0; index < fX.length(); index++) {
				aSubstring = fX.substring(index, secondIndex); 
				/*
				 * Once the method finds the symbol of "^" it will split the 
				 * the string making two new substring call leadingCoefficient
				 * and powerOf. but first it will check if the string contains
				 * mathematical symbols such as "+" and "-".
				 */
				if(aSubstring.equals("^")){
					//System.out.println("Testing Power rule second");
					leadingCoeffincient = Integer.parseInt(fX.substring(0, index-1));
					if(fX.contains("+")|| fX.contains("-")) {
						temporaryHolder = fX.substring(secondIndex+1, fX.length());
						//System.out.println("Temporary Holder Value " + temporaryHolder);
						/*
						 * The method will check if the string has blank space and Mathematical
						 * symbols("+", "-") in the front of the string.
						 * If it does it will go inside the while loop and delete blank spaces and 
						 * mathematical symbols, but it will save mathematical symbols. After it 
						 * deletes and save symbols or blank spaces, the method will run itself 
						 * again from the beginning until its able to passes. once its done it returns again it 
						 * will save itself into temporaryHolder
						 */
						while(temporaryHolder.substring(0,1).equals("-")||temporaryHolder.substring(0,1).equals("+")||temporaryHolder.substring(0,1).equals(" ")) {
							//System.out.println("Checking +,  , -");
							if(temporaryHolder.substring(0,1).equals("-")||temporaryHolder.substring(0,1).equals("+")) {
								symbols = temporaryHolder.substring(0,1);
							}
							temporaryHolder = temporaryHolder.substring(1, temporaryHolder.length()); 
							//System.out.println("TemporaryHolder Value "+temporaryHolder);
							//System.exit(0);
						}
						temporaryHolder = powerRule(temporaryHolder);
					}
					/*
					 * The Method will make two new integer that will come from part of the string 
					 * fX. Than it will give leadingCoeffincient a new value by multiplying powerOf
					 * and leadingCoeffincient. It will also give powerOf a new value by subtracting 
					 * one out of it. The method will make noPowerOf equals to false, meaning the 
					 * part of string had the symbol "^"; 
					 */
					powerOf = Integer.parseInt(fX.substring(secondIndex, secondIndex+1));
					//System.out.println(leadingCoeffincient +" "+ powerOf);
					leadingCoeffincient = leadingCoeffincient *	powerOf;					
					powerOf= powerOf - 1; 
					noPowerOf = false;
					/*
					 * The method will check if the powerOf is equals to one, if it does than the 
					 * the method will return the Value of the leadingCoeffincient, the correspondent
					 * variable, the correct mathematical symbols, and temporaryHolder. If its not 
					 * equals to one than the method will return  the Value of the leadingCoeffincient, the correspondent
					 * variable, "^" , the value of powerOf,the correct mathematical symbols, and temporaryHolder
					 */
					if(powerOf == 1) {
						//System.out.println("The return value test one "+String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1));
						return String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1) + symbols+temporaryHolder;
					}
					//System.out.println("The return value test two "+String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1) + "^"+ String.valueOf(powerOf));
					return String.valueOf(leadingCoeffincient) + fX.substring(index-1,secondIndex -1)+"^" + String.valueOf(powerOf) + symbols +temporaryHolder;
				}
				else if (index == fX.length()-1 && noPowerOf == true ) {
				//	System.out.println("Testing power rule three");
					try {
						secondIndex = 1;
						for( index = 0; index < fX.length(); index++) {
				//			System.out.println("Testing PowerRule three 1/2 "+ fX.substring(index, secondIndex));
							leadingCoeffincient = Integer.parseInt(fX.substring(index, secondIndex));			
							secondIndex++; 
						}
					}
					catch(Exception t) {
			//			System.out.println("The return value test three " + fX.substring(0,index) );
						return fX.substring(0,index) ;						
					}
				}				
				secondIndex++; 
				}
		}
		//System.out.println("Final Testing PowerRule");
		return "0";
	}
	public String getF_Of_X() {
		return f_Of_X;
	}
	public String getF_Of_G() {
		return this.f_Of_G;
	}
	public void setF_OF_X(String fX) {
		this.f_Of_X = fX; 
	}
	
}
//}
