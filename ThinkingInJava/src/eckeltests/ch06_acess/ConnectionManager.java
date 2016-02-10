/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch06_acess;

import java.util.Arrays;
import static net.mindview.util.Print.print;

/**
 *
 * @author DmTemp
 */
class Connection {

    public static final int MAX_CONN_NUM = 10;
    private static int totalConnsNumber;
    private int currConnNumber;

    private Connection() {
        currConnNumber=totalConnsNumber;
    }

    public static Connection getConnection() {
        if (totalConnsNumber < MAX_CONN_NUM) {
            totalConnsNumber++;
            return new Connection();
        } else {
            return null;
        }
    }

    public static int getTotalConnsNumber() {
        return totalConnsNumber;
    }

    public String toString() {
        return "Connection (#" + currConnNumber + ")";
    }

}

public class ConnectionManager {

   private Connection[] connections;

    public Connection[] getConnections() {
        return connections;
    }
    
    public void generateConnections(int numberOf){
        connections = new Connection[numberOf];
        for (int i = 0; i < connections.length; i++) {
            connections[i]=Connection.getConnection();
            
        }
    }
    
    public static void main(String[] args) {
        ConnectionManager connectionManager=new ConnectionManager();
        connectionManager.generateConnections(11);
        print(Arrays.toString(connectionManager.getConnections()));
    }
}
