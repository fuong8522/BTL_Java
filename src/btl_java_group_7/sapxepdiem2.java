package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sapxepdiem2 implements Comparator<Diem>{

    @Override
    public int compare(Diem o1, Diem o2) {
        if((o1.getDiemtbky() - o2.getDiemtbky()) > 0 ) {
            return 1; 
        }
        else if((o1.getDiemtbky() - o2.getDiemtbky()) == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }

}
