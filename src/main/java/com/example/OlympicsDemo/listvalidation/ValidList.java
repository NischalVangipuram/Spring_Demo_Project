//package com.example.OlympicsDemo.listvalidation;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ValidList<E> implements List<E> {
//
//    @Valid
//    private List<E> list;
//
//    public ValidList() {
//        this.list = new ArrayList<E>();
//    }
//
//    public ValidList(List<E> list) {
//        this.list = list;
//    }
//
//    // Bean-like methods, used by javax.validation but ignored by JSON parsing
//
//    public List<E> getList() {
//        return list;
//    }
//
//    public void setList(List<E> list) {
//        this.list = list;
//    }
//
//    // List-like methods, used by JSON parsing but ignored by javax.validation
//
//    @Override
//    public int size() {
//        return list.size();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return list.isEmpty();
//    }
//
//    // Other list methods ...
//}
