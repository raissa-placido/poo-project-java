public class Usuario extends Pessoa { 
    private String departamento;

    public Usuario(int id, String nome, String departamento) {
        super(id, nome); // Envia o id e nome para a classe pai (Pessoa) cuidar
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