package myLinkedList;

public class LinListElem<T> implements Cloneable{
   private T element = null;
   private LinListElem<T> before = null;
   private LinListElem<T> after = null;

    public LinListElem(T element, LinListElem<T> before, LinListElem<T> after) {
        this.element = element;
        this.before = before;
        this.after = after;
    }
    public LinListElem(T element, LinListElem<T> before){
        this.element = element;
        this.before = before;
    }
    public LinListElem<T> getAfter() {
        return this.after;
    }

    public LinListElem<T> getBefore() {
        return this.before;
    }

    public T getElement() {
        return this.element;
    }

    public void setAfter(LinListElem<T> after) {
        this.after = after;
    }

    public void setBefore(LinListElem<T> before) {
        this.before = before;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

