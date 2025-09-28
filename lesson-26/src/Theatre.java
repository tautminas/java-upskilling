import java.util.*;

public class Theatre {

    private String theatreName;
    private int seatsPerRow;
    private Set<Seat> seats;

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        this.seatsPerRow = seatsPerRow;
        this.seats = new TreeSet<>();

        for (char row = 'A'; row < 'A' + numRows; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                seats.add(new Seat(row, seatNum));
            }
        }
    }

    public boolean reserveSeat(String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId)) {
                if (seat.reserve()) {
                    System.out.println("Congratulations! Your reserved seat is " + seatId);
                    return true;
                } else {
                    System.out.println("Seat " + seatId + " is already reserved.");
                    return false;
                }
            }
        }
        System.out.println("Seat " + seatId + " does not exist.");
        return false;
    }

    public boolean reserveSeats(int numSeats, char fromRow, char toRow, int fromSeat, int toSeat) {
        if (fromRow < 'A' || toRow < 'A' || fromRow > toRow ||
                fromSeat < 1 || toSeat > seatsPerRow || fromSeat > toSeat) {
            System.out.printf(
                    "Invalid! %d seats between %c[%d-%d]-%c[%d-%d] Try again: Seat must be between A001 and %c%03d%n",
                    numSeats, fromRow, fromSeat, toSeat, toRow, fromSeat, toSeat, (char) ('A' + getNumRows() - 1), seatsPerRow
            );
            return false;
        }

        List<String> reservedIds = new ArrayList<>();

        for (char row = fromRow; row <= toRow; row++) {
            for (int start = fromSeat; start <= toSeat - numSeats + 1; start++) {
                List<Seat> block = new ArrayList<>();
                boolean available = true;
                for (int offset = 0; offset < numSeats; offset++) {
                    String seatId = String.format("%c%03d", row, start + offset);
                    Seat seat = findSeat(seatId);
                    if (seat == null || seat.isReserved()) {
                        available = false;
                        break;
                    }
                    block.add(seat);
                }

                if (available) {
                    for (Seat s : block) {
                        s.reserve();
                        reservedIds.add(s.getSeatId());
                    }
                    System.out.println("Congratulations! Your reserved seats are " + reservedIds);
                    return true;
                }
            }
        }

        System.out.printf("Sorry! No matching contiguous seats in rows: %c-%c%n", fromRow, toRow);
        return false;
    }

    private Seat findSeat(String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId)) {
                return seat;
            }
        }
        return null;
    }

    private int getNumRows() {
        int max = 0;
        for (Seat seat : seats) {
            char row = seat.getSeatId().charAt(0);
            if (row - 'A' + 1 > max) max = row - 'A' + 1;
        }
        return max;
    }

    public void printSeatMap() {
        System.out.println("\n------");
        System.out.println(theatreName + " Seat Map");
        System.out.println("------");

        char currentRow = ' ';
        for (Seat seat : seats) {
            if (seat.getRow() != currentRow) {
                if (currentRow != ' ') System.out.println();
                currentRow = seat.getRow();
            }
            System.out.print(seat + " ");
        }
        System.out.println("\n");
    }

    private static class Seat implements Comparable<Seat> {
        private char row;
        private int seatNumber;
        private String seatId;
        private boolean reserved;

        public Seat(char row, int seatNumber) {
            this.row = row;
            this.seatNumber = seatNumber;
            this.seatId = String.format("%c%03d", row, seatNumber);
            this.reserved = false;
        }

        public String getSeatId() {
            return seatId;
        }

        public char getRow() {
            return row;
        }

        public boolean isReserved() {
            return reserved;
        }

        public boolean reserve() {
            if (!reserved) {
                reserved = true;
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Seat other) {
            return this.seatId.compareTo(other.seatId);
        }

        @Override
        public String toString() {
            return reserved ? seatId + "(•)" : seatId;
        }
    }
}
