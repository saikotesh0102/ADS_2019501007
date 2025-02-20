/**
 * @author SaiKotesh0102
 */

import java.util.*;

public class DeckSort{
    static Card[] cards;
    static int n;

    public DeckSort(){
        cards = new Card[52];
        DeckSort.n = 0;
    }
    /**
     * Selection Sort method to sort the Cards based 
     * on Compare To method.
     * @param cards
     * @return Cards in Sorted Order.
     */
    public static Card[] sorting(Card[] cards){
        for(int i = 0; i < cards.length; i++){
            int min = i;
            for (int j = i+1; j < cards.length; j++) {
                if(cards[j].compareTo(cards[min]) == -1){
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
        DeckSort sort = new DeckSort();
        int[] rank = {1,2,3,4};
        int[] value = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(int i = 0; i < rank.length; i++){
            for(int j = 0; j < value.length; j++){
                cards[n++] = new Card(rank[i],value[j]);
            }
        }

        Random rand = new Random();
		
		for (int i = 0; i < cards.length; i++) {
			int randomIndexToSwap = rand.nextInt(cards.length);
			Card temp = cards[randomIndexToSwap];
			cards[randomIndexToSwap] = cards[i];
			cards[i] = temp;
		}
        System.out.println(Arrays.toString(cards));
        sort.sorting(cards);
        System.out.println(Arrays.toString(cards));
    }
}