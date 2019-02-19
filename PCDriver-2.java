import java.util.*;
import javax.swing.JOptionPane;
public class PCDriver
//Ankur Mathur
{
    public static void main(String[] args)
    {
        int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the" 
                            +" amount of PCs you want."));
        //#17 - JOptionPane
        //#8 - casting (cast string to integer)
        //takes a user input through JOptionPane and stores it in int length
        PC[] PCList = new PC[length];
        //makes a new array of PC objects
        ArrayList<Double> costOfEach = new ArrayList<Double>();
        //#13-use of wrapper class in ArrayList(later traversed in a for loop)
        //makes a new array list of Double wrapper classes
        for(int i = 0; i< length; i++)
        //#4 - loops (used: for loop)
        {
            PCList[i] = new PC();
            //sets zero arg value of PC to index of array PCList
            //#12 - array,PCList,traversed through a for loop
        }  
        for (int i = 0; i < PCList.length; i++)
        //traverses the PCList array
        {
            for (int a = 0; a < ((PCList[i]).getKeyboard()).length; a++)
            //traverses the KeyboardLang array in the PC class
            {
                System.out.println(((PCList[i]).getKeyboard())[a]);
            }
            System.out.println();
        }
        //#18 - nested for loops
        int counter = 0;
        while(counter < PCList.length)
        //#4 - loops (used: while loop)
        {
            costOfEach.add(PCList[counter].getCost());
            //adds the cost of the PCs to the array list costOfEach
            counter++;
        }
        int totalCost = 0;
        double min = costOfEach.get(0);
        for(int i = 0; i<costOfEach.size();i++)
        /*this for loop will be traced in diagram with 
         costOfEach.size() = 5*/
        {
           totalCost += costOfEach.get(i);  
           //finds the sum of the costs of the PCs
           if (costOfEach.get(i) < min)
           //checks of element is less than min
           {
               min = costOfEach.get(i);
               //sets min to the new lowest
           }
           //#13 - arraylist,costOfEach, traversed through a for loop
        }
        System.out.println("The min cost is " + min);
        System.out.println("The total cost is "+totalCost+".");
        System.out.println();
        //prints the total cost
        int inUsePC = Integer.parseInt(JOptionPane.showInputDialog("Which"
                            +" PC do you want to use? (Enter index #)"));
        //takes a user input for which PC to use 
        PC pc = PCList[inUsePC];
        pc.turnOnComputer();
        System.out.println("This is your PC:"+ pc);
        //prints the basics of the PC
        pc.setDateAndTime(JOptionPane.showInputDialog("Enter the day."),
                            JOptionPane.showInputDialog("Enter the time."));
        Boolean addMore = true;
        do
        {
            pc.addApplication(JOptionPane.showInputDialog("Add an " 
                            +"application."));
            //asks what app the user wants to add
            addMore = Boolean.parseBoolean(JOptionPane.showInputDialog("Do"
                       +" you want to add more applications?(true/false)"));
            //finds if the user wants to add more apps
        }
        while(addMore != false);
        //checks that the user does not want to add more applications
        //#2 - relational and logical operators (used: !)
        //#4 - loops (used: do while loop)
        System.out.println("This is your PC:"+ pc);
    }
}
