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
    private static final long serialVersionUID = 1L;
    public ServerOp() {
        super();
    }

    public static void main(String[] args)  {
        try {
            //Naming.rebind("//localhost/CGServer", new ServerOp());
            RMIInterfaceImpl serverObj = new RMIInterfaceImpl();
            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(serverObj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RMIInterface", stub);
            System.err.println("CGServer is ready");
        } catch (Exception e)   {
            System.err.println("CGServer exception: "+e.toString());
            e.printStackTrace();
        }


    }
}
