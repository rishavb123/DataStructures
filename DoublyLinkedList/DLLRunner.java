public class DLLRunner
{
	public DLLRunner()
	{
		//This is to test your code. If it works, you should get my answers!

		DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
		list.add(10);
		list.add(0,5);
		list.add(list.size()-1,8);
		list.add(1,12);
		list.add(20);
		list.add(25);
		list.add(4,100);
		list.add(0,0);
		list.add(list.size()-1,1000);	//Should put 1000 in front of 25 (which had been the end)
		list.add(list.size(),555);	//should make 555 the last number in the list (the end)
		System.out.println("Size: "+list.size());

		System.out.println("List: "+list);
		System.out.println("List reversed: "+list.toReversedString());

		System.out.println("\nValues at Front and End");
			System.out.println("\tFront: "+list.getRoot().getValue());
			System.out.println("\tEnd: "+list.getEnd().getValue());

		list.remove(2);
		list.remove(3);
		list.remove(0);
		list.remove(list.size()-1);

		System.out.println("\nRemove values at indexes 2, 3, 0, and then size()-1 respectively.");
			System.out.println("\tList: "+list);
			System.out.println("\tList reversed: "+list.toReversedString());


		System.out.println("\nContains Test:");
		System.out.println("\tContains 4: "+list.contains(4));
		System.out.println("\tContains 20: "+list.contains(20));

		System.out.println("\nHere is the list, one value at a time: ");
		DoublyLinkedList<Integer> tempList=new DoublyLinkedList<Integer>();
		while(!list.isEmpty())
		{
			int val=list.getRoot().getValue();
			tempList.add(val);
			list.getNext();
			System.out.print(val+" ");
		}
		list=tempList;

		System.out.println();
		list.clear();
		System.out.println("\nClear List!");
			System.out.println("\tList: "+list);
			System.out.println("\tList reversed: "+list.toReversedString());
		DoublyLinkedList<String> stringList=new DoublyLinkedList<String>();
		stringList.add("St1");
		stringList.add("St2");
        stringList.add("St3");
		System.out.println("String List: "+stringList);
        System.out.println("Reversed String List: "+stringList.toReversedString());
        
        stringList = DoublyLinkedList.fromArray("St1", "St2", "St3", "St4", "St5");
        DoublyLinkedList<String> stringList2 = stringList.copy();
        System.out.println("\nFrom Array: ");
		System.out.println("String List: "+stringList);
        System.out.println("Reversed String List: "+stringList.toReversedString());

        stringList.remove("St1");
        System.out.println("\nRemoved St1");
		System.out.println("String List: "+stringList);
		System.out.println("Reversed String List: "+stringList.toReversedString());

        stringList.splice(-1, 2);
        System.out.println("\nSpliced -1 to 2:");
		System.out.println("String List: "+stringList);
        System.out.println("Reversed String List: "+stringList.toReversedString());

        stringList.addAll(stringList2);
        System.out.println("\nAdded back original to end");
		System.out.println("String List: "+stringList);
        System.out.println("Reversed String List: "+stringList.toReversedString());

        stringList.reverse();
        System.out.println("\nReversed the List");
		System.out.println("String List: "+stringList);
        System.out.println("Reversed String List: "+stringList.toReversedString());

        System.out.println("\nIndex of St3: " + stringList.indexOf("St3"));

        DoublyLinkedList<Integer> intList = stringList.map(s -> Integer.parseInt("" + s.charAt(2)));
        System.out.println("\nMapped to Integers: " + intList + "\n\n");
        
        intList.forEachValue(new DoublyLinkedList.Func<Integer>() {

            int sum;

            public void func(Integer num) {
                sum += num;
                System.out.println("Current Sum: " + sum);
            }
        });

	}
	public static void main(String[] args)
	{
		DLLRunner app=new DLLRunner();
	}

}