import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);
    static Cadastro sistema = new Cadastro();
    static ChamadoService chamadoService = new ChamadoService();

    public static void main(String[] args) {
        // Dados de teste iniciais
        sistema.cadastrarUsuario(new Usuario("001", "Ana RH", "RH"));
        sistema.cadastrarUsuario(new Usuario("002", "Pedro Vendas", "Vendas"));
        sistema.cadastrarTecnico(new Tecnico("T001", "Roberto Tech", "Redes"));
        

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DE CHAMADOS ===");
            System.out.println("1 - Login - Usuario");
            System.out.println("2 - Login - Técnico");
            System.out.println("3 - Cadastrar - Técnico");
            System.out.println("4 - Cadastrar - Usuario");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: loginUsuario(); break;
                case 2: loginTecnico(); break;
                case 3: cadastrarNovoTecnico(); break;
                case 4: cadastrarNovoUsuario(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    // --- MÉTODOS DE LOGIN ---

    public static void loginUsuario() {
        System.out.print("Matrícula do Usuário: ");
        String matricula = scanner.nextLine();

        Usuario logado = sistema.buscarUsuario(matricula); //chama a função da classe Cadastro e definir esse usuario como objeto
        if (logado == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        int op = -1;
        while (op != 0) {
            System.out.println("\n>> PAINEL DO USUÁRIO: " + logado.getNome());
            System.out.println("1 - Abrir Novo Chamado");
            System.out.println("2 - Acompanhar Meus Chamados"); // <--- NOVA OPÇÃO
            System.out.println("0 - Voltar (Logout)");
            System.out.print("Escolha: ");
            op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                abrirChamado(logado);
            } else if (op == 2) {
                // Chama o novo método de filtro que criamos
                chamadoService.listarChamadosPorUsuario(logado);
            } else if (op == 0) {
                System.out.println("Logout realizado!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void loginTecnico() {
        System.out.print("Matrícula do Técnico: ");
        String matricula = scanner.nextLine();

        Tecnico logado = sistema.buscarTecnico(matricula); //chama a função da classe Cadastro e defini esse tecnico como objeto
        if (logado == null) {
            System.out.println("Técnico não encontrado!");
            return;
        }

        int op = -1;
        while (op != 0) {
            System.out.println("\n>> PAINEL TÉCNICO: " + logado.getNome());
            System.out.println("1 - Meus Chamados");
            System.out.println("2 - Imprimir Relatório de Atendimentos");
            System.out.println("3 - Ver Chamados Pendentes e Atribuir a Mim");
            System.out.println("0 - Voltar (Logout)");
            System.out.print("Escolha: ");
            op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                meusChamados(logado);
            } else if (op == 2) {
                chamadoService.gerarRelatorioTecnico(logado);
            } else if (op == 3) {
                atribuirChamadoAMim(logado);
            } else if (op == 0) {
                System.out.println("Logout realizado!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    // --- MÉTODOS AUXILIARES ---

    public static void abrirChamado(Usuario u) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        
        // Simulando ID automático simples com base no tempo (ou aleatório)
        int idChamado = (int) (System.currentTimeMillis() % 10000); 
        
            // Prioridade padrão será BAIXA, o técnico que define depois
            chamadoService.abrirChamado(idChamado, titulo, desc, Prioridade.BAIXA, u);
        System.out.println("Chamado #" + idChamado + " criado com sucesso!");
           
    }

    public static void cadastrarNovoUsuario() {
        System.out.print("Nova Matrícula: "); String matricula = scanner.nextLine();
        
        // Valida se a matrícula já existe
        if (sistema.usuarioJaExiste(matricula)) {
            System.out.println("Erro: Esta matrícula já está cadastrada!");
            return;
        }
        
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Depto: "); String dept = scanner.nextLine();
        sistema.cadastrarUsuario(new Usuario(matricula, nome, dept));
    }

    public static void cadastrarNovoTecnico() {
        System.out.print("Nova Matrícula: "); String matricula = scanner.nextLine();
        
        // Valida se a matrícula já existe
        if (sistema.tecnicoJaExiste(matricula)) {
            System.out.println("Erro: Esta matrícula já está cadastrada!");
            return;
        }
        
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Especialidade: "); String esp = scanner.nextLine();
        sistema.cadastrarTecnico(new Tecnico(matricula, nome, esp));
    }

        public static void definirPrioridadeChamado() {
            System.out.print("ID do Chamado: ");
            int idChamado = scanner.nextInt();
            scanner.nextLine();
        
            System.out.print("Nova Prioridade (BAIXA/MEDIA/ALTA): ");
            String prioStr = scanner.nextLine();
        
            try {
                Prioridade prio = Prioridade.valueOf(prioStr.toUpperCase());
                chamadoService.definirPrioridade(idChamado, prio);
            } catch (IllegalArgumentException e) {
                System.out.println("Prioridade inválida! Use: BAIXA, MEDIA ou ALTA");
            }
        }

        public static void atribuirChamadoAMim(Tecnico tecnico) {
            chamadoService.listarChamadosPendentes();
            System.out.print("\nDigite o ID do chamado que deseja atender (ou 0 para cancelar): ");
            int idChamado = scanner.nextInt();
            scanner.nextLine();

            if (idChamado == 0) {
                System.out.println("Operação cancelada.");
                return;
            }

            // Atribui o chamado ao técnico
            if (chamadoService.atribuirChamado(idChamado, tecnico)) {
                // Se atribuiu com sucesso, pede a prioridade
                System.out.print("\nDefina a Prioridade do Chamado (BAIXA/MEDIA/ALTA): ");
                String prioStr = scanner.nextLine();
                
                try {
                    Prioridade prio = Prioridade.valueOf(prioStr.toUpperCase());
                    chamadoService.definirPrioridade(idChamado, prio);
                } catch (IllegalArgumentException e) {
                    System.out.println("Prioridade inválida! Use: BAIXA, MEDIA ou ALTA");
                }
            }
        }

        public static void meusChamados(Tecnico tecnico) {
            chamadoService.listarMeusChamados(tecnico);
            System.out.print("\nDigite o ID do chamado para atualizar o status (ou 0 para cancelar): ");
            int idChamado = scanner.nextInt();
            scanner.nextLine();

            if (idChamado == 0) {
                System.out.println("Operação cancelada.");
                return;
            }

            // Verifica se o chamado existe
            Chamado chamado = chamadoService.obterChamadoPorId(idChamado);
            if (chamado == null) {
                System.out.println("Chamado não encontrado.");
                return;
            }

            System.out.print("\nEscolha o novo status (1-ABERTO, 2-EM_ANDAMENTO, 3-CONCLUIDO): ");
            int opcaoStatus = scanner.nextInt();
            scanner.nextLine();

            Status novoStatus = null;
            switch (opcaoStatus) {
                case 1: novoStatus = Status.ABERTO; break;
                case 2: novoStatus = Status.EM_ANDAMENTO; break;
                case 3: novoStatus = Status.CONCLUIDO; break;
                default: System.out.println("Opção inválida!"); return;
            }

            chamadoService.atualizarStatusChamado(idChamado, novoStatus);
        }
}