package demo.generic;

/**
 * 泛型接口Demo
 * @param <T>
 * @param <N>
 */
public interface GenericIFactory<T, N> {
    T nextObject();
    N nextNumber();
}
