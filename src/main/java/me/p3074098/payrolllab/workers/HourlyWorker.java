package me.p3074098.payrolllab.workers;

import java.util.Map;

public class HourlyWorker extends Worker {
    
    private double wage;
    private double hours;
    
    public HourlyWorker(Map<String, Object> map) {
        super(map);
        
        this.wage = (double) map.get("wage");
        this.hours = (double) map.get("hours");
    }
    
    public HourlyWorker(String firstName, String lastName, double wage, double hours) {
        super(firstName, lastName);
        
        this.wage = wage;
        this.hours = hours;
    }
    
    @Override
    public double earnings() {
        double overtime = Math.max(0, hours - 40);
        double normal = Math.min(40, hours);
        
        return normal * wage + getOvertimeMultiplier() * wage * overtime;
    }
    
    @Override
    public String getColor() {
        return "99, 216, 255";
    }
    
    public double getOvertimeMultiplier() {
        return 1.5;
    }
    
    @Override
    public String toString() {
        return "Hourly Worker: " + super.toString();
    }
    
    @Override
    public String getJobTitle() {
        return "Hourly Worker";
    }
    
    public double getWage() {
        return wage;
    }
    
    public double getHours() {
        return hours;
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = super.serialize();
        
        map.put("wage", wage);
        map.put("hours", hours);
        
        return map;
    }
}
