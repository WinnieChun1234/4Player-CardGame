/**
 * This is a subclass of the Hand class, and are used to model a hand of flush
 * in a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class Flush extends Hand {

	private static final long serialVersionUID = -1176872676059568463L;

	/**
	 * a constructor for building a hand of flush with the specified player and list
	 * of cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Flush(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	public boolean isValid() {
		if (this.size() != 5) {
			return false;
		}

		int suit = this.getCard(0).getSuit();
		for (int i = 1; i < 5; i++) {
			if (this.getCard(i).getSuit() != suit)
				return false;
		}
		return true;
	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "Flush";
	}
}
