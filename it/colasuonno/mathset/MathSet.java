package it.colasuonno.mathset;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SuppressWarnings("unchecked")
public class MathSet<E> implements Serializable, Cloneable {

    /**
     * Class data field in E array
     */
    private E[] classData;

    /**
     *
     * E class type
     *
     */
    private Class<?> dataType;

    @SafeVarargs
    public MathSet(E... objects) {
        this.classData = objects;
        this.dataType = objects.getClass();
    }

    /**
     *
     * A{1,2,3} union B{2,3,4} = C{1,2,3,4}
     *
     * @param mathSet used to check union between two math sets
     * @return the math set union
     */
    public MathSet union(MathSet mathSet) {
        return fromSet(
                Stream.concat(
                        Arrays.stream(classData),
                        Arrays.stream((E[]) mathSet.getClassData())
                ).collect(Collectors.toSet())
        );
    }

    /**
     *
     * A{1,2,3} union B{2,3,4} = C{2,3}
     *
     * @param mathSet used to check intersection between two math sets
     * @return the math set intersection
     */
    public MathSet intersection(MathSet mathSet) {
        return fromSet(Stream.concat(Arrays.stream(classData).distinct(), Arrays.stream((E[]) mathSet.getClassData()).distinct())
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet()));
    }

    /**
     *
     * Convert a set<E> to that class instance(MathSet)
     *
     * @param mathSet used to convert
     * @return math set given the set
     */
    @SuppressWarnings("unchecked")
    public MathSet fromSet(Set<E> mathSet) {
        return new MathSet(mathSet.toArray());
    }

    /**
     * Checking method of two math sets
     *
     * @param mathSet of same objects
     * @return if the current math set has the same classData of the given one
     */
    @Override
    public boolean equals(Object mathSet) {
        return mathSet instanceof MathSet && Arrays.equals(((MathSet) mathSet).getClassData(), this.classData);
    }


    /**
     *
     * Get the list of objects in the set
     *
     * @return the set objects
     */
    @Override
    public String toString() {
        return Arrays.asList(classData).toString();
    }

    public Class<?> getDataType() {
        return dataType;
    }

    public E[] getClassData() {
        return classData;
    }
}
