public interface IChamadoService {
    Chamado abrirChamado(int id, String titulo, String desc, Prioridade prioridade, Usuario u);

    void listarChamadosPorUsuario(Usuario u);
    void listarChamadosPendentes();
    void listarChamados();
    void listarMeusChamados(Tecnico t);

    boolean atribuirChamado(int idChamado, Tecnico tecnico);
    Chamado obterChamadoPorId(int id);

    boolean atualizarStatusChamado(int idChamado, Status novoStatus);
    void definirPrioridade(int idChamado, Prioridade prioridade);

    void gerarRelatorioTecnico(Tecnico t);
}
