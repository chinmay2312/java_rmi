

import Sample.SampleClass;
import cg_interface.RMIInterface;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static junit.framework.TestCase.*;

public class BasicTests {

    private RMIInterface stub;


    @Before
    @Test
    public void canConnectServerRegistry()   {
        boolean saidHello = false;
        String serverHello="";
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            stub = (RMIInterface) registry.lookup("RMIInterface");
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

    @Test
    public void maintainedReferentialIntegrity()   {
        SampleClass sc1 = new SampleClass(3);
        SampleClass sc2 = sc1;

        try {
            boolean serverVerdict = stub.passObj(sc1, sc2);
            assertTrue(serverVerdict);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
