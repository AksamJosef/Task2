package test.realization;

import test.AbstractPaymentXsd;

public class AbstractMapper <T extends AbstractPaymentXsd> {

    T xsd;

    public void doAction() {
        xsd.print();
    }
}
