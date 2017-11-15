/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybirds;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Rectangle;

public class BoardAngrybirds extends JPanel  implements ActionListener {

    private final int INITIAL_Y =500;
    private final int YLINEAPIEDRAS = 226;
    private final int XLINEAPIEDRAS = 450;
    private Cerdo[] cerdos;
    private Pajaro pajaro;
    private Vida vidas;
    private Puntaje puntaje;
    private Timer timer;
    private double t;
    private int positiongameoverx;
    private Image win;
           
    public BoardAngrybirds() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.WHITE);
        this.vidas=new Vida();
        this.puntaje=new Puntaje();
        this.pajaro=new Pajaro();
        this.cerdos= new Cerdo[5];
        this.cerdos[0]=new Cerdo("comun", 336, this.INITIAL_Y-50);
        for (int i=0;i<3;i++){
        this.cerdos[i+1]=new Cerdo("comun",this.XLINEAPIEDRAS+(20*(i+1))+(50*(i+1)),this.YLINEAPIEDRAS-50 );
        }
        this.positiongameoverx=3000;
        this.cerdos[4]=new Cerdo("rey",896,200);
        this.t = 0;
        this.timer = new Timer(25, this);
        setFocusable(true);
        addKeyListener(new EventosTeclado());
        this.timer.start();
    }
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
         
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
            //Toca validar los limites
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_LEFT) {
             pajaro.setPosicionx(pajaro.getPosicionx()-2);
             pajaro.setVelocidadx(pajaro.getVelocidadx()+2);
             
           }
           if (key == KeyEvent.VK_RIGHT) {
             pajaro.setPosicionx(pajaro.getPosicionx()+2);
             pajaro.setVelocidadx(pajaro.getVelocidadx()-2);
           }
            if (key == KeyEvent.VK_UP) {
             pajaro.setPosiciony(pajaro.getPosiciony()-2);
             pajaro.setVelocidady(pajaro.getVelocidady()+2);
           }
            if (key == KeyEvent.VK_DOWN) {
             pajaro.setPosiciony(pajaro.getPosiciony()+2);
             pajaro.setVelocidady(pajaro.getVelocidady()-2);
           }
            
            if(key ==KeyEvent.VK_SPACE){
             pajaro.setPosicionx((int)(pajaro.getPosicionx()+pajaro.getVelocidadx()));
             pajaro.setPosiciony((int)(pajaro.getPosiciony()+pajaro.getVelocidady()+(0.98*t*t*05)));
            // this.y = (int)(this.y + vx*t + (0.5*-9.8)*t*t);
             t +=0.1;
             repaint();
            }
        }
     }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        //g2d.fillOval(x, y, 30, 30);
        Image piso = loadImage("ground_loop.png");
        Image fondo = loadImage("blue_background.png");
        Image resortera = loadImage("resortera.png");
        Image cerdo = loadImage(this.cerdos[1].getTipo());
        Image piedra =loadImage("stone.png");
        Image reyCerdo= loadImage(this.cerdos[4].getTipo());
        Image pajaro= loadImage (this.pajaro.getPajaroinicial());
        Image gameover=loadImage("gameover.png");
        for (int i=0; i<56; i++){
            g.drawImage(fondo, 22*i, 0,null);
        }
        for(int i=0;i<11;i++){
            g.drawImage(piso,112*i, INITIAL_Y, null);
        }  
        g.drawImage(resortera, 70, INITIAL_Y-149, null);
        g.drawImage(cerdo, this.cerdos[0].getPosicionx(), this.cerdos[0].getPosiciony(),null);
        for(int i=1; i<=3; i++ ){
            g.drawImage(piedra, XLINEAPIEDRAS+(i*65), YLINEAPIEDRAS, null);
            g.drawImage(cerdo,this.cerdos[i].getPosicionx() , this.cerdos[i].getPosiciony(), null);
        }
        g.drawImage(reyCerdo, this.cerdos[4].getPosicionx(), this.cerdos[4].getPosiciony(), null);
        g.drawImage(piedra, this.cerdos[4].getPosicionx()-112, this.cerdos[4].getPosiciony()+56, null);
        g.drawImage(piedra, this.cerdos[4].getPosicionx()-65, this.cerdos[4].getPosiciony() -54, null);
        g.drawImage(piedra, this.cerdos[4].getPosicionx()+95, this.cerdos[4].getPosiciony()-54, null);
        g.drawImage(piedra, this.cerdos[4].getPosicionx()+118, this.cerdos[4].getPosiciony()+56, null);
        g.drawImage(piedra, this.cerdos[4].getPosicionx(), this.cerdos[4].getPosiciony() +124, null);
        g.drawImage(pajaro,this.pajaro.getPosicionx() ,this.pajaro.getPosiciony(), this);
        g.setColor(Color.BLACK);
        g.drawString("INSTRUCCIONES:",80 , 55);
        g.drawString("con las flechas se mueve el pajaro y",70 , 70);
        g.drawString("y manteniendo presionado el espacio ",70 , 85);
        g.drawString("o presionando varias veces",70 , 100);
        g.drawString("se hace el tiro",70 , 115);
        g.drawString("VIDAS: "+this.vidas.getNumerovidas(), 336, 70);
        g.drawString("PUNTAJE: "+this.puntaje.getPuntaje(), 784, 70);
        g.drawImage (gameover,this.positiongameoverx,208,null);
        
        //aca se pintan los cuadros de intersección
        Rectangle piedra1=new Rectangle(XLINEAPIEDRAS+65, YLINEAPIEDRAS,195,59);
        Rectangle piedra2=new Rectangle(this.cerdos[4].getPosicionx()-112, this.cerdos[4].getPosiciony()+56,65,59);
        Rectangle piedra3=new Rectangle(this.cerdos[4].getPosicionx()-65, this.cerdos[4].getPosiciony() -54,65,59);
        Rectangle piedra4=new Rectangle(this.cerdos[4].getPosicionx()+95, this.cerdos[4].getPosiciony()-54,65,59);
        Rectangle piedra5=new Rectangle( this.cerdos[4].getPosicionx()+118, this.cerdos[4].getPosiciony()+56,65,59);
        Rectangle piedra6=new Rectangle(this.cerdos[4].getPosicionx(), this.cerdos[4].getPosiciony() +124,65,59);
        Rectangle pajarobox=new Rectangle (this.pajaro.getPosicionx() ,this.pajaro.getPosiciony(),50,50);
        Rectangle pisobox=new Rectangle(0,INITIAL_Y,5000,100);
        Rectangle cerdo0=new Rectangle (this.cerdos[0].getPosicionx(),this.cerdos[0].getPosiciony(),50,50);
        Rectangle cerdo1=new Rectangle (this.cerdos[1].getPosicionx() , this.cerdos[1].getPosiciony(),50,50);
        Rectangle cerdo2=new Rectangle (this.cerdos[2].getPosicionx() , this.cerdos[2].getPosiciony(),50,50);
        Rectangle cerdo3=new Rectangle (this.cerdos[3].getPosicionx() , this.cerdos[3].getPosiciony(),50,50);
        Rectangle cerdorey=new Rectangle (this.cerdos[4].getPosicionx(), this.cerdos[4].getPosiciony(),92,106);
        
        if (pajarobox.intersects(piedra1)||pajarobox.intersects(piedra2)||
                pajarobox.intersects(piedra3)||pajarobox.intersects(piedra4)||
                pajarobox.intersects(piedra5)||pajarobox.intersects(piedra6)||pajarobox.intersects(pisobox)){
            this.pajaro.setPosicionx(this.pajaro.getPosicioninicialx());
            this.pajaro.setPosiciony(this.pajaro.getPosicioninicialy());
            this.pajaro.setVelocidadx(0);
            this.pajaro.setVelocidady(0);
            this.t=0;
            if(this.vidas.getNumerovidas()==1){
                this.positiongameoverx=300;
            }
            this.vidas.setNumerovidas(this.vidas.getNumerovidas()-1);
        }       
        if (pajarobox.intersects(cerdo0)){
            this.pajaro.setPosicionx(this.pajaro.getPosicioninicialx());
            this.pajaro.setPosiciony(this.pajaro.getPosicioninicialy());
            this.pajaro.setVelocidadx(0);
            this.pajaro.setVelocidady(0);
            this.t=0;
            this.puntaje.setPuntaje(this.puntaje.getPuntaje()+1);
            this.cerdos[0].setPosicionx(3000);
        }
        if (pajarobox.intersects(cerdo1)){
            this.pajaro.setPosicionx(this.pajaro.getPosicioninicialx());
            this.pajaro.setPosiciony(this.pajaro.getPosicioninicialy());
            this.pajaro.setVelocidadx(0);
            this.pajaro.setVelocidady(0);
            this.t=0;
            this.puntaje.setPuntaje(this.puntaje.getPuntaje()+1);
            this.cerdos[1].setPosicionx(3000);
            
        }
        if (pajarobox.intersects(cerdo2)){
            this.pajaro.setPosicionx(this.pajaro.getPosicioninicialx());
            this.pajaro.setPosiciony(this.pajaro.getPosicioninicialy());
            this.pajaro.setVelocidadx(0);
            this.pajaro.setVelocidady(0);
            this.t=0;
            this.puntaje.setPuntaje(this.puntaje.getPuntaje()+1);
            this.cerdos[2].setPosicionx(3000);
        }
        if (pajarobox.intersects(cerdo3)){
            this.pajaro.setPosicionx(this.pajaro.getPosicioninicialx());
            this.pajaro.setPosiciony(this.pajaro.getPosicioninicialy());
            this.pajaro.setVelocidadx(0);
            this.pajaro.setVelocidady(0);
            this.t=0;
            this.puntaje.setPuntaje(this.puntaje.getPuntaje()+1);
            this.cerdos[3].setPosicionx(3000);
        }
        if (pajarobox.intersects(cerdorey)){
            this.pajaro.setPosicionx(this.pajaro.getPosicioninicialx());
            this.pajaro.setPosiciony(this.pajaro.getPosicioninicialy());
            this.pajaro.setVelocidadx(0);
            this.pajaro.setVelocidady(0);
            this.t=0;
            this.puntaje.setPuntaje(this.puntaje.getPuntaje()+3);
            if(this.cerdos[4].getVida()==0){
            this.cerdos[4].setPosicionx(3000);
            }else{
                this.cerdos[4].setVida(this.cerdos[4].getVida()-1);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        t += 0.01;
        repaint();
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
