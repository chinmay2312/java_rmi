package cg_client;


import Sample.SampleClass;
import cg_interface.RMIInterface;

import javax.swing.JOptionPane;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientOp {
    private static RMIInterface lookUp;

    private ClientOp()  {}

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        /*lookUp = (RMIInterface) Naming.lookup("//localhost/CGServer");
        String heyServer = JOptionPane.showInputDialog("Hello ServerOp");

        String res = lookUp.sayHello(heyServer);
        JOptionPane.showConfirmDialog(null, res);
        */

        try {
            Registry registry = LocateRegistry.getRegistry(null);

            RMIInterface stub = (RMIInterface) registry.lookup("RMIInterface");
            stub.sayHello("CGServer from CGClient");

            SampleClass sc1 = new SampleClass(3);
            SampleClass sc2 = sc1;
            SampleClass sc3 = new SampleClass(5);
            System.out.println("ClientOp: sc1==sc2 is "+(sc1==sc2));
            stub.passObj(sc1, sc2);
            /*System.out.println("ClientOp: sc1==sc3 is "+(sc1==sc3));
            stub.passObj(sc1, sc3);
            sc3.setVar(3);
            System.out.println("ClientOp: sc1==sc3 after changing sc3 is "+sc1.equals(sc3));
            stub.passObj(sc1, sc3);*/

        } catch (Exception e)   {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
