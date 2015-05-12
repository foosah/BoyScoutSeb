package com.example.emilovich.boyscout.Entities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Michael on 12-05-2015.
 */
public class MorseHandler implements Runnable {

    private Camera camera;
    private Camera.Parameters params;
    private Context context;
    private ArrayList<String> sequence = new ArrayList<>();

    public MorseHandler(ArrayList<String> morseSequence){
        setUpCamera();
        this.sequence = morseSequence;
    }

    //check if phone has flashlight and sets up camera
    private void setUpCamera(){
        camera = Camera.open();
        params = camera.getParameters();
    }

    private void flashlightOn(){
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
    }

    private void flashlightOff(){
        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.stopPreview();
    }
    @Override
    public void run() {
        String letterSeq = "";
        char letter;
        for (int i = 0; i < sequence.size(); i++){
            letterSeq = sequence.get(i);
            for (int k = 0; k < letterSeq.length(); k++){
                letter = letterSeq.charAt(k);
                if(letter == '.'){
                    try {
                        flashlightOn();
                        Thread.sleep(250);
                        flashlightOff();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(letter == '-'){
                    try {
                        flashlightOn();
                        Thread.sleep(1000);
                        flashlightOff();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(letter == '|'){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}