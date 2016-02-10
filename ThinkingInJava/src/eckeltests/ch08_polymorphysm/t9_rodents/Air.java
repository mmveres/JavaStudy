/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch08_polymorphysm.t9_rodents;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class Air {

    private static int totalUsers = 0;
    private static Air air;

    private Air() {
    }

    public static Air getAir() {
        if (air == null) {
            air = new Air();
        }
        totalUsers++;
        print("Providing air, total users: " + totalUsers);
        return air;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public void removeUser() {
        totalUsers--;
    }

    @Override
    protected void finalize() throws Throwable {
        if (totalUsers > 0) {
            print("Air is being used!");
        } else {
            super.finalize();
        }

    }

}
