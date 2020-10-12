package myLinkedList;

public class MyLinkedListImpl<T> implements MyLinkedList<T>, Cloneable {

    private int size = 0;
    private LinListElem<T> firstElement;
    private LinListElem<T> lastElement;

    @Override
    public int getSize() {
        return this.size;
    }

    public void setFirstElement(LinListElem<T> firstElement) {
        this.firstElement = firstElement;
    }

    public void setLastElement(LinListElem<T> lastElement) {
        this.lastElement = lastElement;
    }

    public LinListElem<T> getFirstElement() {
        return firstElement;
    }

    public LinListElem<T> getLastElement() {
        return lastElement;
    }

    @Override
    public MyLinkedList<T> reverse() throws Exception {
        MyLinkedList<T> resLinkedList = (MyLinkedList<T>) this.clone();

        LinListElem<T> temp = resLinkedList.getFirstElement();
//        resLinkedList.setFirstElement(resLinkedList.getLastElement());
//        resLinkedList.setLastElement(temp);
        LinListElem<T> element = resLinkedList.getFirstElement().getAfter();
        LinListElem<T> elementBefore = resLinkedList.getFirstElement();
        for (int i = 1; i <= resLinkedList.getSize(); i++) {
            if (elementBefore.getAfter() != null) temp = elementBefore.getAfter();
            if (elementBefore.getBefore() != null) elementBefore.setAfter(elementBefore.getBefore());
            if (temp != null) elementBefore.setBefore(temp);
            elementBefore = element;
            element = element.getAfter();
        }

        return resLinkedList;
    }

    @Override
    public boolean add(T t) {
        try {
            this.lastElement = new LinListElem<T>(t, lastElement); //добавляем новый элемент и назначаем его последним
            if (getSize() == 0)
                this.firstElement = this.lastElement; // если список пуст - назначаем его первым элементом
            else lastElement.getBefore().setAfter(lastElement); // связываем с предком
            this.size += 1; //увеличиваем размер списка
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delElemByIndex(int index) {

        try {
            LinListElem<T> element = findElemByIndex(index); //получаем элемент по индексу
            LinListElem<T> elementBefore = element.getBefore();//получаем его предка
            LinListElem<T> elementAfter = element.getAfter();//получаем его потомка
            elementBefore.setAfter(elementAfter);//передаем предку нового потомка(исключаем элемент из списка)
            elementAfter.setBefore(elementBefore);//передаем потомку нового предка(исключаем элемент из списка)
            this.size -= 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public LinListElem<T> findElemByIndex(int index) throws Exception {
        if (index > getSize()) throw new Exception("oversize element index");
        LinListElem<T> element;
        if (this.size / 2 > index) element = this.firstElement;
        else {
            element = this.lastElement;
            index = this.size - index;
        }
        for (int i = 1; i <= index; i++)
            element = element.getBefore();
        return element;
    }

    @Override
    public T get(int index) throws Exception {
        return findElemByIndex(index).getElement();
    }
}
