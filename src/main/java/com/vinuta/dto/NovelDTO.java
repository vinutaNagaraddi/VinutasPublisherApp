package main.java.com.vinuta.dto;

import main.java.com.vinuta.entity.Novel;

public class NovelDTO extends BookDTO {
	private static final long serialVersionUID = 1L;
	private Novel novel;
	
	public Novel getNovel() {
		return novel;
	}
	public void setNovel(Novel novel) {
		this.novel = novel;
	}
}
