import java.util.ArrayList;
import java.util.List;

public class Pilha<T> { //Podia ter usado o stack do java, porem queria lembrar como funcionava pilha
	
	private List<T> items = new ArrayList<>();
	
	public void push(T item) {
		items.add(item);
	}
	
	public void pop() {
		items.remove(items.size() -1);
	}
	
	public T peek() {
		return items.get(items.size()-1);
	}
	
	public int size() {
		return items.size();
	}
}
