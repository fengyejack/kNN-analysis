import java.util.Scanner;
import java.lang.*;
import java.io.*;


public class Ass2_autos_encoding { 
	public final static int Max_k = 20;


	
	
// calculate how many different attribute
	static float distance_difference(String[] set1,String[] set2,int attr_num){
		float sum =0;
		float[] set_1= new float[attr_num];
		float[] set_2= new float[attr_num];
		for(int n = 0;n<attr_num;n++){
			set_1[n] = Float.parseFloat(set1[n]);
			set_2[n] = Float.parseFloat(set2[n]);
		}
		sum += ((set_1[0]-set_2[0])/191.0)*((set_1[0]-set_2[0])/191.0);
		sum += ((set_1[1]-set_2[1])/21.0)*((set_1[1]-set_2[1])/21.0);
		sum += ((set_1[2]-set_2[2])/1.0)*((set_1[2]-set_2[2])/1.0);
		sum += ((set_1[3]-set_2[3])/1.0)*((set_1[3]-set_2[3])/1.0);
		sum += ((set_1[4]-set_2[4])/1.0)*((set_1[4]-set_2[4])/1.0);
		sum += ((set_1[5]-set_2[5])/4.0)*((set_1[5]-set_2[5])/4.0);
		sum += ((set_1[6]-set_2[6])/2.0)*((set_1[6]-set_2[6])/2.0);
		sum += ((set_1[7]-set_2[7])/1.0)*((set_1[7]-set_2[7])/1.0);
		sum += ((set_1[8]-set_2[8])/34.3)*((set_1[8]-set_2[8])/34.3);
		sum += ((set_1[9]-set_2[9])/67.0)*((set_1[9]-set_2[9])/67.0);
		sum += ((set_1[10]-set_2[10])/12.0)*((set_1[10]-set_2[10])/12.0);
		sum += ((set_1[11]-set_2[11])/12.0)*((set_1[11]-set_2[11])/12.0);
		sum += ((set_1[12]-set_2[12])/2578.0)*((set_1[12]-set_2[12])/2578.0);
		sum += ((set_1[13]-set_2[13])/6.0)*((set_1[13]-set_2[13])/6.0);
		sum += ((set_1[14]-set_2[14])/6.0)*((set_1[14]-set_2[14])/6.0);
		sum += ((set_1[15]-set_2[15])/265.0)*((set_1[15]-set_2[15])/265.0);
		sum += ((set_1[16]-set_2[16])/265.0)*((set_1[16]-set_2[16])/265.0);
		sum += ((set_1[17]-set_2[17])/1.4)*((set_1[17]-set_2[17])/1.4);
		sum += ((set_1[18]-set_2[18])/2.1)*((set_1[18]-set_2[18])/2.1);
		sum += ((set_1[19]-set_2[19])/16.0)*((set_1[19]-set_2[19])/16.0);
		sum += ((set_1[20]-set_2[20])/240.0)*((set_1[20]-set_2[20])/240.0);
		sum += ((set_1[21]-set_2[21])/2450.0)*((set_1[21]-set_2[21])/2450.0);
		sum += ((set_1[22]-set_2[22])/36.0)*((set_1[22]-set_2[22])/36.0);
		sum += ((set_1[23]-set_2[23])/38.0)*((set_1[23]-set_2[23])/38.0);
		sum += ((set_1[25]-set_2[25])/6.0)*((set_1[25]-set_2[25])/6.0);

		return sum;
	}
	

	
	
public static void main (String[] args)throws IOException{
	int k = 5;
	int test_attribute_number = 24;
	File file = new File("autos.arff");
    BufferedReader readerforline = null;
    String tempString = null;
    int line = 0;
 
    int line_num = 159;
    int attr_num = 26;
    line = 0;
   // System.out.println(line_num);

  //get data of 14 continuous and 1 integer attributes and a attribute price
    String[][] data = new String[line_num][attr_num];
    BufferedReader reader = null;
    reader = new BufferedReader(new FileReader(file));
    while ((tempString = reader.readLine()) != null) {
    	if(tempString.startsWith("%")){
    	}
    	else if(tempString.startsWith("@")){
    	}
        else if(tempString.length() > 1){

        String[] arr = tempString.split(",");
       // System.out.println(arr.length);
        boolean complete_line=true;
        for(int n=0;n<arr.length;n++)
        {
        	if(arr[n].equalsIgnoreCase("?")){
        		complete_line = false;
        	}
        }
        if(complete_line == true){
        for(int a = 0;a<attr_num;a++)	{
        	//data[line][a] = "0";
        }
        
        data[line][0] = arr[0];
        data[line][8] = arr[8];
        data[line][9] = arr[9];
        data[line][10] = arr[10];
        data[line][11] = arr[11];
        data[line][12] = arr[12];
        data[line][15] = arr[15];
        data[line][17] = arr[17];
        data[line][18] = arr[18];
        data[line][19] = arr[19];
        data[line][20] = arr[20];
        data[line][21] = arr[21];
        data[line][22] = arr[22];
        data[line][23] = arr[23];
        data[line][24] = arr[24];
        data[line][25] = arr[25];
        if(arr[1].equalsIgnoreCase("alfa-romero")){
        	data[line][1] = "0";
        }else if(arr[1].equalsIgnoreCase("audi")){
        	data[line][1] = "1";
        }else if(arr[1].equalsIgnoreCase("bmw")){
        	data[line][1] = "2";
        }else if(arr[1].equalsIgnoreCase("chevrolet")){
        	data[line][1] = "3";
        }else if(arr[1].equalsIgnoreCase("dodge")){
        	data[line][1] = "4";
        }else if(arr[1].equalsIgnoreCase("honda")){
        	data[line][1] = "5";
        }else if(arr[1].equalsIgnoreCase("isuzu")){
        	data[line][1] = "6";
        }else if(arr[1].equalsIgnoreCase("jaguar")){
        	data[line][1] = "7";
        }else if(arr[1].equalsIgnoreCase("mazda")){
        	data[line][1] = "8";
        }else if(arr[1].equalsIgnoreCase("mercedes-benz")){
        	data[line][1] = "9";
        }else if(arr[1].equalsIgnoreCase("mercury")){
        	data[line][1] = "10";
        }else if(arr[1].equalsIgnoreCase("mitsubishi")){
        	data[line][1] = "11";
        }else if(arr[1].equalsIgnoreCase("nissan")){
        	data[line][1] = "12";
        }else if(arr[1].equalsIgnoreCase("peugot")){
        	data[line][1] = "13";
        }else if(arr[1].equalsIgnoreCase("plymouth")){
        	data[line][1] = "14";
        }else if(arr[1].equalsIgnoreCase("porsche")){
        	data[line][1] = "15";
        }else if(arr[1].equalsIgnoreCase("renault")){
        	data[line][1] = "16";
        }else if(arr[1].equalsIgnoreCase("saab")){
        	data[line][1] = "17";
        }else if(arr[1].equalsIgnoreCase("subaru")){
        	data[line][1] = "18";
        }else if(arr[1].equalsIgnoreCase("toyota")){
        	data[line][1] = "19";
        }else if(arr[1].equalsIgnoreCase("volkswagen")){
        	data[line][1] = "20";
        }else{
        	data[line][1] = "21";
        }
        
        if(arr[2].equalsIgnoreCase("diesel")){
        	data[line][2] = "0";
        }else{
        	data[line][2] = "1";
        }
        
        if(arr[3].equalsIgnoreCase("std")){
        	data[line][3] = "0";
        }else{
        	data[line][3] = "1";
        }
        
        if(arr[4].equalsIgnoreCase("four")){
        	data[line][4] = "0";
        }else{
        	data[line][4] = "1";
        }
        
        	
        if(arr[5].equalsIgnoreCase("hardtop")){
        	data[line][5] = "0";
        }else if(arr[5].equalsIgnoreCase("wagon")){
        	data[line][5] = "1";
        }else if(arr[5].equalsIgnoreCase("sedan")){
        	data[line][5] = "2";
        }else if(arr[5].equalsIgnoreCase("hatchback")){
        	data[line][5] = "3";
        }else{
        	data[line][5] = "4";
        }
        
        if(arr[6].equalsIgnoreCase("4wd")){
        	data[line][6] = "0";
        }else if(arr[6].equalsIgnoreCase("fwd")){
        	data[line][6] = "1";
        }else{
        	data[line][6] = "2";
        }
        
        if(arr[7].equalsIgnoreCase("front")){
        	data[line][7] = "0";
        }else{
        	data[line][7] = "1";
        }
        
        if(arr[13].equalsIgnoreCase("dohc")){
        	data[line][13] = "0";
        }else if(arr[13].equalsIgnoreCase("dohcv")){
        	data[line][3] = "1";
        }else if(arr[13].equalsIgnoreCase("l")){
        	data[line][13] = "2";
        }else if(arr[13].equalsIgnoreCase("ohc")){
        	data[line][13] = "3";
        }else if(arr[13].equalsIgnoreCase("ohcf")){
        	data[line][13] = "4";
        }else if(arr[13].equalsIgnoreCase("ohcv")){
        	data[line][13] = "5";
        }else {
        	data[line][13] = "6";
        }
        
        if(arr[14].equalsIgnoreCase("eight")){
        	data[line][14] = "0";
        }else if(arr[14].equalsIgnoreCase("five")){
        	data[line][14] = "1";
        }else if(arr[14].equalsIgnoreCase("four")){
        	data[line][14] = "2";
        }else if(arr[14].equalsIgnoreCase("six")){
        	data[line][14] = "3";
        }else if(arr[14].equalsIgnoreCase("three")){
        	data[line][14] = "4";
        }else if(arr[14].equalsIgnoreCase("twelve")){
        	data[line][14] = "5";
        }else {
        	data[line][14] = "6";
        }
        
        if(arr[16].equalsIgnoreCase("1bbl")){
        	data[line][16] = "0";
        }else if(arr[16].equalsIgnoreCase("2bbl")){
        	data[line][16] = "1";
        }else if(arr[16].equalsIgnoreCase("4bbl")){
        	data[line][16] = "2";
        }else if(arr[16].equalsIgnoreCase("idi")){
        	data[line][16] = "3";
        }else if(arr[16].equalsIgnoreCase("mfi")){
        	data[line][16] = "4";
        }else if(arr[16].equalsIgnoreCase("mpfi")){
        	data[line][16] = "5";
        }else if(arr[16].equalsIgnoreCase("spdi")){
        	data[line][16] = "6";
        }else if(arr[16].equalsIgnoreCase("spfi")){
        	data[line][16] = "7";
        }else{
        	data[line][16] = "8";
        }
        line++; 
        }
        
        }
    }
    reader.close();       			 
    distance_difference(data[0],data[1],attr_num);
//output the result of the accuracy with varies k
    BufferedWriter bufferedWriter = null;
    bufferedWriter = new BufferedWriter(new FileWriter("autos_encoding.txt"));
    int leave_one_out = 0;
  //test accuracy of different k
    for(k=2;k<Max_k;k++){
    	int count_right = 0;
    	int count_wrong = 0;
    	int count_right_distance = 0;
    	int count_wrong_distance = 0;
    	double result_difference_total =0;
    	double result_difference_total_wnn =0;

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
    			
    			// compare the new distance with the lowest distance in k-nearest list and update 
    			float Old_distance = distance_difference(data[kNN[k-1]],data[leave_one_out],attr_num);
    			float New_distance = distance_difference(data[m],data[leave_one_out],attr_num);
    			if(New_distance < Old_distance){
    				kNN[k-1] = m;
    				//let k-nearest list as queue with lower distance in front and higher distance in the back
    				for(int a=0;a<k-1;a++){
    					float Old_distance_k = distance_difference(data[kNN[k-2-a]],data[leave_one_out],attr_num);
    	    			float New_distance_k = distance_difference(data[kNN[k-1-a]],data[leave_one_out],attr_num);
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
    	int[] count_price = new int[k];
    	double[] count_price_distance = new double[k];
    	int max=0,max_distance=0;
    	


    	for(int a=0;a<k;a++){
    		count_price[a]=0;
    	}
    	
    	//get the number or weigh of each value(b or g) for price
    	for(int a=0;a<k;a++){
    		for(int b=0;b<k;b++){
    			if(data[kNN[a]][test_attribute_number].equalsIgnoreCase(data[kNN[b]][test_attribute_number])){
    				count_price[a]++;
    				count_price_distance[a]= 1.0/(double)distance_difference(data[kNN[a]],data[leave_one_out],attr_num);
    			}
    		}
    	}
    	
    	//compare with real result in data,
    	//count the right result number and wrong result number
    	//calculate the difference of the predict price and the real price
    	//if the number of several is the same, we set it as the first one
    	for(int a=0;a<k;a++){
    		if(count_price[max]<count_price[a]){
    			max=a;
    		}

    	}
    	for(int a=0;a<k;a++){
    		if(count_price_distance[max_distance]<count_price_distance[a]){
    			max_distance=a;
    		}

    	}

    	if(data[kNN[max]][test_attribute_number].equalsIgnoreCase(data[leave_one_out][test_attribute_number])){
    		count_right++;
    	}else{
    		count_wrong++;
    		double kNN_price = Double.parseDouble(data[kNN[max]][test_attribute_number]);
    		double real_price = Double.parseDouble(data[leave_one_out][test_attribute_number]);
    		
    		result_difference_total+=Math.abs(kNN_price-real_price);
    	}
    	
    	if(data[kNN[max_distance]][test_attribute_number].equalsIgnoreCase(data[leave_one_out][test_attribute_number])){
    		count_right_distance++;
    		//System.out.println(kNN[max_distance]+"+"+leave_one_out);
    	}else{
    		count_wrong_distance++;
    		double kNN_price_wnn = Double.parseDouble(data[kNN[max]][test_attribute_number]);
    		double real_price_wnn = Double.parseDouble(data[leave_one_out][test_attribute_number]);
    		
    		result_difference_total_wnn+=Math.abs(kNN_price_wnn-real_price_wnn);
    	}
    	
    
    	
    	
    }
    //output the data to result file
    float accuacy;
    accuacy = (float)count_right/((float)count_right+(float)count_wrong);
    System.out.println("k is N0."+k+ "and accuracy of knn: " +accuacy+";"+result_difference_total/line_num);
    float accuacy_distance;
    accuacy_distance = (float)count_right_distance/((float)count_right_distance+(float)count_wrong_distance);
    System.out.println("k is N0."+k+ "and accuracy of wnn: " +accuacy_distance+";"+result_difference_total_wnn/line_num);
    String output = null;
    output = k+","+accuacy+","+result_difference_total/line_num+","+accuacy_distance+","+result_difference_total_wnn/line_num;
    bufferedWriter.write(output);
    bufferedWriter.newLine();
    }

    bufferedWriter.flush();
    bufferedWriter.close();
    
    
}
}