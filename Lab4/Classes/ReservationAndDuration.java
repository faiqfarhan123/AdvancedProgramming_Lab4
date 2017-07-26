/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.time.*;
import java.util.*;

public class ReservationAndDuration {
    int reservationId;
    int people;
    int tableId;
    static int id = 0;
    LocalTime reservationTime;
    Duration bookingDuration;
    
    ReservationAndDuration(){
        reservationId = id;
        id++;
    }
    void setTable(int tableId){
        this.tableId = tableId;
    }
}
