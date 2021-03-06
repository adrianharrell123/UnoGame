/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *This class is the controller for all components of the GUI,
 *containing each component's action listener and related game logic
 *to link the GUI to the UnoGame class.
 *
 * @author Derek Syrba, John Frocillo, and Adrian Harrell
 */
public class FXMLDocumentController implements Initializable {

	/**The UnoGame object to handle all of the logic in the game.*/
	private UnoGame game = new UnoGame();

	/**The button the player presses to draw a card from the deck.*/
	@FXML
	private Button drawButton;

	/**The label to show the top card of the discard pile.*/
	@FXML
	private Label discardPile;

	/**The button player 1 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player1PlayCard;

	/**The button that shows the next card in player 1's hand.*/
	@FXML
	private Button player1Next;

	/**The button that shows the previous card in player 1's hand.*/
	@FXML
	private Button player1Prev;

	/**The button player 2 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player2PlayCard;

	/**The button that shows the next card in player 2's hand.*/
	@FXML
	private Button player2Next;

	/**The button that shows the previous card in player 2's hand.*/
	@FXML
	private Button player2Prev;

	/**The button player 3 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player3PlayCard;

	/**The button that shows the next card in player 3's hand.*/
	@FXML
	private Button player3Next;

	/**The button that shows the previous card in player 3's hand.*/
	@FXML
	private Button player3Prev;

	/**The button player 4 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player4PlayCard;

	/**The button that shows the next card in player 4's hand.*/
	@FXML
	private Button player4Next;

	/**The button that shows the previous card in player 4's hand.*/
	@FXML
	private Button player4Prev;

	/**The label that shows the current card in player 1's hand.*/
	@FXML
	private Label player1Card;

	/**The label that shows the current card in player 2's hand.*/
	@FXML
	private Label player2Card;

	/**The label that shows the current card in player 3's hand.*/
	@FXML
	private Label player3Card;

	/**The label that shows the current card in player 4's hand.*/
	@FXML
	private Label player4Card;


