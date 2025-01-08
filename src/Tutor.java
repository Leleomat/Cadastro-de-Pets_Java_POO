import java.time.Period;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tutor {
//teste
    // Criando uma lista de objetos Pets
    private ArrayList<Pet> pets = new ArrayList<>();
    int codigo;
    String nome;
    LocalDate nascimento;
    String endereco;

    // Método construtor para Tutores
    public Tutor(int codigo, String nome, String endereco, int dia, int mes, int ano) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = LocalDate.of(ano, mes, dia);
    }

    // Método para acessar lista de Pets
    public ArrayList<Pet> getPets() {
        return pets;
    }

    // Método para atualizar lista de Pets
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    // Método para acessar o código de um Tutor
    public int getCodigo() {
        return codigo;
    }

    // Método para atualizar o código de um tutor
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Método para acessar o nome de um Tutor
    public String getNome() {
        return nome;
    }

    // Método para atualizar o nome de um Tutor
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para acessar o endereço de um Tutor
    public String getEndereco() {
        return endereco;
    }

    // Método para atualizar o endereço de um Tutor
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método para acessar a data de nascimento de um Tutor
    public String getNascimento() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return nascimento.format(fmt);
    }

    // Método para atualizar a data de nascimento de um Tutor
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;

    }

    // Método para adicionar um Pet para um Tutor
    public void criaPet(String nome, String tipo) {
        pets.add(new Pet(nome, tipo));
    }

    // Método para exibir as informações de um Tutor e seus pets
    public String toString() {
        String ts = String.format("Cod. Tutor: %d.\n", getCodigo());
        ts += String.format(" Nome...........: %s.\n", getNome());
        ts += String.format(" Data Nascimento: %s (%s anos).\n", getNascimento(), Period.between(nascimento, LocalDate.now()).getYears());
        ts += String.format(" Endereço.......: %s.\n Relação de pets: \n", getEndereco());
        System.out.println("");
        if (getPets().size() == 0)
            ts += " Pets de " + nome + ": Nenhum cadastrado.\n";
        else {
            ts += " Pets de " + nome + " (" + getPets().size() + "):\n";
            for (Pet p : getPets()) { // d é um iterador.
                ts += " - Nome do pet: " + p.getNome() + ", ";
                ts += " Tipo: " + p.getTipo() + ".\n";
            }
        }

        return ts;
    }
}

