package cg_interface;

import Sample.SampleClass;

public class RMIInterfaceImpl implements RMIInterface {
    @Override
    public String sayHello(String otherPerson) {
        System.out.println("Hello to "+otherPerson);
        return "Hello";
    }

    @Override
    public Boolean passObj(SampleClass sc1, SampleClass sc2) {
        System.out.println("Both objects have same reference: "+(sc1==sc2));
        return (sc1==sc2);
    }
}
