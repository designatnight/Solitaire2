package com.stevesmith.solitaire.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;


public class GameService {

	private static final String FACE_DOWN = "DWN";
	private static final int CELL_LENGTH = 8;
	
	private final Map<GameSpot, Deck> gameBoard;
	private final RuleService ruleService;

	public GameService(RuleService ruleService, Map<GameSpot, Deck> gameBoard){
		
		this.gameBoard = gameBoard;
		this.ruleService = ruleService;
		
	}
	
	public void newGame(){
		Deck deck = newFullDeck();
		dealGame(deck);
		gameBoard.put(GameSpot.DRAW, deck);
	
	}

	private void creatGameMap() {
		for(GameSpot gameSpot : GameSpot.values()){
			gameBoard.put(gameSpot, new Deck());
		}
	}
	
	public void drawCard(){
		Deck drawDeck = gameBoard.get(GameSpot.DRAW);
		Deck discardDeck = gameBoard.get(GameSpot.DISCARD);
		try{
			Card drawCard = drawDeck.getTopCard();
			drawCard.turnFaceUp();
			transferCard(drawCard, discardDeck);
			drawDeck.removeCard(drawCard);
		}catch(ArrayIndexOutOfBoundsException e){
			for(Card card : discardDeck.getCards()){
				card.turnFaceDown();
				drawDeck.getCards().add(0, card);
			}
			discardDeck.getCards().clear();
		}
	}

	private void transferCard(Card fromCard, Deck toDeck) {
		Deck fromDeck = new Deck();
		fromDeck.addCard(fromCard);
		transferCards(fromDeck, toDeck, fromDeck);
		
	}

	public void dealGame(Deck deck) {
		creatGameMap();
		List<GameSpot> gameSpotList = new ArrayList<>();
		for(GameSpot gameSpot : GameSpot.values()){
			gameSpotList.add(gameSpot);
		}
		for(int row = 1; row < 8; row++){
			int columns = row;
			for(; columns < 8; columns++){
				GameSpot gameSpot = gameSpotList.get(columns + 1);
				Card card = deck.drawCard();
				Deck gameSpotDeck = gameBoard.get(gameSpot);
				if(columns == row){
					card.turnFaceUp();
				}gameSpotDeck.addCard(card);
			}
		}
		
	}

	public Deck getDeck(GameSpot gameSpot) {
		Deck deck = gameBoard.get(gameSpot);
		return deck;
	}
	
	public Deck newFullDeck(){
		Deck deck = new Deck();
		for(Suit suit : Suit.values()){
			for(Rank rank : Rank.values()){
				deck.addCard(new Card(rank, suit, false));
			}
		}return deck;
	}
	
	public Map<GameSpot, Deck> getGameMap(){
		return gameBoard;
	}

	public void moveCard(Deck fromDeck, Deck toDeck, int numberOfCardsToMove) {
		Deck fromCards = getFromCards(fromDeck,numberOfCardsToMove);
		Card fromCard =  getFromCard(fromCards, numberOfCardsToMove);
		if(ruleService.spotIsEmpty(toDeck)){
			
		}
		Card toCard = toDeck.getTopCard();
		if(ruleService.isOppositeColor(fromCard, toCard)){
			if(ruleService.isOneBelow(fromCard, toCard)){
				toDeck.addCard(toCard);
				transferCards(fromCards, toDeck, fromDeck);
				
			}
		}else{
			toDeck.addCard(toCard);
			fromDeck.getCards().addAll(fromCards.getCards());
				
		}Card card = fromDeck.getTopCard();
		if(!card.isFaceUp()){
			card.turnFaceUp();
		}fromDeck.addCard(card);
		
	}

	private Card getFromCard(Deck fromCards, int numberOfCardsToMove) {
		return fromCards.getCards().get(0);
	}

	public void transferCards(Deck fromCards, Deck toDeck, Deck fromDeck) {
		toDeck.getCards().addAll(fromCards.getCards());
		fromDeck.getCards().removeAll(fromCards.getCards());
		
		
	}

	public Deck getFromCards(Deck fromDeck, int numberOfCardsToMove) {
		Deck fromCards = new Deck();
		for(int i = 0; i < numberOfCardsToMove; i++){
			Card card = fromDeck.getTopCard();
			fromCards.getCards().add(0, card);
		}
		return fromCards;
	}
	
	@Override
	public String toString(){
		
		StringBuffer header = new StringBuffer();
		StringBuffer table = new StringBuffer();
		
		GameSpot[] gameSpots = GameSpot.values();
		
		for(int y = 0; y < 20; y++){
			for(int i = 0; i < GameSpot.values().length ; i++){
				List<Card> cards = getDeck(gameSpots[i]).getCards();
				
				Card card = null;
				
				if(y >= cards.size()){
					card = null;
				}else{
					card = cards.get(y);
				}
				
				if(card == null){
					table.append(format(""));
					continue;
				}
				
				if(card.isFaceUp()){
					table.append(format(card.toString()));
				}else{
					table.append(format(FACE_DOWN));
				}
			}
			
			table.append("\n");
		}
		
		for(GameSpot gameSpot : gameSpots){
			header.append(createHeaderTtitle(gameSpot));
		}
		
		header.append("\n");
		header.append(table);
		
		return header.toString();
	}
	
	private String createHeaderTtitle(GameSpot gameSpot){
		
		String headerType[] = gameSpot.name().split("_"); 
		String displayName = null;
		
		if(headerType.length == 2){
			displayName = headerType[0].substring(0, 1) + " " + headerType[1].substring(0, 1);
		}else{
			displayName = headerType[0].substring(0, 3);
		}
		
		return format(displayName);
		
	}
	
	private String format(String str){
		return StringUtils.leftPad(str, CELL_LENGTH);
	}
}