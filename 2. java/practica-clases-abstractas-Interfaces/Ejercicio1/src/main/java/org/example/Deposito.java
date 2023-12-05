package org.example;

import javax.naming.AuthenticationNotSupportedException;

public class Deposito implements ITransaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito");
    }

}
