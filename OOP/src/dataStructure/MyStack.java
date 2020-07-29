package dataStructure;

import java.util.ArrayList;

import javax.naming.directory.NoSuchAttributeException;

public class MyStack {
	ArrayList arr = new ArrayList();

	// add something to the stack
	public void push(char element) {
		arr.add(element);
	}

	// remove thing in the stack
	public Object pop() throws Exception {
		if (arr != null) {
			return (arr.remove(arr.size() - 1));
		} else {
			throw new Exception("Stack is empty");
		}
	}

	public void demonstrate(String s, MyStack stack) throws Exception {
		for (int i = 0; i < s.length(); i++) {
			char element = s.charAt(i);
			if (element == '(' || element == '{' || element == '[') {
				stack.push(element);
			} else if (element == ')') { 
				if (stack.arr.size() == 0) {
					System.out.println("Stack is empty.");
					break;
				}
				if ((char)stack.pop() != '(') {
					System.out.println("Stack is unbalance.");
					break;
				}
			} else if (element == ']') {
				if (stack.arr.size() == 0) {
					System.out.println("Stack is empty.");
					break;
				}
				if ((char)stack.pop() != '[') {
					System.out.println("Stack is unbalance.");
					break;
				}
			} else if (element == '}') {
				if (stack.arr.size() == 0) {
					System.out.println("Stack is empty.");
					break;
				}
				if ((char)stack.pop() != '{') {
					System.out.println("Stack is unbalance.");
					break;
				}
			}else {
				throw new NoSuchAttributeException("This element "+element+" should NOT be in your String");
			}
		}
		if (stack.arr.size() == 0) {
			System.out.println("Stack is balanced");
		}

	}

	public static void main(String[] args) throws Exception {
		MyStack stack = new MyStack();
		String s = "[({}{})]"; // Balanced input
//		 String s = "[({{})]"; // Unbalanced input
//		 String s = "[({};{})]"; // Invalid input
		stack.demonstrate(s, stack);
		//stack.push('[');
		//System.out.println("result= "+ stack.pop());
	}

}
