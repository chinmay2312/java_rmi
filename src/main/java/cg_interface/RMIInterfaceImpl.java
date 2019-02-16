package cg_interface;

import Sample.SampleClass;

public class RMIInterfaceImpl implements RMIInterface {
    @Override
    public void sayHello(String otherPerson) {
        System.out.println("Hello to "+otherPerson);

    }

    @Override
    public void passObj(SampleClass sc1, SampleClass sc2) {
        System.out.println("Both objects have same reference: "+(sc1==sc2));
    }
}
