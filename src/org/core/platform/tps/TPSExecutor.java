package org.core.platform.tps;

public class TPSExecutor implements Runnable {

    protected int tickCount;
    protected long[] ticks = new long[600];
    protected long lastTick;

    public double getTPS(){
        return getTPS(100);
    }

    public double getTPS(int ticks){
        if(this.tickCount < ticks){
            return 20;
        }
        int target = (this.tickCount - 1 - ticks) % this.ticks.length;
        long elapsed = System.currentTimeMillis() - this.ticks[target];
        return ticks / (elapsed / 1000.0);
    }

    public double getTPSPercent(int ticks){
        return (getTPS(ticks) * 100.0f)/20;
    }

    @Override
    public void run() {
        this.ticks[this.tickCount % this.ticks.length] = System.currentTimeMillis();
        this.tickCount = this.tickCount + 1;
    }
}
