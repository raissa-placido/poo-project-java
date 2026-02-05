public abstract class Pessoa {
    // Usamos 'protected' para que as classes filhas (Usuario/Tecnico)
    // consigam acessar esses dados diretamente
    protected String matricula;
    protected String nome;

    public Pessoa(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}