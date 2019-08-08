package com.github.adrienmos.hashSet;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StringHashSetTest {

    @Test
    public void sizeShouldReturnCountOfElementsInserted() {

        Set<String> set = new StringHashSet();
        set.add("Adam");
        set.add("Asia");
        set.add("Aleks");
        set.add("Rafał");
        set.add("Łukasz");
        set.add("Adrian");

        assertEquals(6, set.size());
    }

    @Test
    public void sizeShouldReturnOfOrEmptySet() {
        Set<String> set = new StringHashSet();
        assertEquals(0, set.size());
    }

//    @Test
//    public void shouldAddElementAndIncreaseSetSize() {
//
//        Condition<StringHashSet> Contains
//    }

    @Test
    public void shouldReturn0ForEmptiedSet() {
        Set<String> set = new StringHashSet();
        set.add("Adam");
        set.remove("Adam");
        assertEquals(0, set.size());
    }

    @Test
    public void addTest() {
        Set<String> set = new StringHashSet();
        set.add("Adrian");

        assertTrue(set.contains("Adrian"));
    }

    @Test
    public void addAllTest() {
        assertEquals(true, true );
    }

    @Test
    public void isEmptyTest() {
        Set<String> set = new StringHashSet();

        assertTrue(set.isEmpty());

        set.add("Adrian");
        assertFalse(set.isEmpty());

    }

    @Test
    public void sizeTest() {
        Set<String> set = new StringHashSet();

        assertEquals(0, set.size());
    }

    @Test
    public void removeTest() {
        Set<String> set = new StringHashSet();
    }
}