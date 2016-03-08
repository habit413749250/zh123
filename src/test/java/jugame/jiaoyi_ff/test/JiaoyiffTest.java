package jugame.jiaoyi_ff.test;


import jugame.jiaoyi_ff.controller.MyTest;

import org.junit.Before;
import org.junit.Test;


public class JiaoyiffTest  {

	MyTest myTest;
	
	@Before
	public void testInit(){
		myTest = new MyTest();
	}
	@Test
	public void testGetName(){
		myTest.getName("我是TEST");	
	}
}
