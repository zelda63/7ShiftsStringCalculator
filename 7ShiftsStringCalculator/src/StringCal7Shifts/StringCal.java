/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringCal7Shifts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nimrat Sembhi
 */
public class StringCal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Using scanner to get user input
        String numbers = scan.nextLine(); // Storing user input in a string called numbers
        StringCal stringCal = new StringCal(); 
        System.out.println(stringCal.Add(numbers)); //Displaying result of method Add(numbers)
    }
    
    //Add Method 
    public int Add(String numbers){
        int result = 0; //initiation
        //If string is empty, 0 is returned
        if(numbers.equals("")){
            return 0;
        }
        //if not empty, we proceed
        else{
            //call method readNumbersFromString to extract numbers from our string and then store them in a list
           List<Integer> intNumbers = readNumbersFromString(numbers); 
           //And then add them
            for (int i = 0; i < intNumbers.size(); i++) {
                result+=intNumbers.get(i);
            }
        }
        
        return result;
    }
    
    //This method does all the work to extract numbers from string
    public List<Integer> readNumbersFromString(String numbers){ 
        //initiation of variables
        String delimiters = "";        
        String stringOfNumbers = "";
        //if our string has custom delimiters, it will begin with our control code //
      if(numbers.substring(0,2).equals("//")){
          delimiters = numbers.substring(2, numbers.indexOf("\\n")); //then we extract our custom delimiters
         
          //Now if there are multiple delimiters, they will be seperated by commas, so we check that here
          if(delimiters.contains(",")){
              
              String[] subDelimiters = delimiters.split(","); //we split our delimiters string at every comma
              delimiters = "";// then we empty the original delimiters string
              //and check if our delimiters are single character or multi character
              for (int i = 0; i < subDelimiters.length; i++) {  
                  //if they are multi charactered, we write them in format like "\\*\\*\\*" 
                  if(subDelimiters[i].length() > 1){
                      subDelimiters[i] = subDelimiters[i].replace("", "\\");                      
              subDelimiters[i] = subDelimiters[i].substring(0, subDelimiters[i].length()-1);  //we do this to get rid of // in the end of the string
                  }
                 //And then we put our delimiters back into one string
                  delimiters = delimiters + subDelimiters[i];
              }
             // we put our delimiter characters in [] brackets. Result looks like this: [$@]
              delimiters = new StringBuilder(delimiters).insert(0, "[").toString();
              delimiters = new StringBuilder(delimiters).insert(delimiters.length(), "]").toString();          
              
          }
          
          //Now if our delimiters don't contain a comma, that means there is only one type of delimiter.
          else{
              delimiters = delimiters.replace("", "\\");
              delimiters = delimiters.substring(0, delimiters.length()-1);         
          }
          stringOfNumbers = numbers.substring(numbers.indexOf("\\n")+2, numbers.length());
      }
      //This else is for if statement to check if our string begins with a // or not
      //So if it doesn't we check for \n 
      else{
          delimiters=",";
          stringOfNumbers = numbers;
          if(stringOfNumbers.contains("\\n")){
             stringOfNumbers = stringOfNumbers.replace("\\n", ""); 
          }
          
      }
     
       String[] nums = stringOfNumbers.split(delimiters); //Split the string at every delimiter and store it in a new array  
       //Initiating two int lists
        List<Integer> intNumbers = new ArrayList<>();  //for valid numbers
        List<Integer> negativeNums = new ArrayList<>(); //for negative numbers
        
        //We check every number in the array to see if it is valid
        for (int i = 0; i < nums.length; i++) {  
            //Check for null strings
            if(nums[i].equals("")){                
            }
            //Check for negative numbers
            else if(Integer.parseInt(nums[i]) < 0){
                negativeNums.add(Integer.parseInt(nums[i]));
            } 
            //Check for numbers grater than 1000 so we can ignore them
            else if(Integer.parseInt(nums[i]) > 1000){                
            }
            //if everything checks out we add them up
            else{
            intNumbers.add(Integer.parseInt(nums[i]));
            }
        }
        //now if there is a negative number, the size of this list will be greater than 0
        if(negativeNums.size() > 0){
            try {
                throw new Exception("Negatives not allowed. List of negative numbers: "+ negativeNums); // we throw an excpeption with list of negative numbers
            } catch (Exception ex) {
                Logger.getLogger(StringCal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return intNumbers;                 
    }
    

    
}
