package Sample;

import java.io.Serializable;

public class SampleClass implements Serializable {
    int var;

    public SampleClass(int var)  {
        this.var = var;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }
}
