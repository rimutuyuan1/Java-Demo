package com.forezp.thread.noNameClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exercise {
    public static void main(String[] args) {
        NumClock numClock = new NumClock(1000);
        numClock.start();

        JOptionPane.showMessageDialog(null,"Quit the program?");
        System.exit(0);
    }
}

class NumClock {
    private int sep;
    private int n = 0;
    NumClock(int sep){
        this.sep = sep;
    }

    void start() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(++n);
            }
        };
        Timer timer = new Timer(sep, listener);
        timer.start();
    }

}
