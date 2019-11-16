import java.util.*;

public class DeckSort{
    static Card[] cards;
    static int n;

    public DeckSort(){
        DeckSort.cards = new Card[52];
        DeckSort.n = 0;
    }

    public Card[] sorting(Card[] cards){
        for(int i = 0; i < cards.length; i++){
            int min = i;
            for (int j = i+1; j < cards.length; j++) {
                if(cards[i].compareTo(cards[min]) == -1){
                    min = j;
                }
            }
            Card temp = cards[i];
            cards[i] = cards[min];
            cards[min] = temp;
        }
        return cards;
    }

    public static void main(String[] args) {
        int[] rank = {1,2,3,4};
        int[] value = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(int i = 0; i < rank.length; i++){
            for(int j = 0; i < value.length; j++){
                cards[n++] = new Card(value[j],rank[i]);
            }
        }
    }
}