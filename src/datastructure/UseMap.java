package datastructure;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		List<String> list1 = new ArrayList<String>();
		list1.add("11");
		list1.add("12");
		list1.add("13");

		List<String> list2 = new ArrayList<String>();
		list2.add("21");
		list2.add("22");
		list2.add("23");




		Map<String, List<String>> list = new HashMap<String, List<String>>();
		list.put("List1", list1);
		list.put("List2", list2);


		Iterator it = list.entrySet().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		for (Map.Entry<String, List<String>> listval : list.entrySet()) {
			System.out.println("Lists :" + listval.getKey() + "--->" + listval.getValue());


		}
	}
}
