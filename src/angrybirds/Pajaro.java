/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybirds;

import angrybirds.BoardAngrybirds;
/**
 *
 * @author admin
 */
public class Pajaro {

    private int posicioninicialx;
    private int posicioninicialy;
    private int posicionx;
    private int posiciony;
    private double velocidadx;
    private double velocidady;
    private String [] pajarorodando;
    private String pajaroinicial;


    public Pajaro() {
        this.pajarorodando=new String[4];
        for (int i=0; i<4;i++){
            this.pajarorodando[i]= "pajaro"+(i+1)+".png";
        }
        this.posicioninicialx = 70;
        this.posicioninicialy = 351;
        this.posicionx = posicioninicialx;
        this.posiciony = posicioninicialy;
        this.velocidadx = 0;
        this.velocidady = 0;
        this.pajaroinicial ="pajaro1.png";
    }
    public String getPajaroinicial() {
        return pajaroinicial;
    }

    public void setPajaroinicial(String pajaroinicial) {
        this.pajaroinicial = pajaroinicial;
    }

    public String[] getPajarorodando() {
        return pajarorodando;
    }

    public void setPajarorodando(String[] pajarorodando) {
        this.pajarorodando = pajarorodando;
    }

    public int getPosicioninicialx() {
        return posicioninicialx;
    }

    public void setPosicioninicialx(int posicioninicialx) {
        this.posicioninicialx = posicioninicialx;
    }

    public int getPosicioninicialy() {
        return posicioninicialy;
    }

    public void setPosicioninicialy(int posicioninicialy) {
        this.posicioninicialy = posicioninicialy;
    }

    public int getPosicionx() {
        return posicionx;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

    public double getVelocidadx() {
        return velocidadx;
    }

    public void setVelocidadx(double velocidadx) {
        this.velocidadx = velocidadx;
    }

    public double getVelocidady() {
        return velocidady;
    }

    public void setVelocidady(double velocidady) {
        this.velocidady = velocidady;
    }
    



}
