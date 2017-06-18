package Game;

import java.awt.Polygon;

//extending polygon class as im drawing polygons

class Rock extends Polygon {

	// upper left hand corner of the polygon
	int uLeftXPos, uLeftYPos;

	// used to change direction of asteroid when it hits something
	int xDirection = 1;
	int yDirection = 1;

	// Get board width and heigh
	int width = Lesson50.boardWidth;
	int height = Lesson50.boardHeight;

	// wil hold the X & Y coordinates for polygons
	int[] polyXArray, polyXarray;

	// starting points for asteroids
	public static int[] sPolyXArray = { 10, 17, 26, 34, 27, 36, 26, 14, 8, 1, 5, 1, 10 };
	public static int[] sPolyYArray = { 0, 5, 1, 8, 13, 20, 31, 28, 31, 22, 16, 7, 0 };

	// constructor for rock
	public Rock(int[] polyXArray, int[] polyYArray, int pointsInPoly, int randomStartXPosition,
			int randomStartYPosition) {

		// creates a polygon calling super/parent class of rock
		super(polyXArray, polyYArray, pointsInPoly);

		// let asteroids move in random speeds
		this.xDirection = (int) (Math.random() * 4 + 1);
		this.yDirection = (int) (Math.random() * 4 + 1);

		// so polygons start in different parts of screen
		this.uLeftXPos = randomStartXPosition;
		this.uLeftYPos = randomStartYPosition;

	}

	public void move() {

		// get the upper left and top most point for the polygon
		// this will be dynamic later on
		int uLeftXPos = super.xpoints[0];
		int uLeftYPos = super.ypoints[0];

		// check if rock is going to hit wall if so change dir
		if (uLeftXPos < 0 || (uLeftXPos + 25) > width)
			xDirection = -xDirection;
		if (uLeftYPos < 0 || (uLeftYPos + 50) > height)
			yDirection = -xDirection;

		// change points based off new dir
		for (int i = 0; i < super.xpoints.length; i++) {
			super.xpoints[i] += xDirection;
			super.ypoints[i] += yDirection;
		}

	}

	// method for creating polygon x point arrays
	public static int[] getPolyXArray(int randomStartXPos) {

		// clones the array so that the original shape isnt changed for the
		// asteroid
		int[] tempPolyXArray = (int[]) sPolyXArray.clone();

		for (int i = 0; i < tempPolyXArray.length; i++) {
			tempPolyXArray[i] += randomStartXPos;
		}
		return tempPolyXArray;
	}

	// method for creating polygon y point arrays
	public static int[] getPolyYArray(int randomStartYPos) {

		// clones the array so that the original shape isnt changed for the
		// asteroid

		int[] tempPolyYArray = (int[]) sPolyYArray.clone();

		for (int i = 0; i < tempPolyYArray.length; i++) {
			tempPolyYArray[i] += randomStartYPos;
		}
		return tempPolyYArray;
	}
}