package com.vtxlab.bootcamp;

public class App1 {

    private App2 app2;

    public App1(App2 app2) {
        this.app2 = app2;
    }

    // Developer A
    public int add(int x, int y) { // assert ?

        int result = this.app2.provider(x * 2, y);
        if (x > 10 && y < 20) 
            return result + 1000;
        return result + 500;

        // assume provider(x * 2, y) return 5, 1005
        // assume provider(x * 2, y) return 1000, 2000
        // assume provider(x * 2, y) return -1, 999
    }

}