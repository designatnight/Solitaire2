package com.stevesmith.solitaire.domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;







import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;

public class GameServiceTest {
	
	private Map<GameSpot, Deck> gameBoard = new HashMap<GameSpot, Deck>();
	private GameService gameService = new GameService(new RuleService(), gameBoard);
	
	@Test
	public void aceToEmptyResPileTest(){
		gameService.newGame();
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_CLUB, 1);
		Deck resolutionDeck = gameService.getDeck(GameSpot.RESOLUTION_CLUB);
		assertEquals(1, resolutionDeck.getSize());
		
		
	}
	
	
	@Test
	public void canResetDrawDeck(){
		gameService.newGame();
		assertEquals(24, gameService.getDeck(GameSpot.DRAW).getSize());
		for(int i = 0; i < 24; i++){
			gameService.drawCard();
		}
		assertEquals(0, gameService.getDeck(GameSpot.DRAW).getSize());
		gameService.drawCard();
		assertEquals(24, gameService.getDeck(GameSpot.DRAW).getSize());
	}
	
	@Test
	public void canMoveCards(){
		gameService.newGame();
		this.gameBoard = gameService.getGameMap();
		gameService.getDeck(GameSpot.REGULAR_7).getCards().add(new Card(Rank.JACK, Suit.CLUB,true));
		assertEquals(1, gameService.getDeck(GameSpot.REGULAR_1).getSize());
		assertEquals(8,gameService.getDeck(GameSpot.REGULAR_7).getSize());
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_1, 2);
		assertEquals(1, gameService.getDeck(GameSpot.REGULAR_1).getSize());
		assertEquals(8,gameService.getDeck(GameSpot.REGULAR_7).getSize());
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 2);
		assertEquals(5, gameService.getDeck(GameSpot.REGULAR_3).getSize());
		assertEquals(6, gameService.getDeck(GameSpot.REGULAR_7).getSize());
	}
	
	@Test
	public void autoTurnUpTest(){
		gameService.newGame();
		this.gameBoard = gameService.getGameMap();
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_1, 1);
		assertTrue(gameService.getDeck(GameSpot.REGULAR_7).getTopCard().isFaceUp());
	}
	
	@Test
	public void canMoveACard(){
		gameService.newGame();
		this.gameBoard = gameService.getGameMap();
		gameService.moveCard(GameSpot.REGULAR_7,GameSpot.REGULAR_3, 1);
		assertEquals(4, gameBoard.get(GameSpot.REGULAR_3).getSize());
		assertEquals(6, gameBoard.get(GameSpot.REGULAR_7).getSize());
	}
	@Test
	public void transferCardsTest(){
		gameService.newGame();
		Deck fromDeck = new Deck();
		Deck toDeck = new Deck();
		fromDeck.addCard(new Card(Rank.TWO, Suit.CLUB, true));
		toDeck.addCard(new Card(Rank.THREE, Suit.DIAMOND, true));
		assertEquals(1, fromDeck.getSize());
		assertEquals(1,toDeck.getSize());
		gameService.transferCards(fromDeck, toDeck, fromDeck);
		assertEquals(2,toDeck.getSize());
		
	}
	
	@Test
	public void getFromCardsTest(){
		gameService.newGame();
		Deck fromDeck = gameService.getDeck(GameSpot.REGULAR_1);
		Deck fromCards = gameService.getFromCards(fromDeck, 1);
		assertEquals(1, fromCards.getSize());
		Deck newFromDeck = new Deck().addCard(new Card(Rank.QUEEN, Suit.DIAMOND, true));
		newFromDeck.addCard(new Card(Rank.JACK, Suit.CLUB,true));
		fromCards = gameService.getFromCards(newFromDeck, 2);
		assertEquals(2, fromCards.getSize());
	}
	
	@Test
	public void newGameTest(){
		gameService.newGame();
		assertEquals(24, gameService.getGameMap().get(GameSpot.DRAW).getSize());
	}
	
	@Test
	public void dealGameTest(){
		
		Deck deck = gameService.newFullDeck();
		gameService.dealGame(deck);
		assertEquals(1, gameService.getDeck(GameSpot.REGULAR_1).getSize());
		assertEquals(2, gameService.getDeck(GameSpot.REGULAR_2).getSize());
		assertEquals(3, gameService.getDeck(GameSpot.REGULAR_3).getSize());
		assertEquals(4, gameService.getDeck(GameSpot.REGULAR_4).getSize());
		assertEquals(5, gameService.getDeck(GameSpot.REGULAR_5).getSize());
		assertEquals(6, gameService.getDeck(GameSpot.REGULAR_6).getSize());
		assertEquals(7, gameService.getDeck(GameSpot.REGULAR_7).getSize());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_1).getTopCard().isFaceUp());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_2).getTopCard().isFaceUp());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_3).getTopCard().isFaceUp());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_4).getTopCard().isFaceUp());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_5).getTopCard().isFaceUp());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_6).getTopCard().isFaceUp());
		assertTrue(gameService.getDeck(GameSpot.REGULAR_7).getTopCard().isFaceUp());
		assertFalse(gameService.getDeck(GameSpot.REGULAR_4).getCards().get(2).isFaceUp());
	}
	
	@Test
	public void mapCreationAndGetDeckTest(){
		creatGameMap();
		Deck deck = gameBoard.get(GameSpot.REGULAR_2);
		assertNotNull(deck);
	}
	
	@Test
	public void newFullDeckTest(){
		Deck deck = gameService.newFullDeck();
		assertEquals(52,deck.getSize());
	}
	
	private void creatGameMap() {
		gameBoard = new HashMap<GameSpot, Deck>();
		for(GameSpot gameSpot : GameSpot.values()){
			gameBoard.put(gameSpot, new Deck());
		}		
	}
}
