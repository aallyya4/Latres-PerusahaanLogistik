/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sabri
 */

public class Session {
    private static String username;

    public static void setUsername(String user) {
        username = user;
    }

    public static String getUsername() {
        return username;
    }

    public static void clearSession() {
        username = null;
    }
}
