public class Die {
	private int n;

	public Die(){
		n = 0;
	}

	public int roll() {
		return (int) (Math.random()*6)+1;
	}
}
