import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExHandling {
	public static void main(String[] args){
		int[] intArray = {2,3};
		
		Object nullObj = null;
		String testDouble = "Chocolate Cake";
		
		/*
		 * These are all the broken ones that don't work for generation.
		 * The ones that do work will happen at the bottom later.
		 * However since they will work, the try/catch will be ostensibly useless.
		 */
		try{
			intArray[3] = 4;
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Array Out of bounds detected. Send in the cleaners.");
		}
		
		try{
			File file = new File("notFound.txt");
			Scanner scan = new Scanner(file);
		}
		catch(FileNotFoundException e){
			System.out.println("notFound.txt File doesn't exist. Make it so first");
		}
		
		try{
			nullObj.hashCode();
		}
		catch(NullPointerException e){
			System.out.println("That thing doesn't have anything in the thing. You're trying to work with a null pointer.");
		}
		
		try{
			int i = Integer.parseInt(testDouble);
		}
		catch(NumberFormatException e){
			System.out.println("Cannot format the String that way. Too bad for you.");
		}
		
		try{
			String name = "Gracin";
			if(name.compareTo("Grayson") != 0){
				throw(new NameSpelledWrongException());
			}
		}
		catch(NameSpelledWrongException e){
			System.out.println("You spelled my name wrong :(");
		}
		
		System.out.println("\nThose were badly handled, here's the stuff working \n");
		
		/*
		 * Put the working stuff down here.
		 */
		try{
			intArray[1] = 4;
			System.out.println(intArray[1]);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Array Out of bounds detected. Send in the cleaners.");
		}
		
		try{
			File file = new File("info.txt");
			Scanner scan = new Scanner(file);
			System.out.println(scan.nextLine());
		}
		catch(FileNotFoundException e){
			System.out.println("File doesn't exist. Make it so first");
		}
		
		try{
			nullObj = new String("Cakes");
			System.out.println(nullObj.hashCode());
		}
		catch(NullPointerException e){
			System.out.println("That thing doesn't have anything in the thing.");
		}
		
		try{
			testDouble = "1112";
			int i = Integer.parseInt(testDouble);
			System.out.println(testDouble);
		}
		catch(NumberFormatException e){
			System.out.println("Cannot format those that way. Too bad for you.");
		}
		
		try{
			String name = "Grayson";
			if(name.compareTo("Grayson") != 0){
				throw(new NameSpelledWrongException());
			}
			System.out.println(name);
		}
		catch(NameSpelledWrongException e){
			System.out.println("You spelled my name wrong :(");
		}
	}
}
