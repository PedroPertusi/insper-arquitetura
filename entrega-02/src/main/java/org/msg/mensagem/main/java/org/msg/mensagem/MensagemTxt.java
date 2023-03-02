package main.java.org.msg.mensagem;

import usuario.Usuario;
import main.java.org.msg.mensagem.Mensagem;


public class MensagemTxt extends Mensagem {
    private String conteudo;

    public MensagemTxt(Usuario usuario, String nome_arquivo, String conteudo) {
        super(usuario,nome_arquivo);
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


}