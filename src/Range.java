public class Range<T extends Comparable<T>> {
    private final T lowerBound;
    private final T upperBound;

    private final ContainRange containRange;

    private Range(T lowerBound, T upperBound, ContainRange range) {
        if (lowerBound.compareTo(upperBound) > 0) {
            throw new IllegalArgumentException("lowerBound value cannot be greater than upper value");
        }
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.containRange = range;
    }


    public static <T extends Comparable<T>> Range<T> of(T lowerBound, T upperBound, ContainRange range) {
        return new Range<T>(lowerBound, upperBound, range);
    }

    public boolean contains(T number) {
        return switch (containRange) {
            case open -> number.compareTo(lowerBound) > 0 && number.compareTo(upperBound) < 0;
            case closed -> number.compareTo(lowerBound) >= 0 && number.compareTo(upperBound) <= 0;
            case openClosed -> number.compareTo(lowerBound) < 0 && number.compareTo(upperBound) >= 0;
            case closedOpen -> number.compareTo(lowerBound) >= 0 && number.compareTo(upperBound) < 0;
        };
    }

    public static <T extends Comparable<T>> Range<T> open(T lowerBound, T upperBound) {
        return new Range<T>(lowerBound, upperBound, ContainRange.open);
    }

    public static <T extends Comparable<T>> Range<T> closed(T lowerBound, T upperBound) {
        return new Range<T>(lowerBound, upperBound, ContainRange.closed);
    }

    public static <T extends Comparable<T>> Range<T> openClosed(T lowerBound, T upperBound) {
        return new Range<T>(lowerBound, upperBound, ContainRange.openClosed);
    }

    public static <T extends Comparable<T>> Range<T> closedOpen(T lowerBound, T upperBound) {
        return new Range<T>(lowerBound, upperBound, ContainRange.closedOpen);
    }
}

enum ContainRange {
    open, closed, openClosed, closedOpen
}
