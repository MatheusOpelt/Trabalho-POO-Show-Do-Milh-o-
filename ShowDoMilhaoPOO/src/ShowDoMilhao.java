import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowDoMilhao {
    private List<Pergunta> perguntas;
    private List<Jogador> jogadores;
    private Scanner scanner;

    public ShowDoMilhao() {
        perguntas = new ArrayList<>();
        jogadores = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void carregarPerguntas(String arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(","); // Ou qualquer outro caractere de separação

                if (partes.length == 4) {
                    String pergunta = partes[0];
                    String opcoes = partes[1];
                    String resposta = partes[2];
                    int dificuldade = Integer.parseInt(partes[3]);

                    Pergunta novaPergunta = new Pergunta(pergunta, opcoes, resposta, dificuldade);
                    perguntas.add(novaPergunta);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de perguntas: " + e.getMessage());
        }
    }


    public void gravarPerguntas(String arquivo) {

    }

    public void adicionarJogador(String nome) {
        jogadores.add(new Jogador(nome));
    }

    public void jogar() {
        for (Jogador jogador : jogadores) {
            System.out.println("É a vez do jogador: " + jogador.getNome());


            if (perguntas.isEmpty()) {
                System.out.println("Não há perguntas disponíveis!");
                break;
            }

            Pergunta perguntaSelecionada = selecionarPerguntaAleatoria();

            System.out.println(perguntaSelecionada.getPergunta());
            System.out.println(perguntaSelecionada.getOpcoes());

            String resposta = scanner.nextLine();
            if (perguntaSelecionada.verificarResposta(resposta)) {
                System.out.println("Resposta correta!");
            } else {
                System.out.println("Resposta incorreta!");
            }

    Pergunta pergunta = selecionarPerguntaAleatoria();
            System.out.println(pergunta.getPergunta());
            System.out.println(pergunta.getOpcoes());
            System.out.print("Resposta: ");
            String respostaDojogador = scanner.nextLine();

            if (resposta.equalsIgnoreCase(pergunta.getResposta())) {
                System.out.println("Resposta correta!");
                jogador.aumentarPontuacao(1);
            } else {
                System.out.println("Resposta incorreta!");
            }

            System.out.println("Pontuação atual do jogador " + jogador.getNome() + ": " + jogador.getPontuacao());
            System.out.println();
        }
    }

    private Pergunta selecionarPerguntaAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(perguntas.size());
        return perguntas.get(indice);
    }

    public static void main(String[] args) {
        ShowDoMilhao showDoMilhao = new ShowDoMilhao();
        showDoMilhao.carregarPerguntas("perguntas.txt");
        showDoMilhao.adicionarJogador("Jogador 1");
        showDoMilhao.adicionarJogador("Jogador 2");
        showDoMilhao.jogar();
        showDoMilhao.gravarPerguntas("perguntas_salvas.txt");
    }
}
