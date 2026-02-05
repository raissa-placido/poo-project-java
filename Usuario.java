public class Usuario extends Pessoa { 
    private String departamento;

    public Usuario(String matricula, String nome, String departamento) {
        super(matricula, nome); // Envia a matrícula e nome para a classe pai (Pessoa) cuidar
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Usuario: " + nome + " | Dept: " + departamento;
    }
}