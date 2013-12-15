package com.stevesmith.solitaire.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards = new ArrayList<Card>();

	public Deck addCard(Card card) {
		cards.add(card);
		return this;		
	}
	
	public Deck shuffle(Deck deck){
		Collections.shuffle(deck.getCards());
		return deck;
	}

	public List<Card> getCards(){
		return cards;
	}

	public Card drawCard() {
		Card card = getTopCard();
		cards.remove(card);
		return card;
	}
	
	public int getSize(){
		return cards.size();
	}

	public void removeCard(Card card) {
		cards.remove(card);
		
	}

	public Card getTopCard() {
		Card card = cards.get(getSize() - 1);
		cards.remove(card);
		return card;
	}
	
	public Card showTopCard(){
		Card card = cards.get(getSize() - 1);
		Card copyCard = copyCard(card);
		
		return copyCard;
	}
	
	public Card copyCard(Card card){
		Card cardCopy = new Card(card.getRank(), card.getSuit(), card.isFaceUp());
		return cardCopy;
	}
	
	@Override
	public String toString(){
		String retval = "";
		
		for(Card card : cards){
			if(card.isFaceUp()){
				retval += "{" + card.toString() + "}\n";
			}else{
				retval += "{DWN}\n";
			}
		}
		
		return retval;
	}

	public void removeCards(Deck fromCards) {
		cards.removeAll(fromCards.getCards());
		
	}
}
