
/**
 * The BigTwoCard class is a subclass of the Card class, and is used to model a
 * card used in a Big Two card game. It overrides the compareTo() method it
 * inherits from the Card class to reflect the ordering of cards used in a Big
 * Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class BigTwoCard extends Card {

	
	private static final long serialVersionUID = -5822018182891811204L;

	/**
	 * a constructor for building a card with the specified suit and rank
	 * 
	 * @param suit an integer between 0 and 3
	 * @param rank an integer between 0 and 12
	 */
	public BigTwoCard(int suit, int rank) {
		super(suit, rank);
	}

	/**
	 * a method for comparing the order of this card with the specified card
	 * 
	 * @return a negative integer, zero, or a positive integer as this card is less
	 *         than, equal to, or greater than the specified card
	 */
	@Override
	public int compareTo(Card card) {
		int rank1 = this.getRank();
		int rank2 = card.getRank();

		if (rank1 < 2) { // if A or 2
			rank1 += 13;
		}
		if (rank2 < 2) { // if A or 2
			rank2 += 13;
		}
		if (rank1 > rank2) {
			return 1;
		} else if (rank1 < rank2) {
			return -1;
		} else if (this.getSuit() > card.getSuit()) {
			return 1;
		} else if (this.getSuit() < card.getSuit()) {
			return -1;
		} else {
			return 0;
		}
	}

}
