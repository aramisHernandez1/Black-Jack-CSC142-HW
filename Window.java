import javax.swing.*;
import java.awt.*;

public class Window {
        //Frame size
        int boardWidth = 800;
        int boardHeight = boardWidth;
        JFrame frame = new JFrame("Black Jack");
    
    
        //Card dimensions
        int cardWidth = 110;
        int cardHeight = 154;
    
        //Main components
        JPanel gamePanel;
        JPanel buttonPanel = new JPanel();
        JButton hitButton = new JButton("Hit");
    
        //Colors
        Color backgroundColor = new Color(50, 110, 55); //Similar color to basic black jack games
    
        public Window(Hand playerHand, Deck gameDeck, int dealer){

            //Initalize main game panel
            gamePanel = new JPanel(){ //Draw our cards in this panel 
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
        
                    //Main import code here for drawing cards!
                    try{
                        //Draws all current cards in players hand. 
                        //Updates this each time the hit event is called.
                        for(int i = 0; i < playerHand.getCurrentHand().size(); i++){
                            Card card = playerHand.getCurrentHand().get(i);
                            Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                            g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 350, cardWidth, cardHeight, null);
                        }


                        //Draw end game message on screen.
                        String endMessage = "";

                        //Different ending conditions
                        if(playerHand.getHandSum() > 21){
                            endMessage = "You Lose :(" ;
                        }
                        else if(playerHand.getCurrentHand().size() == 2 && playerHand.getHandSum() == 21){
                            endMessage = "Black Jack!!!";
                        }
                        else if(playerHand.getHandSum() > dealer){
                            endMessage = "You Win!";
                        }
                        else if(playerHand.getHandSum() == dealer){
                            endMessage = "Tie";
                        }

                        //Draw Game ending message
                        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                        g.setColor(Color.white);
                        g.drawString(endMessage, 220, 120);

                        //Draw basic info message
                        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                        g.drawString("Dealer Hand:" + dealer, 600, 50);
                        g.drawString("Player Hand:" + playerHand.getHandSum(), 600, 600);
        
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            //Set up normal frame needs, along with setting up all components and adding them.
            initalize();

            //Repaint when we first build window.
            gamePanel.repaint();
        }

        private void initalize(){
            initalizeWindow();
            initalizePanels();
        }
    
        //Basic set up frame
        private void initalizeWindow(){
            frame.setVisible(true);
            frame.setSize(boardWidth, boardHeight);
            frame.setLocationRelativeTo(null); //Center of the screen
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
        }
    
        private void initalizePanels(){

            gamePanel.setLayout(new BorderLayout());
            gamePanel.setBackground(backgroundColor); 
            frame.add(gamePanel);
    
            //Gets rid of ugly text highlight
            hitButton.setFocusable(false);
    
            //Set color and add buttons and panel to frame
            buttonPanel.setBackground(Color.black);
            buttonPanel.add(hitButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

        }
}
