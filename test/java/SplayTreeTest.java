/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jefe de jefes
 */
public class SplayTreeTest {
    
    public SplayTreeTest() {
    }
  

    /**
     * Test of get method, of class SplayTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        SplayTree<String,String> instance = null;
        instance = new SplayTree<>();
        String expResult = "hola";
        instance.put(expResult, "hi");
        String result = instance.get(expResult);
        assertEquals("hi", result);
    }

    /**
     * Test of put method, of class SplayTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        SplayTree<String,String> instance = null;
        instance = new SplayTree<>();
        String expResult = "simon";
        String value = "bolivar";
        instance.put(expResult, value);
        String result = instance.get(expResult);
        assertEquals(value, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    
}
