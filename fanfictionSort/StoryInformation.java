package fanfictionSort;

import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;

import org.jsoup.nodes.*;



import java.util.List;

public class StoryInformation {
	static List<Story> stories = new ArrayList<Story>();
	
	
	public StoryInformation(Elements StoryI) {
		int count = 0;
		//algorithm for sorting through each node and gathering the necessary data
		//still need to implement finding summary info for each
		//implement saving method as well
		while (StoryI.size() > count) {
			Elements temp = new Elements(StoryI.get(count));
			//System.out.println(temp.select("dd.hits").html());
			Integer temp1;
			Integer temp2;
			String urlTemp;
			if(temp.select("dd.hits").html().isEmpty() == true) {
				temp1 = -1;
				
			}else{
				temp1 = Integer.parseInt(temp.select("dd.hits").html());
			}
			if(temp.select("dd.kudos > a").html().isEmpty() == true) {
				temp2 = -1;
			}else {
				temp2 = Integer.parseInt(temp.select("dd.kudos > a").html());
			}
			Element urlTemps = temp.select("a").first();
					urlTemp = urlTemps.attr("abs:href");
			
			stories.add(new Story(
					temp.select("h4.heading > a[href*=/works/]").html(),
					temp.select("h4.heading > a[href*=/users/]").html(),
					temp1,
					temp2,
					urlTemp
					));
		count++;
	}
	
		
	/*	
	 * old search method
	 * new search method successfully finds elements, allows for ability to check for things that aren't there
	 * (see isEmpty())
	 * 
		String[] HitsTemp = StoryI.select("dd.hits").html().split("\\r?\\n");
		String[] KudosTemp = StoryI.select("dd.kudos > a").html().split("\\r?\\n");
		StoryTitles = StoryI.select("h4.heading > a[href*=/works/]").html().split("\\r?\\n");
		StoryAuthors = StoryI.select("h4.heading > a[href*=/users/]").html().split("\\r?\\n");
		for(int i = 0; i < HitsTemp.length; i++) {
			Hits.add(Integer.parseInt(HitsTemp[i]));
			Kudos.add(Integer.parseInt(KudosTemp[i]));
		}
		for(int j = 0; j < HitsTemp.length; j++) {
			stories.add(new Story(StoryTitles[j], StoryAuthors[j], Hits.get(j), Kudos.get(j)));
		//	stories[j] = new Story(StoryTitles[j], StoryAuthors[j], Hits.get(j), Kudos.get(j));
			
		}
		*/
				
	}
	static public void sortStories() {
		Collections.sort(stories);
		for(Story tempSto:stories) {
			System.out.println(tempSto.ratioHK +"  "+tempSto.url +"Stories Size:" + stories.size() + "\n");
			
		}
		
		
		//Collections.sort(List<Story> stories,Comparator<? super T>c);
		//implement search by ratio of hits to kudos
	}

}
