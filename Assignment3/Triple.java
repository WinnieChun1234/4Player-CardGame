/**
 * This is a subclass of the Hand class, and are used to model a hand of triple
 * in a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class Triple extends Hand {

	private static final long serialVersionUID = 2109395258622002051L;

	/**
	 * a constructor for building a hand of triple with the specified player and
	 * list of cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Triple(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	public boolean isValid() {
		return this.size() == 3 && this.getCard(0).getRank() == this.getCard(1).getRank()
				&& this.getCard(0).getRank() == this.getCard(2).getRank();
	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "Triple";
	}
}
