static class Personagem {
    private String nome;
    protected int vida;
    private int vidaMaxima = 50;

    protected Personagem(String nome, int vida) {
        setNome(nome);
        setVida(vida);
    }

    boolean valorValido(int valor) {
        return valor > 0;
    }
/// GET/SET /// /// /// /// /// /// ///
    private void setNome(String nome) {
        if(nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }else {
            this.nome = "Null";
        }
    }
    private void setVida(int vida) {
        if(valorValido(vida) && vida <= vidaMaxima) {
            this.vida = vida;
        }else {
            this.vida = 10;
        }
    }
    public String getNome() {
        return nome;
    }
    public int getVida() {
        return vida;
    }
/// GET/SET /// /// /// /// /// /// ///
    boolean estaVivo() {
        return getVida() > 0;
    }

    void atacar(Personagem alvo) {
        if(this == alvo) {
            System.out.println("Nao e possivel atacar a si mesmo!");
            return;
        }
        if(!estaVivo()) {
            System.out.println(getNome() +" nao pode atacar enquanto morto!");
            return;
        }
        if(!alvo.estaVivo()) {
            System.out.println(alvo.getNome() +" nao pode ser atacado pois esta morto!");
            return;
        }
        System.out.println(getNome() +" atacou " +alvo.getNome());
        alvo.receberDano(10);
    }

    protected void receberDano(int dano) {
    if(!valorValido(dano)) {
        System.out.println("Valor invalido!");
        return;
    }
    if(!estaVivo()) {
        System.out.println(getNome() +" ja esta morto");
        return;
    }
    vida -= dano;
    if(vida < 0) {
        vida = 0;
    }
    }

    void curar(int cura) {
        if (!valorValido(cura)) {
            System.out.println("Valor invalido de cura!");
            return;
        }
        if (!estaVivo()) {
            System.out.println("Nao pode curar enquanto morto!");
            return;
        }
        int curaTotal = vidaMaxima - vida;
                vida += cura;
        if(getVida() > vidaMaxima) {
            System.out.println("Valor exedeu a vida maxima, entao so curou " +curaTotal);
            vida = vidaMaxima;
            return;
        }
        System.out.println(getNome() +" curou " +cura);
    }
}

static class Guerreiro extends Personagem {
    private int forca;

    Guerreiro(String nome, int vida, int forca) {
        super(nome, vida);
        setForca(forca);
    }

    /// SET/GET ///
    private void setForca(int forca) {
        if (valorValido(forca)) {
            this.forca = forca;
        }
    }

    public int getForca() {
        return forca;
    }

    /// SET/GET ///

    void atacar(Personagem alvo) {
        if (this == alvo) {
            System.out.println("Nao e possivel atacar a si mesmo!");
            return;
        }
        if (!estaVivo()) {
            System.out.println(getNome() +" nao pode atacar enquanto morto!");
            return;
        }
        if (!alvo.estaVivo()) {
            System.out.println(alvo.getNome() + " nao pode ser atacado pois esta morto!");
            return;
        }
        System.out.println(getNome() + " atacou " + alvo.getNome() +" com uma espada, e causou " +getForca() +" de dano");
        alvo.receberDano(getForca());

    }
}


static class Mago extends Personagem {
    private int mana;

    Mago(String nome, int vida, int mana) {
        super(nome, vida);
        setMana(mana);
    }

    /// SET/GET ///
    private void setMana(int mana) {
        if(valorValido(mana)) {
            this.mana = mana;
        }
    }
    public int getMana() {
        return mana;
    }
    /// SET/GET ///

    boolean temMana() {
        return getMana() > 0;
    }

    void atacar(Personagem alvo) {
        if(this == alvo) {
            System.out.println("Nao e possivel atacar a si mesmo!");
            return;
        }
        if(!estaVivo()) {
            System.out.println(getNome() +"Nao pode atacar enquanto morto!");
            return;
        }
        if(!alvo.estaVivo()) {
            System.out.println(alvo.getNome() +" nao pode ser atacado pois esta morto!");
            return;
        }
        if(!temMana()) {
            System.out.println(getNome() +" nao tem mais mana!");
            return;
        }
        int danoMagico = 5;
        System.out.println(getNome() +" atacou " +alvo.getNome() +" usando seus conhecimentos magicos, causou " +danoMagico +" dde dano magico!");
        alvo.receberDano(danoMagico);
        mana --;
    }

}


static class Arqueiro extends Personagem {
    private int flechas;

    Arqueiro(String nome, int vida, int flechas) {
        super(nome, vida);
        setFlechas(flechas);
    }

    /// SET/GET ///

    private void setFlechas(int flechas) {
        if(valorValido(flechas)) {
            this.flechas = flechas;
        }
    }
    public int getFlechas() {
        return flechas;
    }

    /// SET/GET ///

    boolean temFlechas() {
        return getFlechas() > 0;
    }

    void atacar(Personagem alvo) {
        if(this == alvo) {
            System.out.println("Nao e possivel atacar a si mesmo!");
            return;
        }
        if(!estaVivo()) {
            System.out.println(getNome() +"Nao pode atacar enquanto morto!");
            return;
        }
        if(!alvo.estaVivo()) {
            System.out.println(alvo.getNome() +" nao pode ser atacado pois esta morto!");
            return;
        }
        if(!temFlechas()) {
            System.out.println(getNome() +" nao tem mais flechas!");
            return;
        }
        int danoFlechada = 4;
        System.out.println(getNome() +" atacou " +alvo.getNome() +" com um flechada, causando " +danoFlechada +" de dano por flecha");
        alvo.receberDano(danoFlechada);
        flechas --;
    }

}


public static void main(String[] args) {
    Guerreiro g = new Guerreiro("Bernardo", 1, 15);
    Mago m = new Mago("Leo", 16, 2);
    Arqueiro a = new Arqueiro("Duda", 12, 1);

    a.atacar(g);
    System.out.println(g.getVida());
    g.curar(10);
    System.out.println(g.getVida());
}
