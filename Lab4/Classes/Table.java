/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

public class Table {
    int tableId;
    boolean reserved = false;
    int diner; //number of people that can dine on a single table
    
    Table(int tableId, int diner){
        this.tableId = tableId;
        this.diner = diner;
    }    
}
