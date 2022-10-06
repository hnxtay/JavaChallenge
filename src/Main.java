public class Main {
    public static void main(String[] args) {
        Range range = Range.of(12,20);
        System.out.println(range.contains(20));

        Range open = Range.open(12,20);
        System.out.println(open.contains(20));

        Range closed = Range.closed(12,20);
        System.out.println(closed.contains(20));

        Range openClosed = Range.openClosed(12,20);
        System.out.println(openClosed.contains(20));

        Range closedOpen = Range.closedOpen(12,20);
        System.out.println(closedOpen.contains(20));
    }
}