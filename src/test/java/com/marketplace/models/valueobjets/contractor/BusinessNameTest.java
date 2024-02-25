package com.marketplace.models.valueobjets.contractor;

import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessNameTest {

    @Test
    void businessNameIsValid() {
        // Prueba con un nombre comercial válido
        String validName = "Valid Business";
        assertDoesNotThrow(() -> new BusinessName(validName));
    }

    @Test
    void businessNameIsTooShort() {
        // Prueba con un nombre comercial que es demasiado corto
        String tooShortName = "A";
        assertThrows(InvalidBusinessNameException.class, () -> new BusinessName(tooShortName));
    }

    @Test
    void businessNameIsTooLong() {
        // Prueba con un nombre comercial que es demasiado largo
        String tooLongName = "This Business Name Is Too Long For The Allowed Length";
        assertThrows(InvalidBusinessNameException.class, () -> new BusinessName(tooLongName));
    }

    @Test
    void businessNameIsNull() {
        // Prueba con un nombre comercial nulo
        String nullName = null;
        assertThrows(InvalidBusinessNameException.class, () -> new BusinessName(nullName));
    }
}