

import cg_interface.RMIInterface;
import junit.framework.Assert;
import org.junit.Test;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static junit.framework.TestCase.*;

public class BasicTests {

    @Test
    public void canConnectServerRegistry()   {
        boolean saidHello = false;
        String serverHello="";
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            RMIInterface stub = (RMIInterface) registry.lookup("RMIInterface");
            serverHello = stub.sayHello("CGServer from CGClient");
            saidHello = true;
            assertTrue(serverHello.equalsIgnoreCase("Hello"));
        } catch (Exception e)    {
            if(saidHello)
                fail("Returned "+serverHello+" instead of \"Hello\"");
            else
                fail("Could not register");
        }
    }
}
