// Соглашение об именовании пакетов
//package xyberty.java.stacks;

//package xyberty.stacks;
//import xyberty.stacks.*;

public class StackTest {
	public static void fill(Stack<String> stack) {
		for (int i = 0; i < 5; i++) {
			stack.push("i" + i);
		}
	}

	// Обычный метод
	// public static void dump(Stack stack) {
	// 	System.out.println(stack.size());	
	// 	while (stack.size() != 0) {
	// 		System.out.println(stack.peek() + " " + stack.pop());
	// 	}
	// }
	// Generic-метод
	public static <E> void dump(Stack<E> stack) {
		System.out.println(stack.size());	
		while (stack.size() != 0) {
			System.out.println(stack.peek() + " " + stack.pop());
		}
	}

	public static void main(String[] args) {
		{
			LinkedStack<String> stack = new LinkedStack<String>();
			fill(stack);
			dump(stack);
		}
		{
			ArrayStack<String> stack = new ArrayStack<String>(10);
			fill(stack);
			dump(stack);
		}
	}
}