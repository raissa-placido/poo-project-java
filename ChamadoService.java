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
            if (c.getSolicitante().getMatricula().equals(u.getMatricula())) {
                // Imprime informações sem expor a prioridade e técnico
                System.out.println("Chamado #" + c.getId() + " [" + c.getStatus() + "] - " + c.getTitulo()
                                   + "\n   Descrição: " + c.getDescricao()
                                   + "\n   Solicitante: " + c.getSolicitante().getNome());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Você não tem chamados abertos.");
    }

        // Lista todos os chamados abertos
        public void listarChamados() {
            System.out.println("\n--- LISTA GERAL DE CHAMADOS ---");
            if (listaChamados.isEmpty()) {
                System.out.println("Nenhum chamado aberto.");
                return;
            }
            for (Chamado c : listaChamados) {
                System.out.println(c.toString());
            }
        }

    // Filtra e mostra apenas os chamados atendidos por este técnico
    public void gerarRelatorioTecnico(Tecnico t) {
        System.out.println("\n--- RELATÓRIO DE ATENDIMENTOS (" + t.getNome() + ") ---");
        boolean encontrou = false;
        for (Chamado c : listaChamados) {
            // Verifica se tem técnico E se a matrícula bate
            if (c.getTecnico() != null && c.getTecnico().getMatricula().equals(t.getMatricula())) {
                System.out.println(c.toString());
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum atendimento realizado ainda.");
    }

        // Método para o técnico definir a prioridade do chamado
        public void definirPrioridade(int idChamado, Prioridade prioridade) {
            for (Chamado c : listaChamados) {
                if (c.getId() == idChamado) {
                    c.setPrioridade(prioridade);
                    System.out.println("Prioridade do Chamado #" + idChamado + " definida como " + prioridade);
                    return;
                }
            }
            System.out.println("Chamado #" + idChamado + " não encontrado.");
        }

        // Lista chamados pendentes (sem técnico atribuído)
        public void listarChamadosPendentes() {
            System.out.println("\n--- CHAMADOS PENDENTES (sem técnico) ---");
            boolean encontrou = false;
            for (Chamado c : listaChamados) {
                if (c.getTecnico() == null) {
                    System.out.println("Chamado #" + c.getId() + " [" + c.getStatus() + "] - " + c.getTitulo()
                                       + "\n   Descrição: " + c.getDescricao()
                                       + "\n   Solicitante: " + c.getSolicitante().getNome()
                                       + "\n   Prioridade: " + c.getPrioridade());
                    encontrou = true;
                }
            }
            if (!encontrou) System.out.println("Nenhum chamado pendente no momento.");
        }

        // Método para o técnico atribuir um chamado a si mesmo
        public boolean atribuirChamado(int idChamado, Tecnico tecnico) {
            for (Chamado c : listaChamados) {
                if (c.getId() == idChamado) {
                    if (c.getTecnico() != null) {
                        System.out.println("Este chamado já foi atribuído a " + c.getTecnico().getNome());
                        return false;
                    }
                    c.atribuirTecnico(tecnico);
                    System.out.println("Chamado #" + idChamado + " atribuído com sucesso a " + tecnico.getNome());
                    return true;
                }
            }
            System.out.println("Chamado #" + idChamado + " não encontrado.");
            return false;
        }

        // Método para obter um chamado pelo ID
        public Chamado obterChamadoPorId(int id) {
            for (Chamado c : listaChamados) {
                if (c.getId() == id) {
                    return c;
                }
            }
            return null;
        }

        // Lista todos os chamados atribuídos a um técnico específico
        public void listarMeusChamados(Tecnico t) {
            System.out.println("\n--- MEUS CHAMADOS (" + t.getNome() + ") ---");
            boolean encontrou = false;
            for (Chamado c : listaChamados) {
                if (c.getTecnico() != null && c.getTecnico().getMatricula().equals(t.getMatricula())) {
                    System.out.println("Chamado #" + c.getId() + " [" + c.getStatus() + "] - " + c.getTitulo()
                                       + "\n   Descrição: " + c.getDescricao()
                                       + "\n   Solicitante: " + c.getSolicitante().getNome()
                                       + "\n   Prioridade: " + c.getPrioridade());
                    encontrou = true;
                }
            }
            if (!encontrou) System.out.println("Você não possui chamados atribuídos.");
        }

        // Método para atualizar o status de um chamado
        public boolean atualizarStatusChamado(int idChamado, Status novoStatus) {
            for (Chamado c : listaChamados) {
                if (c.getId() == idChamado) {
                    c.setStatus(novoStatus);
                    System.out.println("Status do Chamado #" + idChamado + " atualizado para " + novoStatus);
                    return true;
                }
            }
            System.out.println("Chamado #" + idChamado + " não encontrado.");
            return false;
        }
}