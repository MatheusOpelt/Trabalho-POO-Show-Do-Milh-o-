import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowDoMilhaoTest {
    private ShowDoMilhao showDoMilhao;

    @BeforeEach
    public void setUp() {
        showDoMilhao = new ShowDoMilhao();
    }

    @Test
    public void testJogarComRespostaCorreta() {
        // Simula a entrada do usuário
        String input = "A\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Executa o jogo
        showDoMilhao.adicionarJogador("Jogador 1");
        showDoMilhao.carregarPerguntas("perguntas_teste.txt");
        showDoMilhao.jogar();

        // Verifica se a pontuação do jogador está correta
        Jogador jogador = showDoMilhao.getJogadores().get(0);
        int pontuacaoEsperada = 1; // A resposta correta é "A", o jogador respondeu "A"
        assertEquals(pontuacaoEsperada, jogador.getPontuacao());
    }
}
