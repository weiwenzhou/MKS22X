import java.util.LinkedList;
public class FrontierQueue implements Frontier {
    private LinkedList<Location> locations;

    public FrontierQueue() {
	locations = new LinkedList<Location>();
    }
    
    public Location next() {
	return locations.removeFirst();
    }

    public void add(Location n) {
	locations.addLast(n);
    }

    public boolean hasNext() {
	return locations.size() != 0;
    }

}
