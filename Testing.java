package Test.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
	

	    MyArrayListWithBugs array;

	    @BeforeEach
	    void setUp() {
	        array = new MyArrayListWithBugs();
	    }

	    @Test
	    void TC1() {
	    	assertEquals(0, array.size());
	    	array.add(new RandomObject());
	    	assertEquals(1, array.size());
	    }
	    
	    @Test
	    void TC2() {
	    	assertEquals(0, array.size());
	    	RandomObject second = new RandomObject();
	    	array.add(new RandomObject());
	    	array.add(second);
	    	assertEquals(2, array.size());
	    	assertEquals(second, array.get(1));
	    }
	    
	    @Test
	    void TC3() {
	    	assertEquals(0, array.size());
	    	RandomObject first = new RandomObject();
	    	RandomObject second = new RandomObject();
	    	array.add(first);
	    	array.add(second);
	    	assertEquals(2, array.size());
	    	assertEquals(first, array.get(0));
	    	array.remove(0);
	    	assertEquals(second, array.get(0));
	    }
	    
	    @Test
	    void TC4() {
	    	assertEquals(0, array.size());
	    	RandomObject first = new RandomObject();
	    	RandomObject second = new RandomObject();
	    	RandomObject third = new RandomObject();
	    	RandomObject forth = new RandomObject();
	    	RandomObject fifth = new RandomObject();
	    	array.add(first);
	    	array.add(second);
	    	array.add(third);
	    	array.add(forth);
	    	assertEquals(4, array.size());
	    	assertEquals(forth, array.get(3));
	    	array.add(3, fifth);
	    	assertEquals(fifth, array.get(3));
	    	assertEquals(forth, array.get(4));
	    	assertEquals(5, array.size());
	    }
	    
	    @Test
	    void TC5() {
	    	assertEquals(0, array.size());
	    	array.add(new RandomObject());
	    	assertEquals(1, array.size());
	    	assertThrows(IndexOutOfBoundsException.class, ()->{array.remove(1);});
	    }
	    @Test
	    void TC6() {
	    	assertEquals(0, array.size());
	    	RandomObject first = new RandomObject();
	    	RandomObject second = new RandomObject();
	    	RandomObject third = new RandomObject();
	    	array.add(first);
	    	array.add(second);
	    	assertEquals(2, array.size());
	    	assertEquals(first, array.get(0));
	    	array.add(0, third);
	    	assertEquals(third, array.get(0));
	    	assertEquals(first, array.get(1));
	    	assertEquals(3, array.size());
	    }
	    
	    void TC7() {
	    	assertEquals(0, array.size());
	    	RandomObject same = new RandomObject();
	    	int i = 0;
	    	while(i < 10) {
	    		array.add(same);
	    		i++;
	    	}
	    	assertEquals(10, array.size());
	    }
	    
	    @Test
	    void TC8() {
	    	assertEquals(0, array.size());
	    	array.add(new RandomObject());
	    	assertEquals(1, array.size());
	    	assertThrows(IndexOutOfBoundsException.class, ()->{array.get(1);});
	    }
	    
	    @Test
	    void TC9() {
	    	assertEquals(0, array.size());
	    	assertThrows(IndexOutOfBoundsException.class, ()->{array.add(3, new RandomObject());});
	    }
	    
	    
	    @Test
	    void BoundaryTest1(){
	        RandomObject o = new RandomObject();
	        assertThrows(IndexOutOfBoundsException.class, ()->{array.add(-1, o);});
	    }

	    @Test
	    void BoundaryTest2(){
	        RandomObject o = new RandomObject();
	        array.add(0, o);
	        assertEquals(1, array.size());
	    }

	    @Test
	    void BoundaryTest3(){

	        /////////// Cannot take in indexes higher than current free spot.

	        RandomObject o = new RandomObject();
	        array.add(Integer.MAX_VALUE, o);
	    }

	    @Test
	    void BoundaryTest4(){
	        RandomObject o = new RandomObject();
	        assertThrows(IndexOutOfBoundsException.class, ()->{array.add(Integer.MAX_VALUE+1, o);});

	    }







	

}
