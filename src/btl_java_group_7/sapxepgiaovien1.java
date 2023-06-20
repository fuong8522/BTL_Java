package btl_java_group_7;

import java.util.Comparator;

/**
 *
 * @author fuong
 */
public class sapxepgiaovien1 implements Comparator<CanBoGiaoVien>{

    @Override
    public int compare(CanBoGiaoVien o1, CanBoGiaoVien o2) {
        return o1.getMagv().compareTo(o2.getMagv());
    }

}
