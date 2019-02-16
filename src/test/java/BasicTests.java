

import cg_interface.RMIInterface;
import org.junit.Test;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static junit.framework.TestCase.*;

public class BasicTests {

    @Test
    public static void canConnectServerRegistry()   {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            RMIInterface stub = (RMIInterface) registry.lookup("RMIInterface");
            String serverHello = stub.sayHello("CGServer from CGClient");
            assertTrue(serverHello.equalsIgnoreCase("Hello"));
        } catch (Exception e)    {

        }
    }
}
