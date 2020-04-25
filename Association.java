import java.util.Map;

public class Association<K extends Comparable<K>,V extends Comparable<V>> implements Map.Entry<K,V>
{
    protected K key;
    protected V value;

    public Association(K llave, V valor){
        value = valor;
        key = llave;
    }

    public V getValue()
    {
        return value; //el getter del valor de la pareja
    }

    public V setValue(V valor)
    {
        V anterior = value;
        value = valor;
        return anterior; //el setter del valor de la parejas
    }

    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }

    public int hashCode()
    {
        return getKey().hashCode();
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}