package ca.lambton.termProjectc0839829;

public class PageCounter {
	private Integer pageCounter;
	
	public PageCounter() {
		pageCounter = 0;
	}
	
	public void increaseCounter() {
		this.pageCounter++;
	}
	
	public int getCounter() {
		return this.pageCounter;
	}
}
