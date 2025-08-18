package com.leevilaune.classes;

public class Television {

    private int channel;
    private boolean isOn;

    public Television(){
        this.channel = 0;
        this.isOn = false;
    }
    public void setChannel(int channel){
        if(channel>10){
            channel = 1;
        }
        this.channel = channel;
    }
    public int getChannel(){
        return this.channel;
    }
    public void pressOnOff(){
        if(this.isOn()){
            this.isOn = false;
        }else{
            this.isOn = true;
        }
    }
    public boolean isOn(){
        return isOn;
    }
}
