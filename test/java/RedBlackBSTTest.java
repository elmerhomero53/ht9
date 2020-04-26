/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jefe de jefes
 */
public class RedBlackBSTTest {
    
    public RedBlackBSTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  
    /**
     * Test of get method, of class RedBlackBST.
     */
    @Test
    public void testGet() {
        System.out.println("get rbtree");
        RedBlackBST<String,String> instance = null;
        instance = new RedBlackBST<>();
        String key = "hola";
        String expResult = "hi";
        instance.put(key,expResult);
        String result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of contains method, of class RedBlackBST.
     */
  

    /**
     * Test of put method, of class RedBlackBST.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        RedBlackBST<String,String> instance = null;
        instance = new RedBlackBST<>();
        String key = "simon";
        String expResult = "bolivar";
        instance.put(key, expResult);
        String result = instance.get(key);
        assertEquals(expResult, result);
    }

    
}
