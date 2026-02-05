import java.util.ArrayList;
import java.util.List;

public class Cadastro {

    // Listas para armazenar os objetos em memória
    private List<Usuario> listaUsuarios;
    private List<Tecnico> listaTecnicos;

    // Construtor: Inicializa as listas vazias
    public Cadastro() {
        this.listaUsuarios = new ArrayList<>();
        this.listaTecnicos = new ArrayList<>();
    }

    // --- MÉTODOS DE CADASTRO ---

    // Cadastrar Usuário
    public void cadastrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + usuario.getNome());
    }

    // Cadastrar Técnico
    public void cadastrarTecnico(Tecnico tecnico) {
        listaTecnicos.add(tecnico);
        System.out.println("Técnico cadastrado com sucesso: " + tecnico.getNome());
    }
    

    // --- MÉTODOS DE CONSULTA---

    public void listarUsuarios() {
        System.out.println("--- Lista de Usuários ---");
        for (Usuario u : listaUsuarios) {
            System.out.println(u.toString());
        }
    }

    public void listarTecnicos() {
        System.out.println("--- Lista de Técnicos ---");
        for (Tecnico t : listaTecnicos) {
            System.out.println(t.toString());
        }
    }

    // Método para buscar Usuário pela Matrícula
    public Usuario buscarUsuario(String matricula) {
        for (Usuario u : listaUsuarios) {
            if (u.getMatricula().equals(matricula)) {
                return u; // Encontrou! Devolve o objeto
            }
        }
        return null; // Não achou ninguém
    }

    // Método para buscar Técnico pela Matrícula
    public Tecnico buscarTecnico(String matricula) {
        for (Tecnico t : listaTecnicos) {
            if (t.getMatricula().equals(matricula)) {
                return t;
            }
        }
        return null;
    }

    // Verifica se a matrícula de usuário já existe
    public boolean usuarioJaExiste(String matricula) {
        return buscarUsuario(matricula) != null;
    }

    // Verifica se a matrícula de técnico já existe
    public boolean tecnicoJaExiste(String matricula) {
        return buscarTecnico(matricula) != null;
    }
}