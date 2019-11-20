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
        System.out.println("Filtered: " + list.filter((k -> k % 3 == 0)));
        list.add(3, 55555);
        // TODO: I HAVE TO SORT IT AND FIND THE MEDIAN VALUE HERE, BUT I DIDN'T DO IT CUZ I WANTED TO ASK IF I COULD CONVERT TO A LIST AND BACK TO USE COLLECTIONS.SORT
        String sentence = "Hey dude, how is it going.";
        DoublyLinkedList<String> sentenceList = DoublyLinkedList.fromArray(sentence.replace(",","").replace(".", "").replace("?", "").replace("-", "").replace(";", "").replace("!", "").replace(":", "").split(" "));
        System.out.println("Sentence List: " + sentenceList);
        sentenceList.filter(s -> s.length() > 3);
        System.out.println("Filtered Sentence List: " + sentenceList);
        // TODO: I HAVE TO SORT IT, BUT I DIDN'T DO IT CUZ I WANTED TO ASK IF I COULD CONVERT TO A LIST AND BACK TO USE COLLECTIONS.SORT
        // TODO: ASK IF I CAN USE THIS ITERATOR STUFF
        double sumLengths = 0;
        // sentenceList.forEachValue(s -> sum2 += s.length());
        for(String s: sentenceList) sumLengths += s.length();
        System.out.println("Average Word Length: " + (sumLengths / sentenceList.size()));
        // System.out.println("Average Word Length: " + (sum2 / sentenceList.size()));

    }
}