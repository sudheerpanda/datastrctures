package com.imaginea.problems;

public class Main extends MainExtras {

    @Handleable
    private  String stuff;

    public static void main(String[] args) {
        new Main().handleStuff("hello");
    }
}
