package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */

public class sortbymark implements Comparator<HocSinh> {

    @Override
    public int compare(HocSinh o1, HocSinh o2) {
        return (int) ( o1.getDiemVaoTruong() - o2.getDiemVaoTruong());
    }
    
}
