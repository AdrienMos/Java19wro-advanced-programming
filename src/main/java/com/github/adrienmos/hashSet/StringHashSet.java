package com.github.adrienmos.hashSet;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringHashSet implements Set<String> {

    private final double LOAD_FACTOR = 0.5;
    private final int INITIAL_BUCKET_SIZE = 4;
    private final int INCREASE_FACTOR = 2;

    private List<List<String>> buckets;
    private int currentSize = 0;

    public StringHashSet() {
        buckets = new ArrayList<>();
        for (int i = 0; i < INITIAL_BUCKET_SIZE; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    @Override
    public int size() {
        int sum = 0;
        for (List<String> bucket : this.buckets) {
            sum = sum + bucket.size();
        }
        return sum;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (List<String> bucket : this.buckets) {
            if (bucket.contains(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String potentialMember) {
        List<String> bucket = this.getBucket(potentialMember);
        if (bucket.contains(potentialMember)) {
            return false;
        }
        bucket.add(potentialMember);
        this.currentSize++;

        if (1.0 * this.size() / this.buckets.size() > this.LOAD_FACTOR) {
            increaseBucketCount();
        }

        return true;
    }
//    @Override
//    public boolean add(String s) {
//        int hash = s.hashCode();
//        int index = Math.abs(hash % this.buckets.size());
//        if (buckets.get(index).contains(s)) {
//            return false;
//        }
//        this.buckets.get(index).add(s);
//        return true;
//    }

    @Override
    public boolean remove(Object o) {
        for (List<String> bucket : this.buckets) {
            if (bucket.contains(o)) {
                bucket.remove(o);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> stringsToAdd) {

        int potentialSizeAfterInsertion = this.size() + stringsToAdd.size();
        if (1.0 * potentialSizeAfterInsertion / this.buckets.size() > this.LOAD_FACTOR) {
            this.increaseBucketCount(potentialSizeAfterInsertion);
        }

        boolean changed = false;

        for (String s : stringsToAdd) {
            if (!this.contains(s)) {
                this.add(s);
                this.currentSize++;
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super String> filter) {

        boolean removed =false;

        for (List<String> bucket : this.buckets) {
            for (String element : bucket) {
                bucket.removeIf(filter);
                removed = removed || bucket.removeIf(filter);
            }
        } return removed;
    }

    @Override
    public void clear() {

        for (List<String> bucket : this.buckets) {
            bucket.clear();
        }

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    @Override
    public Stream<String> stream() {
        return null;
    }

    @Override
    public Stream<String> parallelStream() {
        return null;
    }

    @Override
    public String toString() {
        return "{" + this.buckets.stream()
                .flatMap(bucket -> bucket.stream())
                .collect(Collectors.joining(", ")) + "}";
    }

//    @Override
//    public boolean

    private List<String> getBucket(Object o) {
        int hash = o.hashCode();
        int index = Math.abs(hash % this.buckets.size());
        return this.buckets.get(index);
    }

    private void increaseBucketCount() {
        this.increaseBucketCount(size());
    }

    private void increaseBucketCount(int capacity) {
        int newSize = this.buckets.size();
        while (1.0 * capacity / newSize > LOAD_FACTOR) {
            newSize *= this.INCREASE_FACTOR;
        }


        int newBucketSize = this.buckets.size() * this.INCREASE_FACTOR;
        List<List<String>> oldBuckets = this.buckets;
        this.buckets = new ArrayList<>();

        for (int i = 0; i < newBucketSize; i++) {
            this.buckets.add(new ArrayList<>());
        }

        for (List<String> oldBucket : oldBuckets) {
            this.addAll(oldBucket);
        }
    }
}
