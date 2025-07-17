package com.project;

import com.project.classes.Item;
import com.project.classes.Pessoa;
import com.project.classes.Produto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        exercicio1();
//        exercicio2();
//        exercicio3();
//        exercicio4();
//        exercicio5();
//        exercicio6();
//        exercicio7();
//        exercicio8();
//        exercicio9();
//        exercicio10();
//        exercicio11();
//        exercicio12();
//        exercicio13();
//        exercicio14();
//        exercicio15();
//        exercicio16();
//        exercicio17();
//        exercicio18(5);
//        exercicio19();
        exercicio20();
    }

    public static void exercicio1() {
        final List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        list.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(System.out::println);
    }

    public static void exercicio2() {
        final List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        list.stream()
                .map(numero -> numero * 2)
                .forEach(System.out::println);
    }

    public static void exercicio3() {
        final List<String> list = List.of("oi", "tchau", "tudo", "bem");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void exercicio4() {
        final List<String> list = List.of("oi", "tchau", "tudo", "bem");
        list.forEach(System.out::println);
    }

    public static void exercicio5() {
        final List<String> list = List.of("oi", "tchau", "tudo", "bem");
        long count = list.stream().count(); // .size();
        System.out.println(count);
    }

    public static void exercicio6() {
        final List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        int soma = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.print(soma);
    }

    public static void exercicio7() {
        final List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        final Integer produto = list.stream()
                .mapToInt(Integer::intValue)
                .reduce(1, (i, j) -> i * j);
        System.out.println(produto);
    }

    public static void exercicio8() {
        final List<Double> list = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 ,10.0);
        final double media = list.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElseGet(() -> 0.0);
        System.out.println(media);
    }

    public static void exercicio9() {
        final List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt()) ;
    }

    public static void exercicio10() {
        final List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt()) ;
    }

    public static void exercicio11() {
        final List<String> list = List.of("Ana", "Vitor", "Anastacia", "Isabella", "Gustavo", "Ana Clara");
        final List<String> onlyA = list.stream()
                .filter(nome -> nome.startsWith("A"))
                .toList();
        onlyA.forEach(System.out::println);
    }

    public static void exercicio12() {
        final List<Integer> list = List.of(2,2,3,4,5,5,7,9,9,10);
        final Set<Integer> set = list.stream()
                .mapToInt(Integer::intValue)
                .distinct()
                .boxed()
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    public static void exercicio13() {
        final List<String> list = List.of("Pedro", "Vitor", "Anastacia", "Isabella", "Gustavo", "Ana Clara");
        final Map<Integer, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(String::length));
        map.forEach((i, j) -> System.out.println(i + " " + j));
    }

    public static void exercicio14() {
        final List<String> list = List.of("Pedro", "Vitor", "Anastacia", "Isabella", "Gustavo", "Ana Clara");
        final String nomes = list.stream() // String.join("," ,list);
                .collect(Collectors.joining(","));
        System.out.println(nomes);
    }

    public static void exercicio15() {
        final List<Produto> produtos = List.of(
                new Produto("Vitor", 100.0),
                new Produto("Isabella", 540.0)
        );

        final Double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println(total);
    }

    public static void exercicio16() {
        final List<Pessoa> pessoas = List.of(
                new Pessoa("Vitor", 21),
                new Pessoa("Isabella", 24),
                new Pessoa("Julia", 8),
                new Pessoa("Marco", 53)
        );

        final List<String> maior18 = pessoas.stream()
                .filter(i -> i.getIdade() >= 18)
                .map(Pessoa::getNome)
                .toList();
        System.out.println(maior18);
    }

    public static void exercicio17() {
        final List<Item> itens = List.of(
                new Item(1, "pedra"),
                new Item(1, "cama"),
                new Item(2, "tesoura"),
                new Item(3, "faca"),
                new Item(3, "garfo")
        );

        final List<Item> list = itens.stream()
                .collect(Collectors.toMap(
                        Item::id,
                        item -> item,
                        (existing, newItem) -> existing
                ))
                .values()
                .stream()
                .toList();

        list.forEach(System.out::println);
    }

    public static void exercicio18(final Integer n) {
        final List<String> list = List.of("Pedro", "Vitor", "Anastacia", "Isabella", "Gustavo", "Ana Clara");
        final Optional<String> find = Optional.of(list.stream()
                .skip(n)
                .findFirst()
                .orElseGet(() -> "Nao achou!"));
        System.out.println(find.get());
    }

    public static void exercicio19() {
        final List<Integer> list = List.of(1,2,3,0,5,-10,7,0,-9,-10);
        list.stream()
                .filter(numeros -> numeros > 0)
                .forEach(System.out::println);
    }

    public static void exercicio20() {
        Stream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }
}