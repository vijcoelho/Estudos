import classes.Produto;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        exc3();
        exc4();
    }

    public static void exc3() {
        final Scanner scanner = new Scanner(System.in);
        final Produto produto = new Produto(1, "Sabao", 10);
        final Produto produto2 = new Produto(2, "Sabao em po", 3);

        final Map<String, Produto> map = Map.of(
                String.valueOf(produto.getCodigo()), produto,
                String.valueOf(produto2.getCodigo()), produto2
        );

        System.out.print("Digite o codigo do produto: ");
        final String num = scanner.next();

        final Produto find = map.get(num);
        if (Objects.nonNull(find)) {
            System.out.println(find);
        } else {
            System.out.println("Nao achou!");
        }

        System.out.println(map);
    }


    public static void exc4() {
        final Map<String, List<Double>> emprestimo = new HashMap<>();

        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);
        adicionarParcela(emprestimo, "123.456.789-10", 100);

        System.out.println(emprestimo);

        System.out.println(totalDevedor(emprestimo, "123.456.789-10"));

        exibirRelatorioDevedor(emprestimo);
    }

    public static void adicionarParcela(
            final Map<String, List<Double>> emprestimo,
            final String cpf,
            final double parcela
    ) {
        if (Objects.isNull(emprestimo.get(cpf))) {
            emprestimo.put(cpf, new ArrayList<>());
        } else {
            final List<Double> list = emprestimo.get(cpf);
            list.add(parcela);
            emprestimo.put(cpf, list);
        }
    }

    public static double totalDevedor(
            final Map<String, List<Double>> emprestimos,
            final String cpf
    ) {
        if (Objects.isNull(emprestimos.get(cpf))) {
            System.out.println("Cpf nao encontrado.");
            return 0;
        } else {
            final List<Double> list = emprestimos.get(cpf);

            int soma = 0;
            for (Double aDouble : list) {
                soma += aDouble;
            }
            return soma;
        }
    }

    public static void exibirRelatorioDevedor(final Map<String, List<Double>> emprestimos) {
        int somaTotal = 0;

        for (Map.Entry<String, List<Double>> entry : emprestimos.entrySet()) {
            final List<Double> listaDeEmprestimos = entry.getValue();

            for (Double valorDoEmprestimo : listaDeEmprestimos) {
                somaTotal += valorDoEmprestimo;
            }
        }

        System.out.println(somaTotal);
    }

}







    //        Exercício 4 – Agenda Telefônica – Set + List
//        Contexto:
//        Uma empresa quer manter contatos únicos, mas também exibir a lista ordenada por nome.
//                Requisitos:
//        Criar a classe Contato com nome, telefone e email.
//
//
//        Usar Set<Contato> para armazenar contatos sem duplicatas (unicidade baseada no email).
//
//
//        Converter o Set em List<Contato> para exibição ordenada por nome.
//
//
//        Exibir todos os contatos.
