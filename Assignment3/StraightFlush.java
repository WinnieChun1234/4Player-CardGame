/**
 * This is a subclass of the Hand class, and are used to model a hand of
 * Straight Flush in a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class StraightFlush extends Hand {

	private static final long serialVersionUID = -7319311705716526303L;

	/**
	 * a constructor for building a hand of straight flush with the specified player
	 * and list of cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public StraightFlush(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	public boolean isValid() {
		this.sort();

		if (this.size() != 5) {
			return false;
		}

		int suit = this.getCard(0).getSuit();
		for (int i = 1; i < 5; i++) {
			if (this.getCard(i).getSuit() != suit)
				return false;
		}

		int firstRank = this.getCard(0).getRank();
		int lastRank = this.getCard(4).getRank();

		if (firstRank == 10 && lastRank == 1) {// J,Q,K,A,2
			return true;
		} else if (firstRank == 9 && lastRank == 0) {// 10,J,Q,K,A
			return true;
		} else if (firstRank + 4 == lastRank) { // n,n+1,n+2,n+3,n+4
			return true;
		}
		return false;
	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "StraightFlush";
	}
}