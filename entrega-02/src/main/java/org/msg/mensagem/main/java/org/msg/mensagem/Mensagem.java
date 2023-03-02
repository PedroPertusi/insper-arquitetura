package main.java.org.msg.mensagem;

import usuario.Usuario;

public class Mensagem {
    private Usuario usuario;
    private String nome_arquivo;

    public Mensagem(Usuario usuario, String nome_arquivo) {
        this.usuario = usuario;
        this.nome_arquivo = nome_arquivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeArq() {
        return nome_arquivo;
    }

    public void setNomeArq(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
    }
    
}
