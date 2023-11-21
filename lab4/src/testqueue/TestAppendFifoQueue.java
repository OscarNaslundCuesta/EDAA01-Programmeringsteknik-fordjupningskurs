package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> qA;
	private FifoQueue<Integer> qB;

	@BeforeEach
	void setUp() throws Exception {
		qA = new FifoQueue<Integer>();
		qB = new FifoQueue<Integer>();

	}

	@AfterEach
	void tearDown() throws Exception {
		qA = null;
		qB = null;

	}

	@Test
	void testConcatEmpty() {
		qA.append(qB);
		
		assertEquals(0, qA.size(), "Wrong size after concatenation");
		assertTrue(qA.isEmpty(), "qA not empty after concatenation");
		assertTrue(qB.isEmpty(), "qB not empty after concatenation");
	}

	@Test
	void testConcatEmptyToNonEmpty() {
		qA.offer(1);
		qA.offer(2);
		qA.append(qB);
		
		Iterator<Integer> itr = qA.iterator();
		
		for (int i = 1; i <= 2; i++) {
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
		}
		
		assertEquals(2, qA.size(), "Wrong size after concatenation");
		assertTrue(qB.isEmpty(), "qB not empty after concatenation");
	}

	@Test
	void testConcatNonEmptyToEmpty() {
		qB.offer(1);
		qB.offer(2);
		qA.append(qB);
		
		Iterator<Integer> itr = qA.iterator();
		
		for (int i = 1; i <= 2; i++) {
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
		}


		assertEquals(2, qA.size(), "Wrong size after concatenation");
		assertTrue(qB.isEmpty(), "qB not empty after concatenation");
	}

	@Test
	void testConcat() {
		qA.offer(1);
		qA.offer(2);
		qB.offer(3);
		qB.offer(4);
		
		qA.append(qB);
		
		Iterator<Integer> itr = qA.iterator();
		
		for (int i = 1; i <= 4; i++) {
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
		}
		
		assertEquals(4, qA.size(), "Wrong size after concatenation");
		assertTrue(qB.isEmpty(), "qB not empty after concatenation");
	}
	
	@Test
	void testSelfConcat() {
		qA.offer(1);
		qA.offer(2);
		
		assertThrows(IllegalArgumentException.class, () -> qA.append(qA));	}

}
