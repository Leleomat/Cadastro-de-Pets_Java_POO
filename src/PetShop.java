import java.util.ArrayList;
import java.util.Scanner;

public class PetShop {
    // Criando uma lista de objetos Tutor
    static ArrayList<Tutor> tut = new ArrayList<>();

    // Método para cadastrar os novos tutores e seus pets
    public static void cadastraTutor(Scanner scanner) {
        int auxiliar = 0, dia = 0, mes = 0, ano = 0;
        while(true){
            System.out.format("Digite nome do tutor (vazio encerra cadastro tutor): \n");
            String nomeTutor = scanner.nextLine();

            // Verificação se o input estiver vazio (Enter)
            if(nomeTutor == null || nomeTutor.trim().isEmpty()){
                break;
            }

            // Loop que chama o método verificador da data de nascimento
            while (auxiliar == 0) {
                System.out.format("Informe o nascimento do tutor:\nDia (dd): \n");
                dia = scanner.nextInt();
                clearBuffer(scanner);
                System.out.format("Mes (mm): \n");
                mes = scanner.nextInt();
                clearBuffer(scanner);
                System.out.format("Ano (aaaa): \n");
                ano = scanner.nextInt();
                clearBuffer(scanner);
                auxiliar = validador(dia, mes, ano);
            }
            System.out.format("Digite  o endereço do tutor/pet: \n");
            String endereco = scanner.nextLine();
            int codigo = geraCodTutor();

            // Chamando o método construtor para adicionar um novo Tutor
            tut.add(new Tutor(codigo, nomeTutor, endereco, dia, mes, ano));
            while (true) {
                System.out.print("Digite nome do pet (vazio encerra cadastro pet): \n");
                String nomePet = scanner.nextLine();

                // Verificação se o input estiver vazio (Enter)
                if(nomePet == null || nomePet.trim().isEmpty()){
                    break;
                }
                System.out.print("Digite tipo do pet: \n");
                String tipo = scanner.nextLine();
                for (Tutor t:tut) {
                    if (codigo == t.getCodigo()) {
                        t.criaPet(nomePet, tipo);
                    }
                }
                System.out.format("Pet adicionado com sucesso!\n");
            }
            System.out.format("Tutor adicionado com sucesso!\n");
        }
    }

    // Método para validar a data de nascimento do novo tutor
    public static int validador(int d, int m, int a) {
        if(a > 0 && m > 0 && d > 0){
            if(a % 4 == 0){
                if(m == 2 && d > 29){
                    System.out.println("Data inválida! Insira a data novamente");
                    return 0;
                }else if((m == 4 || m == 6 || m == 9 || m == 11) && d == 31){
                    System.out.println("Data inválida!  Insira a data novamente");
                    return 0;
                }else if(d < 32 && m < 13){
                    return 1;
                }else{
                    System.out.println("Data inválida! Insira a data novamente");
                    return 0;
                }
            }
            if(m == 2 && d >= 29){
                System.out.println("Data inválida! Insira a data novamente");
                return 0;
            }else if((m == 4 || m == 6 || m == 9 || m == 11) && d == 31){
                System.out.println("Data inválida! Insira a data novamente");
                return 0;
            }else if(d < 32 && m < 13){
                return 1;
            }else{
                System.out.println("Data inválida! Insira a data novamente");
                return 0;
            }
        }else{
            System.out.println("Data inválida! Insira a data novamente");
            return 0;
        }
    }

    // Método para gerar os códigos únicos de cada novo tutor
    public static int geraCodTutor(){ // Gera código p/ contribuinte.
        if (tut.size()==0)
            return 1;
        else // Incrementa o código do contribuinte no final da lista.
            return tut.get(tut.size()-1).getCodigo()+1;
    }

    // Método para remover o tutor
    public static void removerTutor(int cod){
        boolean del=false;
        for (Tutor t:tut){
            if (cod == t.getCodigo()){
                tut.remove(t);
                del=true;
                break;
            }
        }
        if (del) {
            System.out.println("--- Tutor (+pets) com codigo " + cod + " excluido com sucesso! ---");
        } else {
            System.out.println("--- Tutor (+pets) com codigo " + cod + " inexistente! ---");
        }
    }

    // Método para achar determinado tutor pelo seu código
    public static void buscarTutor(Scanner scanner){
        System.out.println("Digite o Código do Tutor que deseja achar.");
        int cod = scanner.nextInt();
        clearBuffer(scanner);
        int auxiliar = 0;

        for (Tutor t:tut){
            if (cod == t.getCodigo()){
                System.out.format("Informações do Tutor de código %d: \n", cod);
                System.out.println(t.toString());
                auxiliar = 1;
            }
        }
        if (auxiliar == 0){
            System.out.println("Tutor não encontrado!");
        }
    }

    // Método para popular o cadastro no início do programa
    public static void popularCadastro() {

        Tutor tutor1 = new Tutor(geraCodTutor(), "Zeca Silva Soares", "Rua Tupi, 32", 11, 9, 2000);
        tutor1.criaPet("Rex", "Cachorro");
        tut.add(tutor1);

        Tutor tutor2 = new Tutor(geraCodTutor(), "Zeca Silva Afonso", "Rua Tupi, 33", 12, 10, 2001);
        tutor2.criaPet("Miau", "Gato");
        tut.add(tutor2);

        Tutor tutor3 = new Tutor(geraCodTutor(), "Zeca Silva Carvalho", "Rua Tupi, 34", 13, 11, 2002);
        tutor3.criaPet("Piu", "Pássaro");
        tut.add(tutor3);
    }

    // Método para imprimir os tutores cadastrados
    public static void imprimeTutor(){
        System.out.format("\n++ Cadastro dos Tutores ++\n");
        if (tut.size()==0)
            System.out.println(" Tutores: Nenhum cadastrado.");
        else{
            for (Tutor t:tut)
                // Chamando o método que exibe as informações de um Tutor e seus pets
                System.out.print(t.toString());
        }
    }

    // Método principal do programa
    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);
        popularCadastro();
        System.out.println();
        menu(scanner);

    }

    // Método do menu, com a interface e suas opções
    public static void menu(Scanner scanner){

        while(true) {
            int d;
            // Interface
            System.out.format("\n~~~ PET SIEMENS ~~~\nSistema de cadastro de Pets\n");
            System.out.format("1 - Cadastro de Tutores e Pets\n2 - Mostrar Cadastro\n" +
                    "3 - Buscar Pets por Código Tutor\n4 - Excluir Pets por Código Tutor\n5 - Encerrar o Programa.\n");
            System.out.format("Opção: ");
            d = scanner.nextInt();
            clearBuffer(scanner);
            switch (d) {
                // Chama função de cadastro
                case 1:
                    cadastraTutor(scanner);
                    break;
                // Chama função de impressão
                case 2:
                    imprimeTutor();
                    break;
                // Chama função de busca
                case 3:
                    buscarTutor(scanner);
                    break;
                // Chama função de remoção
                case 4:
                    System.out.println("Digite o código do usuário que deseja excluir");
                    int cod = scanner.nextInt();
                    clearBuffer(scanner);
                    removerTutor(cod);
                    break;
                // Chama encerra o programa
                case 5:
                    System.exit(0);
                    // Repete o switch até entrar uma opção válida
                default:
                    System.out.println("Opção Inválida. Tente novamente!");
            }
        }
    }

    // Método de limpar a próxima linha para não acumular
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
