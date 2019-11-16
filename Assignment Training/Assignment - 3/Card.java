/**
 * @author SaiKotesh0102
 * This Class implements Card which has attributes as facevalue and 
 * suit value.
 */

public class Card implements Comparable<Card>{
    public int faceValue;
    public int type;

    public Card(int type, int faceValue){
        this.faceValue = faceValue;
        this.type = type;
    }
    /**
     * Compare To method to cards based on Suit value.
     * If Suit value is equal, then compare them with the face value.
     */
    public int compareTo(Card that){
        if(this.type > that.type){
            return 1;
        }else if(this.type < that.type){
            return -1;
        }else{
            if(this.faceValue > that.faceValue){
                return 1;
            }else if(this.faceValue < that.faceValue){
                return -1;
            }else{
                return 0;
            }
        }
    }
    /**
     * To String method to print the output.
     */
    public String toString(){
        String rank = "";
        String value = "";

        if(this.type == 1){
            rank = "Spades";
        }else if(this.type == 2){
            rank = "Hearts";
        }else if(this.type == 3){
            rank = "Clubs";
        }else if(this.type == 4){
            rank = "Diamonds";
        }

        if(this.faceValue == 1){
            value = "A";
        }else if(this.faceValue == 11){
            value = "J";
        }else if(this.faceValue == 12){
            value = "Q";
        }else if(this.faceValue == 13){
            value = "K";
        }else{
            value = this.faceValue + "";
        }

        return rank +":"+ value;
    }

}