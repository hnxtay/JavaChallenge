public class Main {
    public static void main(String[] args) {
        Range<Integer> range = Range.of(12, 20, ContainRange.closed);
        System.out.println(range.contains(20));

        Range<Integer> open = Range.open(12, 20);
        System.out.println(open.contains(12));

        Range<Integer> closed = Range.closed(12, 20);
        System.out.println(closed.contains(20));

        Range<Integer> openClosed = Range.openClosed(12, 20);
        System.out.println(openClosed.contains(20));

        Range<Integer> closedOpen = Range.closedOpen(12, 20);
        System.out.println(closedOpen.contains(20));
    }
}