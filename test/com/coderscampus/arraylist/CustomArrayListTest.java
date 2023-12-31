package com.coderscampus.arraylist;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	// Tests adding and resizing array
	@Test
	public void should_add_one_item_to_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		sut.add(1);
		Integer expectedResult = sut.get(0);
		Integer expectedSize = sut.getSize();

		assertEquals(1, expectedResult);
		assertEquals(10, expectedSize);
	}

	@Test
	public void should_add_20_items_to_the_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 20; i++) {
			sut.add(i);
		}

		assertEquals(20, sut.getSize());
		assertEquals(19, sut.get(19));

	}

	@Test
	public void should_NOT_resize_list_at_ten_items() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.remove(9);
		sut.remove(7);
		sut.add(1000);
		sut.add(1001);

		assertEquals(10, sut.getSize());
		assertEquals(1000, sut.get(8));
		assertEquals(1001, sut.get(9));
	}

	@Test
	public void should_NOT_resize_list_when_adding_at_index_when_length_is_10() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.remove(9);
		sut.remove(7);
		sut.add(1000);
		sut.add(7, 1001);

		assertEquals(10, sut.getSize());
		assertEquals(1000, sut.get(9));
		assertEquals(8, sut.get(8));
		assertEquals(1001, sut.get(7));

	}

	@Test
	public void should_resize_list_at_11_items() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.add(1000);

		assertEquals(20, sut.getSize());
		assertEquals(1000, sut.get(10));

	}

	@Test
	public void should_add_item_at_first_null_after_multiple_method_calls() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.remove(9);
		sut.remove(7);
		sut.add(1000);
		sut.add(7, 1001);
		sut.add(7, 1002);
		sut.add(7, 89);
		sut.remove(7);
		sut.add(2000);

		assertEquals(20, sut.getSize());
		assertEquals(2000, sut.get(11));

	}

	// Tests adding items at various parts of array
	@Test
	public void should_add_item_at_null() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.remove(9);
		sut.remove(7);
		sut.add(1000);
		sut.add(2000);

		assertEquals(1000, sut.get(8));
		assertEquals(2000, sut.get(9));
		assertEquals(10, sut.getSize());
	}
	

	@Test
	public void should_add_item_to_beginning_of_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i <= 10; i++) {
			sut.add(i);
		}
		sut.add(0, 5);

		assertEquals(5, sut.get(0));
		assertEquals(20, sut.getSize());

	}

	@Test
	public void should_add_item_to_specified_index() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}
		sut.add(4, 5);

		assertEquals(20, sut.getSize());
		assertEquals(5, sut.get(4));
	}

	@Test
	public void should_add_element_to_end_of_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.add(9, 1);

		assertEquals(1, sut.get(9));
		assertEquals(20, sut.getSize());
	}

	@Test
	public void should_throw_exception_when_adding_at_index_that_does_not_exist() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}
		
		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(12,3));
	}

	// Test the getSize method
	@Test
	public void should_get_size_of_empty_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		sut.getSize();

		assertEquals(10, sut.getSize());
	}

	@Test
	public void should_get_size_of_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}
		Integer size = sut.getSize();

		assertEquals(10, size);
	}

	// Test the get method
	@Test
	public void should_get_item_at_specfied_index() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.get(0);

		assertEquals(0, sut.get(0));
	}

	@Test
	public void should_get_item_after_removing_and_adding() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.remove(0);
		sut.add(0, 5);
		sut.get(0);

		assertEquals(5, sut.get(0));
		assertEquals(1, sut.get(1));
		assertEquals(10, sut.getSize());
	}

	@Test
	public void should_throw_exception_when_get_index_does_not_exist() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(12));
	}

	// Test the remove method
	@Test
	public void should_remove_item_from_beginning_of_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}
		sut.remove(0);

		assertEquals(10, sut.getSize());
		assertEquals(1, sut.get(0));
	}

	@Test
	public void should_remove_item_at_the_end_of_the_list() {
		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		sut.remove(9);

		assertEquals(sut.get(9), null);
		assertEquals(10, sut.getSize());
		assertEquals(8, sut.get(8));

	}

	@Test
	public void should_remove_item_at_specified_index() {

		CustomList<Integer> sut = new CustomArrayList<>();

		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}
		sut.remove(8);

		assertEquals(9, sut.get(8));
		assertEquals(null, sut.get(9));
		assertEquals(10, sut.getSize());
	}

	@Test
	public void should_throw_exception_when_remove_index_does_not_exist(){
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}

		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(12));
	}
}
