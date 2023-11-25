package entities;

public class Aluno {

    static private int idContador = 1;

    private String nome;
    private int id;
    private Double nota_1;
    private Double nota_2;
    private Double nota_3;
    private Double nota_4;

    private Double totalNotas;

    @Override
    public String toString() {
        return "Aluno: " + getNome() + "\n"
                + "ID: " + getId() + "\n\n"
                + "Nota 1: " + String.format("%.1f",getNota_1()) + "\n"
                + "Nota 2: " + String.format("%.1f",getNota_2()) + "\n"
                + "Nota 3: " + String.format("%.1f",getNota_3()) + "\n"
                + "Nota 4: " + String.format("%.1f",getNota_4()) + "\n";
    }

    public Aluno(String nome, Double[] notas) {
        this.nome = nome;
        this.id += Aluno.idContador;
        this.nota_1 = notas[0];
        this.nota_2 = notas[1];
        this.nota_3 = notas[2];
        this.nota_4 = notas[3];

        this.setTotalNotas();

        Aluno.idContador += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() { return id;}

    public Double getNota_1() {
        return nota_1;
    }

    public void setNota_1(Double nota_1) {
        this.nota_1 = nota_1;
    }

    public Double getNota_2() {
        return nota_2;
    }

    public void setNota_2(Double nota_2) {
        this.nota_2 = nota_2;
    }

    public Double getNota_3() {
        return nota_3;
    }

    public void setNota_3(Double nota_3) {
        this.nota_3 = nota_3;
    }

    public Double getNota_4() {
        return nota_4;
    }

    public void setNota_4(Double nota_4) {
        this.nota_4 = nota_4;
    }

    public Double getTotalNotas(){ return  totalNotas;}

    public void setTotalNotas(){
        this.totalNotas = (this.nota_1 + this.nota_2 + this.nota_3 + this.nota_4) / 4;
    }

    public void setTodasNotas(Double[] totalNotas){
        setNota_1(totalNotas[0]);
        setNota_2(totalNotas[1]);
        setNota_3(totalNotas[2]);
        setNota_4(totalNotas[3]);

        setTotalNotas();
    }
}
