package br.newtonpaiva.av1.pergunta3;

public class PostRedeSocial {
    private String msg;
    private byte relevancia; //1 para relevante e 2 para não relevante

    public PostRedeSocial(String msg, byte relevancia) {
        this.msg = msg;
        this.relevancia = relevancia;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(byte relevancia) {
        this.relevancia = relevancia;
    }

    @Override
    public String toString() {
        return "PostRedeSocial{" +
                "msg='" + msg + '\'' +
                ", relevancia=" + relevancia +
                '}';
    }
}