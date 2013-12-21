/**
 *	Этот класс расширяет (наследуется от) AbstractStack,
 *	описывая его метод popS() и метод peek() из интерфейса Stack.
 *
 *	LinkedStack - это стэк на основе "родительской" связи.
 */
public class LinkedStack<E> extends AbstractStack<E> {
	private Node<E> head;

	// Реализует метод интерфейса Stack
	public void push(final E element) {
		head = new Node<E>(head, element);
		size++;
	}

	// Реализует метод из класса AbstractStack
	protected E popS() {
		final E value = head.value;
		head = head.next;
		return value;
	}

	// Реализует метод интерфеса Stack
	public E peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}

	private static class Node<E> {
		private final E value;
		private final Node<E> next;

		public Node(Node<E> next, E value) {
			this.next = next;
			this.value = value;
		}
	}
}