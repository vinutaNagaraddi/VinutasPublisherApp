package main.java.com.vinuta.dto;

import main.java.com.vinuta.entity.ComicBook;

public class ComicBookDTO extends BookDTO{
	
	private static final long serialVersionUID = 1L;
	private ComicBook comicBook;

	public ComicBook getComicBook() {
		return comicBook;
	}

	public void setComicBook(ComicBook comicBook) {
		this.comicBook = comicBook;
	}
	
}
