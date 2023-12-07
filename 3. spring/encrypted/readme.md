## Encryption Api

This API allows to perform a customized encryption of the cesar cipher. In this api you can send the sentence to encrypt (only letters, no numbers or special characters) and the encrypted sentence will be returned with the key {2,3}, that is to say first a rotation of 2 and then 3 and again 2 until the whole string is encrypted.
It is also possible to send the desired key for encryption.

**URL:** http://localhost:8080/api/v1/encryptor

Examples of Postman queries:

### 1. Key default [2,3]: 
![post-default.png](img%2Fpost-default.png)

### 2. Key sent:

![post-key-sent.png](img%2Fpost-key-sent.png)

