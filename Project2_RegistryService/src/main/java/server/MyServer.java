package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServer {
    public static void main(String[] args) {
        try{
            int port = 16790;
            String host= "localhost";
            AddImpl addImplObj = new AddImpl();
            LocateRegistry.createRegistry(port);
            String registryURL = "rmi://"+ host+ ":"+port + "/hello";
            Naming.rebind(registryURL, addImplObj);
            System.out.println("Server Running at port "+ port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
