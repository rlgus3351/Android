package com.example.dbtest0707;

public class MusicDTO {
    private int mp_idx;
    private String mp_name;
    private String mp_answer;

    public MusicDTO(){

    }
    public MusicDTO(int mp_idx, String mp_name, String mp_answer) {
        this.mp_idx = mp_idx;
        this.mp_name = mp_name;
        this.mp_answer = mp_answer;
    }

    public int getMp_idx() {
        return mp_idx;
    }

    public void setMp_idx(int mp_idx) {
        this.mp_idx = mp_idx;
    }

    public String getMp_name() {
        return mp_name;
    }

    public void setMp_name(String mp_name) {
        this.mp_name = mp_name;
    }

    public String getMp_answer() {
        return mp_answer;
    }

    public void setMp_answer(String mp_answer) {
        this.mp_answer = mp_answer;
    }
}


