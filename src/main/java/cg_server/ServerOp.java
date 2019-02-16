package cg_server;

import cg_interface.RMIInterface;
import cg_interface.RMIInterfaceImpl;

import java.rmi.Naming;
import Sample.SampleClass;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerOp extends RMIInterfaceImpl {
    public ServerOp() {
        super();
    }

    public static void main(String[] args)  {

        Logger logger = Logger.getLogger("ServerOp");
        try {
            RMIInterfaceImpl serverObj = new RMIInterfaceImpl();
            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(serverObj, 0);

            //1099 is the default port
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RMIInterface", stub);
            logger.log(Level.INFO, "CGServer is ready");
        } catch (Exception e)   {
            logger.log(Level.SEVERE, "CGServer exception: "+e.toString());
            e.printStackTrace();
        }


    }
}
