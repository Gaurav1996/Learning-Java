package com.gagrawal.practice.nonaccessmodifiers;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TransientFinalExampleTest {
    @Test
    void assertSerialiseDeserialiseFunctionality() {
        final String fileName = "test.ser";
        /**
         * <b>RULES</b>
         * So when we declare any variable as both final & transient, then there are 2 cases,
         *
         *
         *
         * Case 1: Initializing final transient variable at the time of declaration (explicit initialization)
         * This case is very simple, as during serialization process directly value is serialized instead of final variable
         * Important : There is no impact on final variable declaring as transient
         * In the below example customerAge is declared as final as well as transient and explicitly initialized with value 10
         *
         *
         * Case 2 & 3: Initializing final transient variable inside constructor or instance block
         * Serialization :
         * These cases are bit tricky; when we serialize an Object
         *
         * all non-final instance variables will be serialized
         * all non-final transient variable won’t be serialized
         * all final non-transient variable will be serialized (directly as values)
         * Important : But all final transient variable won’t be serialized
         * De-Serialization :
         * During de-serialization process, constructor of an object isn’t invoked and this is handled by JVM for object instantiation
         * after de-serialization process final transient variable will be assigned to default value
         */
        try {
            TransientFinalExample serialiseObject = new TransientFinalExample(100, "Gaurav", 201258);
            writeToFile(serialiseObject, fileName);
            System.out.println("Serialization Success, object saved to file");
            TransientFinalExample deserialiseObject = readFromFile(fileName);
            assertEquals(deserialiseObject.customerId,100);
            assertEquals(deserialiseObject.customerName,null);
            assertEquals(deserialiseObject.customerAge,10);
            assertEquals(deserialiseObject.customerSSN,0);
            /**
             * Explanation:
             *
             * During Serialization process, in above Customer POJO,
             *
             * final customerId variable will be serialized
             * final transient customerName variable won’t be serialized
             * explicitly initialized final transient customerAge variable will be serialized directly as value
             * regular transient customerSSN instance variable won’t be serialized
             * During De-Serialization process,
             *
             * final customerId variable will be de-serialized and restored
             * final transient customerName variable will be restored to default value, as it doesn’t get serialized (null for this case)
             * explicitly initialized final transient customerAge variable will be restored correctly as it’s saved as value directly
             * regular transient customerSSN instance variable will be restored to default value (0 for this case)
             */
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /**
         * Conclusion:
         *
         * If final transient variable is initialized in any other way except explicitly initializing at the time of declaration, then value restored back during de-serialization is default value. Like 0 for integer, null for String, etc
         * But explicit initialization of final transient variable will result in getting back original back for respective fields during de-serialization
         * Whereas, final transient variable initialized by using instance block or constructor will assign default values for respective fields during de-serialization
         */
    }

    private TransientFinalExample readFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientFinalExample deserialiseObject = (TransientFinalExample) ois.readObject();
        ois.close();
        return deserialiseObject;
    }

    private void writeToFile(TransientFinalExample serialiseObject, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(serialiseObject);
        oos.flush();
        oos.close();
    }
}
