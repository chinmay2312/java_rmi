package cg_client;


import Sample.SampleClass;
import cg_interface.RMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientOp {
    //private static RMIInterface lookUp;

    private ClientOp()  {}

    public static void main(String[] args) {
        /*lookUp = (RMIInterface) Naming.lookup("//localhost/CGServer");
        String heyServer = JOptionPane.showInputDialog("Hello ServerOp");

        String res = lookUp.sayHello(heyServer);
        JOptionPane.showConfirmDialog(null, res);
        */

        Logger logger = Logger.getLogger("ClientOp");

        try {
            //No need to pass port number as parameter, since 1099 is the default port
            Registry registry = LocateRegistry.getRegistry(null);

            RMIInterface stub = (RMIInterface) registry.lookup("RMIInterface");

            logger.log(Level.INFO, "Looked up RMIInterface on registry");

            stub.sayHello("CGServer from CGClient");

            logger.log(Level.FINE, "Hello from server");

            SampleClass sc1 = new SampleClass(3);
            SampleClass sc2 = sc1;
            //SampleClass sc3 = new SampleClass(5);
            logger.log(Level.FINER, "ClientOp: sc1==sc2 is "+(sc1==sc2));

            boolean serverResult = stub.passObj(sc1, sc2);

            logger.log(Level.FINE, "ServerOp replied: sc1==sc2 is "+serverResult);

            /*stub.passObj(sc1, sc3);
            sc3.setVar(3);
            System.out.println("ClientOp: sc1==sc3 after changing sc3 is "+sc1.equals(sc3));
            stub.passObj(sc1, sc3);*/

        } catch (Exception e)   {
            logger.log(Level.SEVERE, "Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
