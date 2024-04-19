import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Curently working on hitting and staying so main gameplay loop
public class BlackJack{

    Window mainWind;
    Hand player;
    Deck deck;
    int dealer;

    public BlackJack(){
        startGame();

        PlayerHit();

    }

    public void startGame(){
        //Main game deck.
        deck = new Deck();

        //Dealer
        Random random = new Random();
        dealer = random.nextInt(16, 22);

        //Init player hand.
        player = new Hand();

        mainWind = new Window(player, deck, dealer);


        System.out.println("Dealer Hand:" + dealer);

        System.out.print("\nPlayer Hand:");
        System.out.print(player.getCurrentHand());
        System.out.print(" " + player.getHandSum());
    }

    private void PlayerHit(){
        mainWind.hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                while (player.handSum < dealer) {
                    player.addCard(deck.drawCard());
                    
                }
                System.out.print(player.getCurrentHand());
                
                System.out.println(player.handSum);
                
                if(player.handSum >= 21){
                    mainWind.hitButton.setEnabled(false);
                }

                mainWind.gamePanel.repaint();
            }
        });
    }

}