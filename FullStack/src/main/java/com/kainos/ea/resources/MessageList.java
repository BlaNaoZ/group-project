package com.kainos.ea.resources;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
public class MessageList {
    private List<Message> list;
    @JsonCreator
    public MessageList(@JsonProperty("employees") List<Message> list) {
        setList(list);
    }

    public void setList(List<Message> list) {
        this.list = list;
    }

    public List<Message> getList() {
        return list;
    }
}