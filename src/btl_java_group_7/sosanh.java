package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sosanh implements Comparator<Lop>{

    @Override
    public int compare(Lop o1, Lop o2) {

            return o1.getTenlop().compareTo(o2.getTenlop());

    }
    
}
