public class Tecnico extends Pessoa {
    private String especialidade;

    public Tecnico(String matricula, String nome, String especialidade) {
        super(matricula, nome); // Passa a matrícula para o pai
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