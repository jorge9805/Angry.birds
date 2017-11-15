/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybirds;
import javax.swing.JFrame;
/**
 *
 * @author admin
 */
public class AngryBirds extends JFrame{
    
    public AngryBirds() {

        initUI();
    }

    private void initUI() {
        add(new BoardAngrybirds());
        setSize(1232, 568);
        setTitle("AngryBirds");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        AngryBirds ex = new AngryBirds();
        ex.setVisible(true);
       
    }
}
