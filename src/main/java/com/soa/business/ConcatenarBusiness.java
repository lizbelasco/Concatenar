/**
 * 
 */
package com.soa.business;

import org.springframework.stereotype.Component;

/**
 *  Capa de negocio de concatenación de Strings.
 */
@Component
public class ConcatenarBusiness {

    public String concatenar(String s1, String s2) {
        return String.format("%s %s", s1, s2);
//        StringBuilder sb = new StringBuilder();
//        sb.append(s1);
//        sb.append(s2);
//        StringBuffer sbf = new StringBuffer();
//        sbf.append(s1);
//        sbf.append(s2);
//        return s1 + s2;
    }
}
