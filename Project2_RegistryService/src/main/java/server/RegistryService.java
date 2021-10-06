
package server;
        import java.rmi.Remote;
        import java.rmi.RemoteException;

public interface RegistryService extends Remote {
    public String record(String firstName, String lastName, String phone) throws RemoteException;
    public String find(String firstName, String lastName) throws RemoteException;
}