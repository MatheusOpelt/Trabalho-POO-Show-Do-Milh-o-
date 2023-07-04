import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShowDoMilhaoTest {

    private ShowDoMilhao showDoMilhao;

    @BeforeEach
    public void setup() {
        showDoMilhao = new ShowDoMilhao();
        showDoMilhao.carregarPerguntas("ShowDoMilhaoPOO/perguntas.txt");
    }

    @Test
    public void testCarregarPerguntas() {
        // Verifica se o número de perguntas carregadas é igual a 16
        int expectedSize = 16;
        int actualSize = showDoMilhao.getPerguntas().size();
        Assertions.assertEquals(expectedSize, actualSize);

        // Verifica se a primeira pergunta foi carregada corretamente
        String expectedQuestion = "Qual é o protagonista do anime 'One Piece'?";
        String actualQuestion = showDoMilhao.getPerguntas().get(0).getPergunta();
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void testJogar() {
        // Adiciona dois jogadores
        showDoMilhao.adicionarJogador("Jogador 1");
        showDoMilhao.adicionarJogador("Jogador 2");

        // Executa o jogo
        showDoMilhao.jogar();

        // Verifica se os jogadores têm pontuações maiores que zero
        for (Jogador jogador : showDoMilhao.getJogadores()) {
            int pontuacao = jogador.getPontuacao();
            Assertions.assertTrue(pontuacao > 0);
        }
    }
}
