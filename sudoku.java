//để có được như định dạng thì bỏ writer.write("\t"); ở dòng thứ 22 và writer.write("\n"); ở dòng thứ 27
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
public class tuple_test2 {
    public static void print_3d(int[][][][] target, String file_name) throws IOException{
        int numb_hole = 18;
        int hole_cell;
        Random random_number = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_name))) {
            for (int lay1 = 0; lay1 < 3; lay1++) { 

                for (int lay2 = 0; lay2 < 3; lay2++) { 
                    int random_take_new, random_pos_new;
                    hole_cell = numb_hole / 9;
                    
                    while(hole_cell != 0){
                        
                        int random_take = 0 + random_number.nextInt(3);
                        int random_pos = 0 + random_number.nextInt(3);
                        
                        System.out.println(lay2 + " is " +random_take + " and " + random_pos);

                        for (int lay3 = 0; lay3 < 3; lay3++) { 

                            for(int lay4 = 0; lay4 < 3; lay4++){

                                if(lay3 == random_take && lay4 == random_pos){
                                    if(target[lay1][lay2][lay3][lay4] == 0){
                                        hole_cell++;
                                        break;
                                    }
                                    else{
                                        target[lay1][lay2][lay3][lay4] = 0;
                                    }
                                    
                                }
                                
                            }
                            
                        }
                        
                        hole_cell--;
                        
                    }
                     
                } 
                
            }
            for (int lay1 = 0; lay1 < 3; lay1++) { 

                for (int lay2 = 0; lay2 < 3; lay2++) { 
                    
                    for (int lay3 = 0; lay3 < 3; lay3++) { 
                        
                        for(int lay4 = 0; lay4 < 3; lay4++){
                            
                            if(lay3 == 2 && lay4 == 2){
                                writer.write(target[lay1][lay3][lay2][lay4] + "");
                            }
                            
                            else{
                                writer.write(target[lay1][lay3][lay2][lay4] + ", ");
                            }
                        }
                        writer.write("\t");
                    } 
  
                    writer.write("\n"); 
                } 
                writer.write("\n"); 
            }
        }
        catch(IOException error){
            System.out.println(error.getMessage());
        }
    }
    public static void main(String args[]) throws IOException{
        Random random_number = new Random();
        int[] one_nine = {1,2,3,4,5,6,7,8,9};
        int[] copy = new int[9];
        int array_len = one_nine.length;
        for (int i = 0; i < array_len; i++) {
            int position = 0 + random_number.nextInt(array_len);
            int temp = (int) one_nine[i];
            one_nine[i] = one_nine[position];
            one_nine[position] = temp;
        }
        copy = one_nine.clone();
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i] + " ");
        }
        
        //For Line1
        //int[][][] line1 = {{take6,take8,take7},{take7.clone(),take6.clone(),take8.clone()},{take8.clone(),take7.clone(),take6.clone()}};
        int[] take0 = {copy[0],copy[1],copy[2]};
        int[] take1 = {copy[3],copy[4],copy[5]};
        int[] take2 = {copy[6],copy[7],copy[8]};
        int[][][] line1 = {{take0,take2,take1},{take1.clone(),take0.clone(),take2.clone()},{take2.clone(),take1.clone(),take0.clone()}};
        
        //For Line2
        int[] take3 = {copy[2],copy[0],copy[1]};//0
        int[] take4 = {copy[5],copy[3],copy[4]};  //1
        int[] take5 = {copy[8],copy[6],copy[7]}; //2
        int[][][] line2 = {{take3,take5,take4},{take4.clone(),take3.clone(),take5.clone()},{take5.clone(),take4.clone(),take3.clone()}};
        
        //For Line3
        int[] take6 = {copy[1],copy[2],copy[0]}; //3
        int[] take7 = {copy[4],copy[5],copy[3]}; //4
        int[] take8 = {copy[7],copy[8],copy[6]}; //5
        int[][][] line3 = {{take6,take8,take7},{take7.clone(),take6.clone(),take8.clone()},{take8.clone(),take7.clone(),take6.clone()}};
        
        System.out.println();
        
        int[][][][] final_sudoku = {line1,line2,line3}; 
        print_3d(final_sudoku,"output1.txt");
    }
}
