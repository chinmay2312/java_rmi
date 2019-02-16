package cg_client;


import Sample.SampleClass;
import cg_interface.RMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientOp {
    //private static RMIInterface lookUp;

    private ClientOp()  {}

    public static void main(String[] args) {
        /*lookUp = (RMIInterface) Naming.lookup("//localhost/CGServer");
        String heyServer = JOptionPane.showInputDialog("Hello ServerOp");

        String res = lookUp.sayHello(heyServer);
        JOptionPane.showConfirmDialog(null, res);
        */

        try {
            //No need to pass port number as parameter, since 1099 is the default port
            Registry registry = LocateRegistry.getRegistry(null);

            RMIInterface stub = (RMIInterface) registry.lookup("RMIInterface");
            stub.sayHello("CGServer from CGClient");

            SampleClass sc1 = new SampleClass(3);
            SampleClass sc2 = sc1;
            //SampleClass sc3 = new SampleClass(5);
            System.out.println("ClientOp: sc1==sc2 is "+(sc1==sc2));
            Boolean serverResult = stub.passObj(sc1, sc2);
            System.out.println("ServerOp: sc1==sc2 is "+serverResult);

            /*stub.passObj(sc1, sc3);
            sc3.setVar(3);
            System.out.println("ClientOp: sc1==sc3 after changing sc3 is "+sc1.equals(sc3));
            stub.passObj(sc1, sc3);*/

        } catch (Exception e)   {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
