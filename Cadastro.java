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

    // Método para buscar Usuário pelo ID
    public Usuario buscarUsuario(int id) {
        for (Usuario u : listaUsuarios) {
            if (u.getId() == id) {
                return u; // Encontrou! Devolve o objeto
            }
        }
        return null; // Não achou ninguém
    }

    // Método para buscar Técnico pelo ID
    public Tecnico buscarTecnico(int id) {
        for (Tecnico t : listaTecnicos) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}