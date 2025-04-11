package org.example.freespace.javastudy.abstractstudy;

public abstract class Unit {
    // 유닛의 현위치
    int x, y;
    // 추상 메서드는 추상클래스가 아니면 사용할 수 없다!!
    abstract void move(int a, int b);
    void stop() {

    }
}
