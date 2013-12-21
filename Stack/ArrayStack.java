public class ArrayStack<E> extends AbstractStack<E> implements Stack<E> {
	private E[] elements;
	public static final int AAA_BBB;	// Это константа!

	// Метод инициализации класса (имя должно совпадать с именем класса)
	public ArrayStack(int capacity) {
		elements = (E[]) new Object[capacity];
	}

	// Такой код выполняется до конструктора (инициализации)
	static {
		if (Math.random() > 0.5) {
			AAA_BBB = 1;
		} else {
			AAA_BBB = 10;
		}
	}

	// Удостовериться в возможности увеличения массива
	public void ensureCapacity(int capacity) {
		if (elements.length >= capacity) {
			return;
		}
		E[] newElements = (E[]) new Object[capacity * 2];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	// Реализует метод интерфеса Stack
	public void push(E value) {
		ensureCapacity(size + 1);
		elements[size] = value;
		size++;
	}

	// Реализует метод из класса AbstractStack
	protected E popS() {
		return elements[size];
	}

	// Реализует метод интерфеса Stack
	public E peek() {
		if (size == 0) {
			return null;
		}
		return elements[size - 1];
	}
}