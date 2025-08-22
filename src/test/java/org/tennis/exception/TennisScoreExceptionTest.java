package org.tennis.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TennisScoreExceptionTest {

    @Test
    void testConstructor_setsMessageCorrectly() {
        String message = "Score error";
        TennisScoreException ex = new TennisScoreException(message);
        assertEquals(message, ex.getMessage());
    }

    @Test
    void testIsRuntimeException() {
        TennisScoreException ex = new TennisScoreException("Test");
        assertInstanceOf(RuntimeException.class, ex);
    }
}

