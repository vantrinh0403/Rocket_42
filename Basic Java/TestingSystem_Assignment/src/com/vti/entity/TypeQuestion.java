package com.vti.entity;
public class TypeQuestion {
    private long id;
    private Type typeName;
    private Question[] questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getTypeName() {
        return typeName;
    }

    public void setTypeName(Type typeName) {
        this.typeName = typeName;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
