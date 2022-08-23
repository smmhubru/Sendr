package ru.smmhub.sendr.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    private HelloWorld helloWorld;
    private final long ID = 1L;
    private final String HELLO = "Hello world!";

    @BeforeEach
    void reload() {
        this.helloWorld = new HelloWorld(ID, HELLO);
    }

    @Test
    void getId() {
        assertEquals(ID, helloWorld.getId());
    }

    @Test
    void getHello() {
        assertEquals(HELLO, helloWorld.getHello());
    }

    @Test
    void setId() {
        long newId = 2;
        helloWorld.setId(newId);
        assertEquals(newId, helloWorld.getId());
    }

    @Test
    void setHello() {
        String newHello = "No more hellos";
        helloWorld.setHello(newHello);
    }

    @Test
    void testEquals() {
        HelloWorld equalHello = new HelloWorld(ID, HELLO);
        assertEquals(helloWorld, equalHello);
    }

    @Test
    void testHashCode() {
        HelloWorld equalHello = new HelloWorld(ID, HELLO);
        assertEquals(helloWorld.hashCode(), equalHello.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("HelloWorld(id=1, hello=Hello world!)", helloWorld.toString());
    }
}