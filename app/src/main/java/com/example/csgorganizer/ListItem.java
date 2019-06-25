package com.example.csgorganizer;

public class ListItem {
    int id;
    String maps, date, comment, opponent;

    public ListItem(int id, String maps, String date, String comment, String opponent) {
        this.id = id;
        this.maps = maps;
        this.date = date;
        this.comment = comment;
        this.opponent = opponent;
    }

    public ListItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

}
