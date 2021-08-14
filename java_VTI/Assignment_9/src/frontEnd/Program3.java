package frontEnd;

import entity.CPU;

public class Program3 {
    public static void main(String[] args) {
        CPU cpu = new CPU(10000);
        CPU.Processor ta = cpu.new Processor(1, "TAH");
        CPU.Ram ta1 = cpu.new Ram("f", "TAH");
        System.out.println(ta.getCache());
        System.out.println(ta1.getClockSpeed());
    }
}
