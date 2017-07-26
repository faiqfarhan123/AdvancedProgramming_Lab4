/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.time.*;
import java.util.*;

/**
 *
 *
 */
public class ApplicationSystem {

    //a list of a class Table
    List<Table> allocatedTables;

    //a map of a map of time, duration, reservation class and table class
    Map<Map<LocalTime, Duration>, Map<ReservationAndDuration, Table>> application;

    //constructor
    ApplicationSystem() {
    }

    //initializing tables with the maximum amount of people who can dine on a single table and total number of table in each category
    public void initTable() {
        allocatedTables = new ArrayList();

        //1 table initialized for 12 people, 0th element in a list is allocated for a table of 12 people
        allocatedTables.add(new Table(0, 12));

        //3 tables initialized for 6 people, 1,2 and 3rd elements in a list are allocated for a table of 6 people
        for (int i = 1; i < 4; i++) {
            allocatedTables.add(new Table(i, 6));
        }

        //8 tables initialized for 4 people, 4,5,6,7,8,9,10 and 11th elements in a list are allocated for a table of 4 people
        for (int i = 4; i < 12; i++) {
            allocatedTables.add(new Table(i, 4));
        }

        //4 tables initialized for 2 people, 12,13,14,15th elements in a list are allocated for a table of 2 people
        for (int i = 12; i < 16; i++) {
            allocatedTables.add(new Table(i, 2));
        }
    }

    //making reservations of total people to serve and localtime 
    public void makeReservation(int guests, LocalTime time) {
        //object of a reservation class
        ReservationAndDuration reserve = new ReservationAndDuration();
        
        //if people are greater than 6, allocate them a table for 12 people
        if (guests > 6) {
            //dividing double map into single maps
            Map<ReservationAndDuration, Table> tempTable = new HashMap();
            Map<LocalTime, Duration> tempDuration = new HashMap();
            
            //allocating 2 hours for that table
            tempDuration.put(time, Duration.ofHours(2));
            //reserving a table 
            tempTable.put(reserve, allocatedTables.get(0));
            reserve.setTable(0);
            //setting bool value of reserve to true
            tempTable.get(0).reserved = true;
            application.put(tempDuration, tempTable);
        }
        
        //if people are greater than 4, allocate them a table for 6 people
        else if (guests > 4) {
            Map<ReservationAndDuration, Table> tempTable = new HashMap();
            Map<LocalTime, Duration> tempDuration = new HashMap();
            
            for (int i = 1; i < 4; i++) {
                if (allocatedTables.get(i).reserved == false) {
                    tempTable.put(reserve, allocatedTables.get(i));
                    tempTable.get(i).reserved = true;
                    reserve.setTable(i);
                    break;
                } else {
                    continue;
                }
            }

            tempDuration.put(time, Duration.ofMinutes(90));
            application.put(tempDuration, tempTable);
        }
        
        //if people are greater than 2, allocate them a table for 4 people
        else if (guests > 2) {
            Map<ReservationAndDuration, Table> tempTable = new HashMap();
            Map<LocalTime, Duration> tempDuration = new HashMap();
            for (int i = 4; i < 12; i++) {
                if (allocatedTables.get(i).reserved == false) {
                    tempTable.put(reserve, allocatedTables.get(i));
                    tempTable.get(i).reserved = true;
                    reserve.setTable(i);
                    break;
                } else {
                    continue;
                }
            }

            tempDuration.put(time, Duration.ofHours(1));
            application.put(tempDuration, tempTable);
        }
        
        //else allocate them a table for 2 people
        else if (guests >= 1) {
            Map<ReservationAndDuration, Table> tempTable = new HashMap();
            Map<LocalTime, Duration> tempDuration = new HashMap();
            for (int i = 12; i < 16; i++) {
                if (allocatedTables.get(i).reserved == false) {
                    tempTable.put(reserve, allocatedTables.get(i));
                    tempTable.get(i).reserved = true;
                    reserve.setTable(i);
                    break;
                } else {
                    continue;
                }
            }
            tempDuration.put(time, Duration.ofMinutes(30));
            application.put(tempDuration, tempTable);
        }
    }

}
