package demo.generic;

/**
 * 实现泛型接口变成一个泛型类
 * @param <T>
 * @param <N>
 */
public class GenericFactoryImpl<T,N> implements GenericIFactory<T, N>{
    @Override
    public T nextObject() {
        return null;
    }

    @Override
    public N nextNumber() {
        return null;
    }
}
