package com.company;

public class AreaPerimeterVolume {
    public static void main(String[] args) {

        System.out.println("Area - Perimeter - Volume");

    }
    private static void circle(double r){
        double area =  Math.PI*r*r;
        double perimeter = 2*Math.PI*r;
        System.out.println(":: Area - " + area + " | Perimeter - " + perimeter);
    }

    private static void triangle(double base,double height){
        double area = 0.5*base*height;
        System.out.println(":: Area - " + area);
    }

    private static void rectangle(double l, double w){
        double area =  l*w;
        double perimeter = 2*(l+w);
        System.out.println(":: Area - " + area + " | Perimeter - " + perimeter);
    }

    private static void isoscelesTriangle(double b, double h){
        double area =  0.5*b*h;
        System.out.println(":: Area - " + area );
    }

    private static void parallelogram(double base, double height, double side){
        double area =  base*height;
        double perimeter = 2*(base+side);
        System.out.println(":: Area - " + area + " | Perimeter - " + perimeter);
    }

    private static void rhombus(double d1, double d2,double side){
        double area =  d1*d2/2;
        double perimeter = side*4;
        System.out.println(":: Area - " + area + " | Perimeter - " + perimeter);
    }

    private static void equilateralTriangle(double side){
        double area =  (Math.sqrt(3)/4)*side*side;
        double perimeter = 3*side;
        System.out.println(":: Area - " + area + " | Perimeter - " + perimeter);
    }

    private static void square(double side){
        double area =  side*side;
        double perimeter = 4*side;
        System.out.println(":: Area - " + area + " | Perimeter - " + perimeter);
    }
}
