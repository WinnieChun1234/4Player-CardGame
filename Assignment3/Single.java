/**
 * This is a subclass of the Hand class, and are used to model a hand of single
 * in a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class Single extends Hand {

	private static final long serialVersionUID = 178749520333021015L;

	/**
	 * a constructor for building a hand of single with the specified player and list of
	 * cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Single(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	public boolean isValid() {
		return this.size() == 1;
	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "Single";
	}
}
