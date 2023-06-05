package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sortbyname implements Comparator<HocSinh>{

    @Override
    public int compare(HocSinh o1, HocSinh o2) {
        return o1.getHoTen().compareTo(o2.getHoTen());
    }
    
}
