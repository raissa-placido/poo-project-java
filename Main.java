import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);
    static Cadastro sistema = new Cadastro();
    static ChamadoService chamadoService = new ChamadoService();

    public static void main(String[] args) {
        // Dados de teste iniciais
        sistema.cadastrarUsuario(new Usuario(1, "Ana RH", "RH"));
        sistema.cadastrarUsuario(new Usuario(2, "Pedro Vendas", "Vendas"));
        sistema.cadastrarTecnico(new Tecnico(10, "Roberto Tech", "Redes"));
        

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
        System.out.print("ID do Usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuario logado = sistema.buscarUsuario(id); //chama a função da classe Cadastro e definir esse usuario como objeto
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

            //if (op == 1) {
            //    abrirChamado(logado);
            //} else if (op == 2) {
                // Chama o novo método de filtro que criamos
            //    sistema.listarChamadosPorUsuario(logado);
            //}
        }
    }

    public static void loginTecnico() {
        System.out.print("ID do Técnico: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tecnico logado = sistema.buscarTecnico(id); //chama a função da classe Cadastro e defini esse tecnico como objeto
        if (logado == null) {
            System.out.println("Técnico não encontrado!");
            return;
        }

        int op = -1;
        while (op != 0) {
            System.out.println("\n>> PAINEL TÉCNICO: " + logado.getNome());
            System.out.println("1 - Ver Lista Geral de Chamados"); // <--- JÁ EXISTIA
            System.out.println("2 - Imprimir Relatório de Atendimentos"); // <--- NOVA OPÇÃO
            System.out.println("0 - Voltar (Logout)");
            System.out.print("Escolha: ");
            op = scanner.nextInt();
            scanner.nextLine();

            //if (op == 1) {
            //    sistema.gerarRelatorioTecnico(logado); // Mostra todos
            //} else if (op == 2) {
            //    sistema.gerarRelatorioTecnico(logado); // Mostra só os dele
            //}
        }
    }

    // --- MÉTODOS AUXILIARES ---

    public static void abrirChamado(Usuario u) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        System.out.print("Prioridade (BAIXA/MEDIA/ALTA): ");
        String prioStr = scanner.nextLine();
        Prioridade prio = Prioridade.valueOf(prioStr.toUpperCase());
        
        // Simulando ID automático simples com base no tempo (ou aleatório)
        int idChamado = (int) (System.currentTimeMillis() % 10000); 
        
        chamadoService.abrirChamado(idChamado, titulo, desc, prio, u);
        System.out.println("Chamado #" + idChamado + " criado com sucesso!");
    }

    public static void cadastrarNovoUsuario() {
        System.out.print("Novo ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Depto: "); String dept = scanner.nextLine();
        sistema.cadastrarUsuario(new Usuario(id, nome, dept));
    }

    public static void cadastrarNovoTecnico() {
        System.out.print("Novo ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Especialidade: "); String esp = scanner.nextLine();
        sistema.cadastrarTecnico(new Tecnico(id, nome, esp));
    }
}