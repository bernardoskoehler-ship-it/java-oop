static class Personagem {
    String nome;
    int vida;

    void atacar() {
        if(estaVivo()) {
            System.out.println(nome + " atacou!");
        }
    }
    boolean estaVivo() {
        return vida > 0;
    }
}
static class Mago extends Personagem {
    int mana;

    private boolean temMana() {
        return mana > 0;
    }

    void atacar() {
        if(!estaVivo()) {
            System.out.println("nao pode atacar pois esta morto");
            return;
        }
        if(temMana()) {
            mana --;
            super.atacar(); System.out.println(" lançando magia!");
        }else {
            System.out.println("nao tem mais mana");
        }
    }

}
static class Arqueiro extends Personagem {
    int flechas;

    private boolean temFlechas() {
        return flechas > 0;
    }

    void atacar() {
        if(!estaVivo()) {
            System.out.println("nao pode atacar pois esta morto");
            return;
        }
        if(temFlechas()) {
            flechas --;
            super.atacar(); System.out.println(" atirando flechas!");
        }else {
            System.out.println("nao tem mais flechas");
        }
    }
}


public static void main(String[] args) {
    Mago m = new Mago();
    Arqueiro a = new Arqueiro();

    m.nome = "Marcelo Mago";
    a.nome = "Arthur Arqueiro";

    m.vida = 10;
    a.vida = 1;

    m.mana = 3;
    a.flechas = 0;

    m.atacar();
    a.atacar();
}
