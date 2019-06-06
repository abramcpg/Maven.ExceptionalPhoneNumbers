package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory { //generates phone numbers



    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber createRandomPhoneNumber[] = new PhoneNumber[phoneNumberCount]; //declare object array of phone numbers


        return createRandomPhoneNumber;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = ThreadLocalRandom.current().nextInt(100,999);
        int centralOfficeCode = ThreadLocalRandom.current().nextInt(100,999);
        int phoneLineCode = ThreadLocalRandom.current().nextInt(1000,9999);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumberString = "";
        phoneNumberString = "(" + areaCode + ")-" + centralOfficeCode + "-"+ phoneLineCode;
        try {
            return createPhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException xcep) {
            logger.log(Level.FINE, phoneNumberString + " is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        try {
            logger.log(Level.FINE, "Attempting to create a new phoneNumber object with a value of "+phoneNumberString);
            return new PhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException xcep){
            throw new InvalidPhoneNumberFormatException();
        }
    }
}
