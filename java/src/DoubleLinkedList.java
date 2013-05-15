public class DoubleLinkedList {

	int[] next;
	int[] prev;

	public DoubleLinkedList(int maxSize) {
		next = new int[maxSize + 1];
		prev = new int[maxSize + 1];
	}

	public void insert(int x, int pos) {
		prev[x] = pos;
		next[x] = next[pos];
		prev[next[x]] = x;
		next[prev[x]] = x;
	}

	public void remove(int x) {
		next[prev[x]] = next[x];
		prev[next[x]] = prev[x];
	}

	// Usage example
	public static void main(String[] args) {
		int n = 10;
		DoubleLinkedList list = new DoubleLinkedList(n);
		for (int i = 1; i <= n; i++) {
			list.insert(i, 0);
		}
		list.remove(1);
		list.remove(10);
		list.remove(5);
		for (int i = list.next[0]; i != 0; i = list.next[i]) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}