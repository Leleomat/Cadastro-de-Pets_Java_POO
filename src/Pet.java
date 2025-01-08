public class Pet {
    String nome;
    String tipo;

    // Método construtor para Pets
    public Pet(String nome,String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    // Método para acessar o nome de um Pet
    public String getNome() {
        return nome;
    }

    // Método para atualizar o nome de um Pet
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para acessar o tipo de um Pet
    public String getTipo() {
        return tipo;
    }

    // Método para atualizar o nome de um Pet
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

