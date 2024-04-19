import java.util.ArrayList;

public class Hand {
    protected ArrayList<Card> current = new ArrayList<Card>();
    protected int handSum = 0;  //Total sum of the complete hand.
    protected int aceCount = 0; //First ace will count as 11 unless it makes a bust.

    public int getAceCount(){
        return this.aceCount;
    }

    public int getHandSum(){
        return this.handSum;
    }

    public ArrayList<Card> getCurrentHand(){
        return this.current;
    }

    public void addCard(Card card){
        this.current.add(card);

        handSum += card.getValue();
        aceCount += card.isAce() ? 1 : 0; //if ace add 1 else add 0.

        aceReduce();
    }

    public int aceReduce(){
        while(this.handSum > 21 && this.aceCount > 0){
            this.handSum -= 10;
            this.aceCount -= 1;
        }
        return this.handSum;
    }
}
