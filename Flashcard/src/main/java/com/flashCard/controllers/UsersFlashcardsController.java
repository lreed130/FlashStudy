
	package com.flashCard.controllers;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

	import com.flashCard.model.FlashCardSet;
	import com.flashCard.service.FlashcardService;

	public class UsersFlashcardsController {

		@Autowired
		FlashcardService flashcardService;

		@RequestMapping(value = "/userFlashcards", method = RequestMethod.GET)
		public ModelAndView getUserFlashcards(HttpServletRequest request, HttpServletResponse response) {
			
			String user = (String) request.getAttribute("user");
			//call to database to grab flashcards.
			ModelAndView mav = null;
			if(user != null) {
				mav = new ModelAndView("create");
				mav.addObject("flashCardSet", new FlashCardSet());
			}else {
				mav = new ModelAndView("login");
			}
			return mav;
		}

		@RequestMapping(value = "/getOneFlashcardSet", method = RequestMethod.POST)
		public ModelAndView getOneFlashcardSet(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav = null;

			return mav;
		}
		
		
	}
