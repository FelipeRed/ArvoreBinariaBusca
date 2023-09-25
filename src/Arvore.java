public class Arvore {
    private No raiz;

    public Arvore(int valor) {
        this.raiz = new No(valor);
    }

    public void inserirNumero(int numero, No no) {
        if (this.raiz == null) {
            this.raiz = new No(numero);
        }
        else if (numero < no.getChave()) {
            if (no.getEsquerda() == null) {
                no.setFilhoEsquerdo(new No(numero));
            }
            else {
                inserirNumero(numero, no.getEsquerda());
            }
        }
        else {
            if (no.getDireita() == null) {
                no.setFilhoDireito(new No(numero));
            }
            else {
                inserirNumero(numero, no.getDireita());
            }
        }
    }

    public boolean buscarNumero(int numero, No no) {
        if (numero == no.getChave()) {
            return true;
        }
        else if (numero < no.getChave()){
            if (no.getEsquerda() == null) {
                return false;
            }
            else {
                return buscarNumero(numero, no.getEsquerda());
            }
        }
        else {
            if (no.getDireita() == null) {
                return false;
            }
            else {
                return buscarNumero(numero, no.getDireita());
            }
        }
    }

    public void excluirNumero(int numero, No no, No pai) {
        if (numero == no.getChave()) {
            if (no.isFolha()) {
                apagarNoFolha(no, pai);
            }
            else if (no.filhoEsquerdoEhNull()) {
                subirFilho(no.getDireita(), no, pai);
            }
            else if (no.filhoDireitoEhNull()) {
                subirFilho(no.getEsquerda(), no, pai);
            }
            else if (no.temDoisFilhos()) {
                trocarNoESucessor(no, pai);
            }
        }
        else {
            if (numero >= no.getChave()) {
                excluirNumero(numero, no.getDireita(), no);
            }
            else {
                excluirNumero(numero, no.getEsquerda(), no);
            }
        }
    }

    public void apagarNoFolha(No no, No pai) {
        if (no == this.raiz) {
            this.raiz = null;
        }
        else {
            if (pai.getDireita() == no) {
                pai.setFilhoDireito(null);
            }
            else {
                pai.setFilhoEsquerdo(null);
            }
        }
    }

    public void subirFilho(No filho, No excluido, No pai) {
        if (excluido == this.raiz) {
            this.raiz = filho;
        }
        else {
            if (pai.getDireita() == excluido) {
                pai.setFilhoDireito(filho);
            }
            else {
                pai.setFilhoEsquerdo(filho);
            }
        }
    }

    public void trocarNoESucessor(No no, No pai) {
        No sucessor = no.procurarSucessor(no.getDireita(), no);
        if (no == this.raiz) {
            this.raiz = sucessor;
        }
        else {
            if (pai.getDireita() == no) {
                pai.setFilhoDireito(sucessor);
            }
            else {
                pai.setFilhoEsquerdo(sucessor);
            }
        }
        sucessor.setFilhoEsquerdo(no.getEsquerda());
        if (no.getDireita() != sucessor) {
            sucessor.getUltimoFilhoADireita().setFilhoDireito(no.getDireita());
        }
    }

    public static Arvore criarArvoreBase() {
        Arvore arvore = new Arvore(50);
        arvore.inserirNumero(40, arvore.getRaiz());
        arvore.inserirNumero(35, arvore.getRaiz());
        arvore.inserirNumero(45, arvore.getRaiz());
        arvore.inserirNumero(60, arvore.getRaiz());
        arvore.inserirNumero(55, arvore.getRaiz());
        arvore.inserirNumero(65, arvore.getRaiz());
        return arvore;
    }

    public void print() {
        Printer printer = new Printer();
        System.out.println(printer.topDown(this.raiz));
        System.out.println();
    }

    public No getRaiz() {return this.raiz;}
}
