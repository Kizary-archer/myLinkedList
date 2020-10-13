package myLinkedList;

import java.io.IOException;

public interface MyLinkedList<T> {

    int getSize();

    MyLinkedList<T> reverse() throws Exception;

    MyLinkedList<T> clone(MyLinkedList<T> myLinkedList) throws IOException, ClassNotFoundException;



    boolean add(T t);

    boolean delElemByIndex(int index);

    T get(int index) throws Exception;

    LinListElem<T> getFirstElement();

    LinListElem<T> getLastElement();

    void setLastElement(LinListElem<T> lastElement);

    void setFirstElement(LinListElem<T> lastElement);
}
