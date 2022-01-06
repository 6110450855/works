package services;

public interface Datasource<T> {
    T readData();
    void writeData(T t);
}
