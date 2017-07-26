/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Faiq
 */
public class ManagementSystemTest {
    
    public ManagementSystemTest() {
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
     * Test of initTable method, of class ManagementSystem.
     */
    @Test
    public void testInitTable() {
        System.out.println("initTable");
        ApplicationSystem instance = new ApplicationSystem();
        instance.initTable();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of makeReservation method, of class ManagementSystem.
     */
    @Test
    public void testMakeReservation() {
        System.out.println("makeReservation");
        int guests = 0;
        LocalTime time = null;
        ApplicationSystem instance = new ApplicationSystem();
        instance.makeReservation(guests, time);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
