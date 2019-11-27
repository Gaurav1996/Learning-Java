package com.gagrawal.practice.generics;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericsTest {
    private Integer[] intArray = {1,2,3,4,5};

    @Test
    void assertThatIntegerArrayConvertedToList() {
        List<Integer> integerList = GenericsSample.fromArrayToList(intArray);
        assertThat(integerList, hasItems(1,2,3,4,5));

    }
    @Test
    void assertThatIntegerArrayConvertedToStringList() {
        List<String> stringList = GenericsSample.fromArrayToList(intArray, Objects::toString);
        assertThat(stringList, hasItems("1","2","3","4","5"));
    }

    @Test
    void assertTheSumOfList() {
        List<Integer> integerList = GenericsSample.fromArrayToList(intArray);
        assertEquals(15,GenericsSample.sumOfElementsOfList(integerList));
//        List<String> stringList = GenericsSample.fromArrayToList(intArray, Objects::toString);
//        assertThrows(Exception.class,GenericsSample.sumOfElementsOfList(stringList));
    }

}
