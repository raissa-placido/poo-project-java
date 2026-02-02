public class Chamado {
    private int id;
    private String titulo;
    private String descricao;
    private String prioridade; // Ex: Baixa, Media, Alta
    private String status;     // Ex: Aberto, Em Andamento, Encerrado
    
    // RELACIONAMENTOS (O Pulo do Gato!)
    private Usuario solicitante; // Quem abriu?
    private Tecnico tecnico;     // Quem vai resolver? (Pode ser null no início)

    // Construtor: Quando criamos o chamado, SÓ sabemos quem pediu.
    // O técnico e o status são definidos automaticamente no início.
    public Chamado(int id, String titulo, String descricao, String prioridade, Usuario solicitante) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.solicitante = solicitante;
        
        this.status = "Aberto"; // Todo chamado nasce Aberto
        this.tecnico = null;    // Ainda não tem técnico atribuído
    }

    // --- MÉTODOS DE AÇÃO ---

    // Atribuir um técnico muda o status para "Em Andamento"
    public void atribuirTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        this.status = "Em Andamento";
    }

    // Fechar o chamado
    public void fecharChamado() {
        this.status = "Encerrado";
    }

    // --- GETTERS (Para consultar dados) ---
    public String getTitulo() { return titulo; }
    public String getStatus() { return status; }
    

    // --- TO STRING (Para imprimir bonito) ---
    @Override
    public String toString() {
        // Truque para não dar erro se o técnico for null
        String nomeTecnico = (tecnico != null) ? tecnico.getNome() : "Pendente";
        
        return "Chamado #" + id + " [" + status + "] - " + titulo +
               "\n   Solicitante: " + solicitante.getNome() +
               "\n   Técnico: " + nomeTecnico +
               "\n   Prioridade: " + prioridade;
    }


    public Usuario getSolicitante() {
        return solicitante;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }
}