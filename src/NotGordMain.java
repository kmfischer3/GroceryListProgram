import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class NotGordMain {
	
	
	
	public static void main (String [] args){
		Scanner scnr = new Scanner(System.in);

//		File main_course_file = new File("main_courses.txt");
//		File side_dish_file = new File("side_dishes.txt");
		ArrayList mains = new ArrayList<String>();
		ArrayList sides = new ArrayList<String>();
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("main_courses.txt"));
			String line;
			while ((line = br.readLine()) != null) {
			   mains.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException caught");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException caught");
			e.printStackTrace();
		}
		
		BufferedReader br_2;
		try {
			br_2 = new BufferedReader(new FileReader("side_dishes.txt"));
			String line_2;
			while ((line_2 = br_2.readLine()) != null) {
			   sides.add(line_2);
			}
			br_2.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException caught");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException caught");
			e.printStackTrace();
		}
		
		System.out.println("main courses:");
		for(int i = 0; i < mains.size(); i++){
			System.out.println(mains.get(i));
		}
		System.out.println();
		System.out.println("side dishes:");
		for(int j = 0; j < sides.size(); j++){
			System.out.println(sides.get(j));
		}

		Random RNG_mains = new Random();
		Random RNG_sides = new Random();
		
		boolean done = false;
		while (!done){
			System.out.println();
			System.out.println("Enter 'r' to generate random dinner combination or anything else to quit");
			if(scnr.next().equals("r")){
				System.out.println("Random combination: ");
				int main_index = RNG_mains.nextInt(mains.size());
				int side_index = RNG_sides.nextInt(sides.size());
				System.out.println(mains.get(main_index));
				System.out.println("and");
				System.out.println(sides.get(side_index));
				
			}
			else{
				done = true;
			}
		}

	}
}
