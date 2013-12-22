//package xyberty.stacks;

/**
 *	Этот класс реализует методы интерфейса (абстрактного класса) Stack,
 *	позволяя при этом классам, которые будут его расширять (наследоваться от него)
 *	реализовывать другие методы интерфейса (например, push() и peek()).
 *
 *	Для возможности использования параметра типа, определённого в интерфейсе,
 *	в реализующем интерфейс классе необходимо тоже определить этот параметр типа.
 */
public abstract class AbstractStack<E> implements Stack<E> {
	protected int size;

	public final boolean isEmpty() {
		return size == 0;
	}

	public final int size() {
		return size;
	}

	// Это публичный метод, который может спокойно вызываться для экземпляров класса...
	public E pop() {
		if (size == 0) {
			return null;
		}
		size++;
		return popS();
	}

	// ...а этот метод как раз должен быть реализован в наследующих AbstractStack классах!
	protected abstract E popS();
}