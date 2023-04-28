
package com.conexion;

import static java.lang.System.out;

/**
 *
 * @author josue
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Conexion con=new Conexion();
        con.conectar();
        out.println(con.conectar());

    }
}
