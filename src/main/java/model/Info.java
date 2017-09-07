package model;

/**
 * Created by zwl on 2017/9/6.
 * May god bless me
 */
public class Info<T> {
    private T t;

     private String whereCondition;

    public String getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(String whereCondition) {
        this.whereCondition = whereCondition;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


}
