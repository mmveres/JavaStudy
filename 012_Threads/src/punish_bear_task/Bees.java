package punish_bear_task;

public class Bees implements Runnable {
	public final int id;
	private static int counter = 1;
	private Forest forest;
	private int row;
	private boolean atHome=true;

	public Bees(Forest forest) {
		id = counter++;
		this.forest = forest;
	}

	public Bees(Forest forest, int row) {
		id = counter++;
		this.forest = forest;
		this.row = row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public void run() {
		atHome=false;
		int cell = 0;
		boolean found = false;
		System.out.println("Bees group " + id + " is searching row " + row);
		while (cell < forest.getForest()[row].length) {
			if (forest.getForest()[row][cell]) {
				found = true;
				break;
			}
			cell++;
		}
		if (found) {
			System.out.println("Bees group " + id + " found and punished bear at [" + row + "," + cell + "]!!!!!!!!!!!!!!");

			forest.serBearFound(true);
		} else {
			System.out.println("Bees group " + id + " found nothing!");
		}
		System.out.println("Bees group " + id + " is returning home...");
		atHome=true;

	}
	
	public boolean isAtHome() {
		return atHome;
	}
	
	public void setAtHome(boolean atHome) {
		this.atHome = atHome;
	}
	

}
