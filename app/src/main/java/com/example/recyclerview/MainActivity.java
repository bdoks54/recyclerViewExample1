package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new MainRecyclerViewAdapter());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);   //LinearLayoutManager 순서대로 배치한다 GridLayoutManager 격자로 배치한다 StaggeredGridLayoutManager 크기가 다른 요소를 격자로 배치한다
        recyclerView.setLayoutManager(layoutManager);

    }

    private static class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewViewHolder>{
        //onCreateViewHolder 레이아웃을 만들고 해당 아이템에 관련된 자료를 담을 뷰 홀더를 만든다. 뷰홀더는 아이템에 대한 뷰와 그와 관련된 메타데이터를 가지고 있는 객체이다.
        @Override
        public MainRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
            return new MainRecyclerViewViewHolder(itemView);
        }

        //onBindViewHolder 뷰 홀더가 실제로 연결(bind)될 때 호출된다. onCreateViewHolder 후에 호출 될 수 있고 이전에 만들어진 뷰 홀더를 재사용 할 수 있다.
        @Override
        public void onBindViewHolder(MainRecyclerViewViewHolder holder, int position){
            holder.setTitle((position+1)+"번째 아이템입니다.");
        }

        //getItemCount 리스트에 표시될 아이템의 개수를 리턴한다
        @Override
        public int getItemCount(){
            return 10;
        }
    }

    private static class MainRecyclerViewViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;

        public MainRecyclerViewViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }

        public void setTitle(String title){
            this.title.setText(title);
        }
    }
}