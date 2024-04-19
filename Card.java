public class Card {
    String value; //Card numeric value, (ex: King = 10, 9 = 9, etc...)
    String type; //Card type(Not very relevant) EX: Hearts, Clubs, etc...

    //Vaule is the cards actual value in the game.
    //Type is not very important and is only their to match the picture cards making it look more like black jack.
    Card(String value, String type){
        this.value = value;
        this.type = type;
    }
    
    public int getValue(){
        //Check if any of the head cards
        if("AKQJ".contains(value)){
            if(value == "A") return 11; //Only ace is not 10
            
            return 10;
        }

        //If its not a head card we can just straight convert it to an int.
        return Integer.parseInt(value);
    }

    public boolean isAce(){
        return value == "A";
    }

    //Override toString method, and add dash to match png image names.
    public String toString(){
        return this.value + "-" + this.type;
    }

    //Returns image path + the card name, image is in cards folder in the same directory.
    public String getImagePath(){
        return "./cards/" + this.toString() + ".png";
    }
}
