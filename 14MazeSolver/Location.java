public class Location {
    private int x, y, distance, distanceSoFar;
    private Location previous;
    
    public Location(int _x, int _y, Location prev, int _distance) {
	x = _x;
	y = _y;
	previous = prev;
	distance = _distance;
	if (previous == null) {
	    distanceSoFar = 0;
	} else {
	    distanceSoFar = previous.getSoFar();
	}
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public Location getPrev() {
	return previous;
    }

    public int getSoFar() {
	return soFar;
    }

    public int getDistance() {
	return distance;
    }
    
    public boolean equals(Location l) {
        return x == l.getX() && y == l.getY();
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
