package com.leevilaune.sync;

public class Reservation implements Runnable{

    private int customerNum;
    private int tickets;
    private ReservationSystem rs;

    public Reservation(int customerNum, int tickets,ReservationSystem rs){
        this.customerNum = customerNum;
        this.tickets = tickets;
        this.rs = rs;
    }
    @Override
    public void run() {
        try {
            boolean success = this.rs.addReservation(this);
            if (success) {
                System.out.println("Customer " + this.customerNum + " reserved " + this.tickets + " tickets");
            } else {
                System.out.println("Customer " + this.customerNum + " couldnt reserve " + this.tickets + " tickets");
            }
        } catch (Exception e) {
            System.err.println("Error processing reservation for customer " + customerNum + ": " + e.getMessage());
        }
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
