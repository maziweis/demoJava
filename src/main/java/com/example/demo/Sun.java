package com.example.demo;

import javax.sound.midi.Soundbank;

public class Sun extends Parent{

    Sun(){
        System.out.println("s constructor");
    }
    static {
        System.out.println("static s");
    }
    {
        System.out.println("s kong");
    }
}
