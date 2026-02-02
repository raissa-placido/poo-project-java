public abstract class Pessoa {
    // Usamos 'protected' para que as classes filhas (Usuario/Tecnico)
    // consigam acessar esses dados diretamente
    protected int id;
    protected String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}