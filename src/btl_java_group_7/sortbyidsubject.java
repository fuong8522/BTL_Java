package btl_java_group_7;

import java.util.Comparator;


/**
 *
 * @author fuong
 */
public class sortbyidsubject implements Comparator<MonHoc>{

    @Override
    public int compare(MonHoc o1, MonHoc o2) {
        return o1.getMamh().compareTo(o2.getMamh());
    }
    
}
