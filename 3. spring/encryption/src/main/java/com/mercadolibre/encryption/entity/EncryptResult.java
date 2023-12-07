package com.mercadolibre.encryption.entity;

public class EncryptResult {
    private String encryptedMessage23;
    private String encryptedMessage012;

    public EncryptResult(String encryptedMessage23, String encryptedMessage012) {
        this.encryptedMessage23 = encryptedMessage23;
        this.encryptedMessage012 = encryptedMessage012;
    }

    public String getEncryptedMessage23() {
        return encryptedMessage23;
    }

    public void setEncryptedMessage23(String encryptedMessage23) {
        this.encryptedMessage23 = encryptedMessage23;
    }

    public String getEncryptedMessage012() {
        return encryptedMessage012;
    }

    public void setEncryptedMessage012(String encryptedMessage012) {
        this.encryptedMessage012 = encryptedMessage012;
    }
}
