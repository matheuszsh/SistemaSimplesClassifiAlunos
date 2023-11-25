package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import entities.Aluno;
import util.limparTela;

public class sistemaDeClassifAlunos {
    static ArrayList <Aluno> alunos;
    static Scanner get = new Scanner(System.in);

    public static void main(String[] args){
        Locale.setDefault(Locale.US);

        //Importando a interface de lista
        alunos = new ArrayList<>();

        menu();
        //cadAlunoNotas();


    }
    public static void menu(){
        int opDeMenu = 0;
        do {
            System.out.println("***** MENU CADASTRO DE NOTAS ALUNOS *****\n");
            System.out.println("(1) - Cadastrar alunos");
            System.out.println("(2) - Mostrar Alunos cadastrados");
            System.out.println("(3) - Editar alunos");
            System.out.println("(4) - Classificação De Alunos\n");
            System.out.println("(0) - Sair");
            System.out.print(">>>:");
            opDeMenu = get.nextInt();
            get.nextLine();
        }while (!(opDeMenu >= 0 && opDeMenu <= 4));

        limparTela.limpar();

        switch (opDeMenu){
            case 0:
                System.out.println("Programa Encerrado.");
                System.exit(0);
                break;
            case 1:
                //Cadastrar Alunos
                cadNotasAlunos();
                break;
            case 2:
                //Mostrar alunos cadastrados
                mostrarAlunosCad();
                break;
            case 3:
                //Editar nome e notas
                editarAlunos();
                break;
            case 4:
                //Função pra dizer os alunos aprovados/reprovado
                classifiAlunos();
                break;
            default:
                System.out.println("Algo deu errado.");
                menu();
                break;
        }
    }

    //Função para cadastrar alunos
    public static void cadNotasAlunos(){
        //Entrada de dados alunos
        String nome;
        Double[] notas = new Double[4];

        System.out.print("Nome Aluno:");
        nome = get.nextLine();

        System.out.println("<Notas>\n");
        for (int n = 0; n < notas.length; n++) {
            do {
                System.out.printf("NOTA %d: ", n+1);
                notas[n] = get.nextDouble();
                get.nextLine();
            }while (!(notas[n] >= 0 && notas[n] <= 10));
        }

        alunos.add(new Aluno(nome,notas));

        limparTela.limpar();

        for (Aluno a: alunos) {
            System.out.println(a);
            System.out.println();
        }

        menu();
    }

    //Função para mostrar Alunos
    public static void mostrarAlunosCad(){
        int opBuscaA;

        System.out.println("Selecione a opção:\n(1)Todos os alunos\n(2)Buscar aluno\n\n(0)Cancelar\n\n>>>:");
        opBuscaA = get.nextInt();
        get.nextLine();

        switch (opBuscaA){
            case 0:
                limparTela.limpar();
                menu();
                break;
            case 1:
                System.out.println("ALUNOS CADASTRADOS:\n");
                for (Aluno listA: alunos){
                    System.out.println(listA);
                    System.out.println();
                }
                break;
            case 2:
                int buscaId;

                System.out.print("Indique o ID do aluno: ");
                buscaId = get.nextInt();
                get.nextLine();

                for(Aluno aluno: alunos){
                    if (aluno.getId() == buscaId){
                        System.out.println(aluno);
                    }
                }
                break;
            default:
                limparTela.limpar();
                System.out.println("Algo deu errado.");
                menu();
                break;
        }

        System.out.println("ENTER para voltar ao menu.");
        get.nextLine();

        menu();
    }

    //Função pra editar Alunos
    public static void editarAlunos(){
        //Utilizar o Id pra fazer a comparação na lista
        int buscaId;

        System.out.print("Indique o ID do aluno: ");
        buscaId = get.nextInt();
        get.nextLine();

        for (Aluno listA: alunos){
            if (listA.getId() == buscaId){
                Double[] notas = new Double[4];

                System.out.println("Insira Novos dados: ");
                System.out.printf("Nome atual: %s\n", listA.getNome());
                System.out.print("Novo nome: ");
                listA.setNome(get.nextLine());

                for (int n = 0; n < notas.length; n++){

                    do {
                        System.out.printf("Nota %d:",n+1);
                        notas[n] = get.nextDouble();
                        get.nextLine();
                    }while (!(notas[n] >= 0 && notas[n] <= 10));
                }

                listA.setTodasNotas(notas);
                menu();
            }
        }
    }

    //Função Classificar alunos
    
    public static void classifiAlunos(){
        for(Aluno listA: alunos){
            if (listA.getTotalNotas() >= 6){
                System.out.println(listA);
                System.out.println("STATUS: APROVADO\n");
            }
            else {
                System.out.println(listA);
                System.out.println("STATUS: REPROVADO\n");
            }
            System.out.printf("Nota Final: %.1f\n\n", listA.getTotalNotas());
            System.out.println("----------------------------------------");
        }

        System.out.println("ENTER para voltar ao menu.");
        get.nextLine();

        menu();
    }
}

