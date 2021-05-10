package fr.byzas.programme;

import java.awt.Color;

public class Main {
	
	public static void printPixelARGB(int pixel) {
	    int alpha = (pixel >> 24) & 0xff;
	    int red = (pixel >> 16) & 0xff;
	    int green = (pixel >> 8) & 0xff;
	    int blue = (pixel) & 0xff;
	    System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
	  }
	
	public static int[] applyRedFilterOnRGBArray(LoadImageApp Img) {
		int w = Img.img.getWidth();
		int h = Img.img.getHeight();
		
		int treshold = 150;
		int red = 0;
		int green = 0;
		int blue = 0;
		System.out.println("width, heigth: "+w+", "+h);
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++)
			{
				System.out.println("x,y: " + j + ", " + i);
		        int pixel = Img.img.getRGB(j, i);
		        printPixelARGB(pixel);
		        red = (pixel >> 16) & 0xFF;
		        green = (pixel >> 8) & 0xFF;
		        blue = pixel & 0xFF;
		        if ( red >= treshold && green >= treshold && blue >= treshold) {
		        	Img.img.setRGB(j, i, new Color(255, 0, 0, 127).getRGB());
		        }
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoadImageApp Img = new LoadImageApp();
		Img.DisplayImg();
		
		applyRedFilterOnRGBArray(Img);
		Img.DisplayImg();
		
		
	}

}
