import java.util.HashMap;

/**
 * Created by Tom on 17/03/2015.
 */
public class KeyValueMap<T1 extends Object, T2 extends Object> {
    public HashMap<T1, T2> keyValue;
    public HashMap<T2, T1> valueKey;

    public KeyValueMap(){
        this.keyValue = new HashMap<T1, T2>();
        this.valueKey = new HashMap<T2, T1>();
    }
    public KeyValueMap(T1 val1 ,T2 val2){
        this.keyValue = new HashMap<T1, T2>();
        this.valueKey = new HashMap<T2, T1>();
    }

    public void add(T1 key, T2 value){
        this.keyValue.put(key, value);
        this.valueKey.put(value, key);
    }

    public T2 getValue(T1 key){
        return this.keyValue.get(key);
    }

    public T1 getKey(T2 value){
        return this.valueKey.get(value);
    }

}
