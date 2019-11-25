public class Runner {

    public static double sum2;

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for(int i = 0; i < 30; i++)
            list.add((int)(Math.random() * 1000) + 1);
        System.out.println("List: " + list);
        System.out.println("Reversed List: " + list.toReversedString());
        System.out.println("Size: " + list.size());
        int sum = 0;
        int oddSum = 0;
        int evenSum = 0;
        // for(Integer i: list) sum += i;
        DoublyLinkedList<Integer> temp = list.copy();
        temp = list.copy();
        int i = 0;
        while(!list.isEmpty()) {
            int add = list.poll();
            sum += add;
            if(i % 2 == 0) evenSum += add;
            else oddSum += add;
            if(add % 2 == 0) temp.add(add);
            i++;
        }
        list = temp;
        System.out.println("Sum: " + sum);
        System.out.println("Even Sum: " + evenSum);
        System.out.println("Odd Sum: " + oddSum);
        System.out.println("Duplicated Evens: " + list);
        // list = DoublyLinkedList.fromArray(4, 8, 3, 9, 12, 100, 99);
        System.out.println("Filtered: " + list.filter((k -> k % 3 != 0)));
        list.add(3, 55555);

        System.out.println("Sorted: " + MyCollections.sort(list));
        double median = 0;
        if(list.size() % 2 == 0)
            median = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        else
            median = list.get(list.size() / 2);
        System.out.println("The median of the list is " + median);
        System.out.println("The values that come before it are: " + list.copy().splice(0, list.size() / 2));
        System.out.println("The values that come after it are: " + list.copy().splice(list.size() / 2 + (list.size() % 2 == 0? 0: 1)));

        String sentence = "Hello dude, how is it going. I'm Zach with a lowercase Z.";
        DoublyLinkedList<String> sentenceList = DoublyLinkedList.fromArray(sentence.replace(",","").replace(".", "").replace("?", "").replace("-", "").replace(";", "").replace("!", "").replace(":", "").split(" "));
        System.out.println("Sentence List: " + sentenceList);
        sentenceList.filter(s -> s.length() > 3);
        System.out.println("Filtered Sentence List: " + sentenceList);

        double sumLengths = 0;
        // sentenceList.forEachValue(s -> sum2 += s.length());
        for(String s: sentenceList) sumLengths += s.length();
        // System.out.println("Average Word Length: " + (sum2 / sentenceList.size()));
        System.out.println("Average Word Length: " + (sumLengths / sentenceList.size()));

        DoublyLinkedList<String> sentenceListLowerCase = sentenceList.map(str -> str.toLowerCase());
        MyCollections.sort(sentenceListLowerCase, sentenceList);
        System.out.println("Sorted: " + sentenceList);

    }
}