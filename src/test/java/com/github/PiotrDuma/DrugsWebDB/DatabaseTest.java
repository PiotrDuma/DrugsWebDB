package com.github.PiotrDuma.DrugsWebDB;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.sql.Connection;

public class DatabaseTest {
    @Test 
    public void getConnectionNotNullTest() {
    	
    	try {
    	Class<?> objClass = Class.forName("com.github.PiotrDuma.DrugsWebDB.Database");
    	Object obj = objClass.newInstance();
    	Method method = objClass.getMethod("getConnection");
    	method.setAccessible(true);
        assertNotNull(method.invoke(obj));
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    @Test
    public void getConnectionCorrectTypeTest(){
    	try {
	    	Class<?> objClass = Class.forName("com.github.PiotrDuma.DrugsWebDB.Database");
	    	Object obj = objClass.newInstance();
	    	Method method = objClass.getMethod("getConnection");
	    	method.setAccessible(true);
	    	System.out.println(Connection.class.isInstance(method.invoke(obj)));
	    	assertTrue(Connection.class.isInstance(method.invoke(obj)));
		}catch(Exception e) {
			System.out.println(e);
		}
    }
    
}