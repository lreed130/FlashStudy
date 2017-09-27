package com.flashCard.model;

import java.util.List;

public class FlashCardSet {
	
	private List<FlashCard> flashcards;
	//List of all flashcards in one set
	//Not sure if this will work, testing is a must!

	public FlashCardSet() {
		
	}
	
	public FlashCardSet(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}
	
	public List<FlashCard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}
	
	
}
