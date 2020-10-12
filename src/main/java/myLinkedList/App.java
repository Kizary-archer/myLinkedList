package myLinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        MyLinkedList<String> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add("11111");
        myLinkedList.add("22222");
        myLinkedList.add("33333");
        myLinkedList.add("44444");

        try {
            MyLinkedList<String> rev = myLinkedList.reverse();
            // myLinkedList.delElemByIndex(2);
            System.out.println(myLinkedList.get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
