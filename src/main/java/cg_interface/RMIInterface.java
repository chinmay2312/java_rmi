package cg_interface;

import Sample.SampleClass;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote    {
    public void sayHello(String otherPerson) throws RemoteException;
    public void passObj(SampleClass sc1, SampleClass sc2) throws RemoteException;
}