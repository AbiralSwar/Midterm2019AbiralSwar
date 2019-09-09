package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */

		Queue<String> num=new LinkedList<String>();
		num.add("1");
		num.add("2");
		num.add("3");
		num.add("4");
		num.remove();
		num.peek();
		num.poll();
		for(String nums: num){
			System.out.println(nums);

		}
		Iterator it=num.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}




	}

}
