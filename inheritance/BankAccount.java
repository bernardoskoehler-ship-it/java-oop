static class Conta {
    private String titular;
    private double saldo;

    protected Conta(String titular, double saldo) {
        setTitular(titular);
        setSaldo(saldo);
    }

    private void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
        }
    }

    protected String getTitular() {
        return titular;
    }

    private void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean valorValido(double valor) {
        return valor > 0;
    }

    protected boolean temSaldo(double valor) {
        return getSaldo() >= valor;
    }

    protected void adicionarSaldo(double valor) {
        saldo += valor;
    }

    protected void removerSaldo(double valor) {
        saldo -= valor;
        if (saldo < 0) {
            saldo = 0;
        }
    }

    void depositar(double valor) {
        if (!valorValido(valor)) {
            System.out.println("Valor invalido!");
            return;
        }

        adicionarSaldo(valor);
        System.out.println(getTitular() + " depositou " + valor);
    }

    void sacar(double valor) {
        if (!valorValido(valor)) {
            System.out.println("Valor invalido!");
            return;
        }

        if (!temSaldo(valor)) {
            System.out.println("Nao tem saldo suficiente!");
            return;
        }

        removerSaldo(valor);
        System.out.println(getTitular() + " sacou " + valor);
    }
}

static class ContaCorrente extends Conta {
    ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
    }

    void sacar(double valor) {
        double valorTotal = valor + 2.0;

        if (!valorValido(valor)) {
            System.out.println("Valor invalido!");
            return;
        }

        if (!temSaldo(valorTotal)) {
            System.out.println("Nao tem saldo suficiente!");
            return;
        }

        removerSaldo(valorTotal);
        System.out.println(getTitular() + " sacou " + valor + " com taxa de 2.0");
    }
}

static class ContaPoupanca extends Conta {
    ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    void renderJuros() {
        adicionarSaldo(getSaldo() * 0.05);
    }
}

public static void main(String[] args) {
    ContaCorrente cc = new ContaCorrente("Bernado", 0);
    ContaPoupanca cp = new ContaPoupanca("Leo", 0);

    cc.depositar(1000);
    cc.sacar(100);

    cp.depositar(1000);
    cp.renderJuros();

    System.out.println(cc.getSaldo());
    System.out.println(cp.getSaldo());
}
