import java.util.ArrayList;
import java.util.List;

public class ChamadoService {

    private List<Chamado> listaChamados;

    public void cadastrarChamado(Chamado chamado) {
        listaChamados.add(chamado);
        System.out.println("Chamado aberto com sucesso!");
    }

    
}