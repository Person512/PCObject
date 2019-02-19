import java.util.Random;
import java.util.*;
public class PC
//Ankur Mathur
{
    private String display;
    private String[] keyboardLang;
    private ArrayList<Applications> applications;
    //#11 use of class composition (use of class Applications in class PC)
    private double storage;
    //#3 - primitive data types (used: double)
    private int batteryLeft;
    private boolean powerOn;
    //#3 - primitive data type (used: boolean)
    private String dayOfTheWeek;
    private String time;
    private int isCharging;
    private int crash;
    //#3 - primitive data types (used: int)
    private double cost;
    //#9 - the big three (used: instance variables)
    public PC()
    //#9 - the big three (used: zero arg constructor)
    //zero arg constructor
    {
        display = "LED";
        keyboardLang = new String[3];
        keyboardLang[0] = "Chinese";
        keyboardLang[1] = "Japanese";
        keyboardLang[2] = "English";
        applications = new ArrayList<Applications>();
        applications.add(new Applications("Chrome"));
        applications.add(new Applications("Bluej"));
        applications.add(new Applications("Firefox"));
        storage = Math.pow(10,5); 
        //#6 - call to Math.pow
        batteryLeft = 90;
        powerOn = false;
        dayOfTheWeek = "Monday";
        time = "2:30";
        isCharging = 0;
        crash = (int)(Math.random()*10)+1;
        //#6 - call to Math.random
        //#8 use of casting (casted Math.random,which is a double, to an int)
        cost = 500.00;
    }
    public PC(String display, int storage,
    String dayOfTheWeek, String time)
    //#9 - the big three (used: multi arg constructor)
    //multi arg constructor
    {
        this.display = display;
        this.storage = storage;
        this.powerOn = powerOn;
        this.dayOfTheWeek = dayOfTheWeek;
        this.time = time;
    }
    public String[] getKeyboard()
    {
        return keyboardLang;
    }
    public double getStorage()
    //#10a - methods (used: getter method)    
    //#9 - the dynamic duo (used: getter method)
    //get storage method returns int storage
    {
        return storage;
    }
    public void setDateAndTime(String dayOfTheWeek, String time)
    //#10b - methods (used: setter method)
    //#9 - the dynamic duo (used: setter method)
    /* set Date and Time method returns void and allows user to set the date
    and time*/
    {
        this.dayOfTheWeek = dayOfTheWeek;
        this.time = time;
    }
    public double getCost()
    //get cost method returns the double cost
    {
        return cost;
    }
    public String getDateAndTime()
    //get date and time method returns the combined String date and time
    {
        String output = ((dayOfTheWeek.substring(0,3)).toUpperCase()).concat(" ") 
                                + time;
        //#7 - String method (used: substring)
        //#7 - String method (used: toUpperCase)
        //#7 - String method (used: concat)
        return output;
    }
    public void turnOnComputer()
    //allows user to turn on computer
    //if computer crashes,throws an error
    //#10d - methods (used: other method than parts a,b,c)
    {
        if ((Integer.parseInt(getBatteryLeft()) > 1) && (powerOn == false))
        //#1-relational operator (used: >, ==) and logical operator(used: &)
        //checks if battery is greater than 1%and if the computer is already on
        {
            if(crash <= 3)
            //checks if the computer crashed
            //#2 if-then-else statement that throws error
            {                
                powerOn = false;
                throw new IllegalArgumentException("Your computer crashed.");
                //throws an error
            }
            else
            {
                powerOn = true;
            }
        }
    }
    public boolean getPowerOn()
    //get power on returns boolean if the computer is on or off
    {
        return powerOn;
    }
    public void chargeComputer()
    //#10d - methods (used: other method
    //#9 - The Brain (used: processor methods)
    //get computer method returns the int 1 or 2
    {
        this.isCharging = 1;
    }
    public void addApplication(String application)
    //adds a new application object to the application array list 
    //#10c use of overloaded method (addApplication(String application))
    {
        applications.add(new Applications(application));
    }
    public void addApplication()
    //calls the zero arg of class Application and adds it to array list
    //#10c use of overloaded method (addApplication())
    {
        applications.add(new Applications());
    }
    public String getBatteryLeft()
    //get battery left returns the String battery of the PC
    {
        String battery = "";
        switch(isCharging)
        //#5 - switch statement   
        //switches boolean isCharging
        {
            case 1:
                if(batteryLeft > 60 && batteryLeft < 90)
                //#1 relational and logical operator (used: &&)            
                //#2 - if-then-else statement
                //checks if battery is greater than 60 and less than 90
                {
                    battery = "100";
                    break;
                }
                else
                {
                    battery = "Your computer is fully charged.";
                    break;
                }
            default:
                battery = Integer.toString(batteryLeft);
                break;
        }
        return battery;
    }
    public String toString()
    //#9 - the big three (used: toString method)
    //to String method returns the String descriptions of the PC
    {
        String output = "\nBattery Left: "+getBatteryLeft()+"\nStorage: "+
            getStorage()+"\nDate and time: "+getDateAndTime()+ "\nCost: "+
            getCost()+"\nApplications:\n";
        for (Applications i: applications)
        //#4 - loops (used: for-each-loop)
        //traverses the array list and adds each method to the application
        {
            output += i+"\n";
        }
        return output;
    }
}
