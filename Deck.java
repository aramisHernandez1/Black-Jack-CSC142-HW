import java.util.ArrayList;
import java.util.Random;

//Deck class for main game deck
public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Random random = new Random();

    public Deck(){
        BuildDeck();
        Shuffle();

        System.out.println("BUILD DECK");
        System.out.println(cards);
    }



    private String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J"}; //All possilble card values.
    private String[] types = {"C", "D", "H", "S"}; //Types are irrelavant when computing winner, but are here to get correct looking card.


    //Build deck method that itterates through type and value and creates cards, adding them to array.
    private void BuildDeck(){
        for(int i = 0; i < types.length; i++){
            for(int j = 0; j < values.length; j ++){
                Card card = new Card(values[j], types[i]);
                cards.add(card);
            }
        }


    }

    //Suffle method which randomizes cards
    public void Shuffle(){
        
        for(int i = 0; i < cards.size(); i++){
            //Gets a random index of any card so 0-51.
            int randIndex = random.nextInt(cards.size());
            
            //Stores both cards then swaps their locations.
            Card currCard = cards.get(i);
            Card randomCard = cards.get(randIndex); 

            cards.set(i, randomCard);
            cards.set(randIndex, currCard);
        }
    }

    public Card drawCard(){
        return cards.remove(cards.size()-1); //Draw last card form array.
    }

    //Test method to draw only aces these Aces are created and not apart of the deck
    public Card drawAce(){
        return new Card("A", "S");
    }
}
