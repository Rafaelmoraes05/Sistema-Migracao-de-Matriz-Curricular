package sistemaNovaMatriz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ComparadorMatrizes {

    public static void main(String[] args) {
        List<Disciplina> matrizAntiga = criarMatrizAntiga();
        List<Disciplina> matrizNova = criarMatrizNova();

        Map<String, Disciplina> equivalencias = criarEquivalencias(matrizAntiga, matrizNova);

        // Exemplo: Obtendo a disciplina equivalente à "Y60120" na nova matriz
        Disciplina equivalente = equivalencias.get("Y60120");
        if (equivalente != null) {
            System.out.println("Disciplina equivalente na nova matriz: " + equivalente.getCodigo());
        } else {
            System.out.println("Não há equivalência para Y60120 na nova matriz.");
        }
    }

    private static List<Disciplina> criarMatrizAntiga() {
        List<Disciplina> matrizAntiga = new ArrayList<>();
        // Adicionar todas as disciplinas da matriz antiga usando o construtor de Disciplina
        
        matrizAntiga.add(new Disciplina("Y60120", "Empreendedorismo em Negócio de TIC", 27, "Antiga"));
        // Adicionar as demais disciplinas da matriz antiga...
        return matrizAntiga;
    }

    private static List<Disciplina> criarMatrizNova() {
        List<Disciplina> matrizNova = new ArrayList<>();
        // Adicionar todas as disciplinas da matriz nova usando o construtor 
        
        matrizNova.add(new Disciplina("TADS23D001", "Iniciação à Informática", 5, "Nova"));
        // Adicionar as demais disciplinas da matriz nova...
        return matrizNova;
    }

    private static Map<String, Disciplina> criarEquivalencias(List<Disciplina> matrizAntiga, List<Disciplina> matrizNova) {
        Map<String, Disciplina> equivalencias = new HashMap<>();
        // Criar o mapeamento entre as disciplinas das matrizes antiga e nova
        for (Disciplina disciplinaAntiga : matrizAntiga) {
            for (Disciplina disciplinaNova : matrizNova) {
                if (disciplinaAntiga.getNome().equals(disciplinaNova.getNome())) {
                    equivalencias.put(disciplinaAntiga.getCodigo(), disciplinaNova);
                }
            }
        }
        return equivalencias;
    }
}
