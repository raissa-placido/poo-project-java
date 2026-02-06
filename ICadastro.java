public interface ICadastro {
    void cadastrarUsuario(Usuario usuario);
    void cadastrarTecnico(Tecnico tecnico);

    Usuario buscarUsuario(String matricula);
    Tecnico buscarTecnico(String matricula);

    boolean usuarioJaExiste(String matricula);
    boolean tecnicoJaExiste(String matricula);

    void listarUsuarios();
    void listarTecnicos();
}
