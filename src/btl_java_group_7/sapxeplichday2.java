package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sapxeplichday2 implements Comparator<PhanCongGiangDay>{

    @Override
    public int compare(PhanCongGiangDay o1, PhanCongGiangDay o2) {
        return o1.getMaMonHoc().compareTo(o2.getMaMonHoc());
    }

}
