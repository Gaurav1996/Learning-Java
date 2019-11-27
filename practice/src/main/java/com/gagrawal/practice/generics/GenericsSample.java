package com.gagrawal.practice.generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericsSample {
    //simple generics
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    //Generic with multiple args
    public static <T,G> List<G> fromArrayToList(T[] a, Function<T,G> mapperFunction) {
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }

    //Upper bound generics
    public static double sumOfElementsOfList(List<? extends Number> numberList) {
        return numberList.stream().mapToDouble(Number::doubleValue).sum();
    }
}
