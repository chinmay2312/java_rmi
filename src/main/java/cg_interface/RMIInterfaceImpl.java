package cg_interface;

import Sample.SampleClass;

import java.rmi.RemoteException;

public class RMIInterfaceImpl implements RMIInterface {
    @Override
    public void sayHello(String otherPerson) throws RemoteException {
        System.out.println("Hello to "+otherPerson);

    }

    @Override
    public void passObj(SampleClass sc1, SampleClass sc2) throws RemoteException {
        System.out.println("Both objects are same: "+sc1.equals(sc2));
    }
}
