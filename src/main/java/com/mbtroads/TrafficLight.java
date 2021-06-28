package com.mbtroads;

public class TrafficLight {
    public static enum Color {
        RED, GREEN
    }
    private Color myColor;
    public TrafficLight() {
        myColor = Color.GREEN;
    }
    public Color getCurColor(){
        return this.myColor;
    }
    public void setColor(Color color){
        this.myColor = color;
    }
    public void toggleLight(){
        if(this.myColor == Color.GREEN) {
            this.myColor = Color.RED;
        }
        else {
            this.myColor = Color.GREEN;
        }
    }
    public static void main(final String[] args) {
        final TrafficLight target = new TrafficLight();
        target.setColor(Color.RED);
        System.out.println(target.getCurColor());
    }
}