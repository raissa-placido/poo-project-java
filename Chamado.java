public class Chamado {
    private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade; // Ex: Baixa, Media, Alta
    private Status status;     // Ex: Aberto, Em Andamento, Concluído
    
    // RELACIONAMENTOS 
    private Usuario autor; // Quem abriu?
    private Tecnico responsavel;     // Quem vai resolver? (Pode ser null no início)

    // Construtor: Quando criamos o chamado, SÓ sabemos quem pediu.
    // O técnico e o status são definidos automaticamente no início.
    public Chamado(int id, String titulo, String descricao, Prioridade prioridade, Usuario autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.autor = autor;
        
        this.status = Status.ABERTO; // Todo chamado nasce Aberto
        this.responsavel = null;    // Ainda não tem técnico atribuído
    }

    // --- MÉTODOS DE AÇÃO ---

    // Atribuir um técnico muda o status para "Em Andamento"
    public void atribuirTecnico(Tecnico tecnico) {   
        this.responsavel = tecnico;  
        this.status = Status.EM_ANDAMENTO;
    }

    // --- GETTERS (Para consultar dados) ---
    public String getTitulo() { return titulo; } 
    public Status getStatus() {return status;}
    

    // --- TO STRING  ---
    @Override
    public String toString() {
        // Truque para não dar erro se o técnico for null
        String nomeTecnico = (responsavel != null) ? responsavel.getNome() : "Pendente";
        
        return "Chamado #" + id + " [" + status + "] - " + titulo +
               "\n   Solicitante: " + autor.getNome() +
               "\n   Técnico: " + nomeTecnico +
               "\n   Prioridade: " + prioridade;
    }


    public Usuario getSolicitante() {
        return autor;
    }

    public Tecnico getTecnico() {
        return responsavel;
    }

        public void setPrioridade(Prioridade prioridade) {
            this.prioridade = prioridade;
        }

        public int getId() {
            return id;
        }

        public String getDescricao() {
            return descricao;
        }

        public Prioridade getPrioridade() {
            return prioridade;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
}