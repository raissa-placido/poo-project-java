import java.util.ArrayList;
import java.util.List;

public class ChamadoService {

    private List<Chamado> listaChamados;

    //construtor
    public ChamadoService() {
        this.listaChamados = new ArrayList<>();
    }


    public Chamado abrirChamado(int id, String titulo, String desc, Prioridade prioridade, Usuario u) {
        Chamado c = new Chamado(id, titulo, desc, prioridade, u);
        listaChamados.add(c);
        return c;
    }

    // Filtra e mostra apenas os chamados de um usuário específico
    public void listarChamadosPorUsuario(Usuario u) {
        System.out.println("\n--- MEUS CHAMADOS (" + u.getNome() + ") ---");
        boolean encontrou = false;
        for (Chamado c : listaChamados) {
            if (c.getSolicitante().getId() == u.getId()) {
                System.out.println(c.toString());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Você não tem chamados abertos.");
    }

    // Filtra e mostra apenas os chamados atendidos por este técnico
    public void gerarRelatorioTecnico(Tecnico t) {
        System.out.println("\n--- RELATÓRIO DE ATENDIMENTOS (" + t.getNome() + ") ---");
        boolean encontrou = false;
        for (Chamado c : listaChamados) {
            // Verifica se tem técnico E se o ID bate
            if (c.getTecnico() != null && c.getTecnico().getId() == t.getId()) {
                System.out.println(c.toString());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum atendimento realizado ainda.");
    }
}