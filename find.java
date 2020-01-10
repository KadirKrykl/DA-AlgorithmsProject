/**
 * find
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 



public class find {

    public static void main(String[] args) {

        Set<String> setData = new HashSet<String>(); 

        ArrayList<String> arrayForHeap = new ArrayList<String>();
        
        Heap heapData = new Heap();

        //File load for set data
        try {
            File myObj = new File("names1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              setData.add(data);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //File load for heap data
        try {
            File myObj = new File("names2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                heapData.insert(arrayForHeap, data);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name:");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println();

        long startTimeSet = System.nanoTime();
        /*
        for (String item : setData) {
            if (item.equals(input)){
                System.out.println(input + " found" );
                break;
            } 
        } 
        */
        setData.contains(input);
        long endTimeSet = System.nanoTime();
        
        long timeElapsedSet = endTimeSet - startTimeSet;
        System.out.println("Execution time in nanoseconds for Set Data Structured  : " + timeElapsedSet);
        System.out.println();

        long startTimeHeap = System.nanoTime();

        heapData.find(arrayForHeap, input);

        long endTimeHeap = System.nanoTime();

        long timeElapsedHeap = endTimeHeap - startTimeHeap;
		System.out.println("Execution time in nanoseconds for Heap Data Structured  : " + timeElapsedHeap);




    }
}