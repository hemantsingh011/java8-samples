package com.github.samples.interface_samples;

public interface Util {
    static int  getNumberOFCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
