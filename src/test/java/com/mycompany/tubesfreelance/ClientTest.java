package com.mycompany.tubesfreelance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testConstructorAndGetUsername() {
        Client client = new Client("testClient", "securePassword");
        assertEquals("testClient", client.getUsername());
    }

    @Test
    public void testCheckPasswordSuccess() {
        Client client = new Client("testClient", "securePassword");
        assertTrue(client.checkPassword("securePassword"));
    }

    @Test
    public void testCheckPasswordFailure() {
        Client client = new Client("testClient", "securePassword");
        assertFalse(client.checkPassword("wrongPassword"));
    }

    @Test
    public void testDefaultSaldo() {
        Client client = new Client("testClient", "securePassword");
        assertEquals(1000000.0, client.getSaldo(), 0.001);
    }

    @Test
    public void testSetSaldo() {
        Client client = new Client("testClient", "securePassword");
        client.setSaldo(500000.0);
        assertEquals(500000.0, client.getSaldo(), 0.001);
    }
}
