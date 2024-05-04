package com.example.picaria_ldp;
import java.util.*;
public class UserInput {

    private Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public int lerInt() {
        return input.nextInt();
    }

}
