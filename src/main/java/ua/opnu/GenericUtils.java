package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class GenericUtils {

    @SuppressWarnings("unchecked")
    public <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                result[counter] = item;
                counter++;
            }
        }

        // повертаємо масив з реальним типом вхідного масиву,
        // щоб не було ClassCastException (наприклад, String[] r = filter(...))
        return Arrays.copyOfRange(result, 0, counter, (Class<? extends T[]>) input.getClass());
    }

    public <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}