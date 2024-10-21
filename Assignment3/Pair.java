/**
 * This is a subclass of the Hand class, and are used to model a hand of pair in
 * a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class Pair extends Hand {

	private static final long serialVersionUID = -7735787877198652522L;

	/**
	 * a constructor for building a hand of pair with the specified player and list
	 * of cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Pair(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	public boolean isValid() {
		return this.size() == 2 && this.getCard(0).getRank() == this.getCard(1).getRank();
	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "Pair";
	}
}