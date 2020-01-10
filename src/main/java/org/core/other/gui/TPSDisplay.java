package org.core.other.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TPSDisplay extends JPanel {

    private List<Double> tps = new ArrayList<>();
    private int maxSize = 20;

    public int getMaxSize(){
        return this.maxSize;
    }

    public TPSDisplay setMaxSize(int size){
        this.maxSize = size;
        return this;
    }

    public TPSDisplay register(double tps){
        if(this.tps.size() >= this.maxSize){
            this.tps.remove(0);
        }
        this.tps.add(tps);
        return this;
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        Dimension dim = this.getSize();
        if(this.tps.isEmpty()){
            return;
        }
        int width = dim.width / this.tps.size();
        int height = dim.height / 20;
        int lowY = 0;
        int previousX = 0;
        double previousHighY = 20;
        for(int A = 0; A < this.tps.size(); A++){
            int x = width * A;
            double highY = height * this.tps.get(A);
            graphics.drawLine(x, dim.height - lowY, x, (int)(dim.height - highY));
            graphics.drawLine(previousX, (int)(dim.height - previousHighY), x, (int)(dim.height - highY));
            graphics.drawString(this.tps.get(A) + "", x, (((int)(dim.height - highY)) - 20));
            previousHighY = highY;
            previousX = x;
        }
    }
}
