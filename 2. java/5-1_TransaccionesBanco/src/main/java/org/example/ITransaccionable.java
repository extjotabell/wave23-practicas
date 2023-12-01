package org.example;

public interface ITransaccionable {
     void transaccionOk();
     default void noTransaccionOk(){
          throw new UnsupportedOperationException("No puede realizar operacion");
     }

}
