package com.games.wordsearchgame;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController("/")
public class WordSearchController {
	
	@Autowired
	WordSearchService wordSearchService;
	
	@GetMapping("/wordgrid")
	@CrossOrigin(origins = "http://localhost:1234")
	public String buildGrid(@RequestParam int gridSize, @RequestParam String stringOfWords) {
	 List<String> words = Arrays.asList(stringOfWords.split(","));
	 //words.forEach(System.out::println);
	 char[][] grid_array= wordSearchService.generateGrid(words, gridSize);
	 String gridToString = "";
	 for(int i=0; i < grid_array.length; i++) {
			for(int j=0; j < grid_array.length; j++) {
				gridToString += grid_array[i][j]+" ";
			
			}
			gridToString += "\r\n";
			
	 }	
		return gridToString;
	}
}
