public class No {
    private final int chave;
    private No esquerda, direita;

    public No(int chave) {
        this.chave = chave;
        this.esquerda = null;
        this.direita = null;
    }

    public No procurarSucessor(No no, No pai) {
    // Procura um nó que seja maior e o mais próximo possível ao nó que se deseja excluir
    // Exemplo: excluir 30, buscar o nó mais próximo de 31
        if (no.esquerda == null) {
            if (pai.esquerda == no) {
                pai.esquerda = null;
            }
            return no;
        } else {
            return procurarSucessor(no.esquerda, no);
        }
    }

    public No getUltimoFilhoADireita() {
        No no = this;
        while (no.direita != null) {
            no = no.direita;
        }
        return no;
    }

    public boolean isFolha() {return this.esquerda == null && this.direita == null;}

    public boolean temDoisFilhos() {return this.esquerda != null && this.direita != null;}

    public boolean filhoEsquerdoEhNull() {return this.esquerda == null;}

    public boolean filhoDireitoEhNull() {return this.direita == null;}

    public void setFilhoEsquerdo(No filhoEsquerdo) {this.esquerda = filhoEsquerdo;}

    public void setFilhoDireito(No filhoDireito) {this.direita = filhoDireito;}

    public int getChave() {return chave;}

    public No getEsquerda() {return esquerda;}

    public No getDireita() {return direita;}
}
