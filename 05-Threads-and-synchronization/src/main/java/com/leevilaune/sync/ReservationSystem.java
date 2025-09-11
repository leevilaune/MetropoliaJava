package com.leevilaune.sync;

public class ReservationSystem {
    private int reservations;
    private int maxReservations;

    public ReservationSystem(int maxReservations) {
        this.reservations = 0;
        this.maxReservations = maxReservations;
    }

    public synchronized boolean addReservation(Reservation r) {
        if (this.reservations + r.getTickets() > this.maxReservations) {
            return false;
        }
        this.reservations += r.getTickets();
        return true;
    }

    public static void main(String[] args) {
        ReservationSystem rs = new ReservationSystem(10);
        for(int i = 1; i <= 10; i++) {
            Reservation reservation = new Reservation(i, (int)(Math.random() * 4) + 1, rs);
            Thread thread = new Thread(reservation);
            thread.start();
        }
    }
}