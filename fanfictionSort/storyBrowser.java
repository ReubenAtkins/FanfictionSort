package fanfictionSort;

import javax.swing.*;
import org.jsoup.nodes.Document;



import java.awt.*;
import java.awt.event.*;
//import java.io.IOException;
import org.jsoup.Jsoup;

import org.jsoup.select.Elements;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;



public class storyBrowser {
	static String url;
	static Elements storyInfo;
	static StoryInformation pageInfo;
	static windowComponents wk;
	private static DecimalFormat df = new DecimalFormat(".####");
	
	public static void main(String[] args) throws Exception {
		wk = new windowComponents();
		ListenForButton lForButton = new ListenForButton();
		wk.urlB.addActionListener(lForButton);
		
	}
	public static void getStoryInfos(int pageNumbers) {
		int total = pageNumbers;
		System.out.println(total);
	
		int counterz = (int) pageNumbers/2;
		System.out.println("\n" + counterz);
		//algorithm to return/review 50 pages need to figure out, should work as is?
		if(counterz < 1) {
			counterz = 1;
			
		}
		Random counting = new Random();

		
		StoryInformation pageInfos = null;
		int i = 1;
		while (i < total) {
		String s = "?page=";
			try {
				s+=i;
				Document document = Jsoup.connect(url+s).userAgent("Alternative Sort Test -- reubenatkins.com").get();
				
				Elements storyInfoz = document.select("li.work");
				pageInfos = new StoryInformation(storyInfoz);
			}
			catch (IOException e){
				
			}
			//implement proper counting, 50 random pages for example
			//counterz+=15;
			if(counterz == 1){
			i+=counterz;
			//wk.info.append("Page number:"+i+"/"+total);
			}
			else{
				int j = counting.nextInt(counterz);
				while(j < (counterz/2)) {
					j = counting.nextInt(counterz);
					
				}
				i+=j;
				//wk.info.append("Completion:"+i+"/"+total);
				
			}
			System.out.println("\n" +i+"\n");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != pageInfos.stories) {
			pageInfos.sortStories();
			for(Story tempSto:pageInfos.stories) {
				//String temp = String.format("%.10f", tempSto.ratioHK);
			//	Integer temp2 = (int) ((double)tempSto.ratioHK*100.0);
				Double temp2 = tempSto.getratioHK();
				System.out.println("Double:"+df.format(temp2)+"\n");
				System.out.println(temp2+"\n");
				String temp = Double.toString(temp2);
				System.out.println(temp);
				wk.info.append(tempSto.url + "\nRatio:"+temp+"\nTitle: "+tempSto.title+"\n");
			}
		
		}

	}
	private static class ListenForButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == wk.urlB) {
					url = wk.label1.getText();
				
				try{
						//connecting to Fanfiction.net
					Document document = Jsoup.connect(url).userAgent("Alternative Sort Test -- reubenatkins.com").get();
					storyInfo = document.select("li.work");
					//algorithm for finding the page #s
					Elements lists = document.select("ol.pagination");
					
					Elements pageNumberz = lists.select("a");
					Integer pageTemp = 0;
					String[] testing1 = pageNumberz.select("a").html().split("\\r?\\n");
					pageInfo = new StoryInformation(storyInfo);
					
					for(String test: testing1) {
						try {
							if(Integer.parseInt(test) > pageTemp) {
								pageTemp = Integer.parseInt(test);
							}
						}
						catch (NumberFormatException e1) {
							
						}
						//System.out.println(pageTemp/50);
					}
					
					getStoryInfos(pageTemp);
					
				}
				catch (IOException e1) {
										
					//Not much I can do
					
				}
				
				
				
			
			}
			
		}
		
	
	}
	

}


