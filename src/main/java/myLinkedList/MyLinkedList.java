package myLinkedList;

public interface MyLinkedList<T> {

    int getSize();

    MyLinkedList<T> reverse() throws Exception;

    boolean add(T t);

    boolean delElemByIndex(int index);

    LinListElem<T> findElemByIndex(int index) throws Exception;

    T get(int index) throws Exception;

    public LinListElem<T> getFirstElement();

    public LinListElem<T> getLastElement();

    public void setLastElement(LinListElem<T> lastElement);

    public void setFirstElement(LinListElem<T> lastElement);
}
