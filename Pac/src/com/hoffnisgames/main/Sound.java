package com.hoffnisgames.main;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	private AudioClip clip;
	

	public static final Sound hurtEfferc = new Sound("/Production Element Title Transition Laser Short 01.wav");
	public static final Sound fire = new Sound("/Production Element Title Transition Laser 02.wav");
	private Sound(String name) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		}catch(Throwable e) {
			
		}
	}
	public void play(){
		try {
			new Thread() {
				public void run(){
					clip.play();
				}
			}.start();
		}catch(Throwable e) {}
	}
	
	public void loop(){
		try {
			new Thread() {
				public void run(){
					clip.loop();
				}
			}.start();
		}catch(Throwable e) {}
	}
	
}
