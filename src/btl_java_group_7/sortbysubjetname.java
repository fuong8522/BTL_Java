/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sortbysubjetname implements Comparator<MonHoc>{

    @Override
    public int compare(MonHoc o1, MonHoc o2) {
        return o1.getTenmh().compareTo(o2.getTenmh());
    }
    
}
