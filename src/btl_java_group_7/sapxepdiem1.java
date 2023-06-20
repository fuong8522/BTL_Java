package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sapxepdiem1 implements Comparator<Diem>{

    @Override
    public int compare(Diem o1, Diem o2) {
        return o1.getMahs().compareTo(o2.getMahs());
    }

}
