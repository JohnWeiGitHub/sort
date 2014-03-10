package com.example.sort;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements Button.OnClickListener{

    Button btn1;
    Button btn2;
    TextView sorted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 =(Button)this.findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 =(Button)this.findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        sorted= (TextView)this.findViewById(R.id.textView1);
    }
    int []numbers_quick = {
            51,  13  ,83  ,88  ,88
            ,54 , 25  ,5   ,82  ,14
            ,70 , 79  ,88  ,4   ,42
            ,9 ,  21  ,92 , 28  ,32
            ,9 ,  93  ,31 , 1   ,62
            ,49 , 82  ,78 , 21  ,11
            ,16 , 1   ,25 , 66  ,88
            ,19 , 3   ,11 , 62  ,62
            ,62 , 49  ,85 , 64  ,11
            ,48 , 95  ,96 , 78  ,58
            ,78 , 12 , 70 , 63  ,25
            ,4  , 83 , 39 , 68  ,42
            ,12 , 89 , 93 , 80  ,46
            ,50 , 13,  4  , 83  ,38
            ,28 , 34,  65 , 43  ,35
            ,30 , 31,  36 , 76  ,40
            ,20 , 59,  11 , 10  ,60
            ,7  , 27,  50 , 77  ,22
            ,30  ,41,  32 , 42  ,80
            ,39 , 75 , 92 , 93  ,100
            
    };
    int []numbers_bubble = {
            51,  13  ,83  ,88  ,88
            ,54 , 25  ,5   ,82  ,14
            ,70 , 79  ,88  ,4   ,42
            ,9 ,  21  ,92 , 28  ,32
            ,9 ,  93  ,31 , 1   ,62
            ,49 , 82  ,78 , 21  ,11
            ,16 , 1   ,25 , 66  ,88
            ,19 , 3   ,11 , 62  ,62
            ,62 , 49  ,85 , 64  ,11
            ,48 , 95  ,96 , 78  ,58
            ,78 , 12 , 70 , 63  ,25
            ,4  , 83 , 39 , 68  ,42
            ,12 , 89 , 93 , 80  ,46
            ,50 , 13,  4  , 83  ,38
            ,28 , 34,  65 , 43  ,35
            ,30 , 31,  36 , 76  ,40
            ,20 , 59,  11 , 10  ,60
            ,7  , 27,  50 , 77  ,22
            ,30  ,41,  32 , 42  ,80
            ,39 , 75 , 92 , 93  ,99
            
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    void swap (int []numbers,int a_index, int b_index) {
        int temp = numbers[a_index];
        numbers[a_index] = numbers[b_index];
        numbers[b_index] = temp ;        
    }
    void bubble_sort(int []numbers,int size){
        for (int i = 0;i < size;i++) {
            for(int j = 0;j< size-i-1 ;j++) {
                if(numbers[j]>numbers[j+1])
                {
                    swap(numbers,j,j+1);
                }
            }
            
        }        
        
    }
    void print (int[]numbers) {
        String strNumbers = new String();
        for(int i=0;i<100;i++){
            strNumbers = strNumbers+" "+numbers[i];
        }
        sorted.setText(strNumbers);
        
    }
    void quick_sort_inplace(int []numbers,int left,int right) {
        //int[] x = new int[10];
        if(left>=right) return;
        
        int pivot = numbers[right];
        int index  = left;
        for(int i=left;i<right;i++){
            if(numbers[i]<pivot) {
                swap(numbers,i,index);
                index++;
            }
        }
        swap(numbers,right,index);
        quick_sort_inplace(numbers,left,index-1);
        quick_sort_inplace(numbers,index+1,right);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v.getId()==R.id.button1){
        bubble_sort(numbers_bubble,100);
        print(numbers_bubble);
        }
        else {
        quick_sort_inplace(numbers_quick,0,99);
        print(numbers_quick);
        }
    }

}
