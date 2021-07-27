package arrays;

import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/hotel-bookings-possible/
public class HotelBookingsPossible {

    public static void main(String[] args) {
        List<Integer> arrival = Arrays.asList(1, 3, 5);
        List<Integer> departure = Arrays.asList(2, 6, 8);
        int rooms = 1;
        boolean result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", false, result);
        System.out.println("Success");

        arrival = Arrays.asList(1, 3, 7);
        departure = Arrays.asList(2, 6, 8);
        rooms = 1;
        result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", true, result);
        System.out.println("Success");

        arrival = Arrays.asList(1, 3, 5);
        departure = Arrays.asList(2, 6, 8);
        rooms = 2;
        result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", true, result);
        System.out.println("Success");

        arrival = Arrays.asList(49, 8, 22, 28, 9, 15, 42, 3);
        departure = Arrays.asList(72, 38, 66, 51, 49, 57, 79, 30);
        rooms = 2;
        result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", false, result);
        System.out.println("Success");

        arrival = Arrays.asList(35, 48, 33, 26, 16, 11, 14, 37, 41, 12, 47, 38, 23, 4, 0, 10, 47, 30, 46, 38, 26);
        departure = Arrays.asList(51, 53, 40, 54, 23, 39, 33, 70, 61, 45, 78, 77, 50, 12, 4, 25, 77, 35, 53, 38, 61);
        rooms = 2;
        result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", false, result);
        System.out.println("Success");

        arrival = Arrays.asList(47, 4, 0, 12, 47, 31, 15, 49, 29, 33, 7, 22, 26, 24, 16 );
        departure = Arrays.asList(95, 4, 26, 16, 51, 79, 43, 58, 32, 80, 30, 27, 29, 54, 16 );
        rooms = 10;
        result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", true, result);
        System.out.println("Success");

        arrival = Arrays.asList(1, 2, 3 );
        departure = Arrays.asList( 2, 3, 4);
        rooms = 1;
        result = hotel(arrival, departure, rooms);
        Assert.assertEquals("Failed", true, result);
        System.out.println("Success");

    }


    public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        class Event {
            public Integer event;
            public Integer day;

            public Event(int event, int day) {
                this.event = event;
                this.day = day;
            }

            public Integer getEvent() {
                return event;
            }

            public Integer getDay() {
                return day;
            }
        }

        List<Event> events = new ArrayList<>();
        arrive.stream().map(integer -> new Event(1, integer)).forEach(events::add);
        depart.stream().map(integer -> new Event(-1, integer)).forEach(events::add);
        events = events.stream()
                .sorted(Comparator.comparingInt(Event::getDay).thenComparingInt(Event::getEvent))
                .collect(Collectors.toList());

        boolean result = true;
        int occupiedRooms = 0;
        for (Event e: events) {
            occupiedRooms = occupiedRooms + e.event;
            if (occupiedRooms > K){
                result = false;
                break;
            }
        }
        return result;
    }

    /*public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        sortArrivalDeparture(arrive, depart);
        System.out.println(arrive);
        System.out.println(depart);
        boolean result = true;
        Optional<Integer> maxDay = depart.parallelStream().max(Integer::compareTo);
        if (maxDay.isPresent()) {
            int [] occupiedRooms = new int[maxDay.get()+1];
            for (int i = 0; i < arrive.size(); i++) {
                for (int day = arrive.get(i), endDay = depart.get(i); day < endDay; day++) {
                    int occupiedRoomsForDay = occupiedRooms[day];
                    if (occupiedRoomsForDay == K){
                        result = false;
                        break;
                    }
                    occupiedRooms[day] += 1;
                }
            }
        }
        return result;
    }*/

    public static void sortArrivalDeparture(List<Integer> arrive, List<Integer> depart) {
        for (int i = 0; i < arrive.size() - 1; i++) {
            for (int j = i + 1; j < arrive.size(); j++) {
                if (arrive.get(i) > arrive.get(j)){
                    int temp = arrive.get(i);
                    arrive.set(i, arrive.get(j));
                    arrive.set(j, temp);
                    int tempDep = depart.get(i);
                    depart.set(i, depart.get(j));
                    depart.set(j, tempDep);
                }
            }
        }
    }
}
