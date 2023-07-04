public class Pergunta {
    private String pergunta;
    private String opcoes;
    private String resposta;
    private int dificuldade;

    public Pergunta(String pergunta, String opcoes, String resposta, int dificuldade) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.resposta = resposta;
        this.dificuldade = dificuldade;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    public boolean verificarResposta(String respostaDoJogador) {
        return respostaDoJogador.equalsIgnoreCase(resposta);
    }
}
