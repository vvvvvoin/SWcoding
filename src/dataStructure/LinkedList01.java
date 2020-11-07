package dataStructure;

//https://www.youtube.com/watch?v=C1SDkdPvQPA
//첫번째 노드를 삭제할 수 없는 문제점이 있음

public class LinkedList01 {
	private static class Node{
		int data;
		Node next = null;
		
		Node(int d){
			this.data = d;
		}
		
		void append(int d) {
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		void delete(int d) {
			Node n = this;
			while(n.next != null) {
				if(n.next.data == d) {
					n.next = n.next.next;
				}else {
					n = n.next;
				}
			}
		}
		
		void retrieve() {
			Node n = this;
			while(n.next != null) {
				System.out.print(n.data + " -> ");
				n = n.next;
			}
			System.out.println(n.data);
		}
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(2);
		head.delete(3);
		head.retrieve();
	}
}
