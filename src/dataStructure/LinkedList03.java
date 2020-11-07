package dataStructure;

import dataStructure.LinkedList03.LinkedList.Node;
import dataStructure.LinkedList03.LinkedList.Reference;

/*
단방향 LinkedList의 끝에서
K번재 노드를 찾는
알고리즘을 구현하기
*/


public class LinkedList03 {
	static class LinkedList{
		Node header;
		
		static class Node{
			int data;
			Node next = null;
		}
		
		public LinkedList() {
			header = new Node();
		}
		
		void append(int d) {
			Node end = new Node();
			end.data = d;
			Node n = header;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		void delete(int d) {
			Node n = header;
			while(n.next != null) {
				if(n.next.data == d) {
					n.next = n.next.next;
				}else {
					n = n.next;
				}
			}
		}
		
		void retrieve() {
			Node n = header.next;
			while(n.next != null) {
				System.out.print(n.data + " -> ");
				n = n.next;
			}
			System.out.println(n.data);
		}
		
		Node KthToLast(Node first, int k) {
			Node n = first;
			int total = 1;
			while(n.next != null) {
				total++;
				n = n.next;
			}
			n = first;
			for(int i = 1; i < total - k + 1; i++) {
				n = n.next;
			}
			return n;
		}
		
		Integer KthToLast2(Node n, int k) {
			if(n == null) {
				return 0;
			}
			
			int count = KthToLast2(n.next, k) + 1;
			if(count == k) {
				System.out.println(k + "   "+ n.data);
			}
			return count;
		}
		
		static class Reference{
			int count = 0;
		}
		Node KthToLast3(Node n, int k, Reference r) {
			if(n == null) {
				return null;
			}
			
			Node found = KthToLast3(n.next, k, r);
			r.count++;
			if(r.count == k) {
				return n;
			}
			return found;
		}
		
		Node KthToLast4(Node first, int k) {
			Node p1 = first;
			Node p2 = first;
			for(int i = 0 ; i < k ; i++) {
				if(p1 == null) return null;
				p1 = p1.next;
			}
			while(p1 != null) {
				p1 = p1.next;
				p2 = p2.next;
			}
			return p2;
			
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		ll.append(6);
		ll.append(7);
		ll.append(8);
		ll.retrieve();
		Node first = ll.header;
		int k = 1;
		Node kth = ll.KthToLast(first, k);
		System.out.println(k + "    " + kth.data);
		System.out.println("==========================");
		ll.KthToLast2(first, k);
		System.out.println("==========================");
		Reference r = new Reference();
		Node found = ll.KthToLast3(first, k, r);
		System.out.println(k + "    " + found.data);
		System.out.println("==========================");
		Node found2 = ll.KthToLast4(first, k);
		System.out.println(k + "    " + found2.data);
	}
}
