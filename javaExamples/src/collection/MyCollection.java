package collection;

import java.util.List;

/**
 * Created by hariharank12 on 24/6/14.
 */
public class MyCollection {

    public static <T extends MyFindable<? super T>> T findElement(List<T> list) throws Exception {
        T result = null;
        if(list == null || list.size() == 0) new Exception("Insert some element");
        else if(list.size() == 1) return list.get(0);
        else {
            result = list.get(0);
            for(int i = 1; i < list.size(); i++) {
                if(list.get(i).find(result)) result = list.get(i);
            }
        }
        return result;
    }
}
