package Client;
import java.rmi.*;
import java.util.Scanner;
import server.RegistryService;

public class MyClient
{
    private Scanner keyboard = null;
    RegistryService h = null;

    public static void main(String args[])
    { //This method is complete, do not change it. Use it.
        new MyClient();
    }

    public MyClient()
    { //This constructor is complete, do not change it. Use it.
        try
        {
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/hello";
            h = (RegistryService)Naming.lookup(registryURL);
            keyboard = new Scanner(System.in);
            while(true)
            {
                System.out.print(
                        "Enter 1 to add a name, 2 to find a phone #, 3 to end:");
                int choice = keyboard.nextInt();
                while(choice < 1 || choice > 3)
                {
                    System.out.println("Please only enter 1 , 2, or 3.");
                    choice = keyboard.nextInt();
                }
                if(choice == 3)
                    System.exit(0);
                if(choice == 1)
                    add();
                else
                    find();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void add()
    { //Complete this method.
        System.out.println("First Name, last name, and phone number seperated by space : ");
        String[] inputSplit = getInput().split(" ");
        try {
            String response = h.record(inputSplit[0], inputSplit[1], inputSplit[2]);
            System.out.println(response + "is recorded.");
        } catch (RemoteException re){
            re.printStackTrace();
        }
    }

    private void find()
    { //Complete this method.
        System.out.println("First Name, last name, seperated by space : ");
        String inputSplit[] = getInput().split(" ");
        try{
            String response = h.find(inputSplit[0], inputSplit[1]);
            System.out.println(response);
        }catch (RemoteException re){
            re.printStackTrace();
        }
    }
}
