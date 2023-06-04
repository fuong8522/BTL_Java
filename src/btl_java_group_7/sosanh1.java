package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sosanh1 implements Comparator<Lop>{

    @Override
    public int compare(Lop o1, Lop o2) {
        return (int)(o1.getSiso() - o2.getSiso());
    }
    
}
