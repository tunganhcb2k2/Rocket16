package entity;

public class CPU {
    public int price;

    public CPU(int price) {
        this.price = price;
    }

    public class Processor {
        public int coreAmount;
        public String menuFacturer;

        public double getCache() {
            return 4.3;
        }

        public Processor(int coreAmount, String menuFacturer) {
            this.coreAmount = coreAmount;
            this.menuFacturer = menuFacturer;
        }
    }

    public class Ram {
        public String memory;
        public String menuFacturer;

        public double getClockSpeed() {
            return 5.5;
        }

        public Ram(String memory, String menuFacturer) {
            this.memory = memory;
            this.menuFacturer = menuFacturer;
        }
    }
}
