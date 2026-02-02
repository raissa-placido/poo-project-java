public class Tecnico extends Pessoa {
    private String especialidade;

    public Tecnico(int id, String nome, String especialidade) {
        super(id, nome); // Passa para o pai
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return "Técnico: " + nome + " | Spec: " + especialidade;
    }
}