	/**
	 * Method that acts as an action listener for the draw card button.
	 * 
	 * @param e - the drawButton being pressed.
	 */
	@FXML
	private void drawCard(final ActionEvent e) {
		System.out.println("Card is Drawn");

		game.reshuffle();
		
		game.drawCard(game.currentPlayer(), 1);
		
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 1's next
	 * card button.
	 * 
	 * @param e - the player1Next button being pressed.
	 */
	@FXML
	private void nextCard1(final ActionEvent e) {

		game.nextCard(game.getPlayer1(), 
				game.getPlayer1().getCurrentCard(), true);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 1's previous
	 * card button.
	 * 
	 * @param e - the player1Prev button being pressed.
	 */
	@FXML
	private void prevCard1(final ActionEvent e) {

		game.nextCard(game.getPlayer1(), 
				game.getPlayer1().getCurrentCard(), false);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener player 1's play card
	 * button.
	 * 
	 * @param e - the player1PlayCard button being pressed.
	 */
	@FXML
	private void playCard1(final ActionEvent e) {
		if (game.isValid(game.getPlayer1().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {
			
			if (game.getPlayer1().getCurrentCard().getIsWild()) {
				changeColor();
			}
			game.playCard(game.getPlayer1(), game.getPlayer1().getCurrentCard());
			
			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 1 Wins!");
				System.exit(0);
			}
			
			displayBoard();
				
		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}

	}

	
	/**
	 * Method that acts as an action listener for player 2's next
	 * card button.
	 * 
	 * @param e - the player2Next button being pressed.
	 */
	@FXML
	private void nextCard2(final ActionEvent e) {
		game.nextCard(game.getPlayer2(), game.getPlayer2().getCurrentCard(), 
				true);
		
		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 2's previous
	 * card button.
	 * 
	 * @param e - the player2Prev button being pressed.
	 */
	@FXML
	private void prevCard2(final ActionEvent e) {
		game.nextCard(game.getPlayer2(), game.getPlayer2().getCurrentCard(), 
				false);
		
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 2's play card
	 * button.
	 * 
	 * @param e - the player2PlayCard button being pressed.
	 */
	@FXML
	private void playCard2(final ActionEvent e) {
		if (game.isValid(game.getPlayer2().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {
			
			if (game.getPlayer2().getCurrentCard().getIsWild()) {
				changeColor();
			}
			
			game.playCard(game.getPlayer2(), game.getPlayer2().getCurrentCard());
			
			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 2 Wins!");
				System.exit(0);
			}
			
			displayBoard();
			
		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}
	}

	
	/**
	 * Method that acts as an action listener for player 3's next
	 * card button.
	 * 
	 * @param e - the player3Next button being pressed.
	 */
	@FXML
	private void nextCard3(final ActionEvent e) {
		game.nextCard(game.getPlayer3(), game.getPlayer3().getCurrentCard(), true);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 3's previous
	 * card button.
	 * 
	 * @param e - the player3Prev button being pressed.
	 */
	@FXML
	private void prevCard3(final ActionEvent e) {
		game.nextCard(game.getPlayer3(), game.getPlayer3().getCurrentCard(), false);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 3's play
	 * card button.
	 * 
	 * @param e - the player3PlayCard button being pressed.
	 */
	@FXML
	private void playCard3(final ActionEvent e) {
		if (game.isValid(game.getPlayer3().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {
			
			if (game.getPlayer3().getCurrentCard().getIsWild()) {
				changeColor();
			}
			
			game.playCard(game.getPlayer3(), game.getPlayer3().getCurrentCard());
			
			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 3 Wins!");
				System.exit(0);
			}
			
			displayBoard();
			
		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}
	}

	
	/**
	 * Method that acts as an action listener for player 4's next
	 * card button.
	 * 
	 * @param e - the player4Next button being pressed.
	 */
	@FXML
	private void nextCard4(final ActionEvent e) {
		game.nextCard(game.getPlayer4(), game.getPlayer4().getCurrentCard(), true);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 4's previous
	 * card button.
	 * 
	 * @param e - the player4Prev button being pressed.
	 */
	@FXML
	private void prevCard4(final ActionEvent e) {
		game.nextCard(game.getPlayer4(), game.getPlayer4().getCurrentCard(), 
				false);
		
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 4's play
	 * card button.
	 * 
	 * @param e - the player4PlayCard button being pressed.
	 */
	@FXML
	private void playCard4(final ActionEvent e) {
		if (game.isValid(game.getPlayer4().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {
			
			if (game.getPlayer4().getCurrentCard().getIsWild()) {
				changeColor();
			}
			
			game.playCard(game.getPlayer4(), game.getPlayer4().getCurrentCard());
			
			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 4 Wins!");
				System.exit(0);
			}
			
			displayBoard();
			
		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}
	}


	
	/**
	 * Method that provides a pop up window when a wild card is played
	 * so the player can select a new color.
	 */
	private void changeColor() {

		String[] a = {"red", "green", "blue", "yellow"};
		
		String input = (String) JOptionPane.showInputDialog(null,
				"Select A New Color:", "Wild", 
				JOptionPane.QUESTION_MESSAGE, null, a, a[0]);

		if (input == null || input.length() == 0) {
			game.currentPlayer().getCurrentCard().setCardColor("red");
		}


		//FIXME:
		if (!(input.equals(game.currentPlayer().
				getCurrentCard().getCardColor()))) {

			if (input.equals("red"))	{
				game.currentPlayer().getCurrentCard().setCardColor("red");
			}

			if (input.equals("green")) {
				game.currentPlayer().getCurrentCard().setCardColor("green");
			}

			if (input.equals("blue"))	{
				game.currentPlayer().getCurrentCard().setCardColor("blue");
			}

			if (input.equals("yellow"))	{
				game.currentPlayer().getCurrentCard().setCardColor("yellow");
			}
			
		} else {

			JOptionPane.showMessageDialog(null, 
					"Can't select the same color");
		}
	}

	
	/**
	 * Method that updates the the labels in the game display each time
	 * a button is pressed or a turn changes.
	 */
	private void displayBoard() {
		if (game.getPlayer1().getCurrentCard().getIsPlus2()) {
			player1Card.setText("+2");
		} else if (game.getPlayer1().getCurrentCard().getIsPlus4()) {
			player1Card.setText("Wild: +4");
		} else if (game.getPlayer1().getCurrentCard().getIsReverse()) {
			player1Card.setText("Reverse");
		} else if (game.getPlayer1().getCurrentCard().getIsSkip()) {
			player1Card.setText("Skip");
		} else if (game.getPlayer1().getCurrentCard().getIsWild()) {
			player1Card.setText("Wild");
		} else {
			player1Card.setText(Integer.toString(game.getPlayer1().getCurrentCard().getCardNumber()));
		}

		if (game.getPlayer2().getCurrentCard().getIsPlus2()) {
			player2Card.setText("+2");
		} else if (game.getPlayer2().getCurrentCard().getIsPlus4()) {
			player2Card.setText("Wild: +4");
		} else if (game.getPlayer2().getCurrentCard().getIsReverse()) {
			player2Card.setText("Reverse");
		} else if (game.getPlayer2().getCurrentCard().getIsSkip()) {
			player2Card.setText("Skip");
		} else if (game.getPlayer2().getCurrentCard().getIsWild()) {
			player2Card.setText("Wild");
		} else {
			player2Card.setText(Integer.toString(game.getPlayer2().getCurrentCard().getCardNumber()));
		}

		if (game.getPlayer3().getCurrentCard().getIsPlus2()) {
			player3Card.setText("+2");
		} else if (game.getPlayer3().getCurrentCard().getIsPlus4()) {
			player3Card.setText("Wild: +4");
		} else if (game.getPlayer3().getCurrentCard().getIsReverse()) {
			player3Card.setText("Reverse");
		} else if (game.getPlayer3().getCurrentCard().getIsSkip()) {
			player3Card.setText("Skip");
		} else if (game.getPlayer3().getCurrentCard().getIsWild()) {
			player3Card.setText("Wild");
		} else {
			player3Card.setText(Integer.toString(game.getPlayer3().getCurrentCard().getCardNumber()));
		}

		if (game.getPlayer4().getCurrentCard().getIsPlus2()) {
			player4Card.setText("+2");
		} else if (game.getPlayer4().getCurrentCard().getIsPlus4()) {
			player4Card.setText("Wild: +4");
		} else if (game.getPlayer4().getCurrentCard().getIsReverse()) {
			player4Card.setText("Reverse");
		} else if (game.getPlayer4().getCurrentCard().getIsSkip()) {
			player4Card.setText("Skip");
		} else if (game.getPlayer4().getCurrentCard().getIsWild()) {
			player4Card.setText("Wild");
		} else {
			player4Card.setText(Integer.toString(game.getPlayer4().getCurrentCard().getCardNumber()));
		}

		player1Card.setStyle("-fx-background-color: " + game.getPlayer1().getCurrentCard().getCardColor());
		player2Card.setStyle("-fx-background-color: " + game.getPlayer2().getCurrentCard().getCardColor());
		player3Card.setStyle("-fx-background-color: " + game.getPlayer3().getCurrentCard().getCardColor());
		player4Card.setStyle("-fx-background-color: " + game.getPlayer4().getCurrentCard().getCardColor());

		discardPile.setStyle("-fx-background-color: " + game.getDiscardPile().get(game.getDiscardPile().size() - 1).getCardColor());

		if (game.getDiscardPile().get(game.getDiscardPile().size() - 1).getIsPlus2()) {
			discardPile.setText("+2");
		} else if (game.getDiscardPile().get(game.getDiscardPile().size() - 1).getIsPlus4()) {
			discardPile.setText("Wild: +4");
		} else if (game.getDiscardPile().get(game.getDiscardPile().size() - 1).getIsReverse()) {
			discardPile.setText("Reverse");
		} else if (game.getDiscardPile().get(game.getDiscardPile().size() - 1).getIsSkip()) {
			discardPile.setText("Skip");
		} else if (game.getDiscardPile().get(game.getDiscardPile().size() - 1).getIsWild()) {
			discardPile.setText("Wild");
		} else {
			discardPile.setText(Integer.toString(game.getDiscardPile().get(game.getDiscardPile().size() - 1).getCardNumber()));
		}

		if (!(game.getPlayer1().getIsPlayerTurn())) {
			player1PlayCard.setVisible(false);
			player1Next.setVisible(false);
			player1Prev.setVisible(false);
			player1Card.setVisible(false);
		} else {
			player1PlayCard.setVisible(true);
			player1Next.setVisible(true);
			player1Prev.setVisible(true);
			player1Card.setVisible(true);
		}

		if (!(game.getPlayer2().getIsPlayerTurn())) {
			player2PlayCard.setVisible(false);
			player2Next.setVisible(false);
			player2Prev.setVisible(false);
			player2Card.setVisible(false);
		} else {
			player2PlayCard.setVisible(true);
			player2Next.setVisible(true);
			player2Prev.setVisible(true);
			player2Card.setVisible(true);
		}

		if (!(game.getPlayer3().getIsPlayerTurn())) {
			player3PlayCard.setVisible(false);
			player3Next.setVisible(false);
			player3Prev.setVisible(false);
			player3Card.setVisible(false);
		} else {
			player3PlayCard.setVisible(true);
			player3Next.setVisible(true);
			player3Prev.setVisible(true);
			player3Card.setVisible(true);
		}

		if (!(game.getPlayer4().getIsPlayerTurn())) {
			player4PlayCard.setVisible(false);
			player4Next.setVisible(false);
			player4Prev.setVisible(false);
			player4Card.setVisible(false);
		} else {
			player4PlayCard.setVisible(true);
			player4Next.setVisible(true);
			player4Prev.setVisible(true);
			player4Card.setVisible(true);
		}
	}


	/**
	 * Method that sets up the initial game display when the program
	 * is first run.
	 */
	@Override
	public void initialize(final URL url, final ResourceBundle rb) {

		//deals the cards to players
		game.dealDeck();

		//plays the first card
		game.getDiscardPile().add(game.getDeck().get(0));
		game.getDeck().remove(0);

		//initialize the current cards in each players hand
		//(the card they are looking at)
		game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(0));
		game.getPlayer2().setCurrentCard(game.getPlayer2().getPlayerDeck().get(0));
		game.getPlayer3().setCurrentCard(game.getPlayer3().getPlayerDeck().get(0));
		game.getPlayer4().setCurrentCard(game.getPlayer4().getPlayerDeck().get(0));

		displayBoard();

	}    

}
