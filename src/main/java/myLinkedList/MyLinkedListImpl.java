package myLinkedList;

import java.io.*;

public class MyLinkedListImpl<T> implements MyLinkedList<T>, Serializable {

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
        MyLinkedList<T> revLinkList = this.clone(this); //клонируем список
        LinListElem<T> temp = null;
        LinListElem<T> e = revLinkList.getFirstElement().getAfter();
        LinListElem<T> eb = revLinkList.getFirstElement();
        for (int i = 1; i <= revLinkList.getSize(); i++) { //меняем местами ссылки на соседей
            if (eb.getAfter() != null)
                temp = eb.getAfter();
            if (eb.getBefore() != null)
                eb.setAfter(eb.getBefore());
            if (temp != null)
                eb.setBefore(temp);
            if (e != null) {
                eb = e;
                if (e.getAfter() != null)
                    e = e.getAfter();
            }
        }
        // меняем местами первый и последний элемент м подчищаем хвосты
        temp = revLinkList.getFirstElement();
        revLinkList.setFirstElement(revLinkList.getLastElement());
        revLinkList.setLastElement(temp);
        revLinkList.getFirstElement().setBefore(null);
        revLinkList.getLastElement().setAfter(null);
        return revLinkList;
    }

    @Override
    public MyLinkedList<T> clone(MyLinkedList<T> myLinkedList) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        //сохраняем состояние
        ous.writeObject(myLinkedList);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        //создаём кота для опытов и инициализируем его состояние Васькиным
       return (MyLinkedList<T>) ois.readObject();
    }

    @Override
    public boolean add(T t) {
        try {
            this.lastElement = new LinListElem<T>(t, lastElement); //добавляем новый элемент и назначаем его последним
            if (getSize() == 0)
                this.firstElement = this.lastElement; // если список пуст - назначаем его первым элементом
            else lastElement.getBefore().setAfter(lastElement); // связываем с предком
            this.size += 1; //увеличиваем размер списка
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delElemByIndex(int index) {
        try {
            LinListElem<T> e = findElemByIndex(index); //получаем элемент по индексу
//            удаление первого или последнего элемента
            if (e.equals(this.firstElement)) {
                this.firstElement = this.firstElement.getAfter();
                this.firstElement.setBefore(null);
            } else if (e.equals(this.lastElement)) {
                this.lastElement = this.lastElement.getAfter();
                this.lastElement.setAfter(null);
            } else {
//          удаление элементов в цепи
                LinListElem<T> eb = e.getBefore();//получаем его предка
                LinListElem<T> ea = e.getAfter();//получаем его потомка
                eb.setAfter(ea);//передаем предку нового потомка(исключаем элемент из списка)
                ea.setBefore(eb);//передаем потомку нового предка(исключаем элемент из списка)
            }
            this.size -= 1;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private LinListElem<T> findElemByIndex(int index) throws Exception {
        if (index > getSize()) throw new Exception("oversize element index");
//      возврат первого или последнего элемента
        if (index == getSize()) return this.lastElement;
        if (index == 1) return this.firstElement;
//      если нет то ищем элемент по цепочке
        LinListElem<T> e;
        if (this.size / 2 > index) e = this.firstElement; // выбераем сторону с которой идти
        else {
            e = this.lastElement;
            index = this.size - index;
        }
        for (int i = 1; i <= index; i++)
            if (e == firstElement) e = e.getAfter();
            else e = e.getBefore();
        return e;
    }

    @Override
    public T get(int index) throws Exception {
        return findElemByIndex(index).getElement();
    }
}
