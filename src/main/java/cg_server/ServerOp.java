package cg_server;

import cg_interface.RMIInterface;
import cg_interface.RMIInterfaceImpl;

import java.rmi.Naming;
import Sample.SampleClass;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerOp extends RMIInterfaceImpl {
    public ServerOp() {
        super();
    }

    private static void registrar() throws RemoteException{

        //Naming.rebind("//localhost/CGServer", new ServerOp());
        RMIInterfaceImpl serverObj = new RMIInterfaceImpl();
        RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(serverObj, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("RMIInterface", stub);
    }

    public static void main(String[] args)  {
        try {
            registrar();
            System.err.println("CGServer is ready");
        } catch (Exception e)   {
            System.err.println("CGServer exception: "+e.toString());
            e.printStackTrace();
        }


    }
}
