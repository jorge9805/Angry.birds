/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybirds;

/**
 *
 * @author admin
 */
public class Cerdo {

    private String tipo;
    private int vida;
    private int posicionx;
    private int posiciony;
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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


    public Cerdo(String tipo, int posicionx, int posiciony) {
        if(tipo.equals("rey")){
            this.tipo="reycerdo.png";
            this.vida=3;
        }
        if(tipo.equals("comun")){
            this.tipo="cerdopequeño.png";
            this.vida=1;
        }
        this.posicionx=posicionx;
        this.posiciony=posiciony;
    }
    public String explosion(Cerdo cerdo){
        if(cerdo.tipo.equals("cerdopequeño.png")){
            return "explosioncerdopequeño.png";
        }
        if (cerdo.tipo.equals("reycerdo.png")){
            return "explosionreycerdo.png"; 
        }else return null;
             
    } 
    public int posicionexplosionx(Cerdo cerdo){
        return cerdo.posicionx;
    }
    public int posicionexplosiony(Cerdo cerdo){
        return cerdo.posiciony;
    }
}
    
