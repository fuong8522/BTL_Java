package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sapxeplichday1 implements Comparator<PhanCongGiangDay>{

    @Override
    public int compare(PhanCongGiangDay o1, PhanCongGiangDay o2) {
        return o1.getMaLop().compareTo(o2.getMaLop());
    }

}
