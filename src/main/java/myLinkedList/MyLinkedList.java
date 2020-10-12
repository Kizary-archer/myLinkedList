package myLinkedList;

public interface MyLinkedList<T> {

    int getSize();

    MyLinkedList<T> reverse() throws Exception;

    void add(T t);

    void delElemByIndex(int index);

    LinListElem<T> findElemByIndex(int index) throws Exception;

    T get(int index) throws Exception;

    LinListElem<T> getFirstElement();

    LinListElem<T> getLastElement();

    void setLastElement(LinListElem<T> lastElement);

    void setFirstElement(LinListElem<T> lastElement);
}
