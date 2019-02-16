package cg_interface;

import Sample.SampleClass;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote    {
    public String sayHello(String otherPerson) throws RemoteException;
    public Boolean passObj(SampleClass sc1, SampleClass sc2) throws RemoteException;
}