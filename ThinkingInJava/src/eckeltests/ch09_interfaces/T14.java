/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

/**
 *
 * @author d2e
 */
interface Walkable {

    void walkSlow();

    void walkFast();
}

interface Flyable {

    void flySlow();

    void flyFast();
}

interface Swimable {

    void swimSlow();

    void swimFast();
}

interface Moveable extends Walkable, Swimable, Flyable {

    void speed();
}

class Human{};

class Agent extends Human implements Moveable{

    @Override
    public void speed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void walkSlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void walkFast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swimSlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swimFast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flySlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flyFast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void doMissionFly(Flyable f){};
    void doMissionSwim(Swimable s){};
    void doMissionWalk(Walkable w){};
    void setSpeed(Moveable m){};
};

 class T14 {
    public static void main(String[] args) {
        Agent agent=new Agent();
        agent.doMissionFly(agent);
        agent.setSpeed(agent);
        agent.doMissionSwim(agent);
        agent.doMissionWalk(agent);
    }
}
