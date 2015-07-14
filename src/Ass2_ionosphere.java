import java.util.Scanner;
import java.lang.*;
import java.io.*;


public class Ass2_ionosphere { 
	public final static int Max_k = 20;

	
	//calculate euclidean distance for 2 sets.
	static float distance_euclidean(String[] set1,String[] set2,int attr_num){
		float sum =0;
		for(int n = 0;n<attr_num-1;n++){
			float setf1 = Float.parseFloat(set1[n]);
			float setf2 = Float.parseFloat(set2[n]);
			sum +=(setf1-setf2)*(setf1-setf2);
		}
		
		return sum;
	}
	

	
	
public static void main (String[] args)throws IOException{

	
	File file = new File("ionosphere.arff");
	
    BufferedReader readerforline = null;
    String tempString = null;
    int line = 0;
    int attr_num = 0;
    
    //get the number of data line and attribute
   readerforline = new BufferedReader(new FileReader(file));
    while ((tempString = readerforline.readLine()) != null) {
        if(tempString.startsWith("%")){
        }
        else if(tempString.startsWith("@")){
        }
        else if(tempString.length() > 1){
        	String[] arr = tempString.split(",");
        	//System.out.println(arr.length);
        	attr_num=arr.length;
        	 boolean complete_line=true;
             for(int n=0;n<attr_num;n++)
             {
             	if(arr[n].equalsIgnoreCase("?")){
             		complete_line = false;
             	}
             }
             if(complete_line == true){			        	 
                 line++; 
             }
        }
    }
    readerforline.close();
    int line_num = line;
    line = 0;
   // System.out.println(line_num);

    //get data
    String[][] data = new String[line_num][attr_num];
    BufferedReader reader = null;
    reader = new BufferedReader(new FileReader(file));
    while ((tempString = reader.readLine()) != null) {
    	if(tempString.startsWith("%")){
    	}
    	else if(tempString.startsWith("@")){
    	}
        else if(tempString.length() > 1){
        //System.out.println(tempString);
        String[] arr = tempString.split(",");
        boolean complete_line=true;
        for(int n=0;n<attr_num;n++)
        {
        	if(arr[n].equalsIgnoreCase("?")){
        		complete_line = false;
        	}
        }
        if(complete_line == true){
        	for(int n=0;n<attr_num;n++)
            {
            	data[line][n] = arr[n];
            }			        	 
            line++; 
        }
        
        }
    }
    reader.close();       			 
    
    
    int leave_one_out = 0;
    
  //output the result of the accuracy with varies k
    BufferedWriter bufferedWriter = null;
    bufferedWriter = new BufferedWriter(new FileWriter("ionosphere.txt"));
    //test accuracy of different k
    for(int k=2;k<Max_k;k++){
    	int count_right = 0;
    	int count_wrong = 0;
    	int count_right_distance = 0;
    	int count_wrong_distance = 0;
    	
    	//use different leave_one_out data
    for(int n = 0;n<line_num;n++){
    	leave_one_out = n;
    	int[] kNN = new int[k];
    	for(int a=0;a<k;a++){
    		kNN[a]=0;
    	}
    	
    	//get k-nearest and store in kNN
    	for(int m = 0;m<line_num;m++){
    		if(m !=leave_one_out){
    			// compare the new distance with the lowest distance in k-nearest list and updata
    			float Old_distance = distance_euclidean(data[kNN[k-1]],data[leave_one_out],attr_num);
    			float New_distance = distance_euclidean(data[m],data[leave_one_out],attr_num);
    			if(New_distance < Old_distance){
    				kNN[k-1] = m;
    				//let k-nearest list as queue with lower distance in front and higher distance in the back
    				for(int a=0;a<k-1;a++){
    					float Old_distance_k = distance_euclidean(data[kNN[k-2-a]],data[leave_one_out],attr_num);
    	    			float New_distance_k = distance_euclidean(data[kNN[k-1-a]],data[leave_one_out],attr_num);
    	    			if(New_distance < Old_distance){
    	    				int swap;
    	    				swap = kNN[k-2-a];
    	    				kNN[k-2-a] = kNN[k-1-a];
    	    				kNN[k-1-a] = swap;
    	    			}
    	    			else{
    	    				break;
    	    			}
    				}
    			}
    		}
    	}
    	int countb=0;
    	int countg=0;
    	double countb_distance=0;
    	double countg_distance=0;

    	
    	//get the number or weigh of each value(b or g) for class
    	for(int a=0;a<k;a++){
    		if(data[kNN[a]][attr_num-1].equalsIgnoreCase("b")){
    			countb++;
    			countb_distance+= 1.0/distance_euclidean(data[kNN[a]],data[leave_one_out],attr_num);
    		}
    		else if (data[kNN[a]][attr_num-1].equalsIgnoreCase("g")){
    			countg++;
    			countg_distance+= 1.0/distance_euclidean(data[kNN[a]],data[leave_one_out],attr_num);
    		}
    	}

    	//compare with real result in data,
    	//count the right result number and wrong result number
    	//if the number of b or g is the same, we set it as g
    	if(countb > countg){
    		if(data[leave_one_out][attr_num-1].equalsIgnoreCase("b")){
    			count_right++;
    		}
    		else if (data[leave_one_out][attr_num-1].equalsIgnoreCase("g")){
    			count_wrong++;
    		}
    	}else{
    		if(data[leave_one_out][attr_num-1].equalsIgnoreCase("b")){
    			count_wrong++;
    		}
    		else if (data[leave_one_out][attr_num-1].equalsIgnoreCase("g")){
    			count_right++;
    		}
    	}
    	
    	if(countb_distance > countg_distance){
    		if(data[leave_one_out][attr_num-1].equalsIgnoreCase("b")){
    			count_right_distance++;
    		}
    		else if (data[leave_one_out][attr_num-1].equalsIgnoreCase("g")){
    			count_wrong_distance++;
    		}
    	}else{
    		if(data[leave_one_out][attr_num-1].equalsIgnoreCase("b")){
    			count_wrong_distance++;
    		}
    		else if (data[leave_one_out][attr_num-1].equalsIgnoreCase("g")){
    			count_right_distance++;
    		}
    	}
    	
    	
    }
  //output the data to result file
    float accuacy;
    accuacy = (float)count_right/((float)count_right+(float)count_wrong);
    System.out.println("k is N0."+k+ "and accuracy of knn: " +accuacy);
    float accuacy_distance;
    accuacy_distance = (float)count_right_distance/((float)count_right_distance+(float)count_wrong_distance);
    System.out.println("k is N0."+k+ "and accuracy of wnn: " +accuacy_distance);
    String output = null;
    output = k+","+accuacy+","+accuacy_distance;
    bufferedWriter.write(output);
    bufferedWriter.newLine();
    }
    bufferedWriter.flush();
    bufferedWriter.close();
    
    
}
}