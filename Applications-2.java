public class Applications
//Ankur Mathur
{
    private String name;
    //instance variable
    public Applications()
    //zero arg constructor
    {
        name = "Chrome";
    }
    public Applications(String name)
    //multi arg constructor
    {
        this.name = name;
    }
    public String getApplicationName()
    //get application name method returns the String name of the application
    {
        return this.name;
    }
    public String toString()
    //to String method returns the String application name
    {
        String output = "Application name: " + name;
        return output;
    }
}
