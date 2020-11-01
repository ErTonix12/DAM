package Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_1 {

	public static void main(String[] args) {
		/*
		 * 1.-Realiza un programa que sume los 100 números siguientes a un nímero entero
		 *  y positivo introducido por teclado. Se debe comprobar que el dato introducido
		 *   es correcto (que es un número positivo).
		 */
		
		//Ask the user for a number
		
		System.out.println("Please insert a number");
		
		//start the variable and the scanner
		//check if the number if positive
		//doing a loop in the case that the user input will be wrong
		
		Scanner scan = new Scanner(System.in);
		
		double input_num = scan.nextDouble();
		
		if(input_num < 0) {
			System.out.println("please insert a positive integer");
			input_num = scan.nextDouble();
		}
		
		//save the input_number
		double fst_num = input_num;
		
		for(int i = 0 ; i < 100 ; i++){
			input_num = input_num + i;
		}
		
		System.out.println("The input number was: "+fst_num);
		
		System.out.println("The final add is: "+input_num+"\n");
			
		scan.close();

	}

}	
