package server;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.*;
import java.util.*;
import java.rmi.server.*;


public class AddImpl extends UnicastRemoteObject
        implements RegistryService
{
    List<Person> personList = new ArrayList<>();
    public AddImpl() throws RemoteException
    {
        super( );
    }

    public String record(String firstName, String lastName,
                         String phone) throws RemoteException
    {
        Person newPerson = new Person(firstName, lastName, phone);
        personList.add(newPerson);
        return  firstName +" " + lastName + " " + phone + " is recorded";
    }

    public String find(String firstName, String lastName)
            throws RemoteException
    {
        for (Person person : personList) {
            if(person.firstName.equals(firstName) && person.lastName.equals(lastName)){
                return firstName+ " "+ lastName +" Phone number is : " + person.phone;
            }
        }
        return firstName+ " "+ lastName +" is not recorded.";
    }
}
