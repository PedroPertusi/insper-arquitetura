package main.java.org.msg.mensagem;

import usuario.Usuario;
import main.java.org.msg.mensagem.Mensagem;


public class MensagemArq extends Mensagem {
    private String tipo;

    public MensagemArq(Usuario usuario, String nome_arquivo, String tipo) {
        super(usuario,nome_arquivo);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}